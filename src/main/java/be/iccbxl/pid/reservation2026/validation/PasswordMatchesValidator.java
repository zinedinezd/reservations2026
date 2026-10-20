package be.iccbxl.pid.reservation2026.validation;

import be.iccbxl.pid.reservation2026.dto.UserProfileDto;
import be.iccbxl.pid.reservation2026.dto.UserRegistrationDto;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator implements ConstraintValidator<PasswordMatches, Object> {

    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context) {
        String pwd;
        String confirm;

        if (obj instanceof UserRegistrationDto dto) {
            pwd = dto.getPassword();
            confirm = dto.getConfirmPassword();
        } else if (obj instanceof UserProfileDto dto) {
            pwd = dto.getPassword();
            confirm = dto.getConfirmPassword();
        } else {
            return false;
        }

        // Si les deux champs sont vides, on considère que le mot de passe n'est pas modifié => OK
        if ((pwd == null || pwd.isBlank()) && (confirm == null || confirm.isBlank())) {
            return true;
        }

        // Sinon, il faut qu'ils soient identiques
        if (pwd == null) return false;

        return pwd.equals(confirm);
    }
}