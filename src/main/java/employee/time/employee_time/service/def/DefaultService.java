package employee.time.employee_time.service.def;

import employee.time.employee_time.model.def.DefaultEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * @Description: default service
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:05
 **/


public interface DefaultService <T extends DefaultEntity> {

    void save(T t);

    void update(T t);

    Optional<T> findById(Long id);

    List<T> findAll();

    Page<T> findAllByPage(Pageable pageable);

    boolean existsById(Long id);
}
