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
            menuArchive.saveCategory(category)
            coaches.forEach { coach ->
                var recommendMenu: String
                do {
                    recommendMenu = menuRandomGenerator.generateRecommendMenu(category, coach)
                } while (menuArchive.isDuplicatedMenu(recommendMenu, coach.name))
                menuArchive.saveMenus(day, coach.name, recommendMenu)
            }
        }
        showRecommendLunch()
    }

    private fun showRecommendLunch() {
        val days = DayOfTheWeek.entries.map { day ->
            day.title
        }
        val recommendMenus = menuArchive.getRecommendMenus()
        val categoriesByDay = menuArchive.getCategoriesByDay()
        outputView.printRecommendMenuResult(days, recommendMenus, categoriesByDay)
    }
}