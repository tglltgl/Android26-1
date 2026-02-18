package parser

import model.Player
import model.Team
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
                    Player(
                        name = p[0],
                        team = Team(p[1], p[2]),
                        position = p[3],
                        agency = p[5],
                        price = p[6].toLongOrNull() ?: 0L,
                        matches = p[7].toIntOrNull() ?: 0,
                        goals = p[8].toIntOrNull() ?: 0,
                        assists = p[9].toIntOrNull() ?: 0,
                        yellowCards = p[10].toIntOrNull() ?: 0,
                        redCards = p[11].toIntOrNull() ?: 0
                    )
                } catch (e: Exception) {
                    null
                }
            }
    }
}