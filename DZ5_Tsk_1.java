/* Задание 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая, что 1 человек может иметь несколько телефонов.
Добавить функции 1) Добавление номера, 2) Вывод всего */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Scanner;

public class DZ5_Tsk_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in, "cp1251");
        HashMap<String, LinkedList<String>> booklist = new HashMap<>();        

        boolean recording = true; // //  Находимся в цикле, пока не выбран выход
        while (recording) {            
            System.out.println(
                "Выберете действие:\n  1- Записать номер,\n" + "  2- Показать контакты,\n" + "  3- Выход из програмы: ");
            String scaner = sc.nextLine();
            switch (scaner) {
                case "1":
                    adding(booklist, sc);  // Добавляем запись
                    break;
                case "2":
                    showing(booklist);   // Вывод всех записей
                    break;
                case "3":
                    recording = false;  // Выход  
                    System.out.println("Работа програмы завершена");
                    break;
                default:
                    System.out.println("Ошибка при наборе данных! Повториете ввод");
                    break;
            }
        }
    }

    public static void adding(HashMap<String, LinkedList<String>> mapList, Scanner scText) {  // Ф-ция добавления контактов
        LinkedList<String> personNumber = new LinkedList<String>();  // Создаем список
        System.out.println("Введите имя: ");  // Блок ввода имени и телефона
        String personName = scText.nextLine();
        System.out.println();
        System.out.println("Введите номер телефона: ");
        String number = scText.nextLine();
        if (!mapList.containsKey(personName)) {  // Если занчение ввода имени не совпадает по ключам, имеющимся в списке          
            mapList.put(personName, personNumber);  // Добавляем ключ и значение
        }
        mapList.get(personName).add(number);   // Иначе по ключю добавляем значение
    }

    public static void showing(HashMap<String, LinkedList<String>> mapList) {  // Ф-ция вывода запсей телефонной книги
        if (mapList.isEmpty()){                                                // Если нет записей - выводим сообщение
            System.out.println("В записной книге ещё нет контактов");
        }
        for (var elem: mapList.entrySet()) {   //  Для каждого эл-та возвращаем ключ-значение
            System.out.print("  \n" + elem.getKey() + "  номер: ");  // Выводим ключ
            for (String elemValu: elem.getValue()) System.out.print(elemValu + "; "); // Выводим значение(я)           
            System.out.println();
        }
        System.out.println();
    }
}