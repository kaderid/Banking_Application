package com.kader.banking.validators;

import com.kader.banking.exceptions.ObjectValidationException;

public class ObjectsValidator<T> {

    private final ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
    private final Validator validator = factory.getValidator();

    public void validator(T objectToValidate){
        Set<ConstraintValidator<T>> violations = validator.validate(objectToValidate);
        if(!violation.isEmpty()){
            Set<String> errorMessages = violations.stream()
                    .map(ConstraintViolation::getMessage)
                    .collect(Collectors.toSet());
            throw new ObjectValidationException(errorMessages, objectToValidate.getClass().getName());
        }
    }
}
