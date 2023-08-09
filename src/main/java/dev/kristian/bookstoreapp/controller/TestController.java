package dev.kristian.bookstoreapp.controller;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Profile(value = "dev")
@Component
public class TestController {
    //empty class to show the utilisation of profiles, this bean will only be started when in dev profile
}
