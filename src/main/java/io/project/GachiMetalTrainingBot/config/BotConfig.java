package io.project.GachiMetalTrainingBot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import java.util.stream.Stream;
@Configuration
@PropertySource("application.properties")
@Data
public class BotConfig {

//    public String getBotName() {
//        return botName;
//    }

    @Value("${bot.name}")
    String botName;





}
