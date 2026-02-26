package com.moloco.sdk.xenoss.sdkdevkit.android.adrenderer.internal.vast.model;

import androidx.compose.runtime.internal.StabilityInferred;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
@StabilityInferred(parameters = 0)
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final String f20631a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final Integer f20632b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    public final String f20633c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    public final String f20634d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    public final j f20635e;

    public i(@Nullable String str, @Nullable Integer num, @Nullable String str2, @Nullable String str3, @NotNull j child) {
        kotlin.jvm.internal.t.i(child, "child");
        this.f20631a = str;
        this.f20632b = num;
        this.f20633c = str2;
        this.f20634d = str3;
        this.f20635e = child;
    }

    @Nullable
    public final String a() {
        return this.f20634d;
    }

    @NotNull
    public final j b() {
        return this.f20635e;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof i)) {
            return false;
        }
        i iVar = (i) obj;
        return kotlin.jvm.internal.t.d(this.f20631a, iVar.f20631a) && kotlin.jvm.internal.t.d(this.f20632b, iVar.f20632b) && kotlin.jvm.internal.t.d(this.f20633c, iVar.f20633c) && kotlin.jvm.internal.t.d(this.f20634d, iVar.f20634d) && kotlin.jvm.internal.t.d(this.f20635e, iVar.f20635e);
    }

    public int hashCode() {
        String str = this.f20631a;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        Integer num = this.f20632b;
        int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
        String str2 = this.f20633c;
        int iHashCode3 = (iHashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.f20634d;
        return ((iHashCode3 + (str3 != null ? str3.hashCode() : 0)) * 31) + this.f20635e.hashCode();
    }

    @NotNull
    public String toString() {
        return "Creative(id=" + this.f20631a + ", sequence=" + this.f20632b + ", adId=" + this.f20633c + ", apiFramework=" + this.f20634d + ", child=" + this.f20635e + ')';
    }
}
