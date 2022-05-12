package racingcar.dto

import racingcar.domain.LapReport
import racingcar.domain.RacingGameReport

data class RacingGameResponse(
    val lapResponses: List<LapResponse>,
    val winners: List<String>
) {
    companion object {
        fun of(report: RacingGameReport): RacingGameResponse {
            return RacingGameResponse(LapResponse.listOf(report), winners(report))
        }

        private fun winners(report: RacingGameReport): List<String> {
            return report.winner()
                .map { it.value }
        }

        private fun lapReports(report: RacingGameReport): List<List<Pair<String, Int>>> {
            return report.lapReports.map { it.toPairs() }
        }
    }
}

data class LapResponse(
    val lapReport: List<Pair<String, Int>>
) {
    companion object {
        fun of(lapReport: LapReport): LapResponse {
            return LapResponse(lapReport.toPairs())
        }

        fun listOf(report: RacingGameReport): List<LapResponse> {
            return report.lapReports.map { of(it) }
        }
    }
}
