/*
 * Copyright (c) 2024 Max Lemberg. This file is part of ChessMax.
 * Licenced under the CC BY-NC 4.0 License.
 * See "http://creativecommons.org/licenses/by-nc/4.0/".
 */

package com.mlprograms.chess.game.pieces;

import com.mlprograms.chess.game.ui.Board;

import java.awt.image.BufferedImage;

public class Bishop extends Piece {

	public Bishop(Board board, int column, int row, boolean isWhite) {
		super(board);

		setColumn(column);
		setRow(row);
		setXPos(column * getBoard().getTileSize());
		setYPos(row * getBoard().getTileSize());

		setPieceValue(3);
		setWhite(isWhite);
		setName("Bishop");
		setFenChar(isWhite ? 'B' : 'b');

		int sheetScale = getSheetScale();
		setSprite(getSheet().getSubimage(2 * sheetScale, isWhite ? 0 : sheetScale, sheetScale, sheetScale).getScaledInstance(sheetScale, sheetScale, BufferedImage.SCALE_SMOOTH));
	}

	@Override
	public boolean isValidMovement(int targetColumn, int targetRow, boolean checkForKingSafety) {
		if(!isValidPieceMove(targetColumn, targetRow, checkForKingSafety)) {
			return false;
		}

		return Math.abs(getColumn() - targetColumn) == Math.abs(getRow() - targetRow);
	}

	@Override
	public boolean moveCollidesWithPiece(int column, int row) {
		return diagonalCollision(column, row);
	}

}
