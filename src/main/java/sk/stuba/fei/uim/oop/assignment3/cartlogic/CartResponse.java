package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import java.util.ArrayList;
import java.util.List;

@Getter
public class CartResponse {
    private long id;
    private ArrayList<ProductInCart> cartProducts;
    private boolean payed;
    public CartResponse(Cart c){
        this.id = c.getCartId();
        this.cartProducts = c.getCartProducts();
        this.payed = c.isPayed();
    }
}
