package com.moloco.sdk.acm;

import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f17424a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final Long f17425b;

    /* JADX WARN: Multi-variable type inference failed */
    public g() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    @Nullable
    public final String a() {
        return this.f17424a;
    }

    @Nullable
    public final Long b() {
        return this.f17425b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof g)) {
            return false;
        }
        g gVar = (g) obj;
        return t.d(this.f17424a, gVar.f17424a) && t.d(this.f17425b, gVar.f17425b);
    }

    public int hashCode() {
        String str = this.f17424a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Long l10 = this.f17425b;
        return iHashCode + (l10 != null ? l10.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "UpdateConfig(postAnalyticsUrl=" + this.f17424a + ", requestPeriodSeconds=" + this.f17425b + ')';
    }

    public g(@Nullable String str, @Nullable Long l10) {
        this.f17424a = str;
        this.f17425b = l10;
    }

    public /* synthetic */ g(String str, Long l10, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : str, (i10 & 2) != 0 ? null : l10);
    }
}
