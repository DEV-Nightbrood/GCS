package dpmm.bsirh.scopes;

import dpmm.bsirh.jpa.entities.Individu;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.java.Log;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Named("individuController")
//Named rends accessible depuis les pages JSF la classe suivante, le nom en paramètre est optionnel mais il doit etre unique sur le serveur
@ViewScoped
@Log
public class IndividuViewController implements Serializable {


    @Getter
    @Setter
    private String monChampEditable;

    @Inject
    private RequestScopedExample requestIndividu;


    @Getter
    private List<Individu> maListeDeDonnes;

    @PostConstruct
    private void apresConstruction() {
        init_maListeDeDonnes();
        reset_monChampEditable();
    }

    private void reset_monChampEditable() {
        monChampEditable = "";
    }


    private void init_maListeDeDonnes() {
        maListeDeDonnes = requestIndividu.allIndividuSortedByName();
    }


    public void rechercher() {
        Optional<String> oChamp = Optional.ofNullable(monChampEditable);

        if (oChamp.isPresent()) {
            if (oChamp.orElse("").length() != 0) {
                maListeDeDonnes = requestIndividu.rechercher(oChamp.get(), maListeDeDonnes);
            } else {
                init_maListeDeDonnes();
            }

        } else {
            init_maListeDeDonnes();
        }
    }


    @PreDestroy
    private void avantDestruction() {
        log.info("monrequest est va mourir :( !");
    }

}
