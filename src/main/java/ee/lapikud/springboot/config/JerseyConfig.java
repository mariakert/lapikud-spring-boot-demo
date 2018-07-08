package ee.lapikud.springboot.config;

import ee.lapikud.springboot.members.LapikController;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig() {
        register(LapikController.class);
    }
}
