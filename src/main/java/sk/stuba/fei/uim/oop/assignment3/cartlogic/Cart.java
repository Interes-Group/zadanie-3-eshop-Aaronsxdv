package sk.stuba.fei.uim.oop.assignment3.cartlogic;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long cartId;
    private ArrayList<ProductInCart> cartProducts;
    private boolean payed;
}
