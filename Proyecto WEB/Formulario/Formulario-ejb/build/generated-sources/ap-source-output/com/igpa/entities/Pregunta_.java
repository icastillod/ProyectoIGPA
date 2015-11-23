package com.igpa.entities;

import com.igpa.entities.Respuesta;
import com.igpa.entities.Tema;
import com.igpa.entities.TipoPregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-22T11:02:23")
@StaticMetamodel(Pregunta.class)
public class Pregunta_ { 

    public static volatile SingularAttribute<Pregunta, Tema> idTema;
    public static volatile SingularAttribute<Pregunta, String> enunciado;
    public static volatile SingularAttribute<Pregunta, Integer> idPregunta;
    public static volatile CollectionAttribute<Pregunta, Respuesta> respuestaCollection;
    public static volatile SingularAttribute<Pregunta, Integer> complejdad;
    public static volatile SingularAttribute<Pregunta, TipoPregunta> idTipoPregunta;

}