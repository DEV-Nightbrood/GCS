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
import java.util.Collections;
import java.util.List;

@Named("individuController") //Named rends accessible depuis les pages JSF la classe suivante, le nom en paramètre est optionnel mais il doit etre unique sur le serveur
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
    private void apresConstruction()
    {
        init_maListeDeDonnes();
    }


    private void init_maListeDeDonnes()
    {
        maListeDeDonnes = Collections.EMPTY_LIST;
        maListeDeDonnes = requestIndividu.allIndividuSortedByName();
    }




    @PreDestroy
    private void avantDestruction()
    {
        log.info("monrequest est va mourir :( !");
    }

}
