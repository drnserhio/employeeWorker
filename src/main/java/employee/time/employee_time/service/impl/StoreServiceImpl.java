package employee.time.employee_time.service.impl;

import employee.time.employee_time.model.Store;
import employee.time.employee_time.repo.StoreRepo;
import employee.time.employee_time.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * @Description: store service impl
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:11
 **/

@Service
@AllArgsConstructor
@Transactional
public class StoreServiceImpl implements StoreService {

    public final StoreRepo storeRepo;

    @Override
    public void save(Store store) {
        storeRepo.save(store);
    }

    @Override
    public void update(Store store) {
        storeRepo.save(store);
    }

    @Override
    public Optional<Store> findById(Long id) {
        return storeRepo.findById(id);
    }

    @Override
    public List<Store> findAll() {
        return storeRepo.findAll();
    }

    @Override
    public Page<Store> findAllByPage(Pageable pageable) {
        return storeRepo.findAll(pageable);
    }

    @Override
    public boolean existsById(Long id) {
        return storeRepo.existsById(id);
    }
}
