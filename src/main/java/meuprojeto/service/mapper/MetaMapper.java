package meuprojeto.service.mapper;

import meuprojeto.domain.Aluno;
import meuprojeto.domain.Meta;
import meuprojeto.service.dto.AlunoDTO;
import meuprojeto.service.dto.MetaDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Meta} and its DTO {@link MetaDTO}.
 */
@Mapper(componentModel = "spring")
public interface MetaMapper extends EntityMapper<MetaDTO, Meta> {
    @Mapping(target = "aluno", source = "aluno", qualifiedByName = "alunoEmail")
    MetaDTO toDto(Meta s);

    @Named("alunoEmail")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    @Mapping(target = "email", source = "email")
    AlunoDTO toDtoAlunoEmail(Aluno aluno);
}
