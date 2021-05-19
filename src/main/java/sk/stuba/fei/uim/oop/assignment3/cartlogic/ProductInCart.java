package sk.stuba.fei.uim.oop.assignment3.cartlogic;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;

import java.io.Serializable;


@Getter
@Setter
public class ProductInCart implements Serializable {
    long prodid;
    int amount;
    public ProductInCart(long id,int amount){
        this.prodid = id;
        this.amount = amount;
    }
}
