package br.com.zup.consomeviacep.messaging;

import br.com.zup.consomeviacep.domain.Endereco;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.model.SendMessageRequest;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PublicadorDeEndereco {

    private final AmazonSQS amazonSQS;
    private final ObjectMapper objectMapper;

    /**
     * @SneakyThrows pode ser usado para lançar exceções verificadas
     * sem realmente declarar isso na throws cláusula do seu método
     */

    @SneakyThrows
    public void publicar(final Endereco endereco) {
        String queueUrl = amazonSQS.getQueueUrl("fila_enderecos").getQueueUrl();

        SendMessageRequest send_msg_request = new SendMessageRequest()
                .withQueueUrl(queueUrl)
                .withMessageBody(objectMapper.writeValueAsString(endereco))
                .withDelaySeconds(5);

        amazonSQS.sendMessage(send_msg_request);
    }

}
