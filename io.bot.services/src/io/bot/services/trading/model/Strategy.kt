package io.bot.services.trading.model

import io.bot.services.input.model.CursorPosition

data class Strategy (
        val name: String,
        val screenPosition: CursorPosition
)