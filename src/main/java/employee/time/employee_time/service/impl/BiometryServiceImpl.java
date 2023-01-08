package employee.time.employee_time.service.impl;

import employee.time.employee_time.model.Biometry;
import employee.time.employee_time.repo.BiometryRepo;
import employee.time.employee_time.service.BiometryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * @Description: biometry service impl
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:08
 **/

@Service
@AllArgsConstructor
@Transactional
public class BiometryServiceImpl implements BiometryService {

    private final BiometryRepo biometryRepo;

    @Override
    public void save(Biometry biometry) {
        biometryRepo.save(biometry);
    }

    @Override
    public void update(Biometry biometry) {
        biometryRepo.save(biometry);
    }

    @Override
    public Optional<Biometry> findById(Long id) {
        return biometryRepo.findById(id);
    }

    @Override
    public List<Biometry> findAll() {
        return biometryRepo.findAll();
    }

    @Override
    public Page<Biometry> findAllByPage(Pageable pageable) {
        return biometryRepo.findAll(pageable);
    }

    @Override
    public boolean existsById(Long id) {
        return biometryRepo.existsById(id);
    }

    @Override
    public boolean existsLastIsActiveNotTheRoundTimeWorkByUserId(Long userId) {
        return biometryRepo.existsLastIsActiveNotTheRoundTimeWorkByUserId(userId);
    }

    @Override
    public Biometry findLastIsActiveNotTheRoundTimeWorkByUserId(Long userId) {
        return biometryRepo.findLastIsActiveNotTheRoundTimeWorkByUserId(userId);
    }
}
