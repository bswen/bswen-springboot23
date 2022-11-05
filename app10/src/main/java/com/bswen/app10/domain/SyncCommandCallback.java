package com.bswen.app10.domain;

import io.lettuce.core.api.sync.RedisCommands;

@FunctionalInterface
public interface SyncCommandCallback<T> {
    T doInConnection(RedisCommands<String, String> commands);
}
