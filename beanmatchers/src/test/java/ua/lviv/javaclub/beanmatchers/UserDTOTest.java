package ua.lviv.javaclub.beanmatchers;

import org.junit.jupiter.api.Test;

import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanConstructor;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanEquals;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanHashCode;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToString;
import static com.google.code.beanmatchers.BeanMatchers.hasValidBeanToStringExcluding;
import static com.google.code.beanmatchers.BeanMatchers.hasValidGettersAndSetters;
import static com.google.code.beanmatchers.BeanMatchers.isABeanWithValidGettersAndSetters;

import static org.hamcrest.CoreMatchers.allOf;
import static org.hamcrest.MatcherAssert.assertThat;

class UserDTOTest {

  @Test
  void test() {
    assertThat(UserDTO.class, allOf(
        hasValidBeanConstructor(),
        hasValidBeanEquals(),
        hasValidGettersAndSetters(),
        hasValidBeanHashCode(),
        hasValidBeanToStringExcluding("password")));
  }
} 
