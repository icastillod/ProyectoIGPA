/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.igpa.negocio;

import com.igpa.entities.Tema;
import static java.util.Collections.list;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author ivonne
 */
@Stateless
public class TemaFacade extends AbstractFacade<Tema> {
    @PersistenceContext(unitName = "Formulario-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TemaFacade() {
        super(Tema.class);
    }
    
}
