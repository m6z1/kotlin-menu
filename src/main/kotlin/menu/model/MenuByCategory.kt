package menu.model

data class MenuByCategory(
    val category: String,
    val categoryNumber: Int,
    val menus: List<String>,
)
