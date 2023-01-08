package employee.time.employee_time.model.def;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;

/**
 * @Description: abstract entity
 * @Author: Serhio Duran
 * @create: 2023-01-03-21:19
 **/

@MappedSuperclass
@Getter
public abstract class DefaultEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
}
