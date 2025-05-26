package Model;

public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "P";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (fromColumn == toColumn) {
            if (color.equals("White")) {
                if (toLine == fromLine + 1 && board.board[toLine][toColumn] == null) return true;
                if (fromLine == 1 && toLine == 3 && board.board[2][toColumn] == null && board.board[3][toColumn] == null)
                    return true;
            } else {
                if (toLine == fromLine - 1 && board.board[toLine][toColumn] == null) return true;
                if (fromLine == 6 && toLine == 4 && board.board[5][toColumn] == null && board.board[4][toColumn] == null)
                    return true;
            }
        } else if (Math.abs(fromColumn - toColumn) == 1) {
            if (color.equals("White") && toLine == fromLine + 1 && board.board[toLine][toColumn] != null
                    && !board.board[toLine][toColumn].getColor().equals(this.color)) return true;
            if (color.equals("Black") && toLine == fromLine - 1 && board.board[toLine][toColumn] != null
                    && !board.board[toLine][toColumn].getColor().equals(this.color)) return true;
        }
        return false;
    }
}
