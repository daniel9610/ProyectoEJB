package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.Video;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-10-27T21:19:54")
@StaticMetamodel(Serie.class)
public class Serie_ { 

    public static volatile CollectionAttribute<Serie, Video> videoCollection;
    public static volatile SingularAttribute<Serie, Integer> idSerie;
    public static volatile SingularAttribute<Serie, String> nombreSerie;
    public static volatile SingularAttribute<Serie, Integer> temporada;
    public static volatile SingularAttribute<Serie, Integer> valorSerie;

}