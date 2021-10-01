package persistence.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;

import static util.DataUtil.getDateString;

@Getter
@Setter
public class MBRegistry {
    private String date;
    private Long countedBalance;
    private Long baseBalance;
    private List<MBDebtors> debts;
    private List<MBExpenses> expenses;
    private Long gain;

    public MBRegistry() {
        this.date = getDateString();
    }

    @Override
    public String toString() {
        return "Registros de la caja Principal {" + "\n" +
                "Fecha: " + date + "\n" +
                "Total contado: " + countedBalance + "\n" +
                "Base: " + baseBalance + "\n" +
                "Deudas: " + debts + "\n" +
                "Gastos: " + expenses + "\n" +
                "Ganacia total: " + gain + "\n" +
                "}";
    }
}
