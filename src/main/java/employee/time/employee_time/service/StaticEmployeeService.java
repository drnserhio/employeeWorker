package employee.time.employee_time.service;

import employee.time.employee_time.model.Biometry;
import employee.time.employee_time.model.StaticEmployee;
import employee.time.employee_time.service.def.DefaultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:17
 **/

public interface StaticEmployeeService extends DefaultService<StaticEmployee> {

    Page<StaticEmployee> findAllByCreateDate(LocalDate createDate, Pageable pageable);
}
