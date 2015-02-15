package com.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.List;

/**
 * Use the Spring Condition/@Conditional feature to check if the Active profile is loaded
 * Can accomplish similar objective using the @Profile annotation
 */
public class ActiveCondition implements Condition{
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {

        List profile = Arrays.asList(conditionContext.getEnvironment().getActiveProfiles());
        return profile.contains("active");
    }
}
