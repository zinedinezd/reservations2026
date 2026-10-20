package be.iccbxl.pid.reservation2026.validation;

import be.iccbxl.pid.reservation2026.dto.UserProfileDto;
import be.iccbxl.pid.reservation2026.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        String password;
        String confirmPassword;

        if (obj instanceof UserRegistrationDto dto) {
            password = dto.getPassword();
            confirmPassword = dto.getConfirmPassword();
        } else if (obj instanceof UserProfileDto dto) {
            password = dto.getPassword();
            confirmPassword = dto.getConfirmPassword();
        } else {
            return false;
        }

        if (password == null || confirmPassword == null) {
            return false;
        }

        return password.equals(confirmPassword);
    }
}