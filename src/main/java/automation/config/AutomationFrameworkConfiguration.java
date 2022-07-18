package automation.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

@Component
@ComponentScan("automation")
public class AutomationFrameworkConfiguration {

    public AutomationFrameworkConfiguration() {
    }
}
