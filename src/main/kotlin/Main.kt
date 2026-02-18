import parser.CsvParser
import resolver.FootballResolver

fun main() {
    val players = CsvParser().parse("fakePlayers.csv")

    if (players.isEmpty()) {
        println("Error: File not found or empty!")
        return
    }

    val resolver = FootballResolver(players)

    println("=== FOOTBALL REPORT ===")
    println("1. Players without agency: ${resolver.getCountWithoutAgency()}")

    val bestDef = resolver.getBestScorerDefender()
    println("2. Best scoring defender: ${bestDef.first} (${bestDef.second} goals)")

    println("\n--- OPTION 3: FORWARD DATA (PRICE & GOALS) ---")
    val forwards = resolver.getDataForForwardChart()

    if (forwards.isEmpty()) {
        println("No forwards found in the data.")
    } else {
        forwards.forEach { (price, goals) ->
            println("$price, $goals")
        }
    }
}