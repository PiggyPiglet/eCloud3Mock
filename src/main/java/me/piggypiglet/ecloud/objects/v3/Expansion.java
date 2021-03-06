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

package me.piggypiglet.ecloud.objects.v3;

import me.piggypiglet.ecloud.objects.v3.sub.Platform;
import me.piggypiglet.ecloud.objects.v3.sub.Version;
import me.piggypiglet.framework.utils.SearchUtils;

import java.util.Set;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public class Expansion implements SearchUtils.Searchable {
    private String name;
    private String description;
    private Set<Platform> platforms;
    private String sourceUrl;
    private String dependencyUrl;
    private boolean verified;
    private Set<Version> versions;
    private String author;
    private String latestVersion;
    private long lastUpdate;
    private Set<String> placeholders;

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Set<Platform> getPlatforms() {
        return platforms;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public String getDependencyUrl() {
        return dependencyUrl;
    }

    public boolean isVerified() {
        return verified;
    }

    public Set<Version> getVersions() {
        return versions;
    }

    public String getAuthor() {
        return author;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public long getLastUpdate() {
        return lastUpdate;
    }

    public Set<String> getPlaceholders() {
        return placeholders;
    }
}
