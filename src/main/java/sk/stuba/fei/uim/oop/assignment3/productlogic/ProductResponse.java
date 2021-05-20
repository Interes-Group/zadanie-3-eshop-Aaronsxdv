package sk.stuba.fei.uim.oop.assignment3.productlogic;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductResponse {

    private long id;
    private String name;
    private String description;
    private long amount;
    private String unit;
    private double price;
    public ProductResponse(Product p){
        this.id = p.getId();
        this.name = p.getName();
        this.description = p.getDescription();
        this.amount = p.getAmount();
        this.unit = p.getUnit();
        this.price = p.getPrice();
    }
}

