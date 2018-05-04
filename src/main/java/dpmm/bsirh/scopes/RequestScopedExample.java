package dpmm.bsirh.scopes;


import dpmm.bsirh.jpa.entities.Individu;
import dpmm.bsirh.jpa.facade.FacadeIndividu;
import lombok.extern.java.Log;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@RequestScoped //Request = s'instencie a son appel et meur à l'issue
@Log //Logger lombok
public class RequestScopedExample
{

    @EJB
    private FacadeIndividu fc_individu;

    public List<Individu> allIndividuSortedByName()
    {

        Predicate<Individu> commenceParA = individu -> individu.getNom().startsWith("A");

        Predicate<Individu> finitParB = individu -> individu.getNom().endsWith("B");

        Predicate<Individu> finalPredi = commenceParA.and(finitParB);

        return fc_individu
                .readAll()
                .stream()
                .filter( finalPredi)
                .sorted((individuA, individuB) ->
                    individuA.getNom().compareToIgnoreCase(individuB.getNom())
                )
                .collect(Collectors.toList());
    }

}
