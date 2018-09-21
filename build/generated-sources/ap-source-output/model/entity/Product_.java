package model.entity;

import java.math.BigInteger;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import model.entity.Category;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2018-09-04T09:02:43")
@StaticMetamodel(Product.class)
public class Product_ extends AbstractEntity_ {

    public static volatile SingularAttribute<Product, BigInteger> quantity;
    public static volatile SingularAttribute<Product, String> name;
    public static volatile SingularAttribute<Product, Integer> id;
    public static volatile SingularAttribute<Product, Category> category;

}