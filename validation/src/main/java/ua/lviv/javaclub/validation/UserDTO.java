package ua.lviv.javaclub.validation;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {
  @NotNull
  private String username;
  @NotNull
  @Size(min = 5, max = 10)
  private String password;

  @AssertTrue(message = "password is prohibited password")
  public boolean isPassword() {
    return password != null && !password.equalsIgnoreCase("password");
  }
}
