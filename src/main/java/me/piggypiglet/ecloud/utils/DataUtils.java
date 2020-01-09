package me.piggypiglet.ecloud.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import me.piggypiglet.ecloud.objects.v3.Expansion;
import me.piggypiglet.ecloud.objects.v3.sub.Category;
import me.piggypiglet.ecloud.objects.v3.sub.Version;
import me.piggypiglet.framework.mapper.LevenshteinObjectMapper;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class DataUtils {
    private static final Gson GSON = new Gson();
    private static final LevenshteinObjectMapper<Expansion> EXPANSION_MAPPER = new LevenshteinObjectMapper<Expansion>(){};
    private static final LevenshteinObjectMapper<Version> VERSION_MAPPER = new LevenshteinObjectMapper<Version>(){};

    public static Set<Expansion> generate(String json) {
        final Map<String, Map<String, Object>> data = GSON.fromJson(json, new TypeToken<HashMap<String, Map<String, Object>>>(){}.getType());

        return data.entrySet().stream().map(e -> expansion(e.getKey(), e.getValue())).collect(Collectors.toSet());
    }

    @SuppressWarnings("unchecked")
    private static Expansion expansion(String name, Map<String, Object> map) {
        map.put("name", name);
        map.put("category", Category.values()[ThreadLocalRandom.current().nextInt(0, Category.values().length)]);
        map.put("versions", ((List<Map<String, Object>>) map.get("versions")).stream()
                .map(DataUtils::version)
                .collect(Collectors.toList()));

        return EXPANSION_MAPPER.dataToType(map);
    }

    private static Version version(Map<String, Object> map) {
        // Inspection below is irrelevant, as gson literally puts null as the value
        //noinspection Java8MapApi
        if (map.get("release_notes") == null) {
            map.put("release_notes", "");
        }

        return VERSION_MAPPER.dataToType(map);
    }
}
