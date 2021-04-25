package Modelo;

import Modelo.Empresa;
import Modelo.UsuarioPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Usuario.class)
public class Usuario_ { 

    public static volatile SingularAttribute<Usuario, String> cargo;
    public static volatile SingularAttribute<Usuario, Empresa> empresa;
    public static volatile SingularAttribute<Usuario, UsuarioPK> usuarioPK;
    public static volatile SingularAttribute<Usuario, String> nombre;
    public static volatile SingularAttribute<Usuario, String> contraseña;

}