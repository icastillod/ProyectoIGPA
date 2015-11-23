package com.igpa.entities;

import com.igpa.entities.Pregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-22T11:02:23")
@StaticMetamodel(Respuesta.class)
public class Respuesta_ { 

    public static volatile SingularAttribute<Respuesta, Boolean> valorResultado;
    public static volatile SingularAttribute<Respuesta, Pregunta> idPregunta;
    public static volatile SingularAttribute<Respuesta, Integer> idRespuesta;
    public static volatile SingularAttribute<Respuesta, String> respuesta;

}