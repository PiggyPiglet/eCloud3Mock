/*
 * MIT License
 *
 * Copyright (c) 2019 PiggyPiglet
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package me.piggypiglet.ecloud.data;

import com.google.inject.Singleton;
import me.piggypiglet.ecloud.objects.v3.Expansion;
import me.piggypiglet.ecloud.objects.v3.hard.DemoExpansions;
import me.piggypiglet.ecloud.objects.v3.sub.Platform;
import me.piggypiglet.framework.managers.implementations.SearchableManager;
import me.piggypiglet.framework.managers.objects.KeyTypeInfo;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
@Singleton
public final class ExpansionManager extends SearchableManager<Expansion> {
    private final Map<String, Expansion> expansions = new ConcurrentHashMap<>();

    @Override
    protected void preConfigure() {
        Stream.of(
                DemoExpansions.BUKKIT_EXPANSION, DemoExpansions.NUKKIT_EXPANSION, DemoExpansions.SPONGE_EXPANSION,
                DemoExpansions.UNIVERSAL_EXPANSION
        ).forEach(this::add);
    }

    @Override
    protected KeyTypeInfo configure(KeyTypeInfo.Builder builder) {
        return builder
                .key(String.class)
                    .map(expansions)
                .build();
    }

    @Override
    protected void insert(Expansion item) {
        expansions.put(item.getName(), item);
    }

    @Override
    protected void delete(Expansion item) {
        expansions.remove(item.getName());
    }

    public Set<Expansion> getAllByPlatforms(Set<Platform> platforms) {
        return getAll().stream().filter(e -> e.getPlatforms().containsAll(platforms)).collect(Collectors.toSet());
    }
}
