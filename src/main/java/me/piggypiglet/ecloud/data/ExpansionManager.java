package me.piggypiglet.ecloud.data;

import com.google.inject.Singleton;
import me.piggypiglet.ecloud.objects.Expansion;
import me.piggypiglet.framework.managers.implementations.SearchableManager;
import me.piggypiglet.framework.managers.objects.KeyTypeInfo;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
@Singleton
public final class ExpansionManager extends SearchableManager<Expansion> {
    private final Map<String, Expansion> managers = new ConcurrentHashMap<>();

    @Override
    protected KeyTypeInfo configure(KeyTypeInfo.Builder builder) {
        return null;
    }

    @Override
    protected void insert(Expansion item) {

    }

    @Override
    protected void delete(Expansion item) {

    }
}
