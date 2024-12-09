package menu

import menu.model.Coach
import menu.view.InputView

class MenuController(
    private val inputView: InputView
) {

    fun start() {
        val coaches = inputView.getCoachNames()
        val coachesEatingLunch: MutableList<Coach> = mutableListOf()
        coaches.forEach { coach ->
            val cantEatFood = inputView.getCantEatFoodByCoach(coach)
            coachesEatingLunch.add(Coach(coach, cantEatFood))
        }

    }

    fun
}