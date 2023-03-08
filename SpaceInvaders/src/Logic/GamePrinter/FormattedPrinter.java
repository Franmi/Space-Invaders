package Logic.GamePrinter;

import Logic.Game.Game;
import Logic.MyStringUtils.MyStringUtils;

public class FormattedPrinter extends GamePrinter {

	//////////////////////////////////////		ATRIBUTOS		/////////////////////////////////////////////////////////////////

	private String[][] board;
	private final String space = " ";
	private int numRows = game.DIM_Y, numCols = game.DIM_X;

	//////////////////////////////////////		MÉTODOS		/////////////////////////////////////////////////////////////////

	private void encodeGame(Game game) {
		board = new String[numRows][numCols];
		for(int i = 0; i <numRows; i++) {
			for(int j =0; j<numCols; j++) {
				board[i][j] = game.positionToString(i, j);
			}
		}
	}

	@Override
	public String toString(Game game) {
		encodeGame(game);

		int cellSize = 7;
		int marginSize = 2;
		String vDelimiter = "|";
		String hDelimiter = "-";

		String rowDelimiter = MyStringUtils.repeat(hDelimiter, (numCols * (cellSize + 1)) - 1);
		String margin = MyStringUtils.repeat(space, marginSize);
		String lineDelimiter = String.format("%n%s%s%n", margin + space, rowDelimiter);

		StringBuilder str = new StringBuilder();

		str.append(lineDelimiter);

		for(int i=0; i<numRows; i++) {
			str.append(margin);
			str.append(vDelimiter);
			for (int j=0; j<numCols; j++) {
				str.append( MyStringUtils.centre(board[i][j], cellSize));
				str.append(vDelimiter);
			}
			str.append(lineDelimiter);
		}
		return str.toString();
	}

	@Override
	public String helpText() {
		return "GamePrinter: imprime el juego en un tablero.";
	}
}
