package io.bot.services.trading

import io.bot.services.input.model.CursorPosition
import io.bot.services.trading.model.Order
import io.bot.services.trading.model.StockExchageCurrentData
import io.bot.services.trading.model.Strategy

interface ITradingBotService {

    fun isTimeToBuy(currentData: StockExchageCurrentData):Boolean

    fun isTimeToSell(currentData: StockExchageCurrentData):Boolean

    fun chooseStrategy(strategyName: String): Strategy

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