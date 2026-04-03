package com.moloco.sdk.internal.services.bidtoken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f18446a;

    public g(boolean z10) {
        this.f18446a = z10;
    }

    public final boolean a() {
        return this.f18446a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof g) && this.f18446a == ((g) obj).f18446a;
    }

    public int hashCode() {
        boolean z10 = this.f18446a;
        if (z10) {
            return 1;
        }
        return z10 ? 1 : 0;
    }

    @NotNull
    public String toString() {
        return "BidTokenConfig(dbtEnabled=" + this.f18446a + ')';
    }
}
