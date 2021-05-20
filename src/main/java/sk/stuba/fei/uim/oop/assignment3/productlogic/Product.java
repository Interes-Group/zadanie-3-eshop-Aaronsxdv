package sk.stuba.fei.uim.oop.assignment3.productlogic;


import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.cartlogic.Cart;

import javax.persistence.*;


@Getter
@Setter
@Entity
public class Product{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String name;
    private String description;
    private long amount;
    private String unit;
    private double price;

    /*@OneToOne
    private Cart cart;*/
}
