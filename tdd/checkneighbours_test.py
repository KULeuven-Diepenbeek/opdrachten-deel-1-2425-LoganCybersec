import unittest
from checkneighbours import get_same_neighbours_ids

class TestFunctions(unittest.TestCase):
    def test_gegevenElementInMidden_wanneerGetSameNeighboursIds_danCorrecteIds(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 5)
        # Assert
        self.assertEqual(result, [2, 4, 10])

    def test_gegevenElementInLinkerRand_wanneerGetSameNeighboursIds_danCorrecteIds(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 4)
        # Assert
        self.assertEqual(result, [5])

    def test_gegevenGeenBuren_wanneerGetSameNeighboursIds_GeenNeighboursFound(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 7)
        # Assert
        self.assertEqual(result, [], "No neighbours found")

    def test_gegevenElementInBovenhoek_wanneerGetSameNeighboursIds_danCorrecteIds(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 0)
        # Assert
        self.assertEqual(result, [1])

    def test_gegevenElementInOnderhoek_wanneerGetSameNeighboursIds_danCorrecteIds(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act
        result = get_same_neighbours_ids(voorbeeld_grid, 4, 4, 15)
        # Assert
        self.assertEqual(result, [10, 14])

    def test_gegevenOngeldigElement_wanneerGetSameNeighboursIds_danThrowException(self):
        # Arrange
        voorbeeld_grid = [ 0, 0, 1, 0,
                          1, 1, 0, 2,
                          2, 0, 1, 3,
                          0, 1, 1, 1 ]
        # Act & Assert
        with self.assertRaises(IndexError) as context:
            get_same_neighbours_ids(voorbeeld_grid, 4, 4, 16)
        self.assertTrue("index_to_check is out of range" in str(context.exception))

if __name__ == '__main__':
    unittest.main()