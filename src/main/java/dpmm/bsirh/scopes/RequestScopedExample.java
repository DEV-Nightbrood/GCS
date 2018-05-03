package dpmm.bsirh.scopes;


import dpmm.bsirh.jpa.entities.Individu;
import dpmm.bsirh.jpa.facade.FacadeIndividu;
import lombok.extern.java.Log;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.stream.Collectors;

@RequestScoped //Request = s'instencie a son appel et meur à l'issue
@Log //Logger lombok
public class RequestScopedExample
{

    @EJB
    private FacadeIndividu fc_individu;

    List<Individu> getAllIndividuSortedByName()
    {
        return fc_individu
                .readAll()
                .stream()
                .sorted((individuA, individuB) ->
                    individuA.getNom().compareToIgnoreCase(individuB.getNom())
                )
                .collect(Collectors.toList());
    }

}
