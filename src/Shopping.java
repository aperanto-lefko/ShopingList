import java.util.Scanner;

public class Shopping {
    public static void main(String[] args) {
        System.out.println("Вас приветствует список покупок");
        String[] shoppingList = new String[8];
        Scanner scanner = new Scanner(System.in);
        int productCount = 0;
        while (true) {
            System.out.println("Выберите одну из команд:");
            System.out.println("1. Добавить товар в список");
            System.out.println("2. Показать список");
            System.out.println("3. Очистить список");
            System.out.println("4. Завершить работу");
            int actionNumber = scanner.nextInt();
            if (actionNumber == 1) {
                System.out.println("Вы можете добавить " + (shoppingList.length - productCount) + " позиций. Сколько позиций вы хотите добавить?");
                int index = scanner.nextInt();
                if (index > 0 && index <= (shoppingList.length - productCount)) {
                    for (int i = 1; i <= index; i++) { //введение без остановки
                        System.out.println("Введите название товара без пробела через нижнее подчеркивание, например, зерновой_хлеб ");
                        String product = scanner.next();
                        for (int y = 0; y <= (shoppingList.length - 1); y++) {
                            if (product.equals(shoppingList[y])) {
                                System.out.println("Товар " + product + " уже есть в списке");
                                System.out.println("Что вы хотите сделать? , ");
                                System.out.println("1. добавить другую позицию");
                                System.out.println("2. выйти в главное меню");
                                int choice = scanner.nextInt();
                                if (choice == 1) {
                                    System.out.println("Введите название товара без пробела через нижнее подчеркивание, например, зерновой_хлеб ");
                                    product = scanner.next();
                                    break;
                                } else if (choice == 2) {
                                    product = null;
                                    break;
                                } else {
                                    System.out.println("Неверная команда");
                                    product = null;
                                    break;
                                }
                            }
                        }
                        if (product != null) {
                            shoppingList[productCount] = product;
                            productCount++;
                            System.out.println("Товар " + product + " добавлен в список под номером " + (productCount));
                            if (productCount == shoppingList.length) {
                                String[] doubleShoppingList = new String[productCount * 2];
                                for (int z = 0; z < shoppingList.length; z++) {
                                    doubleShoppingList[z] = shoppingList[z];
                                }
                                shoppingList = doubleShoppingList;
                                System.out.println("Список ваших покупок увеличен до " + doubleShoppingList.length + " пунктов");
                            }
                        } else {
                            break;
                        }
                    }
                } else {
                    System.out.println("Пока добавить можно не более " + (shoppingList.length - productCount) + " позиций. В дальнейшем список может быть увеличен");
                }
            } else if (actionNumber == 2) {
                for (int i = 0; i <= shoppingList.length - 1; i++) {
                    if (shoppingList[i] != null) {
                        System.out.println("Товар " + (i + 1) + ". " + shoppingList[i]);
                    } else {
                        System.out.println("Товар " + (i + 1) + ". " + " ");
                    }
                }
            } else if (actionNumber == 3) {
                for (int i = 0; i <= shoppingList.length - 1; i++) {
                    shoppingList[i] = null;
                    productCount = 0;
                    shoppingList = new String[8];
                }
                System.out.println("Список очищен");

            } else if (actionNumber == 4) {
                System.out.println("Всего наилучшего!");
                return;
            } else {
                System.out.println("Неизвестная команда!");
            }
        }
    }
}
