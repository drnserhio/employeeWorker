package employee.time.employee_time.exception;

import employee.time.employee_time.exception.domain.StoreException;
import employee.time.employee_time.service.StoreService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

/**
 * @Description: StoreExceptionHandler
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:25
 **/

@Component
@AllArgsConstructor
public class StoreExceptionHandler {

    private final StoreService storeService;

    public void throwExceptionIfStoreIdIsNotValid(Long storeId)
            throws StoreException {
        if (ObjectUtils.isEmpty(storeId)) {
            throw new StoreException("Store id is null, or empty.");
        }
    }

    public void throwExceptionIfStoreIdIsNotExists(Long storeId)
            throws StoreException {
        if (!storeService.existsById(storeId)) {
            throw new StoreException("Store with id: " + storeId + " is not exists.");
        }
    }
}
