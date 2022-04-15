package com.example.customvalidation.validator;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import java.util.List;
import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = StringListValidator.class)
public @interface StringList {
    String message() default "max length is {maxChars} characters";

    int maxChars() default 1000;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}

class StringListValidator implements ConstraintValidator<StringList, List<String>> {
    private int maxChars;

    @Override
    public void initialize(StringList constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
        maxChars = constraintAnnotation.maxChars();
    }

    @Override
    public boolean isValid(List<String> listOfString, ConstraintValidatorContext context) {
        final int length = listOfString.stream().mapToInt(String::length).sum();
        return length <= maxChars;
    }
}