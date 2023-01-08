package employee.time.employee_time.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import employee.time.employee_time.dto.def.RequestDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Description: RequestEmployeeFormStartWorkDto
 * @Author: Serhio Duran
 * @create: 2023-01-04-01:05
 **/

@EqualsAndHashCode(callSuper = false)
@Data
public class RequestEmployeeFormStartWorkDto extends RequestDto {

    private Long storeId;
    private Long userId;

    @JsonCreator
    public RequestEmployeeFormStartWorkDto(
            @JsonProperty("storeId") Long storeId,
            @JsonProperty("userId") Long userId) {
        this.storeId = storeId;
        this.userId = userId;
    }
}
