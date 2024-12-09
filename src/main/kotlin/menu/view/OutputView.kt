package menu.view

import menu.model.RecommendMenuByCoach

class OutputView {

    fun printServiceStart() {
        println("점심 메뉴 추천을 시작합니다.")
        println()
    }

    fun printRecommendMenuResult(
        recommendDays: List<String>,
        recommendMenus: List<RecommendMenuByCoach>,
        categories: List<String>,
    ) {
        println()
        println("메뉴 추천 결과입니다.")
        printDay(recommendDays)
        printCategories(categories)
        val recommendMenusSortedByCoachName = recommendMenus.groupBy { it.coachName }
        recommendMenusSortedByCoachName.values.forEach {
            printMenusByCoach(it)
        }
        println()
        println()
        println("추천을 완료했습니다.")
    }

    private fun printDay(recommendDays: List<String>) {
        print("[ 구분 ")
        recommendDays.forEach { day ->
            print("| ${day}요일 ")
        }
        print("]")
        println()
    }

    private fun printCategories(categories: List<String>) {
        print("[ 카테고리 ")
        categories.forEach { category ->
            print("| $category ")
        }
        print("]")
    }

    private fun printMenusByCoach(recommendMenu: List<RecommendMenuByCoach>) {
        println()
        print("[ ${recommendMenu.first().coachName} ")
        recommendMenu.forEach { menu ->
            print("| ${menu.recommendMenu} ")
        }
        print("]")
    }
}