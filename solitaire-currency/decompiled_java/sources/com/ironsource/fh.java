package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class fh {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12140a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f12141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final String f12142c;

    public fh() {
        this(null, 0, null, 7, null);
    }

    public static /* synthetic */ fh a(fh fhVar, String str, int i10, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = fhVar.f12140a;
        }
        if ((i11 & 2) != 0) {
            i10 = fhVar.f12141b;
        }
        if ((i11 & 4) != 0) {
            str2 = fhVar.f12142c;
        }
        return fhVar.a(str, i10, str2);
    }

    public final int b() {
        return this.f12141b;
    }

    @Nullable
    public final String c() {
        return this.f12142c;
    }

    @Nullable
    public final String d() {
        return this.f12142c;
    }

    @NotNull
    public final String e() {
        return this.f12140a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof fh)) {
            return false;
        }
        fh fhVar = (fh) obj;
        return kotlin.jvm.internal.t.d(this.f12140a, fhVar.f12140a) && this.f12141b == fhVar.f12141b && kotlin.jvm.internal.t.d(this.f12142c, fhVar.f12142c);
    }

    public final int f() {
        return this.f12141b;
    }

    public int hashCode() {
        int iHashCode = ((this.f12140a.hashCode() * 31) + this.f12141b) * 31;
        String str = this.f12142c;
        return iHashCode + (str == null ? 0 : str.hashCode());
    }

    @NotNull
    public String toString() {
        return "InstanceInformation(instanceId=" + this.f12140a + ", instanceType=" + this.f12141b + ", dynamicDemandSourceId=" + this.f12142c + ')';
    }

    public fh(@NotNull String instanceId, int i10, @Nullable String str) {
        kotlin.jvm.internal.t.i(instanceId, "instanceId");
        this.f12140a = instanceId;
        this.f12141b = i10;
        this.f12142c = str;
    }

    @NotNull
    public final fh a(@NotNull String instanceId, int i10, @Nullable String str) {
        kotlin.jvm.internal.t.i(instanceId, "instanceId");
        return new fh(instanceId, i10, str);
    }

    public /* synthetic */ fh(String str, int i10, String str2, int i11, kotlin.jvm.internal.k kVar) {
        this((i11 & 1) != 0 ? "" : str, (i11 & 2) != 0 ? 0 : i10, (i11 & 4) != 0 ? "" : str2);
    }

    @NotNull
    public final String a() {
        return this.f12140a;
    }
}
