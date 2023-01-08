package employee.time.employee_time.service;

import employee.time.employee_time.model.User;
import employee.time.employee_time.service.def.DefaultService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Set;

/**
 * @Description: user service
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:10
 **/


public interface UserService extends DefaultService<User> {

    Page<Long> findAllIdsByPage(Pageable pageable);
}
