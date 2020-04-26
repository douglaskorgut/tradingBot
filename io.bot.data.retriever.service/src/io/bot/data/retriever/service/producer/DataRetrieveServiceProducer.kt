package io.bot.data.retriever.service.producer

import io.bot.services.constants.ForbiddenPeriods
import io.bot.services.input.model.CursorPosition
import io.bot.services.retriever.IDataRetrieverService
import io.bot.services.retriever.model.ForbiddenPeriod
import io.bot.services.trading.model.Candle
import io.bot.services.trading.model.CandleContext
import io.bot.services.trading.model.Order
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate
import org.osgi.util.measurement.Unit.s
import org.slf4j.Logger
import org.slf4j.LoggerFactory


@Component(name="io.bot.data.retriever.service.producer", immediate = true, service = [IDataRetrieverService::class])
class DataRetrieveServiceProducer: IDataRetrieverService{

    private val logger: Logger = LoggerFactory.getLogger(DataRetrieveServiceProducer::class.java)

    @Activate
    fun start (){
        logger.info("${this.javaClass} has been started!")
    }

    @Deactivate
    fun stop (){
        logger.info("${this.javaClass} has been stopped!")
    }

    override fun retrieveForbiddenPeriods(): Array<ForbiddenPeriod> {
        val forbiddenPeriods = arrayOf<ForbiddenPeriod>()


        return forbiddenPeriods

    }


    override fun retrieveSellButtonPosition(): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveBuyButtonPosition(): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveSellMarketButtonPosition(): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveBuyMarketButtonPosition(): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveConfirmOrderButtonPosition(): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveChooseStrategyButtonPosition(): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveConfirmStrategyButtonPosition(strategyName: String): CursorPosition {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveResistenceLines(): Array<Double> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveSupportLines(): Array<Double> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveCurrentCandle(): Candle {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun retrieveCandleContext(candle: Candle): CandleContext {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun isOrderConfirmed(order: Order): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}