public class Strin {

    public static void main(String args[])
    {
        String cadena1 = "   hola";
        String cadena2 = " mundo   ";
        String numero1 = "100";
        int numero2 = 10;
        String contatenado = cadena1 + cadena2;

        System.out.println(contatenado.length());

        System.out.println(contatenado.charAt(0));
        System.out.println(contatenado.charAt(contatenado.length() -1 ));

        contatenado.toLowerCase();
        contatenado.toUpperCase();

        if(contatenado.contains("mundo"))
        {
            System.out.println(String.format("Si contiene %s","mundo"));
        }


        String form1 = String.valueOf(numero2);

        int form2 = Integer.parseInt(numero1);

        System.out.println(contatenado.strip());



    }
}
