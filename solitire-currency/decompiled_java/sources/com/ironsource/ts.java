package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.model.NetworkSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class ts {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final String f15475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    private final String f15476b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f15477c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private final Boolean f15478d;

    public ts(@Nullable String str, boolean z10, @Nullable Boolean bool, @Nullable String str2) {
        this.f15475a = str2;
        this.f15476b = str;
        this.f15477c = z10;
        this.f15478d = bool;
    }

    @Nullable
    public final String a() {
        return this.f15475a;
    }

    public final boolean b() {
        return kotlin.jvm.internal.t.d(this.f15478d, Boolean.TRUE);
    }

    public /* synthetic */ ts(String str, boolean z10, Boolean bool, String str2, int i10, kotlin.jvm.internal.k kVar) {
        this(str, z10, (i10 & 4) != 0 ? Boolean.FALSE : bool, (i10 & 8) != 0 ? null : str2);
    }

    public final boolean a(@NotNull NetworkSettings networkSettings, @NotNull IronSource.AD_UNIT adUnit) {
        kotlin.jvm.internal.t.i(networkSettings, "networkSettings");
        kotlin.jvm.internal.t.i(adUnit, "adUnit");
        String str = this.f15476b;
        if (str == null || str.length() == 0) {
            return true;
        }
        zs zsVar = zs.f16492a;
        return kotlin.jvm.internal.t.d(zsVar.a(networkSettings), this.f15476b) && zsVar.a(networkSettings, adUnit) == this.f15477c;
    }
}
