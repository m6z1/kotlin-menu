package menu.view

import camp.nextstep.edu.missionutils.Console

class InputView {

    fun getCoachNames() {
        val coaches = Console.readLine().split(",")
        require(coaches.distinct().count() == coaches.count()) { "[ERROR] 코치 이름은 중복될 수 없습니다." }
    }
}