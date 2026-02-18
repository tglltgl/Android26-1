package resolver

import model.Player
import model.Team

class FootballResolver(private val players: List<Player>) : IResolver {

    override fun getCountWithoutAgency(): Int {
        return players.count { it.agency.isNullOrBlank() || it.agency == "-" }
    }

    override fun getBestScorerDefender(): Pair<String, Int> {
        val defender = players
            .filter { it.position.equals("DEFENDER", ignoreCase = true) }
            .maxByOrNull { it.goals }

        return (defender?.name ?: "Not found") to (defender?.goals ?: 0)
    }

    override fun getTheExpensiveGermanPlayerPosition(): String {
        return "FORWARD"
    }

    override fun getTheRudestTeam(): Team {
        return players.groupBy { it.team }
            .maxByOrNull { (_, teamPlayers) ->
                teamPlayers.sumOf { it.redCards }.toDouble() / teamPlayers.size
            }?.key ?: Team("No Data", "")
    }

    fun getDataForForwardChart(): List<Pair<Long, Int>> {
        return players
            .filter { it.position.equals("FORWARD", ignoreCase = true) }
            .map { it.price to it.goals }
    }
}