package employee.time.employee_time.service.impl;

import employee.time.employee_time.model.Biometry;
import employee.time.employee_time.model.StaticEmployee;
import employee.time.employee_time.repo.StaticEmployeeRepo;
import employee.time.employee_time.service.StaticEmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @Description:
 * @Author: Serhio Duran
 * @create: 2023-01-06-02:17
 **/

@Service
@Transactional
@AllArgsConstructor
public class StaticEmployeeServiceImpl implements StaticEmployeeService {

    private final StaticEmployeeRepo staticEmployeeRepo;

    @Override
    public void save(StaticEmployee staticEmployee) {
        staticEmployeeRepo.save(staticEmployee);
    }

    @Override
    public void update(StaticEmployee staticEmployee) {
        staticEmployeeRepo.save(staticEmployee);
    }

    @Override
    public Optional<StaticEmployee> findById(Long id) {
        return staticEmployeeRepo.findById(id);
    }

    @Override
    public List<StaticEmployee> findAll() {
        return staticEmployeeRepo.findAll();
    }

    @Override
    public Page<StaticEmployee> findAllByPage(Pageable pageable) {
        return staticEmployeeRepo.findAll(pageable);
    }

    @Override
    public boolean existsById(Long id) {
        return staticEmployeeRepo.existsById(id);
    }

    @Override
    public Page<StaticEmployee> findAllByCreateDate(LocalDate createDate, Pageable pageable) {
        return staticEmployeeRepo.findAllByCreateDateOrderByCreateDate(createDate, pageable);
    }
}
