package com.rd.epam.autotasks.scopes.config.postProcessor.Scopes;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.config.Scope;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class ThreadScope implements Scope {
    private final Map<String, Object> objectMap = new HashMap();
    private final List<Thread> threads = new LinkedList<>();


    @Override
    public Object get(String beanName, ObjectFactory<?> objectFactory) {
        if (threads.contains(Thread.currentThread())) {
                if (!objectMap.containsKey(beanName)) {
                    objectMap.put(beanName, objectFactory.getObject());
                }
            return objectMap.get(beanName);
        }else{
            threads.add(Thread.currentThread());
            objectMap.put(beanName, objectFactory.getObject());
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
        return "thread";
    }


}
