package Model;

public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getSymbol() {
        return "Q";
    }

    @Override
    public boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn) {
        Rook rook = new Rook(this.color);
        Bishop bishop = new Bishop(this.color);
        return rook.canMoveToPosition(board, fromLine, fromColumn, toLine, toColumn) ||
                bishop.canMoveToPosition(board, fromLine, fromColumn, toLine, toColumn);
    }
}

