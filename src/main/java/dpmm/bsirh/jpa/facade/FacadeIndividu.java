package dpmm.bsirh.jpa.facade;

import dpmm.bsirh.jpa.annotation.GCSDataBase;
import dpmm.bsirh.jpa.entities.Individu;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Stateless
public class FacadeIndividu extends dpmm.bsirh.jpa.facade.AbstractFacade<Individu>
{

    @Inject
    @GCSDataBase
    private EntityManager gcs;

    @Override
    protected EntityManager getEntityManager() {
        return gcs;
    }
}
