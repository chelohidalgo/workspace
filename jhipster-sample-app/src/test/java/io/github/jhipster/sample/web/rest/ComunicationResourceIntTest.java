package io.github.jhipster.sample.web.rest;

import io.github.jhipster.sample.JhipsterSampleApplicationApp;

import io.github.jhipster.sample.domain.Comunication;
import io.github.jhipster.sample.repository.ComunicationHistoryRepository;
import io.github.jhipster.sample.repository.ComunicationRepository;
import io.github.jhipster.sample.service.ComunicationHistoryService;
import io.github.jhipster.sample.service.ComunicationService;
import io.github.jhipster.sample.web.rest.errors.ExceptionTranslator;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import static io.github.jhipster.sample.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for the ComunicationResource REST controller.
 *
 * @see ComunicationResource
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JhipsterSampleApplicationApp.class)
public class ComunicationResourceIntTest {

    private static final Long DEFAULT_PROTOCOL = 1L;
    private static final Long UPDATED_PROTOCOL = 2L;

    private static final String DEFAULT_PRODUCER = "AAAAAAAAAA";
    private static final String UPDATED_PRODUCER = "BBBBBBBBBB";

    private static final String DEFAULT_TYPE = "AAAAAAAAAA";
    private static final String UPDATED_TYPE = "BBBBBBBBBB";

    private static final String DEFAULT_STATUS = "AAAAAAAAAA";
    private static final String UPDATED_STATUS = "BBBBBBBBBB";

    private static final String DEFAULT_DESCRIPTION = "AAAAAAAAAA";
    private static final String UPDATED_DESCRIPTION = "BBBBBBBBBB";

    private static final LocalDate DEFAULT_DATE_CREATED = LocalDate.ofEpochDay(0L);
    private static final LocalDate UPDATED_DATE_CREATED = LocalDate.now(ZoneId.systemDefault());

    @Autowired
    private ComunicationRepository comunicationRepository;

    @Autowired
    private ComunicationService comunicationService;

    @Autowired
    private ComunicationHistoryService comunicationHistoryService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private EntityManager em;

    private MockMvc restComunicationMockMvc;

    private Comunication comunication;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final ComunicationResource comunicationResource = new ComunicationResource(comunicationService, comunicationHistoryService);
        this.restComunicationMockMvc = MockMvcBuilders.standaloneSetup(comunicationResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Comunication createEntity(EntityManager em) {
        Comunication comunication = new Comunication()
            .protocol(DEFAULT_PROTOCOL)
            .producer(DEFAULT_PRODUCER)
            .type(DEFAULT_TYPE)
            .status(DEFAULT_STATUS)
            .description(DEFAULT_DESCRIPTION)
            .dateCreated(DEFAULT_DATE_CREATED);
        return comunication;
    }

    @Before
    public void initTest() {
        comunication = createEntity(em);
    }

    @Test
    @Transactional
    public void createComunication() throws Exception {
        int databaseSizeBeforeCreate = comunicationRepository.findAll().size();

        // Create the Comunication
        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isCreated());

        // Validate the Comunication in the database
        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeCreate + 1);
        Comunication testComunication = comunicationList.get(comunicationList.size() - 1);
        assertThat(testComunication.getProtocol()).isEqualTo(DEFAULT_PROTOCOL);
        assertThat(testComunication.getProducer()).isEqualTo(DEFAULT_PRODUCER);
        assertThat(testComunication.getType()).isEqualTo(DEFAULT_TYPE);
        assertThat(testComunication.getStatus()).isEqualTo(DEFAULT_STATUS);
        assertThat(testComunication.getDescription()).isEqualTo(DEFAULT_DESCRIPTION);
        assertThat(testComunication.getDateCreated()).isEqualTo(DEFAULT_DATE_CREATED);
    }

    @Test
    @Transactional
    public void createComunicationWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = comunicationRepository.findAll().size();

        // Create the Comunication with an existing ID
        comunication.setId(1L);

        // An entity with an existing ID cannot be created, so this API call must fail
        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        // Validate the Comunication in the database
        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeCreate);
    }

    @Test
    @Transactional
    public void checkProtocolIsRequired() throws Exception {
        int databaseSizeBeforeTest = comunicationRepository.findAll().size();
        // set the field null
        comunication.setProtocol(null);

        // Create the Comunication, which fails.

        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkProducerIsRequired() throws Exception {
        int databaseSizeBeforeTest = comunicationRepository.findAll().size();
        // set the field null
        comunication.setProducer(null);

        // Create the Comunication, which fails.

        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkTypeIsRequired() throws Exception {
        int databaseSizeBeforeTest = comunicationRepository.findAll().size();
        // set the field null
        comunication.setType(null);

        // Create the Comunication, which fails.

        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkStatusIsRequired() throws Exception {
        int databaseSizeBeforeTest = comunicationRepository.findAll().size();
        // set the field null
        comunication.setStatus(null);

        // Create the Comunication, which fails.

        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDescriptionIsRequired() throws Exception {
        int databaseSizeBeforeTest = comunicationRepository.findAll().size();
        // set the field null
        comunication.setDescription(null);

        // Create the Comunication, which fails.

        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void checkDateCreatedIsRequired() throws Exception {
        int databaseSizeBeforeTest = comunicationRepository.findAll().size();
        // set the field null
        comunication.setDateCreated(null);

        // Create the Comunication, which fails.

        restComunicationMockMvc.perform(post("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isBadRequest());

        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeTest);
    }

    @Test
    @Transactional
    public void getAllComunications() throws Exception {
        // Initialize the database
        comunicationRepository.saveAndFlush(comunication);

        // Get all the comunicationList
        restComunicationMockMvc.perform(get("/api/comunications?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(comunication.getId().intValue())))
            .andExpect(jsonPath("$.[*].protocol").value(hasItem(DEFAULT_PROTOCOL.intValue())))
            .andExpect(jsonPath("$.[*].producer").value(hasItem(DEFAULT_PRODUCER.toString())))
            .andExpect(jsonPath("$.[*].type").value(hasItem(DEFAULT_TYPE.toString())))
            .andExpect(jsonPath("$.[*].status").value(hasItem(DEFAULT_STATUS.toString())))
            .andExpect(jsonPath("$.[*].description").value(hasItem(DEFAULT_DESCRIPTION.toString())))
            .andExpect(jsonPath("$.[*].dateCreated").value(hasItem(DEFAULT_DATE_CREATED.toString())));
    }

    @Test
    @Transactional
    public void getComunication() throws Exception {
        // Initialize the database
        comunicationRepository.saveAndFlush(comunication);

        // Get the comunication
        restComunicationMockMvc.perform(get("/api/comunications/{id}", comunication.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(comunication.getId().intValue()))
            .andExpect(jsonPath("$.protocol").value(DEFAULT_PROTOCOL.intValue()))
            .andExpect(jsonPath("$.producer").value(DEFAULT_PRODUCER.toString()))
            .andExpect(jsonPath("$.type").value(DEFAULT_TYPE.toString()))
            .andExpect(jsonPath("$.status").value(DEFAULT_STATUS.toString()))
            .andExpect(jsonPath("$.description").value(DEFAULT_DESCRIPTION.toString()))
            .andExpect(jsonPath("$.dateCreated").value(DEFAULT_DATE_CREATED.toString()));
    }

    @Test
    @Transactional
    public void getNonExistingComunication() throws Exception {
        // Get the comunication
        restComunicationMockMvc.perform(get("/api/comunications/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    @Transactional
    public void updateComunication() throws Exception {
        // Initialize the database
        comunicationService.save(comunication);

        int databaseSizeBeforeUpdate = comunicationRepository.findAll().size();

        // Update the comunication
        Comunication updatedComunication = comunicationRepository.findOne(comunication.getId());
        updatedComunication
            .protocol(UPDATED_PROTOCOL)
            .producer(UPDATED_PRODUCER)
            .type(UPDATED_TYPE)
            .status(UPDATED_STATUS)
            .description(UPDATED_DESCRIPTION)
            .dateCreated(UPDATED_DATE_CREATED);

        restComunicationMockMvc.perform(put("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(updatedComunication)))
            .andExpect(status().isOk());

        // Validate the Comunication in the database
        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeUpdate);
        Comunication testComunication = comunicationList.get(comunicationList.size() - 1);
        assertThat(testComunication.getProtocol()).isEqualTo(UPDATED_PROTOCOL);
        assertThat(testComunication.getProducer()).isEqualTo(UPDATED_PRODUCER);
        assertThat(testComunication.getType()).isEqualTo(UPDATED_TYPE);
        assertThat(testComunication.getStatus()).isEqualTo(UPDATED_STATUS);
        assertThat(testComunication.getDescription()).isEqualTo(UPDATED_DESCRIPTION);
        assertThat(testComunication.getDateCreated()).isEqualTo(UPDATED_DATE_CREATED);
    }

    @Test
    @Transactional
    public void updateNonExistingComunication() throws Exception {
        int databaseSizeBeforeUpdate = comunicationRepository.findAll().size();

        // Create the Comunication

        // If the entity doesn't have an ID, it will be created instead of just being updated
        restComunicationMockMvc.perform(put("/api/comunications")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(comunication)))
            .andExpect(status().isCreated());

        // Validate the Comunication in the database
        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeUpdate + 1);
    }

    @Test
    @Transactional
    public void deleteComunication() throws Exception {
        // Initialize the database
        comunicationService.save(comunication);

        int databaseSizeBeforeDelete = comunicationRepository.findAll().size();

        // Get the comunication
        restComunicationMockMvc.perform(delete("/api/comunications/{id}", comunication.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isOk());

        // Validate the database is empty
        List<Comunication> comunicationList = comunicationRepository.findAll();
        assertThat(comunicationList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    @Transactional
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Comunication.class);
        Comunication comunication1 = new Comunication();
        comunication1.setId(1L);
        Comunication comunication2 = new Comunication();
        comunication2.setId(comunication1.getId());
        assertThat(comunication1).isEqualTo(comunication2);
        comunication2.setId(2L);
        assertThat(comunication1).isNotEqualTo(comunication2);
        comunication1.setId(null);
        assertThat(comunication1).isNotEqualTo(comunication2);
    }
}
