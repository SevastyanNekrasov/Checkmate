
public class Bishop extends ChessPiece {
    public String symbol;

    public Bishop(String color) {
        super(color);
        this.symbol = "B";
    }


    @Override
    public String getColor() {return this.color;}

    @Override
    public String getSymbol() {return this.symbol;}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 8 && toLine >= 0 && toColumn < 8 && toColumn >= 0 && chessBoard.board[line][column] != null) {
            if (!(line == toLine) && !(column == toColumn) && (Math.abs(line - toLine) == Math.abs(column - toColumn)) && checkTheLineFree(chessBoard, line, column, toLine, toColumn)) return true;
            else return false;
        }
        else return false;
    }

    public boolean checkTheLineFree (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = false;
        int step = Math.abs(line - toLine);
        if (toLine - line > 0 && toColumn - column > 0) {
            for (int i = 1; i <= step; i++) {
                if (chessBoard.board[line + i][column + i] == null) {
                    result = true;
                    continue;
                }
                else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                break;
            }
        }
        else if (toLine - line > 0 && toColumn - column < 0) {
            for (int i = 1; i <= step; i++ ) {
                if (chessBoard.board[line + i][column - i] == null){
                    result = true;
                    continue;
                }
                else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                break;
            }
        }
        else if (toLine - line < 0 && toColumn - column > 0) {
            for (int i = 1; i <= step; i++ ) {
                if (chessBoard.board[line - i][column + i] == null) {
                    result = true;
                    continue;
                }
                else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                break;
            }
        }
        else if (toLine - line < 0 && toColumn - column < 0) {
            for (int i = 1; i <= step; i++ ) {
                if (chessBoard.board[line - i][column - i] == null) {
                    result = true;
                    continue;
                }
                else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                break;
            }
        }
        else result = false;
        return result;
    }
}
