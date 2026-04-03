package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final x f20689a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f20690b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final t f20691c;

    public w(@NotNull x event, @NotNull String url, @Nullable t tVar) {
        kotlin.jvm.internal.t.i(event, "event");
        kotlin.jvm.internal.t.i(url, "url");
        this.f20689a = event;
        this.f20690b = url;
        this.f20691c = tVar;
    }

    @NotNull
    public final x a() {
        return this.f20689a;
    }

    @Nullable
    public final t b() {
        return this.f20691c;
    }

    @NotNull
    public final String c() {
        return this.f20690b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof w)) {
            return false;
        }
        w wVar = (w) obj;
        return this.f20689a == wVar.f20689a && kotlin.jvm.internal.t.d(this.f20690b, wVar.f20690b) && kotlin.jvm.internal.t.d(this.f20691c, wVar.f20691c);
    }

    public int hashCode() {
        int iHashCode = ((this.f20689a.hashCode() * 31) + this.f20690b.hashCode()) * 31;
        t tVar = this.f20691c;
        return iHashCode + (tVar == null ? 0 : tVar.hashCode());
    }

    @NotNull
    public String toString() {
        return "Tracking(event=" + this.f20689a + ", url=" + this.f20690b + ", offset=" + this.f20691c + ')';
    }
}
