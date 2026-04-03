package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.mraid;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public enum s {
    Loading("loading"),
    Default("default"),
    Resized("resized"),
    Expanded("expanded"),
    Hidden("hidden");


    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f19619a;

    s(String str) {
        this.f19619a = str;
    }

    @NotNull
    public final String c() {
        return this.f19619a;
    }
}
