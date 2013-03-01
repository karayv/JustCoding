package my.coding.matrix.game;

/**
 * This class is a helper service for tick-tack-toe game field with arbitrary
 * field size and arbitrary size of the line to win.
 * 
 * @author Andrey Karayvansky
 * 
 */
public class OXChecker {

    /**
     * Checks whether the last move was winning or not.
     * 
     * @param field the game field with possible values 1, 2 or 0 (0 is no move).
     * @param lastX last move coordinate X
     * @param lastY last move coordinate Y
     * @param sizeToWin size of a line to win
     * @return true if last move was winning 
     */
    public boolean check(byte[][] field, int lastX, int lastY, int sizeToWin) {
        if (field == null) {
            throw new NullPointerException("Field cannot be null.");
        }
        if (lastX <= 0 || lastY <= 0 || sizeToWin <= 0) {
            throw new IllegalArgumentException("LastX, lastY and sizeToWin should be positive.");
        }
        byte val = field[lastX][lastY];
        if (val == 0) {
            throw new IllegalArgumentException("The move was not made!");
        }
        
        if (checkWinByDirection(field, lastX, lastY, sizeToWin, -1, -1) ||
            checkWinByDirection(field, lastX, lastY, sizeToWin,  0, -1) ||
            checkWinByDirection(field, lastX, lastY, sizeToWin,  1, -1) ||
            checkWinByDirection(field, lastX, lastY, sizeToWin, -1,  0)) {
            return true;
        }
        return false;
    }

    private boolean checkWinByDirection(byte[][] field, int x, int y, int sizeToWin, int deltaX, int deltaY) {
        int leftLineSize = checkNeighbor(field, x, y, sizeToWin, deltaX, deltaY, 1);
        
        if (leftLineSize >= sizeToWin || leftLineSize + checkNeighbor(field, x, y, sizeToWin, -deltaX, -deltaY, 0) >= sizeToWin) {
            return true;
        }
        return false;
    }
    
    private int checkNeighbor(byte[][] field, int x, int y, int sizeToWin, int deltaX, int deltaY, int i) {
        if (x + deltaX < 0 || y + deltaY < 0 || x + deltaX >= field.length || y + deltaY >= field[x + deltaX].length) {
            return i;
        }
        
        if (field[x][y] > 0 && field[x][y] == field[x + deltaX][y + deltaY]) {
            i++;
            if (i >= sizeToWin) {
                return i;
            }
            i = checkNeighbor(field, x + deltaX, y + deltaY, sizeToWin, deltaX, deltaY, i);
        }
        return i;
    }

}
