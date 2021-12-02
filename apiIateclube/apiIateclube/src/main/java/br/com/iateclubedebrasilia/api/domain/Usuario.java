package br.com.iateclubedebrasilia.api.domain;

import br.com.iateclubedebrasilia.api.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "USUARIOS", schema = "dbo")
@Builder
@Getter
@Setter
@AllArgsConstructor
/*@JsonIdentityInfo(scope = br.com.iateclubedebrasilia.api.domain.Usuario.class,
		generator = ObjectIdGenerators.PropertyGenerator.class,
		property = "usuIden")*/
public class Usuario {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "usu_iden")
	private Integer usuIden;

	@Column(name = "usu_nome")
	private String nome;
	
	@Column(name = "usu_email", unique=true)
	private String email;

	@Column(name = "usu_cpf_cnpj", unique=true)
	private String cpfOuCnpj;

	@JsonIgnore
	@Column(name = "usu_senha")
	private String senha;

	@JsonIgnore
	@Column(name = "usu_dta_hora")
	@CreationTimestamp
	private LocalDateTime dtaHora;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "usu_usu_iden", referencedColumnName = "usu_iden")
	private Usuario usuario;

	@ElementCollection(fetch=FetchType.EAGER)
	@CollectionTable(name="PERFIS")
	private Set<Integer> perfis = new HashSet<>();
	
	public Usuario() {
		addPerfil(Perfil.USUARIO);
	}

	public Usuario(Integer id, String nome, String email, String cpfOuCnpj, String senha) {
		super();
		this.usuIden = id;
		this.nome = nome;
		this.email = email;
		this.cpfOuCnpj = cpfOuCnpj;
		this.senha = senha;
		addPerfil(Perfil.USUARIO);
	}

	public Set<Perfil> getPerfis() {
		return perfis.stream().map(x -> Perfil.toEnum(x)).collect(Collectors.toSet());
	}

	public void addPerfil(Perfil perfil) {
		perfis.add(perfil.getCod());
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((usuIden == null) ? 0 : usuIden.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		if (usuIden == null) {
			if (other.usuIden != null)
				return false;
		} else if (!usuIden.equals(other.usuIden))
			return false;
		return true;
	}	
}
