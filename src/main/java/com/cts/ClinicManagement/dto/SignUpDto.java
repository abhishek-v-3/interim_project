package com.cts.ClinicManagement.dto;

// import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SignUpDto {

    @NotNull(message = "Phone number cannot be null")
    @Pattern(regexp = "\\d{10}", message = "Phone number should be 10 digits")
    private Long phoneNumber;

    // @Email(message = "Email should be valid")
    // private String email;

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 8, max = 32, message = "Password should have minimum 8 and maximum 32 characters")
    private String password;
}
