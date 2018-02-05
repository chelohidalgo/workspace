package io.github.jhipster.sample.repository;

import io.github.jhipster.sample.domain.ComunicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComunicationHistoryRepository extends JpaRepository<ComunicationHistory, Long> {


}
