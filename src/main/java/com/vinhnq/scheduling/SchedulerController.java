package com.vinhnq.scheduling;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


/*
 * This is class of Scheduler auto run task load  
 */

@Component("schedulerController")
@Transactional
public class SchedulerController {
	private static final Logger logger = LogManager.getLogger(SchedulerController.class);


	public SchedulerController() {

	}


	@Scheduled(fixedDelay = 30000)
	public void alertScheduler() {
		try {
		//	ResponseAPI<String>  alert = alertService.alertStepCounter(userId, 5);
		//	System.err.println(alert.getMessage());
		} catch (Exception ex) {
			logger.error(ex.getMessage(), ex);
		}
	}

}
