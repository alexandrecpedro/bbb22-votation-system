package me.dio.coding.votacao.bbb.api.service;

import lombok.AllArgsConstructor;
import me.dio.coding.votacao.bbb.api.model.ParticipanteModel;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class VotacaoService {

    // Attributes
    private static final String TOPICO_VOTACAO = "votacao";

    // Kafka Template (required on constructor)
    private final KafkaTemplate<Object, Object> template;

    // Methods
    public void adicionarEvento(ParticipanteModel participante) {
        template.send(TOPICO_VOTACAO, participante);
    }
}
