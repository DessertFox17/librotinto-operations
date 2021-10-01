package domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class PACDebtorDTO {
    String name;
    Long debt;

    @Override
    public String toString() {
        return "Deudas pendientes {" + "\n" +
                "Nombre: " + name + "\n" +
                "Deuda: " + debt + "\n" +
                "}";
    }
}
