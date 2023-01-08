package employee.time.employee_time.facade.impl;

import employee.time.employee_time.facade.StoreFacade;
import employee.time.employee_time.model.Store;
import employee.time.employee_time.service.StoreService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @Description: store facade impl
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:16
 **/

@Service
@AllArgsConstructor
public class StoreFacadeImpl implements StoreFacade {

    private final StoreService storeService;


    @Override
    public Page<Store> findAll(int page, int size) {
        return storeService.findAllByPage(PageRequest.of(page, size));
    }
}
