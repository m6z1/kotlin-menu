package menu

import menu.view.InputView

fun main() {
    val inputView = InputView()
    val menuController = MenuController(inputView)
    menuController.start()
}
