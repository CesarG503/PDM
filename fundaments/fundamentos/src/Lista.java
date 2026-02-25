import java.util.ArrayList;

public class Lista
{
    public static void main(String Args[])
    {

        ArrayList<String> nombres = new ArrayList<String>();

        ArrayList<Integer> numeros = new ArrayList<>();


        numeros.add(1);
        numeros.add(2);
        System.out.println(numeros.get(1)); //obtener


        numeros.removeLast();

        System.out.println(numeros.getLast());


        int tamaño = numeros.size(); //tamaño


        numeros.set(0,100);
        for (int numero: numeros)
        {
            System.out.println(numero);
        }





    }
}
