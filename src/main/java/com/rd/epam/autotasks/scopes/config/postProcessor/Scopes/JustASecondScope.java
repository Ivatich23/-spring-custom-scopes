package com.rd.epam.autotasks.scopes.config.postProcessor.Scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class JustASecondScope implements Scope {
    private final Map<String, Object> objectMap = new HashMap();
    long previousTime = System.currentTimeMillis();


    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {
        long currentTime = System.currentTimeMillis();
        long differenceTime = (currentTime - previousTime)/1000;
        if (!objectMap.containsKey(beanName) || differenceTime >= 1) {
            objectMap.put(beanName, objectFactory.getObject());
            previousTime = currentTime;
        }
        return objectMap.get(beanName);
    }


    @Override
    public Object remove(String s) {
        return null;
    }

    @Override
    public void registerDestructionCallback(String s, Runnable runnable) {

    }

    @Override
    public Object resolveContextualObject(String s) {
        return null;
    }

    @Override
    public String getConversationId() {
        return "justASecond";
    }
}
