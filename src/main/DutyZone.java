package main;

public class DutyZone {
    public static void main(String[] args) {
        Menu menu = new Menu();
        try {
            while (true) {
                menu.show();
            }
        } catch (IllegalArgumentException exception) {
            System.out.println(exception.getMessage());
        }
    }
}
