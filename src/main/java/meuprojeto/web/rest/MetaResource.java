package meuprojeto.web.rest;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import meuprojeto.repository.MetaRepository;
import meuprojeto.service.MetaService;
import meuprojeto.service.dto.MetaDTO;
import meuprojeto.web.rest.errors.BadRequestAlertException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import tech.jhipster.web.util.HeaderUtil;
import tech.jhipster.web.util.PaginationUtil;
import tech.jhipster.web.util.ResponseUtil;

/**
 * REST controller for managing {@link meuprojeto.domain.Meta}.
 */
@RestController
@RequestMapping("/api/metas")
public class MetaResource {

    private static final Logger LOG = LoggerFactory.getLogger(MetaResource.class);

    private static final String ENTITY_NAME = "meta";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final MetaService metaService;

    private final MetaRepository metaRepository;

    public MetaResource(MetaService metaService, MetaRepository metaRepository) {
        this.metaService = metaService;
        this.metaRepository = metaRepository;
    }

    /**
     * {@code POST  /metas} : Create a new meta.
     *
     * @param metaDTO the metaDTO to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new metaDTO, or with status {@code 400 (Bad Request)} if the meta has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("")
    public ResponseEntity<MetaDTO> createMeta(@Valid @RequestBody MetaDTO metaDTO) throws URISyntaxException {
        LOG.debug("REST request to save Meta : {}", metaDTO);
        if (metaDTO.getId() != null) {
            throw new BadRequestAlertException("A new meta cannot already have an ID", ENTITY_NAME, "idexists");
        }
        metaDTO = metaService.save(metaDTO);
        return ResponseEntity.created(new URI("/api/metas/" + metaDTO.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, metaDTO.getId().toString()))
            .body(metaDTO);
    }

    /**
     * {@code PUT  /metas/:id} : Updates an existing meta.
     *
     * @param id the id of the metaDTO to save.
     * @param metaDTO the metaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated metaDTO,
     * or with status {@code 400 (Bad Request)} if the metaDTO is not valid,
     * or with status {@code 500 (Internal Server Error)} if the metaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/{id}")
    public ResponseEntity<MetaDTO> updateMeta(
        @PathVariable(value = "id", required = false) final Long id,
        @Valid @RequestBody MetaDTO metaDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to update Meta : {}, {}", id, metaDTO);
        if (metaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, metaDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!metaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        metaDTO = metaService.update(metaDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, metaDTO.getId().toString()))
            .body(metaDTO);
    }

    /**
     * {@code PATCH  /metas/:id} : Partial updates given fields of an existing meta, field will ignore if it is null
     *
     * @param id the id of the metaDTO to save.
     * @param metaDTO the metaDTO to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated metaDTO,
     * or with status {@code 400 (Bad Request)} if the metaDTO is not valid,
     * or with status {@code 404 (Not Found)} if the metaDTO is not found,
     * or with status {@code 500 (Internal Server Error)} if the metaDTO couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PatchMapping(value = "/{id}", consumes = { "application/json", "application/merge-patch+json" })
    public ResponseEntity<MetaDTO> partialUpdateMeta(
        @PathVariable(value = "id", required = false) final Long id,
        @NotNull @RequestBody MetaDTO metaDTO
    ) throws URISyntaxException {
        LOG.debug("REST request to partial update Meta partially : {}, {}", id, metaDTO);
        if (metaDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        if (!Objects.equals(id, metaDTO.getId())) {
            throw new BadRequestAlertException("Invalid ID", ENTITY_NAME, "idinvalid");
        }

        if (!metaRepository.existsById(id)) {
            throw new BadRequestAlertException("Entity not found", ENTITY_NAME, "idnotfound");
        }

        Optional<MetaDTO> result = metaService.partialUpdate(metaDTO);

        return ResponseUtil.wrapOrNotFound(
            result,
            HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, metaDTO.getId().toString())
        );
    }

    /**
     * {@code GET  /metas} : get all the metas.
     *
     * @param pageable the pagination information.
     * @param eagerload flag to eager load entities from relationships (This is applicable for many-to-many).
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of metas in body.
     */
    @GetMapping("")
    public ResponseEntity<List<MetaDTO>> getAllMetas(
        @org.springdoc.core.annotations.ParameterObject Pageable pageable,
        @RequestParam(name = "eagerload", required = false, defaultValue = "true") boolean eagerload
    ) {
        LOG.debug("REST request to get a page of Metas");
        Page<MetaDTO> page;
        if (eagerload) {
            page = metaService.findAllWithEagerRelationships(pageable);
        } else {
            page = metaService.findAll(pageable);
        }
        HttpHeaders headers = PaginationUtil.generatePaginationHttpHeaders(ServletUriComponentsBuilder.fromCurrentRequest(), page);
        return ResponseEntity.ok().headers(headers).body(page.getContent());
    }

    /**
     * {@code GET  /metas/:id} : get the "id" meta.
     *
     * @param id the id of the metaDTO to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the metaDTO, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/{id}")
    public ResponseEntity<MetaDTO> getMeta(@PathVariable("id") Long id) {
        LOG.debug("REST request to get Meta : {}", id);
        Optional<MetaDTO> metaDTO = metaService.findOne(id);
        return ResponseUtil.wrapOrNotFound(metaDTO);
    }

    /**
     * {@code DELETE  /metas/:id} : delete the "id" meta.
     *
     * @param id the id of the metaDTO to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMeta(@PathVariable("id") Long id) {
        LOG.debug("REST request to delete Meta : {}", id);
        metaService.delete(id);
        return ResponseEntity.noContent()
            .headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString()))
            .build();
    }
}
