package br.com.cauabernardo.gestao_de_vagas.modules.candidate;

import java.util.UUID;

import org.hibernate.validator.constraints.Length;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class CandidateEntity {

    private UUID id;
    private String name;

    @NotBlank(message = "O campo [username] não pode estar em branco")
    @Pattern(regexp = "^[^\\s]+$", message = "O campo [username] não deve conter espaços") // Validação com expressão regular
    private String username;

    @Email(message = "O campo [email] deve conter um e-mail válido") // Validação
    private String email;

    @Length(min = 8, max = 100, message = "A senha deve conter entre 8 e 100 caracteres") // Validação
    private String password;
    private String phone;
    private String description;
    private String curriculum;
}
