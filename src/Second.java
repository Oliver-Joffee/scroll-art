public class Second {
    public static int chars = 2;
    public static int workingArea = getWorkingArea();
    public static int spaces = 0;
    public static boolean receding = true;

    public static void main(String[] args) {
        
        System.err.println(App.getTerminalWidth());
        System.err.println(getWorkingArea());
        
        while(true) {
            spaces = (workingArea / 2) - (chars /2);
            for(int i = 0; i < spaces; i++) {
                System.out.print(" ");
            }

            for(int i = 0; i < chars; i++) {
                System.out.print("#");
            }

            if (chars == workingArea || chars == 2) {
                receding = !receding;
            }
            
            if(receding) {
                chars = chars / 2;
            } else {
                chars = chars * 2;
            }
            System.err.println();

        }
    }

    public static int getWorkingArea() {
        int num = 2;
        int count = 1;
        while (true) {
            for(int i = 0; i < count; i++){
                num = num * 2;
            }
            if ((num * 2) > App.getTerminalWidth()) {
                return num / 2;
            } else {
                count ++;
            }
        }
    }

}
