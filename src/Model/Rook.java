package Model;

public class Rook extends ChessPiece {
    public Rook(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "R";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (fromLine != toLine && fromColumn != toColumn) return false;

        int stepLine = Integer.compare(toLine, fromLine);
        int stepCol = Integer.compare(toColumn, fromColumn);
        int line = fromLine + stepLine;
        int col = fromColumn + stepCol;
        while (line != toLine || col != toColumn) {
            if (board.board[line][col] != null) return false;
            if (line != toLine) line += stepLine;
            if (col != toColumn) col += stepCol;
        }

        return board.board[toLine][toColumn] == null ||
                !board.board[toLine][toColumn].getColor().equals(this.color);
    }
}

