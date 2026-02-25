import java.util.IllegalFormatCodePointException;
import java.util.Scanner;

public class Matematica {

    public static void main(String args[])
    {

        //conversion de numeros a binarios
        int numero = Integer.parseInt("1001010110",2);
        System.out.println(numero);

        //cualquier dato a String
        String cadena = String.valueOf(12);


        Scanner sc = new Scanner(System.in);

        System.out.println("Ingreas tu numero: ");
        int num = sc.nextInt();

        if(num % 2 == 0)
        {
            System.out.println("El numero es par");
        }
        else
        {
            System.out.println("El numero es impar");
        }


        System.out.println("Ingresa un numero binario");
        String binario = sc.next();

        System.out.println("Tu numero binario es: "+ Integer.parseInt(binario,2));

    }





}


