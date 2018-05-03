package dpmm.bsirh.jpa.facade;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractFacade<T> {

    abstract protected EntityManager getEntityManager();

    private Class<T> entity;

    @PostConstruct
    public void init ()
    {
        Class<?> thisClass = this.getClass();
        ParameterizedType paramType = ( ParameterizedType ) thisClass.getGenericSuperclass();
        //noinspection unchecked
        entity = ( Class<T> ) paramType.getActualTypeArguments()[ 0 ];

    }
    public List<T> readAll ( )
    {
        CriteriaBuilder qb = this.getEntityManager().getCriteriaBuilder();
        CriteriaQuery<T> c = qb.createQuery( entity );
        TypedQuery<T> query = this.getEntityManager().createQuery( c );
        return query.getResultList();
    }





}
