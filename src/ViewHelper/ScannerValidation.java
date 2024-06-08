package ViewHelper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

// Classe auxiliar para validar os inputs dos usuários
public class ScannerValidation {

    // Valida se o tipo de dado passado pelo usuário é um tipo Byte. Repete-se enquanto não houver correspondência
    public byte validateByteScanner(int min, int max, String msg) {
        // Inicializando o input com um valor padrão e não utilizável
        byte input = -1;
        // Instanciando um novo scanner para obter o input do usuário
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                // Mostra a mensagem vinda do parâmetro ao usuário
                System.out.print(msg);
                // Se houver resultados, atribui à variável input
                if (scanner.hasNextByte()) {
                    input = scanner.nextByte();
                    // Se o input estiver dentro dos limites, prossegue
                    if (input >= min && input <= max) {
                        break;
                    } else {
                        System.out.println("O número deve estar presente na lista.");
                    }
                } else {
                    System.out.println("A escolha deve ser um número.");
                    // Lê a próxima informação no buffer para liberar o valor que gerou um erro, guardado no scanner
                    scanner.next();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + Arrays.toString(e.getStackTrace()));
        }
        return input;
    }

    // Valida se o tipo de dado passado pelo usuário é um tipo Double. Repete-se enquanto não houver correspondência
    public double validateDoubleScanner(String msg) {
        // Inicializando o input com um valor padrão e não utilizável
        double input = -1;
        // Instanciando um novo scanner para obter o input do usuário
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                // Mostra a mensagem vinda do parâmetro ao usuário
                System.out.print(msg);
                // Se houver resultados, atribui à variável input
                if (scanner.hasNextDouble()) {
                    input = scanner.nextDouble();
                    // Se o input for maior que zero, é um número válido
                    if (input >= 0) {
                        break;
                    } else {
                        System.out.println("O número deve ser positivo.");
                    }
                } else {
                    System.out.println("A escolha deve ser um número.");
                    // Lê a próxima informação no buffer para liberar o valor que gerou um erro, guardado no scanner
                    scanner.next();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + e);
        }
        return input;
    }

    // Valida se o tipo de dado passado pelo usuário é um tipo Date (do sql). Repete-se enquanto não houver correspondência
    public Date validateSqlDateScanner(String msg) {
        // Inicializando a data com um valor padrão
        Date input = Date.valueOf("1970-01-01");
        // Instanciando um novo scanner para obter o input do usuário
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                // Mostra a mensagem vinda do parâmetro ao usuário
                System.out.print(msg);
                System.out.print("Escreva a data neste formato: AAAA-MM-DD (Ex.: 2024-05-30)\nData: ");
                // Se houver resultados, atribui à variável input
                if (scanner.hasNext()) {
                    String aux = scanner.next();
                    // Verificação simples em regex. Se houver uma concordância entre a data digitada e o resultado da regex, prossegue
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
                    // Lê a próxima informação no buffer para liberar o valor que gerou um erro, guardado no scanner
                    scanner.next();
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Erro: " + e);
        }
        return input;
    }
}
