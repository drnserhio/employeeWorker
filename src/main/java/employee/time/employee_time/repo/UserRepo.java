package employee.time.employee_time.repo;

import employee.time.employee_time.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Set;

/**
 * @Description: repo user
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:09
 **/

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    @Query("select id from User")
    Page<Long> findAllIdsByPage(Pageable pageable);
}
