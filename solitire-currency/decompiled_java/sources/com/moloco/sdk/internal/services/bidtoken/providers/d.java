package com.moloco.sdk.internal.services.bidtoken.providers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Long f18494a;

    public d(@Nullable Long l10) {
        this.f18494a = l10;
    }

    @Nullable
    public final Long a() {
        return this.f18494a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof d) && kotlin.jvm.internal.t.d(this.f18494a, ((d) obj).f18494a);
    }

    public int hashCode() {
        Long l10 = this.f18494a;
        if (l10 == null) {
            return 0;
        }
        return l10.hashCode();
    }

    @NotNull
    public String toString() {
        return "AppDirInfo(appDirSize=" + this.f18494a + ')';
    }
}
