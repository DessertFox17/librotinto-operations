package persistence.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PACDebtors {
    String name;
    Long debt;

    public PACDebtors(String name, Long debt){
        this.name = name;
        this.debt = debt;
    }

    @Override
    public String toString() {
        return "Deudas pendientes {" + "\n" +
                "Nombre: " + name + "\n" +
                "Deuda: " + debt + "\n" +
                "}";
    }
}
