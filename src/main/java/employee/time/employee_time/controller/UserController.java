package employee.time.employee_time.controller;

import employee.time.employee_time.dto.RequestEmployeeFormStartWorkDto;
import employee.time.employee_time.exception.domain.BiometryException;
import employee.time.employee_time.exception.domain.StoreException;
import employee.time.employee_time.exception.domain.UserException;
import employee.time.employee_time.facade.StaticEmployeeFacade;
import employee.time.employee_time.facade.UserFacade;
import employee.time.employee_time.model.StaticEmployee;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.springframework.http.HttpStatus.OK;

/**
 * @Description: user controller
 * @Author: Serhio Duran
 * @create: 2023-01-04-01:03
 **/

@RestController
@RequestMapping("/employee")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;
    private final StaticEmployeeFacade staticEmployeeFacade;

    @PostMapping("/work/accept")
    public ResponseEntity<HttpStatus> acceptWork(
            @RequestBody RequestEmployeeFormStartWorkDto employeeFormStartWork)
            throws BiometryException, UserException, StoreException {
        userFacade.acceptWork(employeeFormStartWork);
        return new ResponseEntity<>(OK);
    }

    @GetMapping("/work/check/list")
    public ResponseEntity<Page<StaticEmployee>> getWorkerCheckPage(
            @RequestParam(value = "sort", required = false, defaultValue = "DESC") Sort.Direction sort,
            @RequestParam(value = "page", required = false, defaultValue = "0") int page,
            @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        Page<StaticEmployee> workerCheckPage = staticEmployeeFacade.getWorkerCheckPage(sort, page, size);
        return new ResponseEntity<>(workerCheckPage, OK);
    }
}
