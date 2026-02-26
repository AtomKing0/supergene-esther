package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.render;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class k implements com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final j f21323a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i f21324b;

    public k(@NotNull j resource, @Nullable com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i iVar) {
        t.i(resource, "resource");
        this.f21323a = resource;
        this.f21324b = iVar;
    }

    @Override // com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i
    public void destroy() {
        com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.i iVar = this.f21324b;
        if (iVar != null) {
            iVar.destroy();
        }
    }

    @NotNull
    public final j j() {
        return this.f21323a;
    }
}
