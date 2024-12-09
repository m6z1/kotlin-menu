package menu.model

import camp.nextstep.edu.missionutils.Randoms

class MenuRandomGenerator {
    private val menuByCategories: List<MenuByCategory> = listOf(
        MenuByCategory("일식", listOf("규동", "우동", "미소시루", "스시", "가츠동", "오니기리", "하이라이스", "라멘", "오코노미야끼")),
        MenuByCategory("한식", listOf("김밥", "김치찌개", "쌈밥", "된장찌개", "비빔밥", "칼국수", "불고기", "떡볶이", "제육볶음")),
        MenuByCategory("중식", listOf("깐풍기", "볶음면", "동파육", "짜장면", "짬뽕", "마파두부", "탕수육", "토마토 달걀볶음", "고추잡채")),
        MenuByCategory("아시안", listOf("팟타이", "카오 팟", "나시고렝", "파인애플 볶음밥", "쌀국수", "똠얌꿍", "반미", "월남쌈", "분짜")),
        MenuByCategory("양식", listOf("라자냐", "그라탱", "뇨끼", "끼슈", "프렌치 토스트", "바게트", "스파게티", "피자", "파니니")),
    )

    fun generateRecommendMenu(category: String, coach: Coach): String {
        val menusFilteredByCategory: MenuByCategory = menuByCategories.first {
            it.category == category
        }
        val randomMenu = pickRandomMenu(menusFilteredByCategory.menus)

        if (coach.cantEatFood == null) return randomMenu

        coach.cantEatFood.forEach { food ->
            if (food == randomMenu) {
                generateRecommendMenu(category, coach)
                return@forEach
            }
        }
        return randomMenu
    }

    private fun pickRandomMenu(menus: List<String>): String {
        val randomMenu = Randoms.shuffle(menus)[0]
        return randomMenu
    }
}