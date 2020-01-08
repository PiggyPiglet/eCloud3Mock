package me.piggypiglet.ecloud.objects;

import me.piggypiglet.ecloud.objects.sub.Version;
import me.piggypiglet.framework.utils.SearchUtils;

import java.util.List;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class Expansion implements SearchUtils.Searchable {
    private String name;
    private String description;
    private String sourceUrl;
    private String dependencyUrl;
    private boolean verified;
    private List<Version> versions;
    private String author;
    private String latestVersion;
    private String lastUpdate;
    private int averageRating;
    private int ratingsCount;
    private List<String> placeholders;

    @Override
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
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

    public List<Version> getVersions() {
        return versions;
    }

    public String getAuthor() {
        return author;
    }

    public String getLatestVersion() {
        return latestVersion;
    }

    public String getLastUpdate() {
        return lastUpdate;
    }

    public int getAverageRating() {
        return averageRating;
    }

    public int getRatingsCount() {
        return ratingsCount;
    }

    public List<String> getPlaceholders() {
        return placeholders;
    }
}
