package sk.stuba.fei.uim.oop.assignment3.cartlogic;

import sk.stuba.fei.uim.oop.assignment3.productlogic.Product;

public class ProductInCart {
    long prodid;
    int amount;
    public ProductInCart(long id,int amount){
        this.prodid = id;
        this.amount = amount;
    }
}
