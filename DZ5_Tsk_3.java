/* Задание 3. На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга. И вывести Доску. Пример вывода доски 8x8 */

public class DZ5_Tsk_3 {
    public static void main(String[] args) {
        int[] queen = new int[8];  // Выделяем память под массив из восьми эл-тов
        stepMotion(0, queen);  // Запуск ф-ции проверки пересечений и записи положения клетки без битых полей    
        for (int horizontal = 0; horizontal < 8; horizontal++) { // Проходим цикл по горизонтали
            for (int vertical = 0; vertical < 8; vertical++) {   // В каждой ячеййке проверяем условие
                if (queen[horizontal] == vertical) {             // Если числовые значения совпали
                    System.out.print(" Ф ");                 // В клетке отображаем ферзя
                } 
                else System.out.print(" . ");           //  Иначе точку
            }
            System.out.println();  // Перевод строки для отображения следующего ряда
        }
    }

    // Функция для поиска расстановки ферзей
    public static boolean stepMotion(int count, int[] queenArray) {
        if (count == 8) { // Если все 8 ферзей расставлены, выходим из цикла
            return true;
        }
        for (int vertical = 0; vertical < 8; vertical++) { // Для каждой клетки ряда
            boolean positionQ = true;
            for (int i = 0; i < count; i++) {   // Проверяем  пересечения по вертикали и горизонтали, диагонали слева на право и диагонали и справа на лево                
                if (queenArray[i] == vertical || queenArray[i] == vertical - count + i || queenArray[i] == vertical + count - i) { 
                    positionQ = false; // При пересечении выводим false, прибавляем счетчик вертикалей и проверяем новый ряд 
                    break;
                }
            }
            if (positionQ) {
                queenArray[count] = vertical; // Если цикл пройден, сохраняем индекс погоризонтали для этого ряда
                if (stepMotion(count + 1, queenArray)) { // Вызываем метод сначала прибавляя 1 к номеру ряда
                return true;
                }
            }
        }
        return false;
    }
}