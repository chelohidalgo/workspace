package io.github.jhipster.sample.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.google.gson.Gson;
import io.github.jhipster.sample.domain.Comunication;
import io.github.jhipster.sample.domain.ComunicationHistory;
import io.github.jhipster.sample.service.ComunicationHistoryService;
import io.github.jhipster.sample.service.ComunicationService;
import io.github.jhipster.sample.service.dto.ComunicationDTO;
import io.github.jhipster.sample.service.dto.Filters;
import io.github.jhipster.sample.web.rest.errors.BadRequestAlertException;
import io.github.jhipster.sample.web.rest.util.HeaderUtil;
import io.github.jhipster.sample.web.rest.util.PaginationUtil;
import io.github.jhipster.web.util.ResponseUtil;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing Comunication.
 */
@RestController
@RequestMapping("/api")
public class ComunicationResource {

    private final Logger log = LoggerFactory.getLogger(ComunicationResource.class);

    private static final String ENTITY_NAME = "comunication";
    private static final String ENTITY_NAME_HISTORY = "comunication_history";

    private final ComunicationService comunicationService;

    private final ComunicationHistoryService comunicationHistoryService;

    public ComunicationResource(ComunicationService comunicationService, ComunicationHistoryService comunicationHistoryService) {
        this.comunicationService = comunicationService;
        this.comunicationHistoryService = comunicationHistoryService;
    }

    /**
     * POST  /comunications : Create a new comunication.
     *
     * @param comunicationDTO the comunication to create
     * @return the ResponseEntity with status 201 (Created) and with body the new comunication, or with status 400 (Bad Request) if the comunication has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/comunications")
    @Timed
    public ResponseEntity<Comunication> createComunication(@Valid @RequestBody ComunicationDTO comunicationDTO) throws URISyntaxException {
        log.debug("REST request to save Comunication : {}", comunicationDTO);
        if (comunicationDTO.getId() != null) {
            throw new BadRequestAlertException("A new comunication cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Comunication result = comunicationService.save(comunicationDTO);
        return ResponseEntity.created(new URI("/api/comunications/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

//    /**
//     * POST  /comunications/response : To register the response for the comunication.
//     *
//     * @param comunicationDTO the comunication to create
//     * @return the ResponseEntity with status 201 (Created) and with body the new comunication, or with status 400 (Bad Request) if the comunication has already an ID
//     * @throws URISyntaxException if the Location URI syntax is incorrect
//     */
//    @PostMapping("/comunications/response")
//    @Timed
//    public ResponseEntity<ComunicationHistory> registerResponse(@Valid @RequestBody ComunicationDTO comunicationDTO) throws URISyntaxException {
//        log.debug("REST request to save Comunication : {}", comunicationDTO);
//        Comunication comunication = new Comunication(comunicationDTO.getId(), comunicationDTO.getProtocol(), comunicationDTO.getProducer(), comunicationDTO.getType(), comunicationDTO.getStatus(), comunicationDTO.getDescription(), comunicationDTO.getDateCreated());
//        ComunicationHistory comunicationHistory = new ComunicationHistory(comunicationDTO.getProtocol(), comunicationDTO.getStatus(), comunicationDTO.getResponse() , LocalDate.now(), comunication);
//        ComunicationHistory result = comunicationHistoryService.save(comunicationHistory);
//        return ResponseEntity.created(new URI("/api/comunications/response" + result.getId()))
//            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME_HISTORY, result.getId().toString()))
//            .body(result);
//    }

    /**
     * PUT  /comunications : Updates an existing comunication.
     *
     * @param comunicationDTO the comunication to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated comunication,
     * or with status 400 (Bad Request) if the comunication is not valid,
     * or with status 500 (Internal Server Error) if the comunication couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/comunications")
    @Timed
    public ResponseEntity<Comunication> updateComunication(@Valid @RequestBody ComunicationDTO comunicationDTO) throws URISyntaxException {
        log.debug("REST request to update Comunication : {}", comunicationDTO);
        if (comunicationDTO.getId() == null) {
            return createComunication(comunicationDTO);
        }
        Comunication result = comunicationService.save(comunicationDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, comunicationDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /comunications : get all the comunications.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of comunications in body
     */
    @GetMapping("/comunications")
    @Timed
    public ResponseEntity<List<Comunication>> getAllComunications(@ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Comunications");
        Page<Comunication> page = comunicationService.findAll(pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/comunications");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /comunications : get all the comunications between the fromDate and toDate.
     *
     * @param pageable the pagination information
     * @return the ResponseEntity with status 200 (OK) and the list of comunications in body
     */
    @GetMapping(path="/comunications/filters", params = "filters")
    public ResponseEntity<List<Comunication>> getAllComunicationsByFilters(@RequestParam String filters, @ApiParam Pageable pageable) {
        log.debug("REST request to get a page of Comunications");
        Gson g = new Gson();
        Filters filtersObj = g.fromJson(filters, Filters.class);
        Page<Comunication> page = comunicationService.findByFilters(filtersObj, pageable);
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(page, "/api/comunications");
        return new ResponseEntity<>(page.getContent(), headers, HttpStatus.OK);
    }

    /**
     * GET  /comunications/:id : get the "id" comunication.
     *
     * @param id the id of the comunication to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the comunication, or with status 404 (Not Found)
     */
    @GetMapping("/comunications/{id}")
    @Timed
    public ResponseEntity<Comunication> getComunication(@PathVariable Long id) {
        log.debug("REST request to get Comunication : {}", id);
        Comunication comunication = comunicationService.findOne(id);
        return ResponseUtil.wrapOrNotFound(Optional.ofNullable(comunication));
    }

    /**
     * DELETE  /comunications/:id : delete the "id" comunication.
     *
     * @param id the id of the comunication to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/comunications/{id}")
    @Timed
    public ResponseEntity<Void> deleteComunication(@PathVariable Long id) {
        log.debug("REST request to delete Comunication : {}", id);
        comunicationService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
