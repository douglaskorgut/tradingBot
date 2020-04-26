package io.bot.user.input.service.producer

import io.bot.services.constants.TradingBotConstants
import io.bot.services.input.IUserInputService
import io.bot.services.input.model.CursorPosition
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.awt.MouseInfo
import java.awt.Robot
import java.awt.event.InputEvent

@Component(name="io.bot.user.input.service", immediate = true, service = [IUserInputService::class])
class UserInputServiceProducer: IUserInputService {

    private val logger: Logger = LoggerFactory.getLogger(UserInputServiceProducer::class.java)
    private val robot: Robot = Robot()

    @Activate
    fun start (){
        logger.info("${this.javaClass} has been started!")

        // Set robot default data
        this.robot.autoDelay = 40
        this.robot.isAutoWaitForIdle = true
    }

    @Deactivate
    fun stop (){
        logger.info("${this.javaClass} has been stopped!")
    }

    override fun leftClick() {
       try {
           this.robot.mousePress(InputEvent.BUTTON1_MASK)
           this.robot.delay(TradingBotConstants.LEFT_CLICK_DELAY_MS)
           this.robot.mouseRelease(InputEvent.BUTTON1_MASK)
           this.robot.delay(TradingBotConstants.LEFT_CLICK_DELAY_MS)
       } catch (e: Exception){
           logger.error("Error performing left click: ${e.message}")
       }
    }

    @Throws(Exception::class)
    override fun rightClick() {
        try {
            this.robot.mousePress(InputEvent.BUTTON3_MASK)
            this.robot.delay(TradingBotConstants.RIGHT_CLICK_DELAY_MS)
            this.robot.mouseRelease(InputEvent.BUTTON3_MASK)
            this.robot.delay(TradingBotConstants.RIGHT_CLICK_DELAY_MS)
        } catch (e: Exception){
            logger.error("Error performing right click: ${e.message}")
        }
    }

    @Throws(Exception::class)
    override fun pressKey(key: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Throws(Exception::class)
    override fun enterText(text: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    @Throws(Exception::class)
    override fun retrieveCurrentCursorPosition(): CursorPosition {

        return try {
            CursorPosition(MouseInfo.getPointerInfo().location.x, MouseInfo.getPointerInfo().location.y)
        } catch (e: Exception){
            throw Exception("Error retrieving cursor position: ${e.message}")
        }
    }

    @Throws(Exception::class)
    override fun moveCursorToPosition(cursorPosition: CursorPosition) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }



}