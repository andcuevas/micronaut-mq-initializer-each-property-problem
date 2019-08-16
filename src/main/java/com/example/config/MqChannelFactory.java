package com.example.config;

import io.micronaut.context.annotation.EachBean;
import io.micronaut.context.annotation.Factory;

@Factory
public class MqChannelFactory {

    @EachBean(MqChannelConfiguration.class)
    public MqChannelInitializer channelInitializer(MqChannelConfiguration mqChannelConfiguration) {
        return new MqChannelInitializer(mqChannelConfiguration);
    }

}
