package ViewHelper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ScannerValidation {

    public byte validateByteScanner(int min, int max, String msg) {
        byte input = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print(msg);
                if (scanner.hasNextByte()) {
                    input = scanner.nextByte();
                    if (input >= min && input <= max) {
                        break;
                    } else {
                        System.out.println("O número deve estar presente na lista.");
                    }
                } else {
                    System.out.println("A escolha deve ser um número.");
                    scanner.next();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + Arrays.toString(e.getStackTrace()));
        }
        return input;
    }

    public double validateDoubleScanner(String msg) {
        double input = -1;
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print(msg);
                if (scanner.hasNextDouble()) {
                    input = scanner.nextDouble();
                    if (input >= 0) {
                        break;
                    } else {
                        System.out.println("O número deve ser positivo.");
                    }
                } else {
                    System.out.println("A escolha deve ser um número.");
                    scanner.next();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + e);
        }
        return input;
    }

    public Date validateSqlDateScanner(String msg) {
        Date input = Date.valueOf("1970-01-01");
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print(msg);
                System.out.print("Escreva a data neste formato: AAAA-MM-DD (Ex.: 2024-05-30)\nData: ");
                if (scanner.hasNext()) {
                    String aux = scanner.next();
                    if (aux.matches("\\d{4}-\\d{2}-\\d{2}")) {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        simpleDateFormat.setLenient(false);
                        try {
                            simpleDateFormat.parse(aux);
                            input = Date.valueOf(aux);
                            break;
                        } catch (ParseException e) {
                            System.out.println("Houve um erro na data digitada. Use uma data válida.");
                        }
                    } else {
                        System.out.println("Siga a instrução para digitar a data.");
                    }
                } else {
                    System.out.println("Houve um erro ao escolher a data.");
                    scanner.next();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + e);
        }
        return input;
    }
}
