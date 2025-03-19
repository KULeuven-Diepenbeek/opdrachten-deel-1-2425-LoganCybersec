package be.ses;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import java.util.List;
import java.util.Arrays;

public class CheckNeighboursInGridTest {

    @Test
    public void gegevenElementInMidden_wanneerGetSameNeighboursIds_danCorrecteIds() {
        // 1. Arrange
        CheckNeighboursInGrid checkNeighbours = new CheckNeighboursInGrid();
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 5;

        // 2. Act
        Iterable<Integer> result = checkNeighbours.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 3. Assert
        assertThat(result).containsExactlyInAnyOrder(2, 4, 10);
    }

    @Test
    public void gegevenElementInLinkerRand_wanneerGetSameNeighboursIds_danCorrecteIds() {
        // 1. Arrange
        CheckNeighboursInGrid checkNeighbours = new CheckNeighboursInGrid();
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 4;

        // 2. Act
        Iterable<Integer> result = checkNeighbours.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 3. Assert
        assertThat(result).containsExactlyInAnyOrder(5);
    }

    @Test
    public void gegevenElementInRechterRand_wanneerGetSameNeighboursIds_danCorrecteIds() {
        // 1. Arrange
        CheckNeighboursInGrid checkNeighbours = new CheckNeighboursInGrid();
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 7;

        // 2. Act
        Iterable<Integer> result = checkNeighbours.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 3. Assert
        assertThat(result)
            .withFailMessage("No neighbours found")
            .isEmpty();
    }

    @Test
    public void gegevenElementInBovenhoek_wanneerGetSameNeighboursIds_danCorrecteIds() {
        // 1. Arrange
        CheckNeighboursInGrid checkNeighbours = new CheckNeighboursInGrid();
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 0;

        // 2. Act
        Iterable<Integer> result = checkNeighbours.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 3. Assert
        assertThat(result).containsExactlyInAnyOrder(1);
    }

    @Test
    public void gegevenElementInOnderhoek_wanneerGetSameNeighboursIds_danCorrecteIds() {
        // 1. Arrange
        CheckNeighboursInGrid checkNeighbours = new CheckNeighboursInGrid();
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 15;

        // 2. Act
        Iterable<Integer> result = checkNeighbours.getSameNeighboursIds(grid, width, height, indexToCheck);

        // 3. Assert
        assertThat(result).containsExactlyInAnyOrder(10, 14);
    }

    @Test
    public void gegevenOngeldigElement_wanneerGetSameNeighboursIds_danThrowException() {
        // 1. Arrange
        CheckNeighboursInGrid checkNeighbours = new CheckNeighboursInGrid();
        List<Integer> grid = Arrays.asList(
            0, 0, 1, 0,
            1, 1, 0, 2,
            2, 0, 1, 3,
            0, 1, 1, 1
        );
        int width = 4;
        int height = 4;
        int indexToCheck = 16;

        // 2. Act & 3. Assert
        assertThatThrownBy(() -> checkNeighbours.getSameNeighboursIds(grid, width, height, indexToCheck))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("Element not found in grid");
    }
}