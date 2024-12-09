package menu.model

import camp.nextstep.edu.missionutils.Randoms

class CategoryRandomGenerator {
    private val categories: List<String> = listOf("일식", "한식", "중식", "아시안", "양식")

    fun generateCategory(): String {
        val category: String = categories[Randoms.pickNumberInRange(1 - 1, 5 - 1)]

        return category
    }
}