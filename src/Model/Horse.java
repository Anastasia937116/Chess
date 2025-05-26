package Model;

public class Horse extends ChessPiece {
    public Horse(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "H";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (fromLine == toLine && fromColumn == toColumn) return false;
        if (toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8) {
            if (Math.abs(fromLine - toLine) * Math.abs(fromColumn - toColumn) == 2) {
                return board.board[toLine][toColumn] == null ||
                        !board.board[toLine][toColumn].getColor().equals(this.color);
            }
        }
        return false;
    }
}

