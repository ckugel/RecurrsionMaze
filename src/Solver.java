import java.util.ArrayList;
import java.util.HashMap;

public class Solver {
    private Square[][] matrix;
    private boolean stopper = false;
    private int maxDimensions;
    private HashMap map = new HashMap();
    public Solver(Square[][] matrix, int dimension) {
        this.matrix = matrix;
        maxDimensions = dimension;
    }

    public void solveMaze(int x, int y) {
        if (stopper) {
            return;
        }
        if (x >= maxDimensions) {
            stopper = true;
            return;
        }
        if(y >= maxDimensions) {
            return;
        }
        if (matrix[x][y].getColor() == 1) {
            matrix[x][y].updateColor(2);
            stopper = true;
            solverMaze(x, y);
        }
        solveMaze(x, y+1);
        solveMaze(x+1, 0);
    }

    public void solverMaze(int x, int y) {
        try {
            if (matrix[x][y + 1].getColor() == 1) {
                matrix[x][y + 1].updateColor(2);
                solverMaze(x, y + 1);
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            if (matrix[x][y - 1].getColor() == 1) {
                matrix[x][y - 1].updateColor(2);
                solverMaze(x, y - 1);
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            if (matrix[x + 1][y].getColor() == 1) {
                matrix[x + 1][y].updateColor(2);
                solverMaze(x + 1, y);
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored) {}
        try {
            if (matrix[x - 1][y].getColor() == 1) {
                matrix[x - 1][y].updateColor(2);
                solverMaze(x - 1, y);
            }
        }
        catch (ArrayIndexOutOfBoundsException ignored) {}
    }
}