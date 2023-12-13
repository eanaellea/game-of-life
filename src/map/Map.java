package map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Map {
    int width;
    int height;
    private ArrayList<Coordinates> liveCells = new ArrayList<Coordinates>();
    private final static char liveCellChar = '+';
    private final static char deadCellChar = '.';

    public Map(String filePath) {
        this.liveCells = new ArrayList<Coordinates>();
        try {
            int lineCounter = 0;
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                lineCounter++;
                this.width = line.length();
                for (int i = 0; i < line.length(); i++) {
                    char currentChar = line.charAt(i);
                    if (currentChar == liveCellChar) {
                        this.liveCells.add(new Coordinates(i, lineCounter - 1));
                    }
                }
            }
            this.height = lineCounter;
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: file not found.");
            System.out.println(e.getMessage());
        }
    }

    public boolean isLiveCell(Coordinates coordinates) {
        ArrayList<Coordinates> liveCells = this.getLiveCells();
        return liveCells.contains(coordinates);
    }

    public ArrayList<Coordinates> getLiveCells() {
        return this.liveCells;
    }
}
