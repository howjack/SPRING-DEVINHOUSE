package com.devinhouse.vilacate.consumers;

import com.devinhouse.vilacate.Exceptions.MessageException;
import com.devinhouse.vilacate.model.dto.FinancialDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    //Sete para true, para testar as 3 tentativas de envio de mensagem
    private final Boolean testDeadLetterAndRetryMessage = true;
    
    private static final Logger logger = LoggerFactory.getLogger(RabbitMQConsumer.class);

    @RabbitListener(queues = "acate.generate.pdf")
    public void getFinancial(FinancialDto financialDto) throws MessageException {
        if (testDeadLetterAndRetryMessage){
            logger.error("Falha ao tentar Gerar o pdf");
            throw new MessageException();
        }

        logger.info("Recebendo o relatorio financeiro e gerando pdf");
        System.out.println(financialDto);

    }
}
