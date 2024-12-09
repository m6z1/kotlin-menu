package menu.controller

import menu.model.*
import menu.view.InputView
import menu.view.OutputView

class MenuController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val categoryRandomGenerator: CategoryRandomGenerator,
    private val menuRandomGenerator: MenuRandomGenerator,
    private val menuArchive: MenuArchive,
) {

    fun start() {
        outputView.printServiceStart()
        val coaches = inputView.getCoachNames()
        val coachesEatingLunch: MutableList<Coach> = mutableListOf()
        coaches.forEach { coach ->
            val cantEatFood = inputView.getCantEatFoodByCoach(coach)
            coachesEatingLunch.add(Coach(coach, cantEatFood))
        }
        recommendLunchMenu(coachesEatingLunch)
    }

    private fun recommendLunchMenu(coaches: List<Coach>) {
        DayOfTheWeek.entries.forEach { day ->
            val category = categoryRandomGenerator.generateCategory()
            coaches.forEach { coach ->
                var recommendMenu = menuRandomGenerator.generateRecommendMenu(category, coach)
                while (menuArchive.isDuplicatedMenu(recommendMenu, coach.name)) {
                    recommendMenu = menuRandomGenerator.generateRecommendMenu(category, coach)
                }
                menuArchive.saveMenus(day, category, coach.name, recommendMenu)
            }
        }
    }
}