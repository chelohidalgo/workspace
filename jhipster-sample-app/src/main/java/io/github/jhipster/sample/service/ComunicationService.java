package io.github.jhipster.sample.service;

import io.github.jhipster.sample.domain.Comunication;
import io.github.jhipster.sample.domain.ComunicationHistory;
import io.github.jhipster.sample.repository.ComunicationHistoryRepository;
import io.github.jhipster.sample.repository.ComunicationRepository;
import io.github.jhipster.sample.service.dto.ComunicationDTO;
import io.github.jhipster.sample.service.dto.Filters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;


/**
 * Service Implementation for managing Comunication.
 */
@Service
@Transactional
public class ComunicationService {

    private final Logger log = LoggerFactory.getLogger(ComunicationService.class);

    private final ComunicationRepository comunicationRepository;

    private final ComunicationHistoryRepository comunicationHistoryRepository;

    public ComunicationService(ComunicationRepository comunicationRepository, ComunicationHistoryRepository comunicationHistoryRepository) {
        this.comunicationRepository = comunicationRepository;
        this.comunicationHistoryRepository = comunicationHistoryRepository;
    }

    /**
     * Save a comunication.
     *
     * @param comunicationDTO the entity to save
     * @return the persisted entity
     */
    public Comunication save(ComunicationDTO comunicationDTO) {
        log.debug("Request to save Comunication : {}", comunicationDTO);
        Comunication comunication = new Comunication(comunicationDTO.getId(), comunicationDTO.getProtocol(), comunicationDTO.getProducer(), comunicationDTO.getType(), comunicationDTO.getStatus(), comunicationDTO.getDescription(), comunicationDTO.getDateCreated());
        comunication = comunicationRepository.save(comunication);
        ComunicationHistory comunicationHistory = new ComunicationHistory(comunicationDTO.getProtocol(), comunicationDTO.getStatus(), comunicationDTO.getResponse(), LocalDate.now(), comunication);
        comunicationHistoryRepository.save(comunicationHistory);
        return comunication;

    }

    /**
     * Get all the comunications.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Comunication> findAll(Pageable pageable) {
        log.debug("Request to get all Comunications");
        return comunicationRepository.findAll(pageable);
    }

    /**
     * Get all the comunications by producer, protocol, startDate and endDate.
     *
     * @param pageable the pagination information
     * @return the list of entities
     */
    @Transactional(readOnly = true)
    public Page<Comunication> findByFilters(Filters filters, Pageable pageable) {
        log.debug("Request to get all Comunications");
        if (filters.getProtocol() != null && filters.getProducer() != null && filters.getProducer().length() > 0 && filters.getStatus() != null && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 0");
            return comunicationRepository.findByProtocolAndProducerAndStatusAndDateCreatedBetween(
                Long.valueOf(filters.getProtocol()), filters.getProducer(), filters.getStatus(), convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getProtocol() != null && filters.getProducer() != null && filters.getProducer().length() > 0 && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 1");
            return comunicationRepository.findByProtocolAndProducerAndDateCreatedBetween(Long.valueOf(filters.getProtocol()),
                filters.getProducer(), convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getProtocol() != null && filters.getStatus() != null && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 2");
            return comunicationRepository.findByProtocolAndStatusAndDateCreatedBetween(Long.valueOf(filters.getProtocol()), filters.getStatus(),
                convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getProducer() != null && filters.getProducer().length() > 0 && filters.getStatus() != null && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 3");
            return comunicationRepository.findByProducerAndStatusAndDateCreatedBetween(filters.getProducer(), filters.getStatus(),
                convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getProtocol() != null && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 4");
            return comunicationRepository.findByProtocolAndDateCreatedBetween(Long.valueOf(filters.getProtocol()),
                convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getProducer() != null && filters.getProducer().length() > 0 && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 5");
            return comunicationRepository.findByProducerAndDateCreatedBetween(filters.getProducer(),
                convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getStatus() != null && filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 6");
            return comunicationRepository.findByStatusAndDateCreatedBetween(filters.getStatus(), convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        } else if (filters.getStartDate() != null && filters.getEndDate() != null) {
            log.debug("Request 7");
            return comunicationRepository.findByDateCreatedBetween(convertDate(filters.getStartDate()), convertDate(filters.getEndDate()), pageable);
        }
        return null;
    }

    /**
     * Get one comunication by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Transactional(readOnly = true)
    public Comunication findOne(Long id) {
        log.debug("Request to get Comunication : {}", id);
        return comunicationRepository.findOne(id);
    }

    /**
     * Delete the  comunication by id.
     *
     * @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Comunication : {}", id);
        comunicationRepository.delete(id);
    }

    private LocalDate convertDate(String date) {
        LocalDate localDate = LocalDate.parse(date);
        return localDate;
    }
}
