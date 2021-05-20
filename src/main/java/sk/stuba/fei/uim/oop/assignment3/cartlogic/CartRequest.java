package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CartRequest {
    private ArrayList<ProductInCart> shoppingList;
    private boolean payed;
}
