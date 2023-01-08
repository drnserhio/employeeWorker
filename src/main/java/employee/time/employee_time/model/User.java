package employee.time.employee_time.model;

import employee.time.employee_time.model.def.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * @Description: user model
 * @Author: Serhio Duran
 * @create: 2023-01-03-21:18
 **/

@Entity
@Table(name = "users")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class User extends DefaultEntity {

    @Column(name = "user_name")
    private String username;
}
