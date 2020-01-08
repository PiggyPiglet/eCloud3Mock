package me.piggypiglet.ecloud;

import me.piggypiglet.framework.Framework;

// ------------------------------
// Copyright (c) PiggyPiglet 2020
// https://www.piggypiglet.me
// ------------------------------
public final class EcloudBootstrap {
    private EcloudBootstrap() {
        Framework.builder()
                .main(this)
                .pckg("me.piggypiglet.ecloud")
                .commandPrefixes("!")
                .build()
                .init();
    }

    public static void main(String[] args) {
        new EcloudBootstrap();
    }
}
