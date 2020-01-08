package me.piggypiglet.ecloud.objects.v3.hard;

import me.piggypiglet.ecloud.objects.v3.Expansion;
import me.piggypiglet.ecloud.objects.v3.sub.Category;
import me.piggypiglet.ecloud.objects.v3.sub.Version;
import me.piggypiglet.framework.mapper.LevenshteinObjectMapper;
import me.piggypiglet.framework.utils.map.Maps;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class DemoExpansions {
    private static final LevenshteinObjectMapper<Expansion> EXPANSION_MAPPER = new LevenshteinObjectMapper<Expansion>(){};
    private static final LevenshteinObjectMapper<Version> VERSION_MAPPER = new LevenshteinObjectMapper<Version>(){};

    public static final Expansion BUKKIT_EXPANSION = expansion("bukkit meh", Category.BUKKIT);
    public static final Expansion SPONGE_EXPANSION = expansion("moist sponge", Category.SPONGE);
    public static final Expansion NUKKIT_EXPANSION = expansion("pe bukkit", Category.NUKKIT);
    public static final Expansion UNIVERSAL_EXPANSION = expansion("the future", Category.UNIVERSAL);

    private static Expansion expansion(String name, Category category) {
        final UnaryOperator<String> format = str -> "%" + name.replace(' ', '_') + "_" + str + "%";

        return EXPANSION_MAPPER.dataToType(
                Maps.of(new HashMap<String, Object>())
                        .key("name").value(name)
                        .key("description").value("great expansion for your server very laggy")
                        .key("category").value(category)
                        .key("source_url").value("https://github.com/yes")
                        .key("dependency_url").value("https://spigotmc.org/resources/shittyploogin101.56123")
                        .key("verified").value(false)
                        .key("versions").value(Collections.singleton(VERSION_MAPPER.dataToType(
                                Maps.of(new HashMap<String, Object>())
                                        .key("url").value("https://cdn.placeholderapi.com/expansions/" + name.replace(" ", "%20") + ".jar")
                                        .key("version").value("1.0.0")
                                        .key("release_notes").value("first release, designed to perform terribly.")
                                        .build())))
                        .key("author").value("PiggyPiglet")
                        .key("latest_version").value("1.0.0")
                        .key("last_update").value(System.currentTimeMillis())
                        .key("average_rating").value(69)
                        .key("ratings_count").value(420)
                        .key("placeholders").value(Stream.of("boomer", "oof", "hmm").map(format).collect(Collectors.toSet()))
                        .build()
        );
    }
}
