package model

enum class Position(val title: String) {
    GOALKEEPER("вратарь"),
    DEFENDER("защитник"),
    MIDFIELDER("полузащитник"),
    FORWARD("нападающий");

    override fun toString(): String = title
}

data class Player(
    val name: String,          // Имя
    val team: Team,            // Команда (объект класса Team)
    val position: Position,    // Позиция (теперь это Enum)
    val agency: String?,       // Агентство (может быть null)
    val price: Long,           // Цена
    val matches: Int,          // Матчи
    val goals: Int,            // Голы
    val assists: Int,          // Передачи
    val yellowCards: Int,      // ЖК
    val redCards: Int          // КК
)
