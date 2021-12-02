package br.com.iateclubedebrasilia.api.dto;


import br.com.iateclubedebrasilia.api.domain.enums.Perfil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.services.validation.UsuarioUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;


@Builder
@Data
@AllArgsConstructor
@UsuarioUpdate
public class UsuarioDTO {

    private Integer id;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="E-mail inválido")
    private String email;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;


    public UsuarioDTO(Usuario obj) {
        this.id = obj.getUsuIden();
        this.email = obj.getEmail();
        this.nome = obj.getNome();
    }

}
