class Menu {
    fun showMenu(title: String, items: List<String>): Int {
        println()
        println(title)
        items.forEachIndexed { index, item ->
            println("$index. $item")
        }
        return InputMenu().inputDigit(items)
    }
}