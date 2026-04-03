package com.moloco.sdk.internal.services.events;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public e f18667a = d.f18668a;

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b
    public void a(boolean z10, boolean z11, @NotNull String appForegroundUrl, @NotNull String appBackgroundUrl) {
        t.i(appForegroundUrl, "appForegroundUrl");
        t.i(appBackgroundUrl, "appBackgroundUrl");
        this.f18667a = new e(z10, z11, appForegroundUrl, appBackgroundUrl);
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b
    public boolean b() {
        return this.f18667a.d();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b
    public boolean c() {
        return this.f18667a.c();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b
    @NotNull
    public String d() {
        return this.f18667a.b();
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.core.services.b
    @NotNull
    public String a() {
        return this.f18667a.a();
    }
}
