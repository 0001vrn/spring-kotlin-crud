package varun.bootdemo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BootdemoApplication

fun main(args: Array<String>) {
	runApplication<BootdemoApplication>(*args)
}
