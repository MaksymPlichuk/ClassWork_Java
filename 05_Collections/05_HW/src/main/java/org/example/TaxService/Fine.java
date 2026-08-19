package org.example.TaxService;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Fine {
    private String type;
    private double amount;

    @Override
    public String toString(){
        return "Type: %s | Amount: %.2f".formatted(type,amount);
    }
}
