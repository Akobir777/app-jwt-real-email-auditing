package uz.pdp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {

    @NotNull
    @Email
    private String username;//userning emaili(USERNAME SIFATIDA )

    @NotNull
    private String password;//kalit so'zi
}
