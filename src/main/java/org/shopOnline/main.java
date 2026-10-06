package org.shopOnline;

import java.sql.SQLOutput;
import java.util.Scanner;

public class main {
    static void main() {
        System.out.println(" BIENVENIDOS PORTAL  Simulación de Tienda Online ");
        Scanner teclado = new Scanner(System.in);

        int opcionRol = teclado.nextInt();
        do{
            System.out.println("Seleccina el rol");
            System.out.println("1-Administador");
            System.out.println("2-Cajero");
            System.out.println("3-Cerrar Seccion");


        }while (opcionRol != 8);
    }
}
