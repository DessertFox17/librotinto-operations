package persistence.model;

public class MBDebtors {
    private String name;
    private Long debt;

    public MBDebtors(String name, Long debt){
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
