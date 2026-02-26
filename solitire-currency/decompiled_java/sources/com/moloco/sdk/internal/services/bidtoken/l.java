package com.moloco.sdk.internal.services.bidtoken;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public final String f18466a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    public final String f18467b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public final g f18468c;

    public l(@NotNull String bidToken, @NotNull String publicKey, @NotNull g bidTokenConfig) {
        kotlin.jvm.internal.t.i(bidToken, "bidToken");
        kotlin.jvm.internal.t.i(publicKey, "publicKey");
        kotlin.jvm.internal.t.i(bidTokenConfig, "bidTokenConfig");
        this.f18466a = bidToken;
        this.f18467b = publicKey;
        this.f18468c = bidTokenConfig;
    }

    @NotNull
    public final String a() {
        return this.f18466a;
    }

    @NotNull
    public final g b() {
        return this.f18468c;
    }

    @NotNull
    public final String c() {
        return this.f18467b;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof l)) {
            return false;
        }
        l lVar = (l) obj;
        return kotlin.jvm.internal.t.d(this.f18466a, lVar.f18466a) && kotlin.jvm.internal.t.d(this.f18467b, lVar.f18467b) && kotlin.jvm.internal.t.d(this.f18468c, lVar.f18468c);
    }

    public int hashCode() {
        return (((this.f18466a.hashCode() * 31) + this.f18467b.hashCode()) * 31) + this.f18468c.hashCode();
    }

    @NotNull
    public String toString() {
        return "BidTokenResponseComponents(bidToken=" + this.f18466a + ", publicKey=" + this.f18467b + ", bidTokenConfig=" + this.f18468c + ')';
    }
}
