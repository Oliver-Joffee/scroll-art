import java.util.Random;

public class App {

    public static int width = getTerminalWidth();
    public static void main(String[] args) throws Exception {
        System.out.println(getTerminalWidth());
        printTriforce(20);
    }

    public static int getTerminalWidth() {
        String os = System.getProperty("os.name").toLowerCase();

        if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
            return getUnixTerminalWidth();
        } else {
            return 80; // fallback for unknown OS
        }
    }



    public static void printTriforce(int xSpace) {
        String[][] triforce = new String[16][8];
        fillArray(triforce);

        triforce[7][0] = "/";
        triforce[8][0] = "\\";
        triforce[6][1] = "/";
        triforce[5][2] = "/";
        triforce[4][3] = "/";
        triforce[3][4] = "/";
        triforce[2][5] = "/";
        triforce[1][6] = "/";
        triforce[0][7] = "/";
        triforce[9][1] = "\\";
        triforce[10][2] = "\\";
        triforce[11][3] = "\\";
        triforce[12][4] = "\\";
        triforce[13][5] = "\\";
        triforce[14][6] = "\\";
        triforce[15][7] = "\\";

        for (int i = 1; i <= 14; i++) {
            triforce[i][7] = "_";
        }

        for (int i = 5; i <= 10; i ++) {
            triforce[i][3] = "_";
        }

        triforce[5][4] = "\\";
        triforce[6][5] = "\\";
        triforce[7][6] = "\\";

        triforce[10][4] = "/";
        triforce[9][5] = "/";
        triforce[8][6] = "/";

        printImage(triforce, xSpace);

    }

    public static void fillArray(String[][] array) {
        for (int x = 0; x < array.length; x++) {
            for( int y = 0; y < array[0].length; y++) {
                array[x][y] = " ";
            }
        }
    }

    public static void printStar(int xSpace) {
        String[][] star = new String[10][9];

        fillArray(star);

        star[4][0] = "/";
        star[5][0] = "\\";
        star[3][1] = "/";
        star[6][1] = "\\";
        star[3][2] = "/";
        star[6][2] = "\\";
        star[0][3] = "-";
        star[1][3] = "-";
        star[2][3] = "-";
        star[7][3] = "-";
        star[8][3] = "-";
        star[9][3] = "-";
        star[0][4] = "\\";
        star[9][4] = "/";
        star[1][5] = "\\";
        star[8][5] ="/";
        star[2][6] = "\\";
        star[4][6] = "/";
        star[5][6] = "\\";
        star[6][6] = "/";
        star[7][6] = "/";
        star[2][7] = "/";
        star[3][7] = "/";
        star[6][7] = "\\";
        star[7][7] = "\\";
        star[1][8] = "/";
        star[2][8] = "-";
        star[7][8] = "-";
        star[8][8] = "\\";

        printImage(star, xSpace);
    }

    public static void printImage(String[][] star, int xSpace) {
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