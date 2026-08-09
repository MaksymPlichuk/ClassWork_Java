package org.example.Money;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private String name;
    private int quantity;
    private String desc;
    private Money price;

    public void ReducePrice(int amount){
        int dollar = this.price.getWholeDollar();
        this.price.setWholeDollar(dollar-amount);
    }

    @Override
    public String toString(){
        return "\n%s quantity:%d description:%s; price per item:\n".formatted(name,quantity,desc)+price;
    }

}
