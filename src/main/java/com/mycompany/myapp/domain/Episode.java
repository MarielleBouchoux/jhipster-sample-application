package com.mycompany.myapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

/**
 * A Episode.
 */
@Entity
@Table(name = "episode")
public class Episode implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "duree")
    private Integer duree;

    @OneToMany(mappedBy = "episodes")
    @JsonIgnoreProperties(value = { "series", "episodes" }, allowSetters = true)
    private Set<Saison> saisons = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here

    public Long getId() {
        return this.id;
    }

    public Episode id(Long id) {
        this.setId(id);
        return this;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public Episode name(String name) {
        this.setName(name);
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDuree() {
        return this.duree;
    }

    public Episode duree(Integer duree) {
        this.setDuree(duree);
        return this;
    }

    public void setDuree(Integer duree) {
        this.duree = duree;
    }

    public Set<Saison> getSaisons() {
        return this.saisons;
    }

    public void setSaisons(Set<Saison> saisons) {
        if (this.saisons != null) {
            this.saisons.forEach(i -> i.setEpisodes(null));
        }
        if (saisons != null) {
            saisons.forEach(i -> i.setEpisodes(this));
        }
        this.saisons = saisons;
    }

    public Episode saisons(Set<Saison> saisons) {
        this.setSaisons(saisons);
        return this;
    }

    public Episode addSaison(Saison saison) {
        this.saisons.add(saison);
        saison.setEpisodes(this);
        return this;
    }

    public Episode removeSaison(Saison saison) {
        this.saisons.remove(saison);
        saison.setEpisodes(null);
        return this;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Episode)) {
            return false;
        }
        return id != null && id.equals(((Episode) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Episode{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", duree=" + getDuree() +
            "}";
    }
}
