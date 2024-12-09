package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getCoachNames(): List<String> {
        val coaches = Console.readLine().split(",")
        require(coaches.distinct().count() == coaches.count()) { "[ERROR] 코치 이름은 중복될 수 없습니다." }
        coaches.forEach { coach ->
            require(coach.length in 2..4) { "[ERROR] 코치 이름은 2~4글자만 가능합니다." }
        }
        require(coaches.count() in 2..5) { "[ERROR] 코치는 2~5명까지만 입력할 수 있습니다." }
        return coaches
    }

    fun getCantEatFoodByCoach(coachName: String): List<String>? {
        println("$coachName(이)가 못 먹는 메뉴를 입력해 주세요.")
        val cantEatFoods = Console.readLine()
        if (cantEatFoods.isBlank()) return null
        val foods = cantEatFoods.split(",")
        require(foods.count() in 1..2) { "[ERROR] 못 먹는 음식은 0~2개까지만 입력할 수 있습니다." }
        return foods
    }
}