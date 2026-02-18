package model

data class Player(
    val name: String,          // Имя
    val team: Team,            // Команда (объект класса Team)
    val position: String,      // Позиция (вратарь, защитник и т.д.)
    val agency: String?,       // Агентство (может быть null)
    val price: Long,           // Цена
    val matches: Int,          // Матчи
    val goals: Int,            // Голы
    val assists: Int,          // Передачи
    val yellowCards: Int,      // ЖК
    val redCards: Int          // КК
)