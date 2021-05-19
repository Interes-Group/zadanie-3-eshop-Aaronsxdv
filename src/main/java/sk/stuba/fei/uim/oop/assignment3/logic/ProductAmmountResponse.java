package sk.stuba.fei.uim.oop.assignment3.logic;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductAmmountResponse {
    int amount;
    public ProductAmmountResponse(int ammount){
        this.amount = ammount;
    }

}
