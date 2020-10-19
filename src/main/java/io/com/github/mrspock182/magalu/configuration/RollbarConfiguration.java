package io.com.github.mrspock182.magalu.configuration;

import com.rollbar.notifier.Rollbar;
import com.rollbar.notifier.config.Config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.rollbar.notifier.config.ConfigBuilder.withAccessToken;

@Configuration
public class RollbarConfiguration {

    private final Rollbar rollbar;

    public RollbarConfiguration(@Value("${rollbar.token}") String token,
                                @Value("${rollbar.environment}") String environment,
                                @Value("${rollbar.version}") String version) {
        Config config = withAccessToken(token)
                .environment(environment)
                .codeVersion(version)
                .build();
        this.rollbar = Rollbar.init(config);
    }

    @Bean
    public Rollbar rollbar() {
        return this.rollbar;
    }

}
