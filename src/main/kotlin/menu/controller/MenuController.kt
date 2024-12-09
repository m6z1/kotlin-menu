package menu.controller

import menu.model.Coach
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val inputView: InputView,
    private val outputView: OutputView,
) {

    fun start() {
        outputView.printServiceStart()
        val coaches = inputView.getCoachNames()
        val coachesEatingLunch: MutableList<Coach> = mutableListOf()
        coaches.forEach { coach ->
            val cantEatFood = inputView.getCantEatFoodByCoach(coach)
            coachesEatingLunch.add(Coach(coach, cantEatFood))
        }

    }
}