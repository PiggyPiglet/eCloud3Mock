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

package me.piggypiglet.ecloud.routes.v3;

import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import me.piggypiglet.ecloud.data.ExpansionManager;
import me.piggypiglet.ecloud.objects.v3.Expansion;
import me.piggypiglet.ecloud.objects.v3.sub.Platform;
import me.piggypiglet.framework.http.routes.objects.Response;
import me.piggypiglet.framework.http.routes.types.json.JsonManagerRoute;

import java.util.Collection;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class V3Route extends JsonManagerRoute<Expansion> {
    private static final Pattern REGEX = Pattern.compile("v3?.*");

    private final ExpansionManager manager;

    @Inject
    public V3Route(ExpansionManager manager) {
        super(
                uri -> REGEX.matcher(uri).matches(),
                uri -> REGEX.matcher(uri).replaceFirst(""),
                manager
        );
        this.manager = manager;
    }

    @Override
    protected Object provide(Response response) {
        final Multimap<String, String> params = response.getParams();
        final Stream<Expansion> expansions = Stream.of(params.get("platforms"))
                .map(platforms -> platforms.isEmpty() ? manager.getAll() : manager.getAllByPlatforms(platforms.stream()
                        .map(String::toUpperCase)
                        .map(Platform::valueOf)
                        .collect(Collectors.toSet())))
                .flatMap(Collection::stream);

        final Optional<String> name = params.get("name").stream().findAny();

        if (name.isPresent()) {
            return expansions.filter(expansion -> expansion.getName().equalsIgnoreCase(name.get())).findAny().orElse(null);
        }

        return expansions.collect(Collectors.toSet());
    }
}
