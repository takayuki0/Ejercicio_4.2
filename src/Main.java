import java.io.*;
import java.math.BigInteger;
import java.util.Scanner;
/**
 * 4.- Realiza un programa en JAVA en el que muestres un menú que te permita 3 opciones:
 * 1. Volcado de un array con los 100 primeros números pares a un fichero de texto.
 * El nombre del fichero lo elegirá el usuario.
 * 2. Mostrar por pantalla el contenido del fichero de texto creado.
 * 3. Calcular la suma de dicho fichero
 * 4. Calcular la multiplicación de dicho fichero
 * 5. Salir del Programa.
 */
public class Main {
    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        int arrayDeNumerosPares[] = new int[50];

        int j = 1;
        for (int i = 0; i < arrayDeNumerosPares.length; i++) {
            arrayDeNumerosPares[i] = j * 2;
            j++;
        }

        System.out.println("********************************************************************");
        System.out.println("**                        Menú de Opciones                        **");
        System.out.println("** Opción 1: Volcar Array de Números Pares a un Fichero.          **");
        System.out.println("** Opción 2: Mostrar Por Pantalla el Contenido del Fichero.       **");
        System.out.println("** Opción 3: Calcular la Suma de dicho Fichero.                   **");
        System.out.println("** Opción 4: Calcular la Multiplicación de dicho Fichero.         **");
        System.out.println("** Opción 5: Salir del Programa.                                  **");
        System.out.println("********************************************************************");

        boolean seguir = true;
        while (seguir) {
            System.out.print("Ingrese una Opción: ");
            int opcion = entrada.nextInt();
            if (opcion == 1) {

                File archivo = new File("numPares.txt");
                try {
                    BufferedWriter bw = new BufferedWriter(new FileWriter(archivo));
                    for (int i = 0; i < arrayDeNumerosPares.length; i++) {
                        bw.write("[" + arrayDeNumerosPares[i] + "] ");
                    }
                    bw.close();

                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (opcion == 2) {

                File archivoReader = new File("H:\\Gabriel\\Ies El Rincon\\Programación\\Java\\UT7 Excepciones y ficheros (JAVA)\\Actividad 7.1\\Ejercicio_3.2\\numPares.txt");
                try {
                    BufferedReader br = new BufferedReader(new FileReader(archivoReader));
                    String dato = br.readLine();

                    while (dato != null) {
                        System.out.println(dato);
                        dato = br.readLine();
                    }
                    br.close();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }

            } else if (opcion == 3) {

                int suma = 0;
                for (int i = 0; i < arrayDeNumerosPares.length; i++) {
                    suma += arrayDeNumerosPares[i];
                }
                System.out.println("El resultado de la suma de los Números Pares es: " + suma);

            } else if (opcion == 4) {

                BigInteger multiplicacion = BigInteger.valueOf(1);
                BigInteger num2;
                for (int i = 0; i < arrayDeNumerosPares.length; i++) {
                    num2 = BigInteger.valueOf(arrayDeNumerosPares[i]);
                    multiplicacion = multiplicacion.multiply(num2);
                }
                System.out.println("El resultado de la multiplicación de los Números Pares es: " + multiplicacion);

            } else if (opcion == 5) {

                System.out.println("Programa Finalizado!");
                seguir = false;

            } else {

                System.out.println("Has Ingresado una Opción Inválida!");
            }
        }

    }
}