import java.util.Random;


public class App {
    public static Random rand = new Random();

    public static int count = 0;
    public static int width = getTerminalWidth();

    public static AsciiArt callingCard = new AsciiArt(
                "      /\\\\\\|//\\\\    \n" + //
                "      \\#####/|     \n" + //
                "       |----|      \n" + //
                "       |####|      \n" + //
                "       |####|      \n" + //
                "       |####|      \n" + //
                "       |----|      \n" + //
                "      -|-----      \n" + //
                "     /#######\\##   \n" + //
                "     |###/---##    \n" + //
                "     \\---  ######  \n" + //
                "      |#########   \n" + //
                "      \\// # //#    \n" + //
                "         \\-/  #"); //From conor felczak

    public static AsciiArt jokerMask = new AsciiArt(
                "  /----\\/----\\\n" + //
                "  \\ ##    ## /\n" + //
                "   \\  /  \\  / \n" + //
                "    \\- \\/ -/"); //also from conor felczak
                
    public static AsciiArt sword = new AsciiArt(
                "       |-|      \n" + //
                "       | |\n" + //
                "       | |\n" + //
                "     -------\n" + //
                "    |\\\\\\\\\\\\\\|\n" + //
                "     -------\n" + //
                "       | |\n" + //
                "       | |\n" + //
                "       |||\n" + //
                "       |||\n" + //
                "       |||\n" + //
                "       \\|/\n" + //
                "        ˇ"); //from toby korn


    
    public static void main(String[] args) throws Exception {
        while (true) {
            if(count%4 == 0) {
                printSparkle(rand.nextInt(getTerminalWidth() - 8));
            } else if (count % 4 == 1) {
                printImage(callingCard.collumnToRow(), rand.nextInt(getTerminalWidth() - callingCard.collumnToRow()[0].length));
            } else if (count % 4 == 2) {
                printImage(jokerMask.collumnToRow(), rand.nextInt(getTerminalWidth() - jokerMask.collumnToRow()[0].length));
            } else {
                printImage(sword.collumnToRow(),  rand.nextInt(getTerminalWidth() - sword.collumnToRow()[0].length));
            }
            
            
            printTriforce((width/2) - 8, count%8);
            
            Thread.sleep(100);
            count ++;

            
        }
    }
    public static void printSparkle(int xSpace) {
        String[][] sparkle = new String[8][6];
        fillArray(sparkle);

        sparkle[3][0] = "/";
        sparkle[4][0] = "\\";
        sparkle[2][0] = "_";
        sparkle[1][0] = "_";
        sparkle[5][0] = "_";
        sparkle[6][0] = "_";
        sparkle[1][1] = "\\";
        sparkle[6][1] = "/";
        sparkle[1][2] = "/";
        sparkle[6][2] = "\\";
        sparkle[0][2] = "_";
        sparkle[7][2] ="_";
        sparkle[1][3] = "\\";
        sparkle[6][3] ="/";
        sparkle[1][4] = "/";
        sparkle[6][4] = "\\";
        sparkle[3][5] = "\\";
        sparkle[4][5] = "/";
        sparkle[2][5] = "‾";
        sparkle[1][5] = "‾";
        sparkle[5][5] = "‾";
        sparkle[6][5] = "‾";

        //  ‾ character found by Toby Korn
    
        
        printImage(switchToChar(sparkle), xSpace);
    }

    public static char[][] switchToChar(String[][] stringArray) {
        char[][] charArray = new char[stringArray.length][stringArray[0].length];

        for (int i = 0; i < charArray.length; i ++) {
            for (int j = 0; j < charArray[0].length; j ++) {
                charArray[i][j] = stringArray[i][j].charAt(0);
            }
        }

        return charArray;

    }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }



    public static void printTriforce(int xSpace, int frame) {
        String[][][] triforce = new String[8][16][8];
        for (int i = 0; i < triforce.length; i++) {
            fillArray(triforce[i]);
        }


        triforce[0][7][0] = "/";
        triforce[0][8][0] = "\\";
        triforce[0][6][1] = "/";
        triforce[0][5][2] = "/";
        triforce[0][4][3] = "/";
        triforce[0][3][4] = "/";
        triforce[0][2][5] = "/";
        triforce[0][1][6] = "/";
        triforce[0][0][7] = "/";
        triforce[0][9][1] = "\\";
        triforce[0][10][2] = "\\";
        triforce[0][11][3] = "\\";
        triforce[0][12][4] = "\\";
        triforce[0][13][5] = "\\";
        triforce[0][14][6] = "\\";
        triforce[0][15][7] = "\\";



        for (int i = 1; i <= 14; i++) {
            triforce[0][i][7] = "_";
        }

        for (int i = 5; i <= 10; i ++) {
            triforce[0][i][3] = "_";
        }

        triforce[0][5][4] = "\\";
        triforce[0][6][5] = "\\";
        triforce[0][7][6] = "\\";

        triforce[0][10][4] = "/";
        triforce[0][9][5] = "/";
        triforce[0][8][6] = "/";



        triforce[1][7][0] = "/";
        triforce[1][8][0] = "\\";
        triforce[1][7][1] = "|";
        triforce[1][8][1] = "|";
        triforce[1][6][2] = "/";
        triforce[1][9][2] = "\\";
        triforce[1][6][3] = "|";
        triforce[1][9][3] = "|";
        triforce[1][7][3] = "_";
        triforce[1][8][3] = "_";
        triforce[1][5][4] = "/";
        triforce[1][10][4] = "\\";
        triforce[1][6][4] = "\\";
        triforce[1][9][4] = "/";
        triforce[1][5][5] = "|";
        triforce[1][10][5] = "|";
        triforce[1][7][5] = "|";
        triforce[1][8][5] = "|";
        triforce[1][4][6] = "/";
        triforce[1][7][6] = "\\";
        triforce[1][8][6] = "/";
        triforce[1][11][6] = "\\";
        triforce[1][4][7] = "|";
        triforce[1][5][7] = "_";
        triforce[1][6][7] = "_";
        triforce[1][7][7] = "_";
        triforce[1][8][7] = "_";
        triforce[1][9][7] = "_";
        triforce[1][10][7] = "_";
        triforce[1][11][7] = "|";


        triforce[2][7][0] = "/";
        triforce[2][8][0] = "\\";
        triforce[2][7][1] = "|";
        triforce[2][8][1] = "|";
        triforce[2][7][2] = "|";
        triforce[2][8][2] = "|";
        triforce[2][6][3] = "/";
        triforce[2][7][3] = "_";
        triforce[2][8][3] = "_";
        triforce[2][9][3] = "\\";
        triforce[2][6][4] = "|";
        triforce[2][7][4] = "|";
        triforce[2][8][4] = "|";
        triforce[2][9][4] = "|";
        triforce[2][6][5] = "|";
        triforce[2][7][5] = "|";
        triforce[2][8][5] = "|";
        triforce[2][9][5] = "|";
        triforce[2][5][6] = "/";
        triforce[2][7][6] = "\\";
        triforce[2][8][6] = "/";
        triforce[2][10][6] = "\\";
        triforce[2][5][7] = "|";
        triforce[2][6][7] = "_";
        triforce[2][7][7] = "_";
        triforce[2][8][7] = "_";
        triforce[2][9][7] = "_";
        triforce[2][10][7] = "_";



        triforce[3][7][0] = "/";
        triforce[3][8][0] = "\\";
        triforce[3][7][1] = "|";
        triforce[3][8][1] = "|";
        triforce[3][7][2] = "|";
        triforce[3][8][2] = "|";
        triforce[3][7][3] = "|";
        triforce[3][8][3] = "|";
        triforce[3][6][4] = "/";
        triforce[3][7][4] = "/";
        triforce[3][8][4] = "\\";
        triforce[3][9][4] = "\\";
        triforce[3][6][5] = "|";
        triforce[3][7][5] = "|";
        triforce[3][8][5] = "|";
        triforce[3][9][5] = "|";
        triforce[3][6][6] = "|";
        triforce[3][7][6] = "|";
        triforce[3][8][6] = "|";
        triforce[3][9][6] = "|";
        triforce[3][6][7] = "|";
        triforce[3][7][7] = "_";
        triforce[3][8][7] = "_";
        triforce[3][9][7] = "|";



        triforce[4][7][0] = "/";
        triforce[4][8][0] = "\\";
        triforce[4][7][1] = "|";
        triforce[4][8][1] = "|";
        triforce[4][7][2] = "|";
        triforce[4][8][2] = "|";
        triforce[4][7][3] = "|";
        triforce[4][8][3] = "|";
        triforce[4][7][4] = "|";
        triforce[4][8][4] = "|";
        triforce[4][7][5] = "|";
        triforce[4][8][5] = "|";
        triforce[4][7][6] = "|";
        triforce[4][8][6] = "|";
        triforce[4][7][7] = "|";
        triforce[4][8][7] = "|";

        for(int i = 0; i < triforce[3].length; i ++) {
            for ( int f = 0; f < triforce[3][1].length; f++) {
                triforce[5][i][f] = triforce[3][i][f];
            }
        }

        for(int i = 0; i < triforce[3].length; i ++) {
            for ( int f = 0; f < triforce[3][1].length; f++) {
                triforce[6][i][f] = triforce[2][i][f];
            }
        }

        for(int i = 0; i < triforce[3].length; i ++) {
            for ( int f = 0; f < triforce[3][1].length; f++) {
                triforce[7][i][f] = triforce[1][i][f];
            }
        }

        printImage(switchToChar(triforce[frame]), xSpace);


    }

    public static void fillArray(String[][] array) {
        for (int x = 0; x < array.length; x++) {
            for( int y = 0; y < array[0].length; y++) {
                array[x][y] = " ";
            }
        }
    }

    public static void printImage(char[][] star, int xSpace) {
            if (xSpace + star.length < width) {
                for (int y = 0; y < star[1].length; y++) {
                    for (int i =0; i < xSpace; i++) {
                        System.out.print(" ");
                    }
                    for (int x = 0; x < star.length; x ++) {
                        System.out.print(star[x][y]);
                }
                System.out.println();
                
            }
        }
    }

    private static int getUnixTerminalWidth() {
        try {
            // Try to get terminal size from environment variables first
            String columns = System.getenv("COLUMNS");
            if (columns != null && !columns.isEmpty()) {
                return Integer.parseInt(columns);
            }

            // Fallback to stty command
            ProcessBuilder pb = new ProcessBuilder("/bin/sh", "-c", "stty size </dev/tty");
            pb.redirectErrorStream(true);
            Process process = pb.start();
            java.io.BufferedReader reader = new java.io.BufferedReader(
                    new java.io.InputStreamReader(process.getInputStream()));
            String output = reader.readLine();
            if (output != null && !output.isEmpty()) {
                String[] parts = output.trim().split(" ");
                return Integer.parseInt(parts[1]); // columns
            }
        } catch (Exception ignored) {
            // Silently ignore errors and fall back to default
        }
        return 80; // fallback
    } //All code related to getting terminal width from Ms. Feng
}