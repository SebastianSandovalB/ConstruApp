package Modelo;

import Modelo.Empresa;
import Modelo.ProyectoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Proyecto.class)
public class Proyecto_ { 

    public static volatile SingularAttribute<Proyecto, ProyectoPK> proyectoPK;
    public static volatile SingularAttribute<Proyecto, String> adjudicado;
    public static volatile SingularAttribute<Proyecto, String> direccion;
    public static volatile SingularAttribute<Proyecto, String> comuna;
    public static volatile SingularAttribute<Proyecto, Empresa> empresa;

}