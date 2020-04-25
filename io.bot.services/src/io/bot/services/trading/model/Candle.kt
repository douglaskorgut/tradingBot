package io.bot.services.trading.model

data class Candle(
        val openingPrice: Double,
        val currentPrice: Double,
        val topPrice: Double?,
        val bottomPrice: Double?,
        val closingPrice: Double?
)
