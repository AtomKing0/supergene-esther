package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class v1 extends qb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final k1 f15637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final b1 f15638b;

    public v1(@NotNull k1 adTools, @NotNull b1 adProperties) {
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adProperties, "adProperties");
        this.f15637a = adTools;
        this.f15638b = adProperties;
    }

    @Override // com.ironsource.w1
    @NotNull
    public Map<String, Object> a(@Nullable u1 u1Var) {
        Map<String, Object> mapA = a(this.f15638b);
        mapA.put(IronSourceConstants.EVENTS_PROVIDER, "Mediation");
        mapA.put("sessionDepth", Integer.valueOf(this.f15637a.g()));
        return mapA;
    }
}
