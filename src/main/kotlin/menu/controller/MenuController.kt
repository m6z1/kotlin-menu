package menu.controller

import menu.model.CategoryRandomGenerator
import menu.model.Coach
import menu.model.DayOfTheWeek
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val categoryRandomGenerator: CategoryRandomGenerator,
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

    private fun recommendLunchMenu(coaches: List<Coach>) {
        DayOfTheWeek.entries.forEach {
            val category = categoryRandomGenerator.generateCategory()
        }
    }
}