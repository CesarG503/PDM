import java.util.Arrays;

public class dato {


    public static  void main(String args[])
    {

        int[] numbers; //arreglos de enteros

        int[] numeros = new int[2] ;

        numeros[0] = 1;
        numeros[1] = 10;


        int min = Arrays.stream(numeros).max().getAsInt();

        double promedio = Arrays.stream(numeros).average().getAsDouble();

        System.out.println(promedio);





    }
}
