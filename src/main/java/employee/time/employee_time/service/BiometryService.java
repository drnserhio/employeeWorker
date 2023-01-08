package employee.time.employee_time.service;

import employee.time.employee_time.model.Biometry;
import employee.time.employee_time.service.def.DefaultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

/**
 * @Description: biometry service
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:05
 **/


public interface BiometryService extends DefaultService<Biometry> {

    boolean existsLastIsActiveNotTheRoundTimeWorkByUserId(Long userId);

    Biometry findLastIsActiveNotTheRoundTimeWorkByUserId(Long userId);

}
