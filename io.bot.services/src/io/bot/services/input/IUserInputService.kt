package io.bot.services.input

import io.bot.services.input.model.CursorPosition

interface IUserInputService {

    fun leftClick()

    fun rightClick()

    fun pressKey(key: String)

    fun enterText(text: String)

    fun retrieveCurrentCursorPosition(): CursorPosition

    fun moveCursorToPosition(cursorPosition: CursorPosition)
}