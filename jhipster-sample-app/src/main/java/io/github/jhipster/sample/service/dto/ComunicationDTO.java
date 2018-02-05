package io.github.jhipster.sample.service.dto;

import io.github.jhipster.sample.domain.Comunication;

public class ComunicationDTO extends Comunication{

    private String response;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
