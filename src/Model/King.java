package Model;

public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "K";
    }

    @Override
    public boolean isKing() {
        return true;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn) {
        if (Math.abs(fromLine - toLine) <= 1 && Math.abs(fromColumn - toColumn) <= 1) {
            return board.board[toLine][toColumn] == null ||
                    !board.board[toLine][toColumn].getColor().equals(this.color);
        }
        return false;
    }
}

