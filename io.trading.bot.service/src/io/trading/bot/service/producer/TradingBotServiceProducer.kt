package io.trading.bot.service.producer

import io.bot.services.input.model.CursorPosition
import io.bot.services.retriever.model.ForbiddenPeriod
import io.bot.services.trading.ITradingBotService
import io.bot.services.trading.model.CandleContext
import io.bot.services.trading.model.Order
import io.bot.services.trading.model.Strategy
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Deactivate
import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TradingBotServiceProducer: ITradingBotService {

    private val logger: Logger = LoggerFactory.getLogger(TradingBotServiceProducer::class.java)
    private val marketBuyOrders = arrayListOf<Order>()
    private val marketSellOrders = arrayListOf<Order>()

    @Activate
    fun start (){
        logger.info("${this.javaClass} has been started!")
    }

    @Deactivate
    fun stop (){
        logger.info("${this.javaClass} has been stopped!")
    }

    override fun isTimeWindowForbidden(candleContext: CandleContext, forbiddenPeriods: Array<ForbiddenPeriod>): Boolean {
        // TODO: Start implementing this funcion based on this article: https://stackoverflow.com/questions/17697908/check-if-a-given-time-lies-between-two-times-regardless-of-date
        return false
    }

    override fun chooseStrategy(candleContext: CandleContext): Strategy {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Throws(Exception::class)
    override fun isSupportLineBuyable(candleContext: CandleContext): Boolean {
        try {

            if (
                    (candleContext.currentCandle.currentPrice > candleContext.supportLine + 40) &&
                    (candleContext.timeData.closingTs - (System.currentTimeMillis()/1000) > 40)

            ) return true

        } catch (e: Exception){
            throw Exception("Error executing isSupportLineBuyable() function: ${e.message}")
        }

        return false

    }

    override fun isResistenceLineSellable (candleContext: CandleContext): Boolean {
        try {

            if (
                    (candleContext.currentCandle.currentPrice < candleContext.resistenceLine - 40) &&
                    (candleContext.timeData.closingTs - (System.currentTimeMillis()/1000) > 40)
            ) return true

        } catch (e: Exception){
            throw Exception("Error executing isResistenceLineSellable() function: ${e.message}")
        }
        return false
    }

    override fun isCurrentCandleAPivot(candleContext: CandleContext): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createOrder(candleContext: CandleContext): Order {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Throws(Exception::class)
    override fun executeMarketBuyOrder(order: Order, buyMarketButtonPosition: CursorPosition, orderConfirmationButtonPosition: CursorPosition) {
        try {
            if (order in this.marketBuyOrders) throw Exception("Order: ${order.orderId} has been received already")

            // Click on market buy
        } catch (e: Exception){
            throw Exception("Error executing markey buy order: ${e.message}")
        }
    }

    @Throws(Exception::class)
    override fun executeMarketSellOrder(order: Order, sellMarketButtonPosition: CursorPosition, orderConfirmationButtonPosition: CursorPosition) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun executeBuyOrder(order: Order, buyButtonPosition: CursorPosition, orderConfirmationButtonPosition: CursorPosition) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun executeSellOrder(order: Order, sellButtonPosition: CursorPosition, orderConfirmationButtonPosition: CursorPosition) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}