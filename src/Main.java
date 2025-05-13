import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Leer el párrafo
        System.out.println("Ingrese el párrafo:");
        String input = sc.nextLine();
        String[] words = input.trim().split("\\s+");

        // Calcular longitudes
        int[] wordLengths = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            wordLengths[i] = words[i].length();
        }

        // Leer el ancho de línea
        System.out.print("Ingrese el ancho máximo de cada línea (M): ");
        int M = sc.nextInt();

        // Ejecutar el algoritmo
        WordWrapper justifier = new WordWrapper(words, wordLengths, M);
        justifier.computeOptimal();
        justifier.printSolution();
    }
}
