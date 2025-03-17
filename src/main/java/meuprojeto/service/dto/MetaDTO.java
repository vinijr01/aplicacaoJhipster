package meuprojeto.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link meuprojeto.domain.Meta} entity.
 */
@Schema(description = "Entidade que representa uma Meta.")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class MetaDTO implements Serializable {

    private Long id;

    @NotNull
    private String area;

    @NotNull
    private Integer notaEsperada;

    private AlunoDTO aluno;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNotaEsperada() {
        return notaEsperada;
    }

    public void setNotaEsperada(Integer notaEsperada) {
        this.notaEsperada = notaEsperada;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MetaDTO)) {
            return false;
        }

        MetaDTO metaDTO = (MetaDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, metaDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "MetaDTO{" +
            "id=" + getId() +
            ", area='" + getArea() + "'" +
            ", notaEsperada=" + getNotaEsperada() +
            ", aluno=" + getAluno() +
            "}";
    }
}
