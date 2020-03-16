package dbc.jreis.ticket.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
@Builder
@Table(name = "ESTADO")
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String sigla;

    @Transient
    private long populacao;
    @Transient
    private long nCidades;

    @OneToMany
    @JoinColumn(name = "ESTADO_ID", referencedColumnName = "id")
    private Set<Cidade> cidades;

    public String toJson() {
        return "{nome: " + nome + ", sigla:" + sigla + ", populacao: " + populacao + "}";
    }
}
