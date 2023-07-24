public class Pawn extends ChessPiece {
    public String symbol;

    public Pawn(String color) {
        super(color);
        this.symbol = "P";
    }


    @Override
    public String getColor() {return this.color;}

    @Override
    public String getSymbol() {return this.symbol;}

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (toLine < 8 && toLine >= 0 && toColumn < 8 && toColumn >= 0 && chessBoard.board[line][column] != null) {
            if (column == toColumn && chessBoard.board[toLine][toColumn] == null){
                if ((color.equals("White")) && (line == 1)) {
                    if ((line + 2 == toLine) || (line + 1 == toLine)) return true;
                    else return false;
                }
                else if ((color.equals("White")) && (line > 1)) {
                    if ((line + 1 == toLine)) return true;
                    else return false;
                }
                else if ((color.equals("Black")) && (line == 6)) {
                    if ((line - 2 == toLine) || (line - 1 == toLine)) return true;
                    else return false;
                }
                else if ((color.equals("Black")) && !(line < 6)) {
                    if ((line - 1 == toLine)) return true;
                    else return false;
                }
                else return false;
            }
            else if ((Math.abs(column - toColumn) == 1) && (Math.abs(line - toLine) == 1) && chessBoard.board[toLine][toColumn] != null) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(color);
            }
            else return false;
        }
        else return false;
    }

}
