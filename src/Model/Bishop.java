package Model;

public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "B";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (Math.abs(fromLine - toLine) != Math.abs(fromColumn - toColumn)) return false;

        int stepLine = Integer.compare(toLine, fromLine);
        int stepCol = Integer.compare(toColumn, fromColumn);
        int line = fromLine + stepLine;
        int col = fromColumn + stepCol;
        while (line != toLine && col != toColumn) {
            if (board.board[line][col] != null) return false;
            line += stepLine;
            col += stepCol;
        }

        return board.board[toLine][toColumn] == null ||
                !board.board[toLine][toColumn].getColor().equals(this.color);
    }
}
