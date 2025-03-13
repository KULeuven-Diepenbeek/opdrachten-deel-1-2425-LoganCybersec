package be.ses;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        // Define the grid as a 1D Iterable
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );

        int width = 4;
        int height = 4;
        
        // Ask the user which index to test
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the index you want to test (0 - " + (grid.size() - 1) + "): ");
        int indexToTest = scanner.nextInt();
        
        // Validate index
        if (indexToTest < 0 || indexToTest >= grid.size()) {
            System.out.println("Invalid index. Please enter a value between 0 and " + (grid.size() - 1) + ".");
            scanner.close();
            return;
        }
    
        // Run the method from CheckNeighboursInGrid
        Iterable<Integer> result = CheckNeighboursInGrid.getSameNeighboursIds(grid, width, height, indexToTest);
    
        // Print results
        System.out.println("Immediate neighbors with same value as index " + indexToTest + ": " + result);
        scanner.close();
    }
}
