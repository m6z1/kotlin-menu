package menu

import menu.controller.MenuController
import menu.view.InputView

fun main() {
    val inputView = InputView()
    val menuController = MenuController(inputView)
    menuController.start()
}
