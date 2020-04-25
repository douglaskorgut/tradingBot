package io.bot.services.trading

import io.bot.services.constants.ForbiddenPeriods
import io.bot.services.input.model.CursorPosition
import io.bot.services.retriever.model.ForbiddenPeriod
import io.bot.services.trading.model.CandleContext
import io.bot.services.trading.model.Order
import io.bot.services.trading.model.Strategy

interface ITradingBotService {

    fun isTimeWindowForbidden(candleContext: CandleContext, forbiddenPeriods: Array<ForbiddenPeriod>): Boolean

    fun chooseStrategy(candleContext: CandleContext): Strategy

    fun isCurrentCandleAPivot(candleContext: CandleContext): Boolean

    fun isResistenceLineSellable(candleContext: CandleContext):Boolean

    fun isSupportLineBuyable(candleContext: CandleContext):Boolean

    fun createOrder(candleContext: CandleContext): Order

    fun executeMarketBuyOrder(
            order: Order,
            buyMarketButtonPosition: CursorPosition,
            orderConfirmationButtonPosition: CursorPosition
    )

    fun executeMarketSellOrder(
            order: Order,
            sellMarketButtonPosition: CursorPosition,
            orderConfirmationButtonPosition: CursorPosition
    )

    fun executeBuyOrder(
            order: Order,
            buyButtonPosition: CursorPosition,
            orderConfirmationButtonPosition: CursorPosition
    )

    fun executeSellOrder(
            order: Order,
            sellButtonPosition: CursorPosition,
            orderConfirmationButtonPosition: CursorPosition
    )
}