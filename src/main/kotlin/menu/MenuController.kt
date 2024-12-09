package menu

import menu.view.InputView

class MenuController(
    private val inputView: InputView
) {

    fun start() {
        inputView.getCoachNames()
    }
}