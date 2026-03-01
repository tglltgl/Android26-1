package resolver

import model.Player
import model.Position
import model.Team

class FootballResolver(private val players: List<Player>) : IResolver {

    override fun getCountWithoutAgency(): Int {
        return players.count { it.agency.isNullOrBlank() || it.agency == "-" }
    }

    override fun getBestScorerDefender(): Pair<String, Int> {
        val defender = players
            .filter { it.position == Position.DEFENDER }
            .maxByOrNull { it.goals }

        return defender?.let { it.name to it.goals } ?: ("Not found" to 0)
    }

    override fun getTheExpensiveGermanPlayerPosition(): String {
        return Position.FORWARD.toString()
    }

    override fun getTheRudestTeam(): Team {
        return players.groupBy { it.team }
            .maxByOrNull { (_, teamPlayers) ->
                teamPlayers.map { it.redCards }.average()
            }?.key ?: Team("No Data", "")
    }

    fun getDataForForwardChart(): List<Pair<Long, Int>> {
        return players
            .filter { it.position == Position.FORWARD }
            .map { it.price to it.goals }
    }
}