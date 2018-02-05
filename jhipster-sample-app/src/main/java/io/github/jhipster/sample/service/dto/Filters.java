package io.github.jhipster.sample.service.dto;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDate;

public class Filters {

    @Size(max = 50)
    private String protocol;

    @Size(max = 50)
    private String producer;

    @Size(max = 25)
    private String status;

    private String startDate;

    private String endDate;

    public Filters() {
    }

    public String getProtocol() {
        return protocol;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
