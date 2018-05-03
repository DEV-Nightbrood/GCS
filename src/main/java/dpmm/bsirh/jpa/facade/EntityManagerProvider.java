package dpmm.bsirh.jpa.facade;

import dpmm.bsirh.jpa.annotation.GCSDataBase;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@ApplicationScoped
public class EntityManagerProvider {

    @Produces
    @GCSDataBase
    @PersistenceContext(unitName = "GCS",name = "GCS")
    private EntityManager gcsEm;
}
