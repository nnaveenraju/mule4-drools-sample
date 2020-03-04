package com.drools.example;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RulesEngine {
	public static void executeJobRules(Job inputJob) {
		try {
			// load up the knowledge base
			KieServices ks = KieServices.Factory.get();
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("ksession-job-rules");
			kSession.insert(inputJob);
			kSession.fireAllRules();
			kSession.dispose();
		} catch (Throwable t) {
			t.printStackTrace();
		}
	}
}