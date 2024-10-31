package org.demo.parcialGabrielIglesias;

import org.demo.parcialGabrielIglesias.services.MutantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class ParcialGabrielIglesiasApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(ParcialGabrielIglesiasApplication.class, args);
        System.out.println("===SERVER INICIADO===");

        MutantService mutantService = context.getBean(MutantService.class);
        Scanner scanner = new Scanner(System.in);

        boolean continuar = true;

        while (continuar) {
            System.out.print("Ingrese el tamaño de la matriz NxN (n): ");
            int n = scanner.nextInt();
            scanner.nextLine();  // Consumir el salto de línea

            String[] dna = new String[n];
            System.out.println("Ingrese " + n + " filas de ADN (cada fila debe tener " + n + " caracteres):");

            for (int i = 0; i < n; i++) {
                String input = scanner.nextLine();
                if (input.length() != n || !input.matches("[ATCG]+")) {
                    System.out.println("Entrada inválida. La fila debe tener " + n + " caracteres y solo contener A, T, C, G.");
                    i--;  // Repetir la entrada actual si es inválida
                } else {
                    dna[i] = input;
                }
            }

            try {
                boolean isMutant = mutantService.analyzeDna(dna);
                System.out.println("Secuencia de ADN guardada en la base de datos.");
                if (isMutant) {
                    System.out.println("La secuencia de ADN es mutante.");
                } else {
                    System.out.println("La secuencia de ADN no es mutante.");
                }
            } catch (Exception e) {
                System.out.println("No fue posible guardar la secuencia en la base de datos.");
                e.printStackTrace();
            }

            System.out.print("Ingrese s para continuar o n para salir: ");
            String respuesta = scanner.nextLine().trim().toLowerCase();
            if (!respuesta.equals("s")) {
                continuar = false;  // Salir del bucle si la respuesta no es 's'
            }
        }

        scanner.close();
        System.out.println("=== PROGRAMA FINALIZADO ===");
    }

}
