package menu.model

class MenuArchive {
    private val recommendMenus: MutableList<RecommendMenuByCoach> = mutableListOf()
    private val categoriesByDay: MutableList<Pair<DayOfTheWeek, String>> = mutableListOf()

    fun saveMenus(dayOfTheWeek: DayOfTheWeek, category: String, coachName: String, recommendMenu: String) {
        recommendMenus.add(
            RecommendMenuByCoach(
                dayOfTheWeek, coachName, recommendMenu,
            )
        )
        categoriesByDay.add(dayOfTheWeek to category)
    }

    fun isDuplicatedMenu(menuName: String, coachName: String): Boolean {
        val coachFoods = recommendMenus.filter { it.coachName == coachName }
        var count = 0
        coachFoods.forEach { recommendFood ->
            if (recommendFood.recommendMenu == menuName) count++
        }
        return count != 0
    }
}