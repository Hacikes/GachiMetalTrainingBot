package io.project.GachiMetalTrainingBot;

import io.project.GachiMetalTrainingBot.config.BotConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BotConfigTest implements CommandLineRunner {

    private final BotConfig botConfig;

    @Autowired
    public BotConfigTest(BotConfig botConfig) {
        this.botConfig = botConfig;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Bot Name: " + botConfig.getBotName());
    }
}