package Basic_syntax;

/*
Вам дан список ролей и сценарий пьесы в виде массива строчек.
Каждая строчка сценария пьесы дана в следующем виде:
Роль: текст

Текст может содержать любые символы.
Напишите метод, который будет группировать строчки по ролям, пронумеровывать их и возвращать результат в виде готового
текста (см. пример). Каждая группа распечатывается в следующем виде:

Роль:
i) текст
j) текст2
...
==перевод строки==

i и j -- номера строк в сценарии. Индексация строчек начинается с единицы, выводить группы следует в соответствии с
порядком ролей. Переводы строк между группами обязательны, переводы строк в конце текста не учитываются.

Заметим, что вам предстоит обработка огромной пьесы в 50 000 строк для 10 ролей – соответственно, неправильная сборка
результирующей строчки может выйти за ограничение по времени.
Обратите внимание еще на несколько нюансов:
 - имя персонажа может встречаться в строке более одного раза, в том числе с двоеточием;
 - название одной роли может быть префиксом названия другой роли (например, "Лука" и "Лука Лукич");
 - роль, у которой нет реплик, тоже должна присутствовать в выходном файле;
 - в качестве перевода строки надо использовать символ '\n' (перевод строки в стиле UNIX);
 - будьте внимательны, не добавляйте лишних пробелов в конце строк.
 2.4.10
 */

public class roles {
    public static String printTextPerRole(String[] roles, String[] textLines) {
        StringBuilder res = new StringBuilder();                  // Создание результирующей строки в StringBuilder
        for (int i = 0; i < roles.length; i++) {
            String rol = roles[i] + ":";                          // добавление ":"
            res.append(rol + "\n");                               // Добавление в строку переведенного эл-та массива
            for (int j = 0; j < textLines.length; j++) {          // Прохождение по массиву textLines[]
                String text = textLines[j];                       // Перевод эл-та массива textLiness[] в строку
                if(text.startsWith(rol)) {
                    StringBuilder text1 = new StringBuilder(text);// Перевод текста из String в StringBuilder для форматирования
                    text1.delete(0, roles[i].length() + 2);       // Удаление симоволов в начале строки с текстом роли
                    text1.toString();                             // Перевод из StringBuilder обратно в String
                    res.append((j + 1) + ") " + text1 + "\n");
                }
            }
            res.append("\n");                                     // Перевод строки, для отступа между ролями
        }
        String res1 = res.toString();                             // Перевод результата из StringBuilder обратно в String
        return res1;
    }

    public static void main(String[] args) {
        String [] roles= {
                "Городничий","Аммос Федорович",
                "Артемий Филиппович",
                "Лука Лукич"};
        String [] textLines={
                "Городничий: Я пригласил вас, господа, с тем, чтобы сообщить вам пренеприятное известие: к нам едет ревизор.",
                "Аммос Федорович: Как ревизор?",
                "Артемий Филиппович: Как ревизор?",
                "Городничий: Ревизор из Петербурга, инкогнито. И еще с секретным предписаньем.",
                "Аммос Федорович: Вот те на!",
                "Артемий Филиппович: Вот не было заботы, так подай!",
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!"};
        System.out.print(printTextPerRole(roles,textLines));
    }
}
