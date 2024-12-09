package menu.model

data class RecommendMenuByCoach(
    val dayOfTheWeek: DayOfTheWeek,
    val coachName: String,
    val recommendMenu: String,
)
