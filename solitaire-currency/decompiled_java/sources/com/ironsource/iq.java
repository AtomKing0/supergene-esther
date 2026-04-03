package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class iq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f12652a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f12653b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final List<IronSource.AD_UNIT> f12654c;

    public iq(@NotNull String appKey, @Nullable String str, @NotNull List<IronSource.AD_UNIT> legacyAdFormats) {
        kotlin.jvm.internal.t.i(appKey, "appKey");
        kotlin.jvm.internal.t.i(legacyAdFormats, "legacyAdFormats");
        this.f12652a = appKey;
        this.f12653b = str;
        this.f12654c = legacyAdFormats;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ iq a(iq iqVar, String str, String str2, List list, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            str = iqVar.f12652a;
        }
        if ((i10 & 2) != 0) {
            str2 = iqVar.f12653b;
        }
        if ((i10 & 4) != 0) {
            list = iqVar.f12654c;
        }
        return iqVar.a(str, str2, list);
    }

    @Nullable
    public final String b() {
        return this.f12653b;
    }

    @NotNull
    public final List<IronSource.AD_UNIT> c() {
        return this.f12654c;
    }

    @NotNull
    public final String d() {
        return this.f12652a;
    }

    @NotNull
    public final List<IronSource.AD_UNIT> e() {
        return this.f12654c;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof iq)) {
            return false;
        }
        iq iqVar = (iq) obj;
        return kotlin.jvm.internal.t.d(this.f12652a, iqVar.f12652a) && kotlin.jvm.internal.t.d(this.f12653b, iqVar.f12653b) && kotlin.jvm.internal.t.d(this.f12654c, iqVar.f12654c);
    }

    @Nullable
    public final String f() {
        return this.f12653b;
    }

    public int hashCode() {
        int iHashCode = this.f12652a.hashCode() * 31;
        String str = this.f12653b;
        return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + this.f12654c.hashCode();
    }

    @NotNull
    public String toString() {
        return "SdkInitRequest(appKey=" + this.f12652a + ", userId=" + this.f12653b + ", legacyAdFormats=" + this.f12654c + ')';
    }

    public /* synthetic */ iq(String str, String str2, List list, int i10, kotlin.jvm.internal.k kVar) {
        this(str, (i10 & 2) != 0 ? null : str2, list);
    }

    @NotNull
    public final iq a(@NotNull String appKey, @Nullable String str, @NotNull List<IronSource.AD_UNIT> legacyAdFormats) {
        kotlin.jvm.internal.t.i(appKey, "appKey");
        kotlin.jvm.internal.t.i(legacyAdFormats, "legacyAdFormats");
        return new iq(appKey, str, legacyAdFormats);
    }

    @NotNull
    public final String a() {
        return this.f12652a;
    }

    public final void a(@NotNull List<? extends IronSource.AD_UNIT> adFormats) {
        kotlin.jvm.internal.t.i(adFormats, "adFormats");
        this.f12654c.clear();
        this.f12654c.addAll(adFormats);
    }
}
