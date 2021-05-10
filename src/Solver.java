import java.util.ArrayList;
import java.util.HashMap;

public class Solver {
    public enum direction {
        N,
        E,
        S,
        W,
    }
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
            // solveMaze(x, y, possibleDirections[0]);
        }
        solveMaze(x, y+1);
        solveMaze(x+1, 0);
    }
}
