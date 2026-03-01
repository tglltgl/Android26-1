package parser

import model.Player
import model.Position
import model.Team
import util.orZero
import java.io.File

class CsvParser {
    fun parse(fileName: String): List<Player> {
        val file = File("src/main/resources/$fileName")
        if (!file.exists()) return emptyList()

        return file.readLines()
            .drop(1)
            .mapNotNull { line ->
                val p = line.split(";")
                try {
                    val playerPosition = Position.entries.find { it.title == p[3].lowercase() }
                        ?: Position.FORWARD

                    Player(
                        name = p[0],
                        team = Team(p[1], p[2]),
                        position = playerPosition,
                        agency = p[5],
                        price = p[6].toLongOrNull().orZero(),
                        matches = p[7].toIntOrNull().orZero(),
                        goals = p[8].toIntOrNull().orZero(),
                        assists = p[9].toIntOrNull().orZero(),
                        yellowCards = p[10].toIntOrNull().orZero(),
                        redCards = p[11].toIntOrNull().orZero()
                    )
                } catch (e: Exception) {
                    null
                }
            }
    }
}