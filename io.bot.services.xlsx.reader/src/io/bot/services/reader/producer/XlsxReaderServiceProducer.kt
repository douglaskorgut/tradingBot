package io.bot.services.reader.producer

import io.bot.services.reader.IReaderService
import org.osgi.service.component.annotations.Activate
import org.osgi.service.component.annotations.Component
import org.osgi.service.component.annotations.Deactivate
import org.slf4j.LoggerFactory
import org.slf4j.Logger

@Component(name="io.bot.services.reader.producer", immediate = true, service = [IReaderService::class])
class XlsxReaderServiceProducer: IReaderService {


    val logger: Logger = LoggerFactory.getLogger(XlsxReaderServiceProducer::class.java)

    @Activate
    fun start(){
        logger.info("${this.javaClass} has been started!")
    }

    @Deactivate
    fun stop(){
        logger.info("${this.javaClass} has been stopped!")
    }

    override fun readFromXlsxFile(path: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}