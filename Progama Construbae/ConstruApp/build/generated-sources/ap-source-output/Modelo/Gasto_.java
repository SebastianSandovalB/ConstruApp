package Modelo;

import Modelo.Empresa;
import Modelo.GastoPK;
import Modelo.Inventario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Gasto.class)
public class Gasto_ { 

    public static volatile SingularAttribute<Gasto, String> descripcion;
    public static volatile SingularAttribute<Gasto, String> fecha;
    public static volatile SingularAttribute<Gasto, Integer> precio;
    public static volatile SingularAttribute<Gasto, Integer> total;
    public static volatile ListAttribute<Gasto, Inventario> inventarioList;
    public static volatile SingularAttribute<Gasto, Integer> cantidad;
    public static volatile SingularAttribute<Gasto, Empresa> empresa;
    public static volatile SingularAttribute<Gasto, GastoPK> gastoPK;
    public static volatile SingularAttribute<Gasto, String> nombre;

}