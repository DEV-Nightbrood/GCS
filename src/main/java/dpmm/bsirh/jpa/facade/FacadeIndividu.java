package dpmm.bsirh.jpa.facade;

import dpmm.bsirh.jpa.entities.Individu;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.Serializable;
import java.util.List;

@Stateless
public class FacadeIndividu implements Serializable
{

   @PersistenceContext(name = "GCS",unitName = "GCS")
    private EntityManager gcs;

    public List<Individu> readAll ()
    {
        return gcs.createQuery("SELECT i FROM Individu i",Individu.class).getResultList();
    }
}
