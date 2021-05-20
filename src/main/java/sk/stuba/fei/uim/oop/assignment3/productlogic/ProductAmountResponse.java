package sk.stuba.fei.uim.oop.assignment3.productlogic;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductAmountResponse {
    int amount;
    public ProductAmountResponse(int amount){
        this.amount = amount;
    }

}
