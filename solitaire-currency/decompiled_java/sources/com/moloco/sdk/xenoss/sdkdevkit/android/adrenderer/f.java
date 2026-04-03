package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final q f18986a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final d f18987b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final d f18988c;

    public f(@NotNull q vastOptions, @NotNull d mraidOptions, @NotNull d staticOptions) {
        kotlin.jvm.internal.t.i(vastOptions, "vastOptions");
        kotlin.jvm.internal.t.i(mraidOptions, "mraidOptions");
        kotlin.jvm.internal.t.i(staticOptions, "staticOptions");
        this.f18986a = vastOptions;
        this.f18987b = mraidOptions;
        this.f18988c = staticOptions;
    }

    @NotNull
    public final d a() {
        return this.f18987b;
    }

    @NotNull
    public final d b() {
        return this.f18988c;
    }

    @NotNull
    public final q c() {
        return this.f18986a;
    }
}
