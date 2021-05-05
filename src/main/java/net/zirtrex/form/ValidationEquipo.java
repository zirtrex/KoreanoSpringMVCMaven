package net.zirtrex.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import net.zirtrex.entity.Equipo;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.NumberFormat;
import org.springframework.format.annotation.NumberFormat.Style;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class ValidationEquipo implements Validator{
    
    private static final int MINIMUM_NOMBRE_LENGTH = 3;

    @Override
    public boolean supports(Class<?> type) {
        return Equipo.class.isAssignableFrom(type);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Equipo equipo = (Equipo) o;
        if (equipo.getNombre()!= null
             && equipo.getNombre().trim().length() < MINIMUM_NOMBRE_LENGTH) {
            
            errors.rejectValue("nombre", "field.min.length",
                new Object[]{Integer.valueOf(MINIMUM_NOMBRE_LENGTH)},
                "El nombre debe tener al menos [" + MINIMUM_NOMBRE_LENGTH + "] caracteres.");
            
       }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nombre", "nombre.required", "nombre es required");
	ValidationUtils.rejectIfEmptyOrWhitespace(errors, "marca", "marca.required", "marca es required");
    }
	
}
