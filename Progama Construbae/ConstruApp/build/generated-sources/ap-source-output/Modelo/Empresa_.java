package Modelo;

import Modelo.Gasto;
import Modelo.Inventario;
import Modelo.Personal;
import Modelo.Proyecto;
import Modelo.Usuario;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Empresa.class)
public class Empresa_ { 

    public static volatile ListAttribute<Empresa, Proyecto> proyectoList;
    public static volatile ListAttribute<Empresa, Usuario> usuarioList;
    public static volatile ListAttribute<Empresa, Inventario> inventarioList;
    public static volatile SingularAttribute<Empresa, Integer> idEmpresa;
    public static volatile ListAttribute<Empresa, Gasto> gastoList;
    public static volatile SingularAttribute<Empresa, String> nombre;
    public static volatile ListAttribute<Empresa, Personal> personalList;

}