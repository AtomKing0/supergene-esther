package com.ironsource;

import com.ironsource.mediationsdk.ISBannerSize;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class s6 extends ho {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final k1 f14793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final ISBannerSize f14794c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public s6(@NotNull k1 adTools, @NotNull ISBannerSize size, @NotNull String placement) {
        super(placement);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(size, "size");
        kotlin.jvm.internal.t.i(placement, "placement");
        this.f14793b = adTools;
        this.f14794c = size;
    }

    @Override // com.ironsource.ho, com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@Nullable u1 u1Var) {
        Map<String, Object> mapZ = kotlin.collections.r0.z(super.a(u1Var));
        this.f14793b.a(mapZ, this.f14794c);
        return mapZ;
    }
}
