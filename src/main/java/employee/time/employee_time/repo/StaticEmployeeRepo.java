package employee.time.employee_time.repo;

import employee.time.employee_time.model.StaticEmployee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:18
 **/

@Repository
public interface StaticEmployeeRepo extends JpaRepository<StaticEmployee, Long> {

    Page<StaticEmployee> findAllByCreateDateOrderByCreateDate(
            @Param("createDate") LocalDate createDate, Pageable pageable);
}
