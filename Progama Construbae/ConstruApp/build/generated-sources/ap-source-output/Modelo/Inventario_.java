package Modelo;

import Modelo.Empresa;
import Modelo.Gasto;
import Modelo.Gastoproyecto;
import Modelo.InventarioPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Inventario.class)
public class Inventario_ { 

    public static volatile SingularAttribute<Inventario, InventarioPK> inventarioPK;
    public static volatile SingularAttribute<Inventario, String> caracteristica;
    public static volatile ListAttribute<Inventario, Gastoproyecto> gastoproyectoList;
    public static volatile SingularAttribute<Inventario, Integer> cantidad;
    public static volatile SingularAttribute<Inventario, Empresa> empresa;
    public static volatile SingularAttribute<Inventario, String> nombre;
    public static volatile SingularAttribute<Inventario, Gasto> gasto;

}