package com.bswen.app9.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MySettings {
    @Value("${my.booleanValue}")
    private boolean myBooleanValue;

    public boolean isMyBooleanValue() {
        return myBooleanValue;
    }

    public void setMyBooleanValue(boolean myBooleanValue) {
        this.myBooleanValue = myBooleanValue;
    }
}
