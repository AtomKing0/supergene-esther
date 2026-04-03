package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class nq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final dq f14168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final jq f14169b;

    public nq(@NotNull dq error) {
        kotlin.jvm.internal.t.i(error, "error");
        this.f14168a = error;
        this.f14169b = null;
    }

    @Nullable
    public final dq a() {
        return this.f14168a;
    }

    @Nullable
    public final jq b() {
        return this.f14169b;
    }

    public final boolean c() {
        jq jqVar;
        if (this.f14168a == null && (jqVar = this.f14169b) != null) {
            return jqVar.c().p();
        }
        return false;
    }

    public nq(@NotNull jq sdkInitResponse) {
        kotlin.jvm.internal.t.i(sdkInitResponse, "sdkInitResponse");
        this.f14169b = sdkInitResponse;
        this.f14168a = null;
    }
}
