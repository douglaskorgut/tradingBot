package io.trading.bot.service.producer

import io.bot.services.input.model.CursorPosition
import io.bot.services.trading.ITradingBotService
import io.bot.services.trading.model.Order
import io.bot.services.trading.model.StockExchageCurrentData
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

    override fun isTimeToBuy(currentData: StockExchageCurrentData): Boolean {
        if (currentData.currentPrice > currentData.suportLine + 40) return true
        return false
    }

    override fun isTimeToSell(currentData: StockExchageCurrentData): Boolean {
        if (currentData.currentPrice > currentData.resistenceLine - 40) return true
        return false
    }

    override fun chooseStrategy(strategyName: String): Strategy {
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