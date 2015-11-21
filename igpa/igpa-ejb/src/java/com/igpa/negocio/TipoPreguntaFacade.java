/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igpa.negocio;

import com.igpa.entities.TipoPregunta;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivonne
 */
@Stateless
public class TipoPreguntaFacade extends AbstractFacade<TipoPregunta> {
    @PersistenceContext(unitName = "igpa-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPreguntaFacade() {
        super(TipoPregunta.class);
    }
    
}
