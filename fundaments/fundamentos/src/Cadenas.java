import java.util.Stack;

public class Cadenas {
    public static void main(String args[])
    {
        boolean True = true;
        String cadenas = "";

        cadenas = "hola";

        cadenas = "1";
        double a = 2.322d;
        float b = 21.1f;
        long c = 321232132L;

        int num = Integer.parseInt(cadenas,2); //convertir en int
        float chart = Float.parseFloat("2.321");
        double newd = chart;

        int num2 = (int) a;

        int conversion = True ? 1 :0 ;

        System.out.println(conversion);


        System.out.println(cadenas.charAt(0));

        if (cadenas.equals("1"))
        {
            System.out.println("SIIIU");
        }

        String nueva = cadenas.replace("1","Hola como estan");

        System.out.println(nueva);


        String.format("Hola como estas", a,b,c);




    }
}
