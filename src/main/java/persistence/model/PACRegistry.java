package persistence.model;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
public class PACRegistry {
    /**
     * Attributes
     */
    private String date;
    private Long pacBalance;
    private Long countedBalance;
    private Long redBoxBalance;
    private Long gpBoxBalance;
    private Long grayBoxBalance;
    private Long difference;
    /**
     * Constructors
     */
    private PACRegistry() {
        this.date = date();
    }

    public PACRegistry(Long redBoxBalance, Long gpBoxBalance, Long grayBoxBalance, Long pacBalance) {
        this();
        this.pacBalance = pacBalance;
        this.redBoxBalance = redBoxBalance;
        this.gpBoxBalance = gpBoxBalance;
        this.grayBoxBalance = grayBoxBalance;
        this.countedBalance = redBoxBalance + gpBoxBalance + grayBoxBalance;
        this.difference = countedBalance - pacBalance;
    }
    /**
     * Methods
     */
    protected String date (){
        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return date.format(formatter);
    }

    @Override
    public String toString() {
        return "Registros del PAC {" + "\n" +
                "Fecha: " + date + "\n" +
                "Balance caja roja: " + redBoxBalance + "\n" +
                "Balance caja GP: " + gpBoxBalance + "\n" +
                "Balance caja gris: " + grayBoxBalance + "\n" +
                "Balance del PAC: " + pacBalance + "\n" +
                "Total contado: " + countedBalance + "\n" +
                "Diferencia: " + difference + "\n" +
                "}";
    }
}
