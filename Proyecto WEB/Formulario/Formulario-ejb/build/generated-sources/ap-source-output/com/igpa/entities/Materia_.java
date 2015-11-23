package com.igpa.entities;

import com.igpa.entities.Tema;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2015-11-22T11:02:23")
@StaticMetamodel(Materia.class)
public class Materia_ { 

    public static volatile SingularAttribute<Materia, Integer> idMateria;
    public static volatile CollectionAttribute<Materia, Tema> temaCollection;
    public static volatile SingularAttribute<Materia, String> nombreMateria;

}