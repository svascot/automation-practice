package config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("main")
public class RunConfigurationProperties {

    public RunConfigurationProperties() {
    }
}
