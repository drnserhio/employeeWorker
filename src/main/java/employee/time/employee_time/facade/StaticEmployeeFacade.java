package employee.time.employee_time.facade;

import employee.time.employee_time.model.StaticEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:05
 **/

public interface StaticEmployeeFacade {

    Page<StaticEmployee> getWorkerCheckPage(Sort.Direction sort, int page, int size);
}
