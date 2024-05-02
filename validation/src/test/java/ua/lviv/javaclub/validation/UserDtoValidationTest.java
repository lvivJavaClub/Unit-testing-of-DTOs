package ua.lviv.javaclub.validation;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.SneakyThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.lang.reflect.Field;
import java.util.Set;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserDtoValidationTest {

  @Test
  void givenValidDto_whenValidated_thenNoValidationError() {
    UserDTO userDto = new UserDTO("someName", "mypassword");

    try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
      final Validator validator = factory.getValidator();

      Set<ConstraintViolation<UserDTO>> constraintViolations =
          validator.validate(userDto);

      assertTrue(constraintViolations.isEmpty());
    }
  }

  static Stream<Arguments> provideFieldAndInvalidValue() {
    return Stream.of(
        Arguments.of("username", null),
        Arguments.of("password", null),
        Arguments.of("password", "pass"),
        Arguments.of("password", "password"),
        Arguments.of("password", "password-password-password")
    );
  }

  @SneakyThrows
  @ParameterizedTest
  @MethodSource("provideFieldAndInvalidValue")
  void testInvalidDto(String fieldName, Object invalidValue) {
    UserDTO userDto = new UserDTO("someName", "pass");

    Field field = UserDTO.class.getDeclaredField(fieldName);
    field.setAccessible(true);
    field.set(userDto, invalidValue);

    try (ValidatorFactory factory = Validation.buildDefaultValidatorFactory()) {
      final Validator validator = factory.getValidator();

      Set<ConstraintViolation<UserDTO>> constraintViolations =
          validator.validate(userDto);

      assertFalse(constraintViolations.isEmpty());
    }
  }
}
