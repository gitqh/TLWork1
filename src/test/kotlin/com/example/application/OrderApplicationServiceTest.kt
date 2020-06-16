package com.example.application

import com.example.application.command.CreateOrderCommand
import com.example.domain.exception.OrderException
import io.kotlintest.shouldThrow
import io.kotlintest.specs.StringSpec
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class OrderApplicationServiceTest(
        val orderApplicationService: OrderApplicationService
) : StringSpec({
    "test pay a order fail with wrong goodId"{
        shouldThrow<OrderException> {
            orderApplicationService.order(CreateOrderCommand(1, 1, "food"))
        }
    }

    "test pay a order type fail with wrong good type"{
        shouldThrow<OrderException> {
            orderApplicationService.order(CreateOrderCommand(1, 1, "drink"))
        }
    }

    "test pay a order success"{
        orderApplicationService.order(CreateOrderCommand(1, 1001, "food"))
    }
})