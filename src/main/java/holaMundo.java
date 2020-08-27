public class holaMundo {
    public static void main(String args[]){
        System.out.print("Hola Mundo\n");

        String mensaje1 = "\nExiste bandera";
        String mensaje2 = "\nNo existe bandera";
        int numero1 = 5;
        boolean bandera1 = false;


        System.out.print("Variable numero1: " + numero1);

        if (bandera1){
            System.out.print("Variable Mensaje1: " + mensaje1);
        } else{
            System.out.print(mensaje2);
        }

        for(int i=0; i<numero1; i++){
            System.out.print("\nContador = " + i);
        }

        numero1 = 0;
        while (numero1 < 5){
            System.out.print("\nValor Numero: " + numero1);
            numero1 ++;

        }

    }
}
