package io.github.jhipster.sample.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

/**
 * A Comunication.
 */
@Entity
@Table(name = "comunication_history")
public class ComunicationHistory {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "protocol", nullable = false)
    private Long protocol;

    @NotNull
    @Size(min = 4, max = 25)
    @Column(name = "status", length = 25, nullable = false)
    private String status;


    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "register_date", nullable = false)
    private LocalDate registerDate;

    @ManyToOne
    @JsonIgnore
    private Comunication comunication;

    public ComunicationHistory() {
    }

    public ComunicationHistory(Long protocol, String status, String description, LocalDate registerDate, Comunication comunication) {
        this.protocol = protocol;
        this.status = status;
        this.description = description;
        this.registerDate = registerDate;
        this.comunication = comunication;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getProtocol() {
        return protocol;
    }

    public void setProtocol(Long protocol) {
        this.protocol = protocol;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public Comunication getComunication() {
        return comunication;
    }

    public void setComunication(Comunication comunication) {
        this.comunication = comunication;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ComunicationHistory that = (ComunicationHistory) o;

        if (!id.equals(that.id)) return false;
        if (!protocol.equals(that.protocol)) return false;
        if (status != null ? !status.equals(that.status) : that.status != null) return false;
        if (description != null ? !description.equals(that.description) : that.description != null) return false;
        return registerDate != null ? registerDate.equals(that.registerDate) : that.registerDate == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (protocol != null ? protocol.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        result = 31 * result + (registerDate != null ? registerDate.hashCode() : 0);
        result = 31 * result + (comunication != null ? comunication.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ComunicationHistory{" +
            "id=" + id +
            ", protocol=" + protocol +
            ", status='" + status + '\'' +
            ", description='" + description + '\'' +
            ", registerDate=" + registerDate +
            '}';
    }
}
