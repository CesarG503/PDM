import java.sql.Array;
import java.util.Arrays;
import java.util.Scanner;

public class Empleado {

    public static void main(String[] args)
    {
        //final para constantes
        final int CONSTANTE = 12;

        //datos primitivos
        int number ;
        float flotante;
        double decimal;
        long NumeroLargo;
        boolean bool = false;
        char letra = 'a' ;

        var uno = 1; // variable no tipada

        //datos no primitivos

        String nombre = "JUAN";
        int[] numeros = new int[5]; //arreglos

        System.out.println(nombre.getClass().getSimpleName() ); // forma de Obtener el tipo de datos de objetos

        System.out.println("Hola desde clase empleados");


        Scanner sc = new Scanner(System.in);

        System.out.println("Ingresa tu edad");
        number = sc.nextInt();

        System.out.println("Ingresa tu nombre");
        nombre = sc.next();

        System.out.println("tu nombre es: " + nombre);
        System.out.println("Tu edad es = "+ number);

        System.out.printf("string %s ", nombre);


        double a = 1;
        double b = 2;

        int c = 10;
        int d = 20;

        double suma = a + b;
        double resta = a - b ;
        double multiplicacion = a * b;
        double division = a /b;
        double modulo =  a % 2 ;


        double cuadra = Math.pow(a,2);

        //Operaciones relacionales

        if (!(a >= c) & d == 2)
        {
            System.out.println("TRUE");
        }

        // Operaciones de asignacion

        var x =2;

        for(int i=0; i <=10; i++)
        {
            x++;
            x--;
            x *= x;
            //x /= x;
            //x %= x;
            System.out.println(x);
        }








    }
}
