package com.example.reciperlogging.configuration

import org.springframework.amqp.core.Binding
import org.springframework.amqp.core.BindingBuilder
import org.springframework.amqp.core.Queue
import org.springframework.amqp.core.TopicExchange
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.amqp.support.converter.MessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class RabbitConfig {

    @Bean
    fun recipeQueue(): Queue = Queue("recipe.events", true)

    @Bean
    fun accountQueue(): Queue = Queue("account.events", true)

    @Bean
    fun exchange(): TopicExchange = TopicExchange("reciper.exchange")

    @Bean
    fun recipeBinding(): Binding =
        BindingBuilder.bind(recipeQueue()).to(exchange()).with("event.recipe.created")

    @Bean
    fun accountBinding(): Binding =
        BindingBuilder.bind(accountQueue()).to(exchange()).with("event.account.created")

    @Bean
    fun connectionFactory(): org.springframework.amqp.rabbit.connection.ConnectionFactory {
        val factory = CachingConnectionFactory("localhost")
        factory.username = "guest"
        factory.setPassword("guest")
        return factory
    }

    @Bean
    fun jsonMessageConverter(): MessageConverter {
        return Jackson2JsonMessageConverter()
    }

    @Bean
    fun rabbitTemplate(
        connectionFactory: org.springframework.amqp.rabbit.connection.ConnectionFactory,
        jsonMessageConverter: MessageConverter
    ): RabbitTemplate {
        val template = RabbitTemplate(connectionFactory)
        template.messageConverter = jsonMessageConverter
        return template
    }
}
