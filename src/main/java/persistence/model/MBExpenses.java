package persistence.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MBExpenses {
    private String expense;
    private Long cost;

    public MBExpenses(String expense, Long cost){
        this.expense = expense;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Costos del día {" + "\n" +
                "Producto: " + expense + "\n" +
                "Costo: " + cost + "\n" +
                "}";
    }
}
