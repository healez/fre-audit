package com.myspace.githook_1;

import org.kie.api.KieServices;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PocConfig {
	
	
	private KieServices kieServices = KieServices.Factory.get();
	
	@Bean
	public StatelessKieSession getKieSession() {
		return kieServices.getKieClasspathContainer().newStatelessKieSession();
	}

}
