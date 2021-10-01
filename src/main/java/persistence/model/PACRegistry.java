package persistence.model;

import lombok.Getter;
import lombok.Setter;
import java.util.List;
import static util.DataUtil.getDateString;

@Getter
@Setter
public class PACRegistry {
    private String date;
    private Long pacBalance;
    private Long countedBalance;
    private Long redBoxBalance;
    private Long gpBoxBalance;
    private Long grayBoxBalance;
    private List<PACDebtors> debtors;
    private Long difference;

    public PACRegistry() {
        this.date = getDateString();
    }

    @Override
    public String toString() {
        return "Registros del PAC {" + "\n" +
                "Fecha: " + date + "\n" +
                "Balance caja roja: " + redBoxBalance + "\n" +
                "Balance caja GP: " + gpBoxBalance + "\n" +
                "Balance caja gris: " + grayBoxBalance + "\n" +
                "Balance del PAC: " + pacBalance + "\n" +
                "Deudas: " + debtors + "\n" +
                "Total contado: " + countedBalance + "\n" +
                "Diferencia: " + difference + "\n" +
                "}";
    }
}
