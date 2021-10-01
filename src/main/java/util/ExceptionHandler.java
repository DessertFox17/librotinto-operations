package util;

import java.util.Scanner;

public class ExceptionHandler {
    public int optionValidator(Scanner sc){
        int option = 0;
        try{
          option = Integer.parseInt(sc.nextLine());
        }catch(Exception ex){
            System.out.println("Algo salió mal: " + ex.getMessage());
        }
        return option;
    }

    public long valueValidator(Scanner sc){
        long option = 0;
        try{
            option = Long.parseLong(sc.nextLine());
        }catch(Exception ex){
            System.out.println("Algo salió mal: " + ex.getMessage());
        }
        return option;
    }
}
