package com.myspace.githook_1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Map;

import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.rule.RuleContext;

import java.util.HashMap;
import java.util.List;

public class LoggingInvocationHandler implements InvocationHandler {
    
    Object orig;
    String className;

    // Eventgough it is static there are 
    static private HashMap<String, Map<String, Method>> cls2Methods  = new HashMap<String, Map<String, Method>>();

    // This must be ruleSessionScoped for not sharing contexts though multiple Sessions
    private RuleContext ruleContext;
    private List<LogEntry> logEntryList;
    private String logEntryListGlobalName;

    public void setRuleContext( RuleContext _ruleContext ) {
        // System.out.println( "RuleContext:" +  _ruleContext );
        this.ruleContext = _ruleContext;
        logEntryList = (List<LogEntry>)ruleContext.getKieRuntime().getGlobal(logEntryListGlobalName);
    }

    LoggingInvocationHandler ( Object target,
    		StatelessKieSession _ksess,
                               String _logEntryListGlobalName  ) {
        
        orig = target;
        logEntryListGlobalName = _logEntryListGlobalName;

        ruleContext  = null;

        className = orig.getClass().getName();

        Map<String, Method> methods =  cls2Methods.get(className);

        if ( cls2Methods.get(className) == null ) {
                         
            if ( methods == null ) {

                methods = new HashMap<String, Method>();

                for(Method method: target.getClass().getDeclaredMethods()) {
                    // System.out.println( method.getName() );
                    methods.put(method.getName(), method);
                }

                cls2Methods.put(className, methods);
            }
        }

        if ( _ksess != null ) {
            logEntryList = (List<LogEntry>)_ksess.getGlobals().get(logEntryListGlobalName);
        }
    }

    static final Object[] noArgs = new Object[0];
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
      
        // System.out.println ( "---->kContext:" + ruleContext );

        Map<String, Method> methods =  (Map<String, Method>)cls2Methods.get(className);
        
        // if ( ruleContext == null ) {
        //     throw new IllegalStateException( "No RuleContext set" );
        // }

        String mn = method.getName();

        System.out.println("mn:" + mn );

        Object oldVal = null;

        if (mn.startsWith ("set")) {

            String gn = mn.replaceFirst("s", "g" );

            // System.out.println("gn:" + gn );

            Method getter = methods.get(gn);

            // System.out.println("gttr:" + getter );
            
            oldVal = getter.invoke(orig, noArgs ) ;

            methods.get(mn).invoke(orig, args);


           if ( oldVal != null ) {


                System.out.println ( "Old" + oldVal );
                System.out.println ( "New" + args[0] );

                LogEntry le = new LogEntry();

                le.setField(mn.substring(3));
                le.setType ( "FieldChange" );
                le.setOldVal(oldVal.toString());
                le.setNewVal(args[0].toString());
                le.setClassName(orig.getClass().getName() );
                
                Method idGetter = methods.get("getId");
                //System.out.println ( "Content:" + idGetter );
                //System.out.println ( "orig" + orig );
                //System.out.println ( "Content" + idContent );

                Object idContent;

                if ( idGetter != null ) {
                    idContent = idGetter.invoke(orig, noArgs );
                    if (idContent != null) {
                        idContent = idContent.toString();
                    } else {
                        idContent = "null";
                    }
                } else {
                    idContent = "NO-ID";
                }
                
                le.setId( (idGetter != null)? (String)idContent : "NO-ID");

                if ( ruleContext != null ) { setRuleData ( le ); } 

                logEntryList.add(le);
            }
    
            return null;
        } else {
            Object result = methods.get(mn).invoke(orig, args);
            return result;
        }
    }

    protected void setRuleData ( LogEntry le ) {
        System.out.println ( "RuleName=ID:" + ruleContext.getRule().getName()) ;
        // ruleContext.getMatch().getRule().
    }

}
