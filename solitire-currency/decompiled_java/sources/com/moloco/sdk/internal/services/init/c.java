package com.moloco.sdk.internal.services.init;

import com.moloco.sdk.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final t<com.moloco.sdk.i, h> f18711a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18712b;

    public c(@NotNull t<com.moloco.sdk.i, h> sdkInitResult, @NotNull String fetchType) {
        kotlin.jvm.internal.t.i(sdkInitResult, "sdkInitResult");
        kotlin.jvm.internal.t.i(fetchType, "fetchType");
        this.f18711a = sdkInitResult;
        this.f18712b = fetchType;
    }

    @NotNull
    public final String a() {
        return this.f18712b;
    }

    @NotNull
    public final t<com.moloco.sdk.i, h> b() {
        return this.f18711a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        return kotlin.jvm.internal.t.d(this.f18711a, cVar.f18711a) && kotlin.jvm.internal.t.d(this.f18712b, cVar.f18712b);
    }

    public int hashCode() {
        return (this.f18711a.hashCode() * 31) + this.f18712b.hashCode();
    }

    @NotNull
    public String toString() {
        return "FetchState(sdkInitResult=" + this.f18711a + ", fetchType=" + this.f18712b + ')';
    }
}
