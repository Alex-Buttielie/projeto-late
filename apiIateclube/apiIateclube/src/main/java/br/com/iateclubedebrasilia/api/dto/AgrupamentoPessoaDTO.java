package br.com.iateclubedebrasilia.api.dto;

import br.com.iateclubedebrasilia.api.domain.Pessoa;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgrupamentoPessoaDTO {

    private Pessoa pessoaOrigem;

    private Pessoa pessoaAgrupada;
}
