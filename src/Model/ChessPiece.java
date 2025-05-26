package Model;
public abstract class ChessPiece {
    String color; // "White" или "Black"
    boolean checkCastling = false;

    public ChessPiece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public boolean isKing() {
        return false;
    }

    public abstract String getSymbol();

    public abstract boolean canMoveToPosition(ChessBoard board, int fromLine, int fromColumn, int toLine, int toColumn);
}
