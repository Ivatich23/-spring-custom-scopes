package com.rd.epam.autotasks.scopes.config.postProcessor.Scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.Map;

public class ThreeTimes implements Scope {
    private final Map<String, Object> beanScopeMap = new HashMap<>();
    int count = 1;

    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {
        if (!beanScopeMap.containsKey(beanName) ) {
            count = 1;
        }
        if (count <= 3) {
            if (!beanScopeMap.containsKey(beanName)) {
                beanScopeMap.put(beanName, objectFactory.getObject());
            }
            count++;
            return beanScopeMap.get(beanName);
        } else {
            count=2;
            beanScopeMap.put(beanName, objectFactory.getObject());
            return beanScopeMap.get(beanName);
        }
    }

    @Override
    public Object remove(String scapeName) {
        return beanScopeMap.remove(scapeName);
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
        return "threeTimes";
    }
}
