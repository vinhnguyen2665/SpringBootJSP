package com.vinhnq.scheduling;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;



/*
 * Class define enable scheduler
 */


@Configuration
@EnableScheduling
public class SchedulerConfig {
	public static final Logger logger = Logger.getLogger(SchedulerConfig.class);
}
