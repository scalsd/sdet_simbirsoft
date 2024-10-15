import java.util.Scanner;

class WrongLoginException extends Exception {
    public WrongLoginException() {
        super();
    }

    public WrongLoginException(String message) {
        super(message);
    }
}

class WrongPasswordException extends Exception {
    public WrongPasswordException() {
        super();
    }

    public WrongPasswordException(String message) {
        super(message);
    }
}

public class DataValidation {
    // Метод для проверки логина и пароля
    public static boolean validateUser(String login, String password, String confirmPassword) {
        try {
            // Проверка логина
            if (login.length() >= 20 || !login.matches("[a-zA-Z0-9_]+")) {
                throw new WrongLoginException("Логин должен содержать только латинские буквы, цифры и знак подчеркивания, и быть меньше 20 символов.");
            }

            // Проверка пароля
            if (password.length() >= 20 || !password.matches("[a-zA-Z0-9_]+")) {
                throw new WrongPasswordException("Пароль должен содержать только латинские буквы, цифры и знак подчеркивания, и быть меньше 20 символов.");
            }

            // Проверка равенства паролей
            if (!password.equals(confirmPassword)) {
                throw new WrongPasswordException("Пароли не совпадают.");
            }

            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Запрос логина
        System.out.print("Введите логин: ");
        String login = scanner.nextLine();

        // Запрос пароля
        System.out.print("Введите пароль: ");
        String password = scanner.nextLine();

        // Запрос подтверждения пароля
        System.out.print("Подтвердите пароль: ");
        String confirmPassword = scanner.nextLine();

        // Вызов метода проверки
        boolean isValid = validateUser(login, password, confirmPassword);

        if (isValid) {
            System.out.println("Логин и пароль прошли проверку.");
        } else {
            System.out.println("Ошибка при проверке логина и/или пароля.");
        }
    }
}
