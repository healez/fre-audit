package com.myspace.githook_1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.lang.reflect.Proxy;
import java.net.HttpURLConnection;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.drools.core.event.DebugAgendaEventListener;
import org.drools.core.event.DebugRuleRuntimeEventListener;
import org.drools.core.event.DefaultAgendaEventListener;
import org.drools.core.util.StringUtils;
//import org.drools.workbench.models.guided.dtable.backend.GuidedDTDRLPersistence;
//import org.drools.workbench.models.guided.dtable.backend.GuidedDTXMLPersistence;
//import org.drools.workbench.models.guided.dtable.shared.model.GuidedDecisionTable52;
import org.eclipse.jgit.internal.revwalk.BitmappedObjectReachabilityChecker;
import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.builder.KieRepository;
import org.kie.api.builder.Message;
import org.kie.api.builder.ReleaseId;
import org.kie.api.builder.Results;
import org.kie.api.command.BatchExecutionCommand;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.definition.KiePackage;
import org.kie.api.definition.type.FactType;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;
import org.kie.api.io.Resource;
import org.kie.api.logger.KieRuntimeLogger;
import org.kie.api.marshalling.Marshaller;
import org.kie.api.runtime.ClassObjectFilter;
import org.kie.api.runtime.ExecutionResults;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.api.runtime.process.ProcessInstance;
import org.kie.api.runtime.process.WorkItemManager;
import org.kie.api.runtime.rule.FactHandle;
import org.kie.api.runtime.rule.RuleContext;
import org.kie.internal.builder.KnowledgeBuilder;
import org.kie.internal.builder.KnowledgeBuilderConfiguration;
import org.kie.internal.builder.KnowledgeBuilderFactory;
import org.kie.internal.command.CommandFactory;
import org.kie.internal.io.ResourceFactory;
//import org.kie.server.api.marshalling.MarshallerFactory;
//import org.kie.server.api.marshalling.MarshallingFormat;
//import org.kie.server.api.model.ServiceResponse;
//import org.kie.server.client.KieServicesClient;
//import org.kie.server.client.KieServicesConfiguration;
//import org.kie.server.client.KieServicesFactory;
//import org.kie.server.client.RuleServicesClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myspace.githook_1.*;

@Service
public class TestService {
	
	private StatelessKieSession kieSession;
	
	
	public TestService(StatelessKieSession kieSession){
		this.kieSession = kieSession;
	}
	
	
	final static String logEntyListName = "logEntries";

	
	public static final String URL = "http://localhost:8080/kie-server/services/rest/server";
	public static final String USER = "kieserver";
	public static final String PASSWORD="kieserver1!";
	
	public static final String CONTAINERID="GITHook_1_1.0.0-SNAPSHOT";
	public static final String CLASS_NAME="Shipment";

		
	public void getExecute(ShipmentObjectInterface sdobject) {
		/*
		KieServicesConfiguration config = KieServicesFactory.newRestConfiguration(URL, USER, PASSWORD);
		config.setMarshallingFormat(MarshallingFormat.JSON);
		
		KieServicesClient client = KieServicesFactory.newKieServicesClient(config);
		RuleServicesClient ruleClient = client.getServicesClient(RuleServicesClient.class);
	
		List<Command<?>> cmds = new ArrayList<Command<?>>();
		
		KieCommands commands = KieServices.Factory.get().getCommands();

		cmds.add(commands.newInsert(sdobject,CLASS_NAME));
		cmds.add(commands.newInsert(commands.newFireAllRules()));
		
		BatchExecutionCommand batchCommand = CommandFactory.newBatchExecution(cmds,"defaultKieSession");
		
		
		ServiceResponse<ExecutionResults> response = ruleClient.executeCommandsWithResults(CONTAINERID, batchCommand);
	   
	    if(response.getType() == ServiceResponse.ResponseType.SUCCESS) {
	    	ShipmentObjectInterface sd = (ShipmentObjectInterface) response.getResult().getValue(CLASS_NAME);
	    	System.out.println(sd.getCountryCode() + " " + sd.getCountryName());
	    }else {
	    	System.out.println(response.getMsg());
	    }
	    */
	    

		
	}
	
	public void testExecute3(ShipmentRequest sdobject) throws IOException {
		
		 //String decisionTableXml = new String (Files.readAllBytes(Paths.get("C:\\Projects\\Applications\\FRE_Sprint3\\myproject\\src\\main\\resources\\com\\myspace\\githook_1\\CountryRulesAudit.gdst") ) );
		 //GuidedDecisionTable52 content= GuidedDTXMLPersistence.getInstance().unmarshal(decisionTableXml);
	
		 //String droolsRules = GuidedDTDRLPersistence.getInstance().marshal(content);

		 KieServices kieServices = KieServices.Factory.get();
		 //KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		 
		  //kieFileSystem.write( "src\\main\\resources\\com\\myspace\\githook_1\\GD1.drl",
	    	//	droolsRules );
		 
	     //KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem).buildAll();
       
	     //Results results = kieBuilder.getResults();
	     //if( results.hasMessages( Message.Level.ERROR ) ){
	    //	 System.out.println("Errors" + results.getMessages());
	     //}
	     
	    // kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
	    // ReleaseId rid = new ReleaseIdImpl("com.myspace.githook_1","lib-audit-track","0.0.1-SNAPSHOT");
	    // StatelessKieSession kiesession = kieContainer.newStatelessKieSession();

	     //added
	      //List<String> logEntyList = new ArrayList<String>();
	      //kiesession.setGlobal(logEntyListName, logEntyList);
	      
	     
	     ShipmentObject sdo = new ShipmentObject();
	     sdo.setCountryCode(sdobject.getCountryCode());
	     sdo.setCountryColor(sdobject.getCountryColor());
	     sdo.setCountryName(sdobject.getCountryName());
	     sdo.setCountryNotes(sdobject.getCountryNotes());
	     sdo.setCountryNumber(sdobject.getCountryNumber());

	     /*
	     ShipmentObjectInterface ruleShipment = new ShipmentObject();
	     ruleShipment.setCountryCode(sdo.getCountryCode());
	     ruleShipment.setCountryColor(sdo.getCountryColor());
	     ruleShipment.setCountryName(sdo.getCountryName());
	     ruleShipment.setCountryNotes(sdo.getCountryNotes());
	     ruleShipment.setCountryNumber(sdo.getCountryNumber());
	     */
	     
	     CountryResult notes = new CountryResult();
	     notes.setNotes("MX-ORIG");
	     
	     
	     CountryResultInterface countryInterface =  new CountryResult();
	     countryInterface.setNotes(notes.getNotes());
	     
	     
  		 List<Command<?>> cmds = new ArrayList<Command<?>>();
		
  		 
         List<LogEntry> logEntyList = new ArrayList<LogEntry>();
         kieSession.setGlobal(logEntyListName, logEntyList);
         
         
         LoggingInvocationHandler lih = new LoggingInvocationHandler(sdo, kieSession, logEntyListName );
		 cmds.add(CommandFactory.newInsert(lih,"LoggingInvocationHandler"));
        
		 ShipmentObjectInterface ruleShipment = (ShipmentObjectInterface) Proxy.newProxyInstance(TestService.class.getClassLoader(),
                                   new Class[] { ShipmentObjectInterface.class },lih );
		 
		 //LoggingInvocationHandler lih2 = new LoggingInvocationHandler(notes, lih.getDataAuditList());
		 //cmds.add(CommandFactory.newInsert(lih2,"LoggingInvocationHandler"));
		 //CountryResultInterface  countryInterface =  (CountryResultInterface) Proxy.newProxyInstance( CountryResultInterface.class.getClassLoader(), new Class[] { CountryResultInterface.class }, lih2 );

		 cmds.add(CommandFactory.newInsert(new TryLog(),"TryLog"));
		 cmds.add(CommandFactory.newInsert(ruleShipment,"ShipmentObjectInterface"));
		 cmds.add(CommandFactory.newInsert(countryInterface,"CountryResultInterface"));
	
		 cmds.add(CommandFactory.newStartProcess("githook_1.FlowRow"));
	     cmds.add(CommandFactory.newFireAllRules());
		 
	     //kieSession.addEventListener(new DebugRuleRuntimeEventListener());
		 //kieSession.addEventListener(agendaEventListener);
		 
		 ExecutionResults response = kieSession.execute(CommandFactory
			        .newBatchExecution(cmds));
		 
		 
		 //DataAudit dtaAudit = new DataAudit();
		 //dtaAudit.setDataChangelist(lih.getDataAuditList());
		// dtaAudit.setRuleName((String)(map.get("RuleName")));
		 //dtaAudit.setRuleId((String)(map.get("RuleId")));
		 //dtaAudit.setMatchingRule(processLog(response.getValue("TryLog")));
		 //System.out.println(dtaAudit);
		 
		 //System.out.println(lih2.getDataAuditList());
	        printLog(logEntyList);
	
		}
	
	  static void printLog( List<LogEntry> logList ) {

		    logList.forEach( (e) -> { System.out.println (e); } );
		  }
	
	
	public ResponseUtil testExecute(ShipmentRequest sdobject) throws IOException {
		/*
		 String decisionTableXml = new String (Files.readAllBytes(Paths.get("C:\\Projects\\Applications\\FRE_Sprint3\\myproject\\src\\main\\resources\\com\\myspace\\githook_1\\CountryRules.gdst") ) );
		 GuidedDecisionTable52 content= GuidedDTXMLPersistence.getInstance().unmarshal(decisionTableXml);
	
		 String droolsRules = GuidedDTDRLPersistence.getInstance().marshal(content);

		 System.out.println(droolsRules);
		
		 KieServices kieServices = KieServices.Factory.get();
		 KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
		 
		  kieFileSystem.write( "src\\main\\resources\\com\\myspace\\githook_1\\GD1.drl",
	    		droolsRules );
		 
	     KieBuilder kieBuilder = kieServices.newKieBuilder( kieFileSystem ).buildAll();
	    
        
	     Results results = kieBuilder.getResults();
	     if( results.hasMessages( Message.Level.ERROR ) ){
	    	 System.out.println("Errors" + results.getMessages());
	     }
	     
	     //kieContainer = kieServices.newKieContainer(kieBuilder.getKieModule().getReleaseId());
	     //StatelessKieSession kiesession = kieContainer.newStatelessKieSession();

	     
	     Shipment sdo = new Shipment();
	     sdo.setCountryCode(sdobject.getCountryCode());
	     sdo.setCountryColor(sdobject.getCountryColor());
	     sdo.setCountryName(sdobject.getCountryName());
	     sdo.setCountryNotes(sdobject.getCountryNotes());
	     sdo.setCountryNumber(sdobject.getCountryNumber());
	      
		List<Command<?>> cmds = new ArrayList<Command<?>>();
		cmds.add(CommandFactory.newInsert(sdo,CLASS_NAME));
		cmds.add(CommandFactory.newInsert(new CountryResult(),"CountryResult"));
		cmds.add(CommandFactory.newFireAllRules());
		
		cmds.add(CommandFactory.newGetObjects(new ClassObjectFilter(CountryResult.class), "CountryResult"));
		cmds.add(CommandFactory.newGetObjects(new ClassObjectFilter(TryLog.class), "TryLog"));
		
		     
		 ExecutionResults response = kieSession.execute(CommandFactory
			        .newBatchExecution(cmds));
		 
		 ResponseUtil uti = new ResponseUtil();
		 List<CountryResult> lc = null;
		 Shipment ds =null;
		 TryLog trylog = new TryLog();
		 
		 for(String m : response.getIdentifiers()) {
			 if (response.getValue(m) instanceof Shipment) {
				  ds = (Shipment) response.getValue(m);
				  uti.setShipmentObject2(ds);
				  
			 }else {
				 if (response.getValue(m) instanceof List) {
						 List lco = (List<?>) response.getValue(m);
						 for(Object is: lco) {
							 if(is instanceof TryLog) {
								 trylog = (TryLog)is;
							 }else {
								 uti.setCountryResult((CountryResult)is);
							 }
							 
						 }
				 }
				 
			 }
			 
			 if(trylog!=null && trylog.getMessage()!=null)
			 {
				 System.out.println("Process Message  " + processLog(response.getValue("TryLog"))); 
			 }
			 
		 }
		 return uti;
		 */
		return null;
			 
	}
	
	
	private String  processLog(Object object2) {
		
		TryLog object = new TryLog();
		
		 if (object2 instanceof List) {
			 List lco = (List<?>) object2;
			 for(Object is: lco) {
				 if(is instanceof TryLog) {
					 object = (TryLog)is;
				 }
				 
			 }
		 }
		StringBuffer sb = new StringBuffer();
		sb.append("[");
		if (object.getMessage()!=null) {
		List<String> keyValue = Arrays.asList(object.getMessage().split("\\|"));
		 if(keyValue!=null && keyValue.size()>0) {
			 for(String str : keyValue) {
				 	String [] strs  = str.split("\\=");
				 	if(strs.length > 1)  {
				 		if(StringUtils.isEmpty(strs[1].trim())){
				 		}else {
						 	sb.append(str + " ");
				 		}
				 		
				 	}
			 }
		 }
		}
		return sb.append("]").toString();
	}
	
	

}
