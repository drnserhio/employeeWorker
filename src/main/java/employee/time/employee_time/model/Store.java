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
import java.time.LocalTime;

import static jakarta.persistence.CascadeType.ALL;

/**
 * @Description: store entity
 * @Author: Serhio Duran
 * @create: 2023-01-03-21:39
 **/

@Entity
@Table(name = "stores")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
@Data
public class Store extends DefaultEntity {

    @Column(name = "name")
    private String name;
    @Column(name = "open_date")
    @JsonFormat(pattern = "hh:mm")
    private LocalTime openDate;
    @Column(name = "close_date")
    @JsonFormat(pattern = "hh:mm")
    private LocalTime closeDate;
    @Column(name = "is_round_the_clock")
    private Boolean isRoundTheClock;

}
