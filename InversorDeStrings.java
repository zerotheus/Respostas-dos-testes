import java.util.Scanner;

public class InversorDeStrings {

    public static void main(String[] args) {
        System.out.println("Digite qualquer palavra");
        Scanner scanner = new Scanner(System.in);
        String base = scanner.next();
        // Eu queria usar o String builder pois ele funciona melhor, mas como não irei
        // usar nada pronto
        String invertida = "";
        for (int i = base.length() - 1; i >= 0; i--) {
            invertida += base.charAt(i);
        }
        System.out.println("A string invertida é: " + invertida);
    }
}
