package com.javarush.task.task35.task3513;

import java.util.*;

public class Model {

    private static final int FIELD_WIDTH = 4;

    private Tile[][] gameTiles;
    protected int score;
    protected int maxTile;
    private boolean isSaveNeeded = true;

    private Stack<Tile[][]> previousStates;
    private Stack<Integer> previousScores;

    public Model() {
        resetGameTiles();
        previousStates = new Stack<>();
        previousScores = new Stack<>();
    }

    protected void resetGameTiles() {
        gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        score = 0;
        maxTile = 2;

        addTile();
        addTile();
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            int randomTile = (int) (emptyTiles.size() * Math.random());
            emptyTiles.get(randomTile).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();

        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }

        return emptyTiles;
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            for (int j = i + 1; j < tiles.length; j++) {
                if (tiles[i].isEmpty()) {
                    Tile buff = tiles[i];
                    tiles[i] = tiles[j];
                    tiles[j] = buff;
                    if (!tiles[i].isEmpty()) {
                        isChanged = true;
                    }
                }
            }
        }
        return isChanged;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean isChanged = false;
        for (int i = 0; i < tiles.length - 1; i++) {
            if (tiles[i].value == tiles[i + 1].value) {
                tiles[i].value += tiles[i + 1].value;
                tiles[i + 1].value = 0;
                if (!tiles[i].isEmpty()) {
                    isChanged = true;
                }

                score += tiles[i].value;
                if (tiles[i].value > maxTile) {
                    maxTile = tiles[i].value;
                }

                compressTiles(tiles);
            }
        }
        return isChanged;
    }

    public void left() {
        if (isSaveNeeded) {
            saveState(gameTiles);
        }
        boolean isChanged = false;
        for (Tile[] line : gameTiles) {
            if (compressTiles(line)) {
                isChanged = true;
            }
            if (mergeTiles(line)) {
                isChanged = true;
            }
        }

        isSaveNeeded = true;

        if (isChanged) {
            addTile();
        }
    }

    public void up() {
        saveState(gameTiles);
        rotate();
        rotate();
        rotate();
        left();
        rotate();
    }

    public void right() {
        saveState(gameTiles);
        rotate();
        rotate();
        left();
        rotate();
        rotate();

    }

    public void down() {
        saveState(gameTiles);
        rotate();
        left();
        rotate();
        rotate();
        rotate();
    }

    private void rotate() {
        final int M = gameTiles.length;
        final int N = gameTiles[0].length;
        Tile[][] rotatedArr = new Tile[N][M];
        for (int r = 0; r < M; r++) {
            for (int c = 0; c < N; c++) {
                rotatedArr[c][M-1-r] = gameTiles[r][c];
            }
        }
        gameTiles = rotatedArr;
    }

    public boolean canMove() {
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    return true;
                }
            }
        }

        boolean result = false;
        for (int k = 0; k < 4; k++) {
            for (int i = 0; i < gameTiles.length; i++) {
                for (int j = 0; j < gameTiles.length - 1; j++) {
                    if (gameTiles[i][j].value == gameTiles[i][j + 1].value) {
                        result = true;
                        break;
                    }
                }
                if (result) {
                    break;
                }
            }
            rotate();
        }
        return result;
    }

    private void saveState(Tile[][] gameState) {
        int countLine = gameState.length;
        int countColumn = gameState[0].length;
        Tile[][] arrayForSaving = new Tile[countLine][countColumn];

        for (int i = 0; i < countLine; i++) {
            for (int j = 0; j < countColumn; j++) {
                Tile tile = new Tile();
                tile.value = gameState[i][j].value;
                arrayForSaving[i][j] = tile;
            }
        }

        previousStates.push(arrayForSaving);
        previousScores.push(score);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousScores.empty() && !previousStates.empty()) {
            gameTiles = previousStates.pop();
            score = previousScores.pop();
        }
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;

        switch (n) {
            case 0:
                left();
                break;
            case 1:
                right();
                break;
            case 2:
                up();
                break;
            case 3:
                down();
                break;
        }
    }

    public boolean hasBoardChanged() {
        int currentScore = getScoreInArray(gameTiles);
        int bufferedScore = 0;
        if (!previousStates.empty()) {
            bufferedScore = getScoreInArray(previousStates.peek());
        }

        return currentScore != bufferedScore;
    }

    private int getScoreInArray(Tile[][] array) {
        int count = 0;
        for (Tile[] line : array) {
            for (Tile cell : line) {
                count += cell.value;
            }
        }

        return count;
    }

    public MoveEfficiency getMoveEfficiency(Move move) {
        move.move();
        MoveEfficiency newMoveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);

        if (!hasBoardChanged()) {
            newMoveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();

        return newMoveEfficiency;
    }

    public void autoMove() {
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());

        queue.add(getMoveEfficiency(this::left));
        queue.add(getMoveEfficiency(this::right));
        queue.add(getMoveEfficiency(this::up));
        queue.add(getMoveEfficiency(this::down));

        queue.peek().getMove().move();
    }
}
