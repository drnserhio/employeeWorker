package employee.time.employee_time.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import employee.time.employee_time.model.def.DefaultEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Description: biometry entity
 * @Author: Serhio Duran
 * @create: 2023-01-03-21:21
 **/

@Entity
@Table(name = "biometries")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class Biometry extends DefaultEntity {

    @Column(name = "store_id")
    private Long storeId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "time_stamp")
    @JsonFormat(pattern = "yyyy/MM/dd hh:mm:ss")
    private LocalDateTime timeStamp;
    @Column(name = "is_active")
    private Boolean isActive;
}
