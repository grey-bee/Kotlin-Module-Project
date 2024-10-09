class NotaApp {
    val archives = mutableListOf<Archive>()
    val menu = Menu()

    fun run() {
        while (true) {
            val list = createMenuList(archives.map { it.name }, "создать архив", "выход")
            val choice = menu.showMenu("Список архивов:", list)
            val size = list.size - 1
            handleMenuChoice(
                choice,
                size,
                { createArhive() },
                { showArchive(archives[choice - 1]) })
            if (choice == size) return
        }

    }

    private fun showArchive(archive: Archive) {
        while (true) {
            val list = createMenuList(archive.notes.map { it.title }, "создать заметку", "выход")
            val choice = menu.showMenu("Список заметок в архиве ${archive.name}:", list)
            val size = list.size - 1
            handleMenuChoice(
                choice,
                size,
                { createNote(archive) },
                {
                    val note = archive.notes[choice - 1]
                    println("Заметка: ${note.title}")
                    println("Содержание: ${note.content}")
                }
            )
            if (choice == size) return
        }

    }

    private fun createArhive() {
        val question = "Введите имя архива: "
        val reject = "Имя архива не может быть пустым\n"
        val name = InputMenu().inputString(question, reject)
        archives.add(Archive(name))
    }

    private fun createNote(archive: Archive) {
        val tQuestion = "Введите заголовок заметки: "
        val tReject = "Заголовок заметки не может быть пустым."
        val title = InputMenu().inputString(tQuestion, tReject)

        val cQuestion = "Введите содержание заметки: "
        val cReject = "Заголовок заметки не может быть пустым."
        val content = InputMenu().inputString(cQuestion, cReject)

        archive.notes.add(Note(title, content))
        println("Заметка '$title' создана.")
    }

    private fun createMenuList(
        items: List<String>,
        firstItem: String,
        lastItem: String,
    ): List<String> {
        return listOf(firstItem) + items + lastItem
    }

    private fun handleMenuChoice(
        choice: Int,
        size: Int,
        createAction: () -> Unit,
        showAction: () -> Unit,
    ) {
        when (choice) {
            0 -> createAction()
            (size) -> return
            else -> showAction()
        }
    }
}