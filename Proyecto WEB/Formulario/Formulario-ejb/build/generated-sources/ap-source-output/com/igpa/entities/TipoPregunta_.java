package com.igpa.entities;

import com.igpa.entities.Pregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-22T11:02:23")
@StaticMetamodel(TipoPregunta.class)
public class TipoPregunta_ { 

    public static volatile CollectionAttribute<TipoPregunta, Pregunta> preguntaCollection;
    public static volatile SingularAttribute<TipoPregunta, String> nombreTipoPregunta;
    public static volatile SingularAttribute<TipoPregunta, Integer> cantRespuestasPosibles;
    public static volatile SingularAttribute<TipoPregunta, Integer> cantREspuestasCorrectas;
    public static volatile SingularAttribute<TipoPregunta, Integer> idTipoPregunta;

}