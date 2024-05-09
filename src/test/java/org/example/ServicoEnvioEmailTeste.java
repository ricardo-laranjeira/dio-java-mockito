package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ServicoEnvioEmailTeste {

    @Mock
    private PlataformaEnvio plataformaEnvio;

    @InjectMocks
    private ServicoEnvioEmail servicoEnvioEmail;

    @Captor
    private ArgumentCaptor<Email> captor;

    @Test
    void validarDadosEnviadosParaPlataforma(){

        String enderecoEmail = "teste@teste.com";
        String mensagem = "Hello world.";
        boolean ehFormatoHTML = false;

        servicoEnvioEmail.enviaEmail(enderecoEmail, mensagem, ehFormatoHTML);

        Mockito.verify(plataformaEnvio).enviaEmail(captor.capture());

        Email emailCapturado = captor.getValue();
        Assertions.assertEquals(enderecoEmail, emailCapturado.getEnderecoEmail());
        Assertions.assertEquals(enderecoEmail, emailCapturado.getMensagem());

    }
}
