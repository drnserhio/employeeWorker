package employee.time.employee_time.facade.impl;

import employee.time.employee_time.component.BiometryHelper;
import employee.time.employee_time.dto.RequestEmployeeFormStartWorkDto;
import employee.time.employee_time.exception.BiometryExceptionHandler;
import employee.time.employee_time.exception.StoreExceptionHandler;
import employee.time.employee_time.exception.UserExceptionHandler;
import employee.time.employee_time.exception.domain.BiometryException;
import employee.time.employee_time.exception.domain.StoreException;
import employee.time.employee_time.exception.domain.UserException;
import employee.time.employee_time.facade.UserFacade;
import employee.time.employee_time.model.Biometry;
import employee.time.employee_time.model.StaticEmployee;
import employee.time.employee_time.model.Store;
import employee.time.employee_time.service.BiometryService;
import employee.time.employee_time.service.StaticEmployeeService;
import employee.time.employee_time.service.StoreService;
import employee.time.employee_time.service.UserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @Description: user facade impl
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:16
 **/

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final StoreService storeService;
    private final BiometryService biometryService;
    private final StaticEmployeeService staticEmployeeService;
    private final ThreadPoolTaskExecutor threadPoolTaskExecutor;

    private final UserExceptionHandler userExceptionHandler;
    private final BiometryExceptionHandler biometryExceptionHandler;
    private final StoreExceptionHandler storeExceptionHandler;

    @Override
    public void acceptWork(RequestEmployeeFormStartWorkDto employeeFormStartWork)
            throws UserException, StoreException, BiometryException {
        userExceptionHandler.throwExceptionIfUserIdIsNotValid(employeeFormStartWork.getUserId());
        userExceptionHandler.throwExceptionIfUserIdIsNotExists(employeeFormStartWork.getUserId());
        storeExceptionHandler.throwExceptionIfStoreIdIsNotValid(employeeFormStartWork.getStoreId());
        storeExceptionHandler.throwExceptionIfStoreIdIsNotExists(employeeFormStartWork.getStoreId());

        Store store = storeService.findById(employeeFormStartWork.getStoreId()).get();
        Biometry biometry = BiometryHelper.frmBiometryByParam(
                store.getIsRoundTheClock(),
                store.getOpenDate(),
                store.getCloseDate(),
                employeeFormStartWork.getUserId(),
                employeeFormStartWork.getStoreId(),
                LocalTime.now());
        biometryService.save(biometry);

        ThreadBiometry threadBiometry = new ThreadBiometry(biometry.getUserId(), biometry.getStoreId());
        Future<?> future = threadPoolTaskExecutor.submit(threadBiometry);
        ThreadPoolExecutor threadPoolExecutor = threadPoolTaskExecutor.getThreadPoolExecutor();
    }

    @AllArgsConstructor
    @EqualsAndHashCode(callSuper = false)
    @Data
    public
    class ThreadBiometry implements Runnable {

        private final Long userId;
        private final Long storeId;

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " Start.");
            LocalDate tomorrow = LocalDate.now().plusDays(1);
            while (LocalDate.now().isBefore(tomorrow)) {
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if (!biometryService.existsLastIsActiveNotTheRoundTimeWorkByUserId(this.userId)) {
                    Thread.currentThread().interrupt();
                    System.out.println(Thread.currentThread().getName() + " End.");
                }
                StaticEmployee staticEmployee = new StaticEmployee();
                staticEmployee.setUserId(this.userId);
                staticEmployee.setStoreId(this.storeId);
                staticEmployee.setCreateDate(LocalDate.now());
                staticEmployee.setCountWork(15);
                staticEmployee.setIdInterval(UUID.randomUUID().toString().substring(0, 8));
                staticEmployeeService.save(staticEmployee);
            }
        }
    }
}
