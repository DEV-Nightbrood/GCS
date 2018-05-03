package dpmm.bsirh.jpa.entities;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Data
@EqualsAndHashCode(of ="id")
@Table(name = "individu",catalog = "gcs")
public class Individu implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2,max = 100 ,message = "Le nom doit etre compris entre 2 et 100 caract\u00e8res")
    private String nom;

    @Size(min = 2,max = 100 ,message = "Le pr\u00e9nom doit etre compris entre 2 et 100 caract\u00e8res")
    private String prenom;


}
