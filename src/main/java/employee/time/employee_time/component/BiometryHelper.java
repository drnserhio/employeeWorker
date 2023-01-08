package employee.time.employee_time.component;

import employee.time.employee_time.exception.domain.BiometryException;
import employee.time.employee_time.model.Biometry;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * @Description: helper biometry
 * @Author: Serhio Duran
 * @create: 2023-01-03-23:19
 **/

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class BiometryHelper {

    private static Biometry frmBiometryRoundTheClockByOpenAndCloseTime(LocalTime openDate, LocalTime closeDate, Long userId, Long storeId, LocalTime now)
            throws BiometryException {
        Biometry biometry = new Biometry();
        if (now.equals(closeDate)
                || now.isAfter(closeDate)) {
            throw new BiometryException("You can't start work in this time. Start time: " + openDate + " and close: " + closeDate + ".");
        }
        biometry.setUserId(userId);
        biometry.setStoreId(storeId);
        biometry.setIsActive(true);
        biometry.setTimeStamp(LocalDateTime.now());

        return biometry;
    }

    private static Biometry frmBiometryNotRoundTheClockByOpenAndCloseTime(LocalTime openDate, LocalTime closeDate, Long userId, Long storeId, LocalTime now)
            throws BiometryException {
        Biometry biometry = new Biometry();
        if ((now.isBefore(openDate) || now.isAfter(closeDate))) {
            throw new BiometryException("You can't start work in this time. Start time: " + openDate + " and close: " + closeDate + ".");
        }
        biometry.setUserId(userId);
        biometry.setStoreId(storeId);
        biometry.setIsActive(true);
        return biometry;
    }

    public static Biometry frmBiometryByParam(Boolean isRoundTheClock, LocalTime openDate, LocalTime closeDate, Long userId, Long storeId, LocalTime now)
            throws BiometryException {
        if (isRoundTheClock) {
            return BiometryHelper.frmBiometryRoundTheClockByOpenAndCloseTime(openDate, closeDate, userId, storeId, now);
        } else {
            return BiometryHelper.frmBiometryNotRoundTheClockByOpenAndCloseTime(openDate, closeDate, userId, storeId, now);
        }
    }

    public static Biometry frmCloseBiometry(Long storeId, Long userId) {
        Biometry biometry = new Biometry();
        biometry.setIsActive(false);
        biometry.setStoreId(storeId);
        biometry.setUserId(userId);
        biometry.setTimeStamp(LocalDateTime.now());
        return biometry;
    }
}
