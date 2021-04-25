package Modelo;

import Modelo.GastoproyectoPK;
import Modelo.Inventario;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Gastoproyecto.class)
public class Gastoproyecto_ { 

    public static volatile SingularAttribute<Gastoproyecto, GastoproyectoPK> gastoproyectoPK;
    public static volatile SingularAttribute<Gastoproyecto, String> caracteristica;
    public static volatile SingularAttribute<Gastoproyecto, String> nomProyecto;
    public static volatile SingularAttribute<Gastoproyecto, Integer> cantidad;
    public static volatile SingularAttribute<Gastoproyecto, String> nombre;
    public static volatile SingularAttribute<Gastoproyecto, Inventario> inventario;

}