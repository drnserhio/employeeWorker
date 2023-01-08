package employee.time.employee_time.facade;

import employee.time.employee_time.dto.RequestEmployeeFormStartWorkDto;
import employee.time.employee_time.exception.domain.BiometryException;
import employee.time.employee_time.exception.domain.StoreException;
import employee.time.employee_time.exception.domain.UserException;

/**
 * @Description: user facade
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:16
 **/

public interface UserFacade {

    void acceptWork(RequestEmployeeFormStartWorkDto employeeFormStartWork) throws UserException, StoreException, BiometryException;

}
