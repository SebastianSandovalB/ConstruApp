package Modelo;

import Modelo.Empresa;
import Modelo.PersonalPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2020-07-28T13:32:51")
@StaticMetamodel(Personal.class)
public class Personal_ { 

    public static volatile SingularAttribute<Personal, PersonalPK> personalPK;
    public static volatile SingularAttribute<Personal, Integer> sueldo;
    public static volatile SingularAttribute<Personal, String> cargo;
    public static volatile SingularAttribute<Personal, Empresa> empresa;
    public static volatile SingularAttribute<Personal, String> nombre;

}