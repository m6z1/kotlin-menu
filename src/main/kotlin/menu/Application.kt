package menu

import menu.controller.MenuController
import menu.view.InputView
import menu.view.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val menuController = MenuController(inputView, outputView)
    menuController.start()
}
