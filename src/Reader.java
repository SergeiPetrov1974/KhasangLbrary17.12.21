import java.util.Scanner;

public class Reader {
    public int getAnswer() {
        int d;
        Scanner scanner = new Scanner(System.in);
        while (true) {
            if (scanner.hasNextInt()) {
                d = scanner.nextInt();
                break;
            } else {
                scanner.nextLine();
            }
        }
        return d;
    }

    public String getString() {
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        return str;
    }
}
