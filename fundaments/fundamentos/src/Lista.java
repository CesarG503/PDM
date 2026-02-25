import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

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

        int index = numeros.indexOf(100);

        if(numeros.contains(100))
        {
            System.out.println("si");
            numeros.remove(index);
        }
        for (int item: numeros)
        {
            System.out.println(item);
        }

        HashMap<String, String> diccionario = new HashMap<>(); //como hacer un diccionario


        diccionario.put("Hola","como estas");

        diccionario.get("Hola");


        Integer array[] = new Integer[5];

        for (int i = 0; i < 5 ; i++)
        {
            array[i]=i;
        }

        ArrayList<Integer> lista = new ArrayList<>();

        lista.addAll(Arrays.asList(array));

        HashMap<Integer, Integer> dic = new HashMap<>();


        for (Integer x: lista)
        {
            dic.put(x,x);
        }

        System.out.println(dic);




    }
}
