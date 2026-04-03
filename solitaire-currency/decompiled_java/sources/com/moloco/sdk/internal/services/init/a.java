package com.moloco.sdk.internal.services.init;

import androidx.compose.runtime.internal.StabilityInferred;
import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18702a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18703b;

    public a(@NotNull String appKey, @NotNull String mediation) {
        t.i(appKey, "appKey");
        t.i(mediation, "mediation");
        this.f18702a = appKey;
        this.f18703b = mediation;
    }

    @NotNull
    public final String a() {
        return this.f18703b;
    }

    @NotNull
    public final String b() {
        return this.f18702a + "___" + this.f18703b + "___v0";
    }

    @NotNull
    public final List<String> c() {
        return v.l();
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.d(this.f18702a, aVar.f18702a) && t.d(this.f18703b, aVar.f18703b);
    }

    public int hashCode() {
        return (this.f18702a.hashCode() * 31) + this.f18703b.hashCode();
    }

    @NotNull
    public String toString() {
        return "CacheKey(appKey=" + this.f18702a + ", mediation=" + this.f18703b + ')';
    }
}
