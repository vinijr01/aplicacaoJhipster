package meuprojeto.service.impl;

import java.util.Optional;
import meuprojeto.domain.Meta;
import meuprojeto.repository.MetaRepository;
import meuprojeto.service.MetaService;
import meuprojeto.service.dto.MetaDTO;
import meuprojeto.service.mapper.MetaMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link meuprojeto.domain.Meta}.
 */
@Service
@Transactional
public class MetaServiceImpl implements MetaService {

    private static final Logger LOG = LoggerFactory.getLogger(MetaServiceImpl.class);

    private final MetaRepository metaRepository;

    private final MetaMapper metaMapper;

    public MetaServiceImpl(MetaRepository metaRepository, MetaMapper metaMapper) {
        this.metaRepository = metaRepository;
        this.metaMapper = metaMapper;
    }

    @Override
    public MetaDTO save(MetaDTO metaDTO) {
        LOG.debug("Request to save Meta : {}", metaDTO);
        Meta meta = metaMapper.toEntity(metaDTO);
        meta = metaRepository.save(meta);
        return metaMapper.toDto(meta);
    }

    @Override
    public MetaDTO update(MetaDTO metaDTO) {
        LOG.debug("Request to update Meta : {}", metaDTO);
        Meta meta = metaMapper.toEntity(metaDTO);
        meta = metaRepository.save(meta);
        return metaMapper.toDto(meta);
    }

    @Override
    public Optional<MetaDTO> partialUpdate(MetaDTO metaDTO) {
        LOG.debug("Request to partially update Meta : {}", metaDTO);

        return metaRepository
            .findById(metaDTO.getId())
            .map(existingMeta -> {
                metaMapper.partialUpdate(existingMeta, metaDTO);

                return existingMeta;
            })
            .map(metaRepository::save)
            .map(metaMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<MetaDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Metas");
        return metaRepository.findAll(pageable).map(metaMapper::toDto);
    }

    public Page<MetaDTO> findAllWithEagerRelationships(Pageable pageable) {
        return metaRepository.findAllWithEagerRelationships(pageable).map(metaMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<MetaDTO> findOne(Long id) {
        LOG.debug("Request to get Meta : {}", id);
        return metaRepository.findOneWithEagerRelationships(id).map(metaMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Meta : {}", id);
        metaRepository.deleteById(id);
    }
}
