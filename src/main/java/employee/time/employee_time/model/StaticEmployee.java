package employee.time.employee_time.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import employee.time.employee_time.model.def.DefaultEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:14
 **/

@Entity
@Table(name = "static_employee")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class StaticEmployee extends DefaultEntity {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "create_date")
    @JsonFormat(pattern = "yyyy/MM/dd")
    private LocalDate createDate;
    @Column(name = "idInterval")
    private String  idInterval;
    @Column(name = "countWork")
    private Integer countWork;
}
