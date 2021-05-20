package sk.stuba.fei.uim.oop.assignment3.productlogic;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductRequest {

    private String name;
    private String description;
    private long amount;
    private String unit;
    private double price;
}
