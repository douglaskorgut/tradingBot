package io.bot.services.trading.model

data class Order(
        val id: Int,
        val currentPrice: Double,
        val timeStamp: Double,
        val resistenceLine: Double,
        val supportLine: Double)