package com.moloco.sdk.internal.services.bidtoken.providers;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final com.moloco.sdk.internal.services.p f18523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f18524b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f18525c;

    public n() {
        this(null, null, null, 7, null);
    }

    @Nullable
    public final String a() {
        return this.f18525c;
    }

    @Nullable
    public final String b() {
        return this.f18524b;
    }

    @Nullable
    public final com.moloco.sdk.internal.services.p c() {
        return this.f18523a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof n)) {
            return false;
        }
        n nVar = (n) obj;
        return this.f18523a == nVar.f18523a && kotlin.jvm.internal.t.d(this.f18524b, nVar.f18524b) && kotlin.jvm.internal.t.d(this.f18525c, nVar.f18525c);
    }

    public int hashCode() {
        com.moloco.sdk.internal.services.p pVar = this.f18523a;
        int iHashCode = (pVar == null ? 0 : pVar.hashCode()) * 31;
        String str = this.f18524b;
        int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.f18525c;
        return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "DeviceSignalInfo(orientation=" + this.f18523a + ", locale=" + this.f18524b + ", keyboardLocale=" + this.f18525c + ')';
    }

    public n(@Nullable com.moloco.sdk.internal.services.p pVar, @Nullable String str, @Nullable String str2) {
        this.f18523a = pVar;
        this.f18524b = str;
        this.f18525c = str2;
    }

    public /* synthetic */ n(com.moloco.sdk.internal.services.p pVar, String str, String str2, int i10, kotlin.jvm.internal.k kVar) {
        this((i10 & 1) != 0 ? null : pVar, (i10 & 2) != 0 ? null : str, (i10 & 4) != 0 ? null : str2);
    }
}
