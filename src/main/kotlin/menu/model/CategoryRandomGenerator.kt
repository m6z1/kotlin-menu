package menu.model

import camp.nextstep.edu.missionutils.Randoms

class CategoryRandomGenerator {
    private val categories: List<String> = listOf("일식", "한식", "중식", "아시안", "양식")
    private val categoriesByCount: MutableList<String> = mutableListOf()

    fun generateCategory(): String {
        val category: String = categories[Randoms.pickNumberInRange(1 - 1, 5 - 1)]

        if (isValidCategory(category)) {
            categoriesByCount.add(category)
            return category
        }

        return generateCategory()
    }

    private fun isValidCategory(category: String): Boolean {
        val count = categoriesByCount.groupingBy { it == category }.eachCount()
        return count.size < 2
    }
}