package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.mockito.ArgumentMatchers.anyString;

@ExtendWith(MockitoExtension.class)
public class CadastrarPessoaTeste {

    @Mock
    private ApiCorreios apiCorreios;

    @InjectMocks
    private CadastrarPessoa cadastrarPessoa;

    @Test
    void validarDadosCadsatro(){
        Mockito.when(apiCorreios.buscaDadosCOmBaseNoCep("17520-130"))
                .thenReturn(new DadosLocalizacao("SP", "Marilia", "Avenida Antartica", "Casa", "Jardim Vitoria"));
        Pessoa pessoa = cadastrarPessoa.cadastrarPessoa("Ronaldo", "cpf", LocalDate.now(), "17520-130");

        Assertions.assertEquals("Ronaldo", pessoa.getNome());
        Assertions.assertEquals("cpf", pessoa.getDocumento());
        Assertions.assertEquals("SP", pessoa.getEndereco().getUf());
    }

    @Test
    void lancarExcecaoChamadaApiCorreios(){
        Mockito.when(apiCorreios.buscaDadosCOmBaseNoCep(anyString())).thenThrow(IllegalArgumentException.class);

        Assertions.assertThrows(IllegalArgumentException.class, () -> cadastrarPessoa
                .cadastrarPessoa("Ronaldo", "cpf", LocalDate.now(), "17520-130"));
    }
}
