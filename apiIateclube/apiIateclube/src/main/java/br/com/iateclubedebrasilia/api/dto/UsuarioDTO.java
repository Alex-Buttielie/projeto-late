package br.com.iateclubedebrasilia.api.dto;


import br.com.iateclubedebrasilia.api.domain.Grupo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import br.com.iateclubedebrasilia.api.domain.Usuario;
import br.com.iateclubedebrasilia.api.services.validation.UsuarioUpdate;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;

@Builder
@Data
//@NoArgsConstructor
@AllArgsConstructor
@UsuarioUpdate
public class UsuarioDTO {

    private Integer id;
    private String login;
    private String senha;
    private Collection<Grupo> gruposUsuario;

    @NotEmpty(message="Preenchimento obrigatório")
    @Email(message="Email inválido")
    private String email;

    @NotEmpty(message="Preenchimento obrigatório")
    @Length(min=5, max=120, message="O tamanho deve ser entre 5 e 120 caracteres")
    private String nome;


    public UsuarioDTO(Usuario obj) {
        this.id = obj.getId();
        this.email = obj.getEmail();
        this.nome = obj.getNome();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
