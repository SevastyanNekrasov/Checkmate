public class Rook extends ChessPiece {
    public String symbol;

    public Rook(String color) {
        super(color);
        this.symbol = "R";
    }


    @Override
    public String getColor() {return this.color;}

    @Override
    public String getSymbol() {return this.symbol;}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 8 && toLine >= 0 && toColumn < 8 && toColumn >= 0 && chessBoard.board[line][column] != null) {
            if ((line == toLine) && !(column == toColumn) && checkTheLineFree(chessBoard, line, column, toLine, toColumn)) return true;
            else if (!(line == toLine) && (column == toColumn) && checkTheLineFree(chessBoard, line, column, toLine, toColumn)) return true;
            else return false;
        }
        else return false;
    }

    public boolean checkTheLineFree (ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean result = false;
        int step = 0;
        if (line - toLine == 0) {
            step = Math.abs(column - toColumn);
            if (toColumn - column > 0) {
                for (int i = 1; i <= step; i++) {
                    if (chessBoard.board[line][column + i] == null) {
                        result = true;
                        continue;
                    }
                    else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    break;
                }
            }
            else {
                for (int i = 1; i <= step; i++) {
                    if (chessBoard.board[line][column - i] == null) {
                        result = true;
                        continue;
                    }
                    else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    break;
                }
            }
        }
        else {
            step = Math.abs(line - toLine);
            if (toLine - line > 0) {
                for (int i = 1; i <= step; i++) {
                    if (chessBoard.board[line + 1][column] == null) {
                        result = true;
                        continue;
                    }
                    else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    break;
                }
            }
            else {
                for (int i = 1; i <= step; i++) {
                    if (chessBoard.board[line - i][column] == null) {
                        result = true;
                        continue;
                    }
                    else result = !chessBoard.board[toLine][toColumn].getColor().equals(color);
                    break;
                }
            }
        }
        return result;
    }

}
