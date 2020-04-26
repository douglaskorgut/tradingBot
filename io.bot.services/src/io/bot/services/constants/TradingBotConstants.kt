package io.bot.services.constants

class TradingBotConstants {

    companion object Delays {
        val LEFT_CLICK_DELAY_MS = 200
        val RIGHT_CLICK_DELAY_MS = 200
    }
}

class ForbiddenPeriods {
    companion object {
        val FIRST_FB_PERIOD = "09:00:00/09:05:00"
        val SECOND_FB_PERIOD = "09:25:00/09:35:00"
        val THIRD_FB_PERIOD = "09:55:00/10:35:00"
        val FOURTH_FB_PERIOD = "10:55:00/11:05:00"
    }
}

class OffsetTicks {
    companion object {
        val DEFAULT_OFFSET_TICK = 40
    }
}

class ForbiddenOffsetPeriods {
    companion object {
        val DEFAULT_OFFSET_PERIOD = 40
    }
}