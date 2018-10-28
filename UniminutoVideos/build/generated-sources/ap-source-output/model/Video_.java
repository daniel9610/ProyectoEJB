package model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Idioma;
import model.Serie;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T21:19:54")
@StaticMetamodel(Video.class)
public class Video_ { 

    public static volatile SingularAttribute<Video, Idioma> codIdioma;
    public static volatile SingularAttribute<Video, Serie> serie;
    public static volatile SingularAttribute<Video, String> titulo;
    public static volatile SingularAttribute<Video, Integer> isan;
    public static volatile SingularAttribute<Video, Serie> idSerie;
    public static volatile SingularAttribute<Video, Integer> valorVideo;
    public static volatile SingularAttribute<Video, Idioma> idioma;
    public static volatile SingularAttribute<Video, Date> añoProduccion;
    public static volatile SingularAttribute<Video, Date> duracion;

}