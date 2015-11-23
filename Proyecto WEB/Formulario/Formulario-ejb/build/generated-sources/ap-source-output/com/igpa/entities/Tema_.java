package com.igpa.entities;

import com.igpa.entities.Materia;
import com.igpa.entities.Pregunta;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-22T11:02:23")
@StaticMetamodel(Tema.class)
public class Tema_ { 

    public static volatile CollectionAttribute<Tema, Pregunta> preguntaCollection;
    public static volatile SingularAttribute<Tema, Integer> idTema;
    public static volatile SingularAttribute<Tema, String> nombreTema;
    public static volatile SingularAttribute<Tema, Materia> idMateria;

}