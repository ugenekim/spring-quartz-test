package kr.co.wizcore.nexpom.agent;

import java.util.Collection;

import javax.annotation.PostConstruct;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.stereotype.Component;

@Component
public class TestScheduler {

	private SchedulerFactory schedulerFactory;
	private Scheduler scheduler;
	
	@PostConstruct
	public void start() throws SchedulerException {
		schedulerFactory = new StdSchedulerFactory();
		scheduler = schedulerFactory.getScheduler();
		scheduler.start();
		
		JobDetail jobDetail = JobBuilder.newJob(TestJob.class).withIdentity("testJob").build();
		Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(CronScheduleBuilder.cronSchedule("*/10 * * * * ?")).build();
		
		scheduler.scheduleJob(jobDetail, trigger);
	}
}
