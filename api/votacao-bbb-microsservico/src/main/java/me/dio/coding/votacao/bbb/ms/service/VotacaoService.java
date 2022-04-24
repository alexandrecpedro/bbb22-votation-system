package me.dio.coding.votacao.bbb.ms.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.dio.coding.votacao.bbb.ms.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.ms.model.VotacaoModel;
import me.dio.coding.votacao.bbb.ms.repository.VotacaoRepository;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
@AllArgsConstructor
public class VotacaoService {

    //Acessando o BD
    private final VotacaoRepository repository;

    //Method

    // Kafka Listener
    @KafkaListener(topics = "votacao", groupId = "MicroServicoVotacao")
    private void executar(ConsumerRecord<String, String> registro) {

        // Recebendo o voto
        String participanteStr = registro.value();
        log.info("Voto recebido = {}", participanteStr);

        // Deserializando o JSON e convertendo para String
        ObjectMapper mapper = new ObjectMapper();
        ParticipanteModel participante = null;

        try {
            participante = mapper.readValue(participanteStr, ParticipanteModel.class);
        } catch (JsonProcessingException ex) {
            log.error("Falha ao converter voto [{}]", participanteStr, ex);
            return;
        }

        // Gravando o voto
        VotacaoModel votacao = new VotacaoModel(null, participante, new Date());
        VotacaoModel entity = repository.save(votacao);

        log.info("Voto registrado com sucesso [id={}, dataHora={}]", entity.getId(), entity.getDataHora());
    }
}
