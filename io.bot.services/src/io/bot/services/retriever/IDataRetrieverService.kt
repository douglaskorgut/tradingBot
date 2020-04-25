package io.bot.services.retriever

import io.bot.services.input.model.CursorPosition
import io.bot.services.trading.model.Order

interface IDataRetrieverService {

    fun retrieveSellButtonPosition(): CursorPosition

    fun retrieveBuyButtonPosition(): CursorPosition

    fun retrieveSellMarketButtonPosition(): CursorPosition

    fun retrieveBuyMarketButtonPosition(): CursorPosition

    fun retrieveConfirmOrderButtonPosition(): CursorPosition

    fun retrieveChooseStrategyButtonPosition(): CursorPosition

    fun retrieveConfirmStrategyButtonPosition(strategyName: String): CursorPosition

    fun retrieveResistenceLines(): Array<Double>

    fun retrieveSupportLines(): Array<Double>

    fun retrieveCurrentPrice(): Double

    fun isOrderConfirmed(order: Order): Boolean
}