package meuprojeto.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import java.io.Serializable;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * Entidade que representa uma Meta.
 */
@Entity
@Table(name = "meta")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@SuppressWarnings("common-java:DuplicatedBlocks")
public class Meta implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequenceGenerator")
    @SequenceGenerator(name = "sequenceGenerator")
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "area", nullable = false)
    private String area;

    @NotNull
    @Column(name = "nota_esperada", nullable = false)
    private Integer notaEsperada;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties(value = { "metas" }, allowSetters = true)
    private Aluno aluno;

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Meta id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getArea() {
        return this.area;
    }

    public Meta area(String area) {
        this.setArea(area);
        return this;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public Integer getNotaEsperada() {
        return this.notaEsperada;
    }

    public Meta notaEsperada(Integer notaEsperada) {
        this.setNotaEsperada(notaEsperada);
        return this;
    }

    public void setNotaEsperada(Integer notaEsperada) {
        this.notaEsperada = notaEsperada;
    }

    public Aluno getAluno() {
        return this.aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Meta aluno(Aluno aluno) {
        this.setAluno(aluno);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Meta)) {
            return false;
        }
        return getId() != null && getId().equals(((Meta) o).getId());
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Meta{" +
            "id=" + getId() +
            ", area='" + getArea() + "'" +
            ", notaEsperada=" + getNotaEsperada() +
            "}";
    }
}
