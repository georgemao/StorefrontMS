package com.configuration;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Arrays;
import java.util.List;

/**
 * Created by George Mao on 12/21/2014.
 */
public class LocalCondition implements Condition {
    @Override
    public boolean matches(ConditionContext conditionContext, AnnotatedTypeMetadata annotatedTypeMetadata) {
        List profile = Arrays.asList(conditionContext.getEnvironment().getActiveProfiles());
        return profile.contains("local");
    }
}
