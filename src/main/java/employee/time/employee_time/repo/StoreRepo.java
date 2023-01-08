package employee.time.employee_time.repo;

import employee.time.employee_time.model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: repo store
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:09
 **/

@Repository
public interface StoreRepo extends JpaRepository<Store, Long> {
}
