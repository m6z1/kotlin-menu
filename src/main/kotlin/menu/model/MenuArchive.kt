package menu.model

class MenuArchive {
    private val recommendMenus: MutableList<RecommendMenuByCoach> = mutableListOf()
    private val categoriesByDay: MutableList<String> = mutableListOf()

    fun saveMenus(dayOfTheWeek: DayOfTheWeek, coachName: String, recommendMenu: String) {
        recommendMenus.add(
            RecommendMenuByCoach(
                dayOfTheWeek, coachName, recommendMenu,
            )
        )
    }

    fun saveCategory(category: String) {
        categoriesByDay.add(category)
    }

    fun isDuplicatedMenu(menuName: String, coachName: String): Boolean {
        val coachFoods = recommendMenus.filter { it.coachName == coachName }
        var count = 0
        coachFoods.forEach { recommendFood ->
            if (recommendFood.recommendMenu == menuName) count++
        }
        return count != 0
    }

    fun getRecommendMenus(): List<RecommendMenuByCoach> {
        return recommendMenus.toList()
    }

    fun getCategoriesByDay(): List<String> {
        return categoriesByDay.toList()
    }
}