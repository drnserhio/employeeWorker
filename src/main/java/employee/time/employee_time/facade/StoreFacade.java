package employee.time.employee_time.facade;

import employee.time.employee_time.model.Store;
import org.springframework.data.domain.Page;

/**
 * @Description: store facade
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:16
 **/


public interface StoreFacade {

    Page<Store> findAll(int page, int size);
}
