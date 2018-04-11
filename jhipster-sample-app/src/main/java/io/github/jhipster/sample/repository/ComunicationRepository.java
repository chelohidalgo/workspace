package io.github.jhipster.sample.repository;

import io.github.jhipster.sample.domain.Comunication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;


/**
 * Spring Data JPA repository for the Comunication entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ComunicationRepository extends JpaRepository<Comunication, Long> {

    Page<Comunication> findByProtocolAndProducerAndDateCreatedBetween(Long protocol, String producer, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByProtocolAndDateCreatedBetween(Long protocol, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByProducerAndDateCreatedBetween(String producer, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByDateCreatedBetween(LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByProtocolAndProducerAndStatusAndDateCreatedBetween(Long protocol, String producer, String status, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByProtocolAndStatusAndDateCreatedBetween(Long protocol, String status, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByProducerAndStatusAndDateCreatedBetween(String producer, String status, LocalDate startDate, LocalDate endDate, Pageable pageable);

    Page<Comunication> findByStatusAndDateCreatedBetween(String status, LocalDate startDate, LocalDate endDate, Pageable pageable);
}
