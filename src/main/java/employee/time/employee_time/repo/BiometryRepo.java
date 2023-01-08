package employee.time.employee_time.repo;

import employee.time.employee_time.model.Biometry;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;

/**
 * @Description: repo biometry
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:08
 **/

@Repository
public interface BiometryRepo extends JpaRepository<Biometry, Long> {

    @Query(value = "select exists(select store_id from (select store_id from biometries where is_active = true and user_id =:userId order by time_stamp desc limit 1) m inner join (select id from stores where is_round_the_clock = true) n on n.id = m.store_id)", nativeQuery = true)
    boolean existsLastIsActiveNotTheRoundTimeWorkByUserId(
            @Param("userId") Long userId);

    @Query(value = "select m.id, store_id, user_id, time_stamp, is_active from (select * from biometries where is_active = true and user_id =:userId order by time_stamp desc limit 1) m inner join (select id from stores where is_round_the_clock = true) n on n.id = m.store_id", nativeQuery = true)
    Biometry findLastIsActiveNotTheRoundTimeWorkByUserId(Long userId);

}
