package io.bot.services.trading.model

data class CandleContext(
        val candles: Array<Candle>,
        val currentCandle: Candle,
        val tendency: String,
        val supportLine: Double,
        val resistenceLine: Double,
        val timeData: TimeData
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as CandleContext

        if (!candles.contentEquals(other.candles)) return false
        if (tendency != other.tendency) return false
        if (timeData != other.timeData) return false

        return true
    }

    override fun hashCode(): Int {
        var result = candles.contentHashCode()
        result = 31 * result + tendency.hashCode()
        result = 31 * result + timeData.hashCode()
        return result
    }
}