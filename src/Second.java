public class Second {
    public static int width = App.getTerminalWidth();
    public static int count = 0;
    public static int start = (width/2) - 6;
    public static void main() {
        
        String[][] curvedStar = new String[12][12];
        App.fillArray(curvedStar);
        
        while (true) {
            if (count % 12 == 1)

            count = count + 1;
        }
    }


}
