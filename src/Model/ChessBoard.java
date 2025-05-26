package Model;


public class ChessBoard {
    public ChessPiece[][] board;
    String nowPlayerColor;

    public ChessBoard(String nowPlayerColor) {
        board = new ChessPiece[8][8];
        this.nowPlayerColor = nowPlayerColor;
    }

    public boolean moveToPosition(int fromLine, int fromColumn, int toLine, int toColumn) {
        if (!isValidPosition(fromLine, fromColumn, toLine, toColumn)) return false;

        ChessPiece piece = board[fromLine][fromColumn];
        if (piece == null || !piece.getColor().equals(nowPlayerColor)) return false;

        if (piece.canMoveToPosition(this, fromLine, fromColumn, toLine, toColumn)) {
            board[toLine][toColumn] = piece;
            board[fromLine][fromColumn] = null;
            piece.checkCastling = true;

            // Смена игрока
            nowPlayerColor = nowPlayerColor.equals("White") ? "Black" : "White";
            return true;
        }

        return false;
    }

    public boolean castling0() {
        if (nowPlayerColor.equals("White")) {
            if (board[0][0] instanceof Rook && board[0][4] instanceof King
                    && !board[0][0].checkCastling && !board[0][4].checkCastling
                    && board[0][1] == null && board[0][2] == null && board[0][3] == null) {

                board[0][2] = board[0][4];
                board[0][4] = null;
                board[0][3] = board[0][0];
                board[0][0] = null;
                board[0][2].checkCastling = true;
                board[0][3].checkCastling = true;

                nowPlayerColor = "Black";
                return true;
            }
        } else {
            if (board[7][0] instanceof Rook && board[7][4] instanceof King
                    && !board[7][0].checkCastling && !board[7][4].checkCastling
                    && board[7][1] == null && board[7][2] == null && board[7][3] == null) {

                board[7][2] = board[7][4];
                board[7][4] = null;
                board[7][3] = board[7][0];
                board[7][0] = null;
                board[7][2].checkCastling = true;
                board[7][3].checkCastling = true;

                nowPlayerColor = "White";
                return true;
            }
        }
        return false;
    }

    public boolean castling7() {
        if (nowPlayerColor.equals("White")) {
            if (board[0][7] instanceof Rook && board[0][4] instanceof King
                    && !board[0][7].checkCastling && !board[0][4].checkCastling
                    && board[0][5] == null && board[0][6] == null) {

                board[0][6] = board[0][4];
                board[0][4] = null;
                board[0][5] = board[0][7];
                board[0][7] = null;
                board[0][6].checkCastling = true;
                board[0][5].checkCastling = true;

                nowPlayerColor = "Black";
                return true;
            }
        } else {
            if (board[7][7] instanceof Rook && board[7][4] instanceof King
                    && !board[7][7].checkCastling && !board[7][4].checkCastling
                    && board[7][5] == null && board[7][6] == null) {

                board[7][6] = board[7][4];
                board[7][4] = null;
                board[7][5] = board[7][7];
                board[7][7] = null;
                board[7][6].checkCastling = true;
                board[7][5].checkCastling = true;

                nowPlayerColor = "White";
                return true;
            }
        }
        return false;
    }

    public boolean isUnderAttack(int line, int column, String color) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null && !piece.getColor().equals(color)) {
                    if (piece.canMoveToPosition(this, i, j, line, column)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public void printBoard() {
        System.out.println("  0 1 2 3 4 5 6 7");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == null) {
                    System.out.print("– ");
                } else {
                    String symbol = board[i][j].getSymbol();
                    System.out.print(
                            board[i][j].getColor().equals("White") ? symbol : symbol.toLowerCase()
                    );
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    private boolean isValidPosition(int fromLine, int fromColumn, int toLine, int toColumn) {
        return fromLine >= 0 && fromLine < 8 && fromColumn >= 0 && fromColumn < 8
                && toLine >= 0 && toLine < 8 && toColumn >= 0 && toColumn < 8;
    }
}

