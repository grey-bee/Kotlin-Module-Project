import java.util.Scanner

class InputMenu {
    fun inputDigit(items: List<String>): Int {
        while (true) {
            print("Выберите пункт меню: ")
            try {
                val choice = Scanner(System.`in`).nextLine().toInt()
                if (choice in items.indices) {
                    return choice
                } else {
                    println("Неверный выбор. Пожалуйста, введите число от 0 до ${items.size - 1}.")
                }
            } catch (e: NumberFormatException) {
                println("Вам следует вводить цифру.")
            }
        }
    }

    fun inputString(question: String, reject: String): String {
        while (true) {
            print(question)
            val name = Scanner(System.`in`).nextLine().trim()
            if (name.isNotEmpty()) {
                return name
            } else {
                println(reject)
            }
        }
    }
}