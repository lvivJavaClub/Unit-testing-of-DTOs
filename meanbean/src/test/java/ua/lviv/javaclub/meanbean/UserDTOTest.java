package ua.lviv.javaclub.meanbean;


import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanVerifier;

class UserDTOTest {

  @Test
  void verifyBean() {
    BeanVerifier.verifyBean(UserDTO.class);

//    BeanVerifier.forClass(UserDTO.class).
//        verifyGettersAndSetters()
//        .verifyEqualsAndHashCode()
//        .verifyToString();
  }

  @Test
  void forClass() {
    BeanVerifier.forClass(UserDTO.class)
        .editSettings()
        .addIgnoredProperty(UserDTO::getPassword)
        .edited()
        .verifyGettersAndSetters()
        .verifyEqualsAndHashCode()
        .verifyToString();
  }
} 
