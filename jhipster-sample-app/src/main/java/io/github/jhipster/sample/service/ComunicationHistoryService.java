package io.github.jhipster.sample.service;

import io.github.jhipster.sample.domain.ComunicationHistory;
import io.github.jhipster.sample.repository.ComunicationHistoryRepository;
import io.github.jhipster.sample.repository.ComunicationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing Comunication_History.
 */
@Service
@Transactional
public class ComunicationHistoryService {

    private final Logger log = LoggerFactory.getLogger(ComunicationHistoryService.class);

    private final ComunicationHistoryRepository comunicationHistoryRepository;

    private final ComunicationRepository comunicationRepository;

    public ComunicationHistoryService(ComunicationHistoryRepository comunicationHistoryRepository, ComunicationRepository comunicationRepository) {
        this.comunicationHistoryRepository = comunicationHistoryRepository;
        this.comunicationRepository = comunicationRepository;
    }

    /**
     * Save a comunication.
     *
     * @param comunicationHistory the entity to save
     * @return the persisted entity
     */
    public ComunicationHistory save(ComunicationHistory comunicationHistory) {
        log.debug("Request to save Comunication history: {}", comunicationHistory);
        comunicationRepository.save(comunicationHistory.getComunication());
        return comunicationHistoryRepository.save(comunicationHistory);
    }

}
