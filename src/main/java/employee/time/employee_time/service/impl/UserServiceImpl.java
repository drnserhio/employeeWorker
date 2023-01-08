package employee.time.employee_time.service.impl;

import employee.time.employee_time.model.User;
import employee.time.employee_time.repo.UserRepo;
import employee.time.employee_time.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description: user service impl
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:12
 **/

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;

    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public void update(User user) {
        userRepo.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepo.findById(id);
    }

    @Override
    public List<User> findAll() {
        return userRepo.findAll();
    }

    @Override
    public Page<User> findAllByPage(Pageable pageable) {
        return userRepo.findAll(pageable);
    }

    @Override
    public boolean existsById(Long id) {
        return userRepo.existsById(id);
    }

    @Override
    public Page<Long> findAllIdsByPage(Pageable pageable) {
        return userRepo.findAllIdsByPage(pageable);
    }
}
