package employee.time.employee_time.cron;

import employee.time.employee_time.component.BiometryHelper;
import employee.time.employee_time.model.Biometry;
import employee.time.employee_time.service.BiometryService;
import employee.time.employee_time.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

/**
 * @Description: cron biometry
 * @Author: Serhio Duran
 * @create: 2023-01-03-23:37
 **/

@Component
@AllArgsConstructor
public class CronBiometry {

    private final UserService userService;
    private final BiometryService biometryService;

    public void closeWorkAt14Hours() {
        int page = 0;
        int size = 10;

        Page<Long> users = userService.findAllIdsByPage(PageRequest.of(page, size));

        while (users.hasContent()) {
            for (Long userId : users) {
                if (biometryService.existsLastIsActiveNotTheRoundTimeWorkByUserId(userId)) {
                    Biometry lastBiometryActive = biometryService.findLastIsActiveNotTheRoundTimeWorkByUserId(userId);
                    Biometry biometry = BiometryHelper.frmCloseBiometry(lastBiometryActive.getStoreId(), lastBiometryActive.getUserId());
                    biometryService.save(biometry);
                }
            }
        }
    }

}
