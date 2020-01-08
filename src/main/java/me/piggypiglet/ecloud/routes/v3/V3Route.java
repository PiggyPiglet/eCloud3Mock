package me.piggypiglet.ecloud.routes.v3;

import com.google.inject.Inject;
import me.piggypiglet.ecloud.data.ExpansionManager;
import me.piggypiglet.ecloud.objects.Expansion;
import me.piggypiglet.framework.http.routes.objects.Header;
import me.piggypiglet.framework.http.routes.types.json.JsonManagerRoute;

import java.util.List;
import java.util.Map;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class V3Route extends JsonManagerRoute<Expansion> {
    private final ExpansionManager manager;

    @Inject
    public V3Route(ExpansionManager manager) {
        super("v3", manager);
        this.manager = manager;
    }

    @Override
    protected Object provide(Map<String, List<String>> params, List<Header> headers, String ip) {

        return manager.getAll();
    }
}
