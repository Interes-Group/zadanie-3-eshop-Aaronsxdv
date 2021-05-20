package sk.stuba.fei.uim.oop.assignment3.productlogic;

import lombok.Getter;

@Getter
public class ProductResponse {

    private long id;
    private String name;
    private String description;
    private int amount;
    private String unit;
    private double price;
    public ProductResponse(Product p){
        this.name = p.getName();
        this.id = p.getId();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
    }
}

