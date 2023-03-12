//* Задание 2. Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
//* Отсортировать по убыванию популярности Имени.

import java.util.Map;
import java.util.HashMap;

public class DZ5_Tsk_2 {
    public static void main(String[] args) {          
        String[] personArray = {  //  Входящий массив данных
            "Иван Иванов",
            "Светлана Петрова",
            "Кристина Белова",
            "Анна Мусина",
            "Анна Крутова",
            "Иван Юрин",
            "Петр Лыков",
            "Павел Чернов",
            "Петр Чернышов",
            "Мария Федорова",
            "Марина Светлова",
            "Мария Савина",
            "Мария Рыкова",
            "Марина Лугова",
            "Анна Владимирова",
            "Иван Мечников",
            "Петр Петин",
            "Иван Ежов"
        };
    Map<String, Integer> nameArray = new HashMap<>();  // Создаем конструктор коллекции
    for (String elem: personArray) {  // В цикле пасим массив по пробелам
        String fistName = elem.split(" ")[0];
        if (nameArray.containsKey(fistName)) {  // Проверяем условие есть ли имя в списке
            nameArray.replace(fistName, nameArray.get(fistName) + 1);  // Если есть, получаем значение по ключу и увеличиваем на 1
        }
        else nameArray.put(fistName, 1);  // Если в списке нет имени, записываем имя и значени 1
        }        
    System.out.println("Список повторяющихся имен:");
    for (Map.Entry<String, Integer> entry: nameArray.entrySet())  // В этой же карте в получаем значения  
    {        
        String key = (String)entry.getKey();  // Ключа
        Integer value = entry.getValue();   // Значение
        if (value != 1) System.out.println("Имя " + key + " повторяется " + value + " раза;"); // Если значение не равно 1, вывоводим  
    }
    System.out.println("Список имен по популярности от большего к меньшему:");        
        nameArray.entrySet().stream()  // В этой же карте
        .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())  // Сортируем  по значениям по убыванию
        .forEach(System.out::println); // Выводим каждый эл-т
    }
}