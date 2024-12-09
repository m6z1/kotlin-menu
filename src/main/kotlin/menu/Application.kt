package menu

import menu.controller.MenuController
import menu.model.CategoryRandomGenerator
import menu.model.MenuArchive
import menu.model.MenuRandomGenerator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val categoryRandomGenerator = CategoryRandomGenerator()
    val menuRandomGenerator = MenuRandomGenerator()
    val menuArchive = MenuArchive()
    val menuController = MenuController(inputView, outputView, categoryRandomGenerator, menuRandomGenerator, menuArchive)
    menuController.start()
}
