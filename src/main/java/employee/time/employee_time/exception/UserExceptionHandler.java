package employee.time.employee_time.exception;

import employee.time.employee_time.exception.domain.UserException;
import employee.time.employee_time.service.UserService;
import lombok.AllArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Component;

/**
 * @Description: UserExceptionHandler
 * @Author: Serhio Duran
 * @create: 2023-01-03-22:26
 **/

@Component
@AllArgsConstructor
public class UserExceptionHandler {

    private final UserService userService;

    public void throwExceptionIfUserIdIsNotValid(Long userId)
            throws UserException {
        if (ObjectUtils.isEmpty(userId)) {
            throw new UserException("User id is null, or empty.");
        }
    }

    public void throwExceptionIfUserIdIsNotExists(Long userId)
            throws UserException {
        if (!userService.existsById(userId)) {
            throw new UserException("User with id: " + userId + " is not exists.");
        }
    }
}
