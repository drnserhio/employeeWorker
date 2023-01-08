package employee.time.employee_time.config;

import employee.time.employee_time.cron.CronBiometry;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;

import java.util.Set;

/**
 * @Description: cron conf
 * @Author: Serhio Duran
 * @create: 2023-01-03-23:38
 **/

@Configuration
@AllArgsConstructor
@PropertySource("classpath:cronexpression.properties")
@EnableScheduling
public class CronConfig implements SchedulingConfigurer {

    @Value("${crons}")
    private Set<String> crons;
    private final CronBiometry cronBiometry;

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {

        Runnable runnable = cronBiometry::closeWorkAt14Hours;

        crons.forEach(cron -> {
                Trigger trigger = triggerContext -> {
                    CronTrigger crontrigger = new CronTrigger(cron);
                    return crontrigger.nextExecution(triggerContext);
                };
                taskRegistrar.addTriggerTask(runnable, trigger);
        });


    }
}
