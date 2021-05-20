package sk.stuba.fei.uim.oop.assignment3.productlogic;


import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class ProductAmountResponse {
    long amount;
    public ProductAmountResponse(long amount){
        this.amount = amount;
    }

}
