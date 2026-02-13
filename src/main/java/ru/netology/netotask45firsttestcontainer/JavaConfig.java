package ru.netology.netotask45firsttestcontainer;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.netology.netotask42springbootfirst.interf.SystemProfile;
import ru.netology.netotask42springbootfirst.realization.DevProfile;
import ru.netology.netotask42springbootfirst.realization.ProductionProfile;

@Configuration
public class JavaConfig {
    @Bean
    @ConditionalOnProperty(
            name = "netology.profile.dev",
            havingValue = "true"
    )
    public SystemProfile devProfile() {
        return new DevProfile();
    }

    @Bean
    @ConditionalOnProperty(
            name = "netology.profile.dev",
            havingValue = "false",
            matchIfMissing = false  // не создавать, если свойство не задано
    )
    public SystemProfile prodProfile() {
        return new ProductionProfile();
    }
}
