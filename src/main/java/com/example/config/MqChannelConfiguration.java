package com.example.config;

import io.micronaut.context.annotation.ConfigurationProperties;
import io.micronaut.context.annotation.EachProperty;
import io.micronaut.context.annotation.Parameter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@EachProperty("my-configuration.mq")
public class MqChannelConfiguration {

    private String name;

    public MqChannelConfiguration(@Parameter String name) {
        this.name = name;
    }
    private String exchange;
    private String ttl;
    private Queues queues = new Queues();

    @Getter
    @Setter
    @ConfigurationProperties("queues")
    public static class Queues {
        private List<String> list;
    }

}
