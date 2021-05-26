package com.epam.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Component
public class UserPropertiesContainer {
    @Value("${garbage}")
    private List<String> garbage;

    public List<String> getGarbage() {
        return garbage;
    }
}
