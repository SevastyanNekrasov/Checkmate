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

    /*
    !chessBoard.board[toLine][toColumn].getColor().equals(color) || chessBoard.board[toLine][toColumn] == null;
    Реализуйте метод canMoveToPosition() так, чтобы конь не мог выйти за доску (доска в нашем случае — это двумерный массив размером 8 на 8,
     напоминаем, что индексы начинаются с 0) и мог ходить только буквой «Г».
     Также фигура не может сходить в точку, в которой она сейчас находится.
     Если конь может пройти от точки (line, column) до точки (toLine, toColumn) по всем правилам (указанным выше), то функция вернет true, иначе — false.
     */