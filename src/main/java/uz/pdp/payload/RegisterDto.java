package uz.pdp.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RegisterDto {

    @NotNull
    @Size(min = 3, max = 50)
    private String firstName;//ismi
    @NotNull
    @Length(min = 3, max = 50)
    private String lastName;//familiyasi
    @NotNull
    @Email
    private String username;//userning emaili(USERNAME SIFATIDA )

    @NotNull
    private String password;//kalit so'zi
}
