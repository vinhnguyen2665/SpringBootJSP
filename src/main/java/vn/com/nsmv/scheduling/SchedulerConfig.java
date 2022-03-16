package vn.com.nsmv.scheduling;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Repository;



/*
 * Class define enable scheduler
 */


@Configuration
@EnableScheduling
public class SchedulerConfig {
	public static final Logger logger = Logger.getLogger(SchedulerConfig.class);
}
