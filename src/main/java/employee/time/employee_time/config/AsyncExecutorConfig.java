package employee.time.employee_time.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:59
 **/

@Configuration
@EnableAsync
public class AsyncExecutorConfig implements AsyncConfigurer {

    @Override
    public ThreadPoolTaskExecutor getAsyncExecutor() {
        ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
        taskExecutor.setCorePoolSize(10);
        taskExecutor.setMaxPoolSize(5000);
        taskExecutor.setKeepAliveSeconds(300);
        taskExecutor.setQueueCapacity(Integer.MAX_VALUE);
        taskExecutor.setThreadNamePrefix("AsyncBiometryThread-");
        taskExecutor.initialize();
        return taskExecutor;

    }
}