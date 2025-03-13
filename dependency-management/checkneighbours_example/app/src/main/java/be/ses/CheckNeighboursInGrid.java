package be.ses;

import java.util.*;

public class CheckNeighboursInGrid {
    /**
     * Finds immediate neighbors (including diagonals) that have the same value
     * as the element at indexToCheck.
     */
    public static Iterable<Integer> getSameNeighboursIds(Iterable<Integer> grid, int width, int height, int indexToCheck) {
        List<Integer> gridList = new ArrayList<>();
        for (int value : grid) {
            gridList.add(value);
        }
        
        int valueToCheck = gridList.get(indexToCheck);
        List<Integer> result = new ArrayList<>();
        
        int row = indexToCheck / width;
        int col = indexToCheck % width;
        
        // Direction vectors for immediate neighbors (including diagonals)
        int[][] directions = {
            {0, -1},  // Left
            {0, 1},   // Right
            {-1, 0},  // Up
            {1, 0},   // Down
            {-1, -1}, // Top-left diagonal
            {-1, 1},  // Top-right diagonal
            {1, -1},  // Bottom-left diagonal
            {1, 1}    // Bottom-right diagonal
        };
        
        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            
            // Check that the new position is within the grid boundaries
            if (newRow >= 0 && newRow < height && newCol >= 0 && newCol < width) {
                int newIndex = newRow * width + newCol;
                if (gridList.get(newIndex) == valueToCheck) {
                    result.add(newIndex);
                }
            }
        }
        
        return result;
    }
}
