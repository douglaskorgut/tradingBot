package io.trading.bot.service.consumer

import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import kotlin.concurrent.thread


@Component(name="io.trading.bot.service", immediate = true)
class TradingBotServiceConsumer {

    private val logger: Logger = LoggerFactory.getLogger(TradingBotServiceConsumer::class.java)

    // TODO: Use service workers to execute thread
    private val tradingBotRunner = Thread {
        for (x in 0..10){
            Thread.sleep(200)
            logger.info("$x")
        }
    }

    @Activate
    fun start (){
        logger.info("${this.javaClass} has been started!")
        this.startTradingBot(tradingBotRunner)

    }

    @Deactivate
    fun stop (){
        logger.info("${this.javaClass} has been stopped!")
        this.stopTradingBot(tradingBotRunner)
    }

    fun startTradingBot(tradingBotRunner: Thread) {
        tradingBotRunner.start()
    }

    fun stopTradingBot(tradingBotRunner: Thread) {
        tradingBotRunner.stop()
    }

}