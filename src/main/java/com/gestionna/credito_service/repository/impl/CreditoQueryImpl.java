
package com.gestionna.credito_service.repository.impl;

import com.gestionna.credito_service.entity.Credito;
import com.gestionna.credito_service.repository.CreditoQuery;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class CreditoQueryImpl implements CreditoQuery {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<Credito> buscarPorFiltros(String tipoCredito, Boolean simplesNacional, BigDecimal valorMinimo) {
        StringBuilder jpql = new StringBuilder("SELECT c FROM Credito c WHERE 1=1");

        if (tipoCredito != null && !tipoCredito.isEmpty()) {
            jpql.append(" AND c.tipoCredito = :tipoCredito");
        }

        if (simplesNacional != null) {
            jpql.append(" AND c.simplesNacional = :simplesNacional");
        }

        if (valorMinimo != null) {
            jpql.append(" AND c.valorIssqn >= :valorMinimo");
        }

        TypedQuery<Credito> query = em.createQuery(jpql.toString(), Credito.class);

        if (tipoCredito != null && !tipoCredito.isEmpty()) {
            query.setParameter("tipoCredito", tipoCredito);
        }

        if (simplesNacional != null) {
            query.setParameter("simplesNacional", simplesNacional);
        }

        if (valorMinimo != null) {
            query.setParameter("valorMinimo", valorMinimo);
        }

        return query.getResultList();
    }
}
