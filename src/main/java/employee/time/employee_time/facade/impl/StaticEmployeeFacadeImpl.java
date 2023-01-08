package employee.time.employee_time.facade.impl;

import employee.time.employee_time.facade.StaticEmployeeFacade;
import employee.time.employee_time.model.StaticEmployee;
import employee.time.employee_time.service.StaticEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:05
 **/

@Service
@AllArgsConstructor
public class StaticEmployeeFacadeImpl implements StaticEmployeeFacade {

    private final StaticEmployeeService staticEmployeeService;

    @Override
    public Page<StaticEmployee> getWorkerCheckPage(Sort.Direction sort, int page, int size) {
        PageRequest pageRequest = PageRequest.of(page, size);
        return staticEmployeeService.findAllByCreateDate(LocalDate.now(), pageRequest);
    }
}
