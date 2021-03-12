package meetingrooms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Controller {

    private Office office = new Office();

    public void readOffice() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem adja meg a rögzítendő tárgyalók számát: ");
        int targyalokSzama = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < targyalokSzama; i++) {
            System.out.println((i + 1) + ": tárgyaló neve: ");
            String name = scanner.nextLine();
            System.out.println((i + 1) + ": tárgyaló hossza: ");
            int length = scanner.nextInt();
            scanner.nextLine();
            System.out.println((i + 1) + ": tárgyaló szélessége:");
            int width = scanner.nextInt();
            scanner.nextLine();

            MeetingRoom meetingRoom = new MeetingRoom(name, length, width);

            meetingRoom.setName(name);
            meetingRoom.setLength(length);
            meetingRoom.setWidth(width);

            office.addMeetingRoom(meetingRoom);
        }
    }

    public void printMenu() {

        List<String> menu = new ArrayList<>();

        menu.add("1. Tárgyalók sorrendben");
        menu.add("2. Tárgyalók visszafele sorrendben");
        menu.add("3. Minden második tárgyaló");
        menu.add("4. Területek");
        menu.add("5. Keresés név/névtöredék alapján");
        menu.add("6. Keresés terület alapján");

        System.out.println("Menü: ");
        for (int i = 0; i < menu.size(); i++) {
            System.out.println(menu.get(i));
        }
    }

    public void runMenu() {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Kérem válasszon! ");
        int menuPont = scanner.nextInt();
        scanner.nextLine();

        if (menuPont == 1) {
            office.printNamesInOrder();
        }

        if (menuPont == 2) {
            office.printNameReverse();
        }

        if (menuPont == 3) {
            office.printEvenNames();
        }

        if (menuPont == 4) {
            office.printRoomArea();
        }

        if (menuPont == 5) {
            System.out.println("Kérem adja meg a tárgyaló teljes/rész nevét! ");
            String name = scanner.nextLine();
            office.printMeetingRoomsContains(name);
        }


        if (menuPont == 6) {
            System.out.println("Kérem adja meg a tárgyaló méretét: ");
            int terulet = scanner.nextInt();
            scanner.nextLine();

            office.printAreaLargerThan(terulet);
        }
    }

    public static void main(String[] args) {

        Controller controller = new Controller();

        controller.readOffice();
        controller.printMenu();
        controller.runMenu();
    }
}
