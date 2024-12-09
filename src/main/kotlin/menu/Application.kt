package menu

import menu.controller.MenuController
import menu.model.CategoryRandomGenerator
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val categoryRandomGenerator = CategoryRandomGenerator()
    val menuController = MenuController(inputView, outputView, categoryRandomGenerator)
    menuController.start()
}
