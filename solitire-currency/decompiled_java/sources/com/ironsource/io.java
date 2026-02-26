package com.ironsource;

import com.unity3d.mediation.LevelPlay;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class io {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12646a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final LevelPlay.AdFormat f12647b;

    public io(@NotNull String placementName, @NotNull LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        this.f12646a = placementName;
        this.f12647b = adFormat;
    }

    @NotNull
    public final String a() {
        return this.f12646a + '_' + this.f12647b;
    }
}
