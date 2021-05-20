package sk.stuba.fei.uim.oop.assignment3.cartlogic;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;

import java.io.Serializable;


@Getter
@Setter
public class ProductInCart implements Serializable {
    long productId;
    long amount;
    public ProductInCart(long id,long amount){
        this.productId = id;
        this.amount = amount;
    }
}
