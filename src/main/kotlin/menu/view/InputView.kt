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
}