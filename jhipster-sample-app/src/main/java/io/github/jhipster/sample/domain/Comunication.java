package io.github.jhipster.sample.domain;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * A Comunication.
 */
@Entity
@Table(name = "comunication")
@Cache(usage = CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
public class Comunication implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "protocol", nullable = false)
    private Long protocol;

    @NotNull
    @Size(min = 5, max = 50)
    @Column(name = "producer", length = 50, nullable = false)
    private String producer;

    @NotNull
    @Size(min = 5, max = 25)
    @Column(name = "jhi_type", length = 25, nullable = false)
    private String type;

    @NotNull
    @Size(min = 4, max = 25)
    @Column(name = "status", length = 25, nullable = false)
    private String status;

    @NotNull
    @Size(min = 5, max = 300)
    @Column(name = "description", length = 300, nullable = false)
    private String description;

    @NotNull
    @Column(name = "date_created", nullable = false)
    private LocalDate dateCreated;

    @OneToMany(mappedBy = "comunication", fetch = FetchType.EAGER)
    private List<ComunicationHistory> comunicationHistories;

    public Comunication() {
    }

    public Comunication(Long id, Long protocol, String producer, String type, String status, String description, LocalDate dateCreated) {
        this.id = id;
        this.protocol = protocol;
        this.producer = producer;
        this.type = type;
        this.status = status;
        this.description = description;
        this.dateCreated = dateCreated;
    }

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProtocol() {
        return protocol;
    }

    public Comunication protocol(Long protocol) {
        this.protocol = protocol;
        return this;
    }

    public void setProtocol(Long protocol) {
        this.protocol = protocol;
    }

    public String getProducer() {
        return producer;
    }

    public Comunication producer(String producer) {
        this.producer = producer;
        return this;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getType() {
        return type;
    }

    public Comunication type(String type) {
        this.type = type;
        return this;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public Comunication status(String status) {
        this.status = status;
        return this;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public Comunication description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDateCreated() {
        return dateCreated;
    }

    public Comunication dateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
        return this;
    }

    public void setDateCreated(LocalDate dateCreated) {
        this.dateCreated = dateCreated;
    }

    public List<ComunicationHistory> getComunicationHistories() {
        return comunicationHistories;
    }

    public void setComunicationHistories(List<ComunicationHistory> comunicationHistories) {
        this.comunicationHistories = comunicationHistories;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Comunication comunication = (Comunication) o;
        if (comunication.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), comunication.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "Comunication{" +
            "id=" + getId() +
            ", protocol='" + getProtocol() + "'" +
            ", producer='" + getProducer() + "'" +
            ", type='" + getType() + "'" +
            ", status='" + getStatus() + "'" +
            ", description='" + getDescription() + "'" +
            ", dateCreated='" + getDateCreated() + "'" +
            "}";
    }
}
