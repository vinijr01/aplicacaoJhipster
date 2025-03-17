package meuprojeto.service.impl;

import java.util.Optional;
import meuprojeto.domain.Aluno;
import meuprojeto.repository.AlunoRepository;
import meuprojeto.service.AlunoService;
import meuprojeto.service.dto.AlunoDTO;
import meuprojeto.service.mapper.AlunoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link meuprojeto.domain.Aluno}.
 */
@Service
@Transactional
public class AlunoServiceImpl implements AlunoService {

    private static final Logger LOG = LoggerFactory.getLogger(AlunoServiceImpl.class);

    private final AlunoRepository alunoRepository;

    private final AlunoMapper alunoMapper;

    public AlunoServiceImpl(AlunoRepository alunoRepository, AlunoMapper alunoMapper) {
        this.alunoRepository = alunoRepository;
        this.alunoMapper = alunoMapper;
    }

    @Override
    public AlunoDTO save(AlunoDTO alunoDTO) {
        LOG.debug("Request to save Aluno : {}", alunoDTO);
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return alunoMapper.toDto(aluno);
    }

    @Override
    public AlunoDTO update(AlunoDTO alunoDTO) {
        LOG.debug("Request to update Aluno : {}", alunoDTO);
        Aluno aluno = alunoMapper.toEntity(alunoDTO);
        aluno = alunoRepository.save(aluno);
        return alunoMapper.toDto(aluno);
    }

    @Override
    public Optional<AlunoDTO> partialUpdate(AlunoDTO alunoDTO) {
        LOG.debug("Request to partially update Aluno : {}", alunoDTO);

        return alunoRepository
            .findById(alunoDTO.getId())
            .map(existingAluno -> {
                alunoMapper.partialUpdate(existingAluno, alunoDTO);

                return existingAluno;
            })
            .map(alunoRepository::save)
            .map(alunoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<AlunoDTO> findAll(Pageable pageable) {
        LOG.debug("Request to get all Alunos");
        return alunoRepository.findAll(pageable).map(alunoMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<AlunoDTO> findOne(Long id) {
        LOG.debug("Request to get Aluno : {}", id);
        return alunoRepository.findById(id).map(alunoMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        LOG.debug("Request to delete Aluno : {}", id);
        alunoRepository.deleteById(id);
    }
}
