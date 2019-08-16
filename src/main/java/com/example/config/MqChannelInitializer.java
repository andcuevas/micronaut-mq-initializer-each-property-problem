package com.example.config;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import io.micronaut.configuration.rabbitmq.connect.ChannelInitializer;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

@Slf4j
public class MqChannelInitializer extends ChannelInitializer {

    private MqChannelConfiguration mqChannelConfiguration;

    public MqChannelInitializer(MqChannelConfiguration mqChannelConfiguration) {
        this.mqChannelConfiguration = mqChannelConfiguration;
    }

    @Override
    public void initialize(Channel channel) throws IOException {

        channel.exchangeDeclare(mqChannelConfiguration.getExchange(), BuiltinExchangeType.DIRECT, true);

        for(String queue: mqChannelConfiguration.getQueues().getList()) {

            if (log.isDebugEnabled()) {
                log.debug("Configurando cola mq: {}", queue);
            }

            channel.queueDeclare(queue, true, false, false, null);
            channel.queueBind(queue, mqChannelConfiguration.getExchange(), queue);

        }

    }

}
