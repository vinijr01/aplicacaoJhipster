package meuprojeto.service.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * A DTO for the {@link meuprojeto.domain.Aluno} entity.
 */
@Schema(description = "Entidade que representa um Aluno.")
@SuppressWarnings("common-java:DuplicatedBlocks")
public class AlunoDTO implements Serializable {

    private Long id;

    @NotNull
    private String nome;

    @NotNull
    private String email;

    @NotNull
    private LocalDate dataNascimento;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof AlunoDTO)) {
            return false;
        }

        AlunoDTO alunoDTO = (AlunoDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, alunoDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "AlunoDTO{" +
            "id=" + getId() +
            ", nome='" + getNome() + "'" +
            ", email='" + getEmail() + "'" +
            ", dataNascimento='" + getDataNascimento() + "'" +
            "}";
    }
}
