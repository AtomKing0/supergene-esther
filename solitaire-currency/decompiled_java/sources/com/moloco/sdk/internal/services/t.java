package com.moloco.sdk.internal.services;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class t {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18814a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18815b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final String f18816c;

    public t(@NotNull String applicationName, @NotNull String packageName, @NotNull String version) {
        kotlin.jvm.internal.t.i(applicationName, "applicationName");
        kotlin.jvm.internal.t.i(packageName, "packageName");
        kotlin.jvm.internal.t.i(version, "version");
        this.f18814a = applicationName;
        this.f18815b = packageName;
        this.f18816c = version;
    }

    @NotNull
    public final String a() {
        return this.f18815b;
    }

    @NotNull
    public final String b() {
        return this.f18816c;
    }
}
