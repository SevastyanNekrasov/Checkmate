public class Horse extends ChessPiece {

    public String symbol;

    public Horse(String color) {
        super(color);
        this.symbol = "H";
    }

    public String getColor() {
        return this.color;
    }

    public String getSymbol() {
        return this.symbol;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 8 && toLine >= 0 && toColumn < 8 && toColumn >= 0 && chessBoard.board[line][column] != null) {
            boolean a = ((toLine + 2 == line) || (toLine - 2 == line)) && ((toColumn + 1 == column) || (toColumn - 1 == column));
            boolean b = ((toLine + 1 == line) || (toLine - 1 == line)) && ((toColumn + 2 == column) || (toColumn - 2 == column));
            if (chessBoard.board[toLine][toColumn] == null) {
                if (a) return true;
                else if (b) return true;
                else return false;
            }
            else if (!chessBoard.board[toLine][toColumn].getColor().equals(color)) {
                if (a) return true;
                else if (b) return true;
                else return false;
            }
            else return false;
        }
        else {
            return false;
        }
    }

}
