import java.util.Scanner;

public class Fibonacci {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numero = scanner.nextInt();
        System.out.println(estaNaSequenciaDeFibonacci(numero));
    }

    public static boolean estaNaSequenciaDeFibonacci(int numero) {
        if (numero < 0) {
            return false;
        }
        if (numero == 0 || numero == 1) {
            return true;
        }
        int[] numerosDeFibonaci = { 0, 1 };
        int proximoDaSequencia = numerosDeFibonaci[1] + numerosDeFibonaci[0];
        while (proximoDaSequencia <= numero) {
            if (proximoDaSequencia == numero) {
                return true;
            }
            numerosDeFibonaci[0] = numerosDeFibonaci[1];
            numerosDeFibonaci[1] = proximoDaSequencia;
            proximoDaSequencia = numerosDeFibonaci[1] + numerosDeFibonaci[0];
        }
        return false;
    }

}