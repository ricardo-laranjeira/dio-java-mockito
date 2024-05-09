package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class EnviarMensagemTeste {

    @Spy
    private EnviarMensagem enviarMensagem;

    @Test
    void verificarComportamentoClasse(){
        Mockito.verifyNoInteractions(enviarMensagem);

        Mensagem msg = new Mensagem("Hello woeld!");
        enviarMensagem.adicionarMensagem(msg);
        Mockito.verify(enviarMensagem).adicionarMensagem(msg);

        Assertions.assertFalse(enviarMensagem.getMensagens().isEmpty());
    }
}
