package com.ironsource;

import com.ironsource.mediationsdk.IronSourceSegment;
import com.ironsource.mediationsdk.adunit.adapter.internal.BaseAdAdapter;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.mg;
import com.ironsource.x1;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public class p2 extends k1 {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    private final k1 f14295g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final k2 f14296h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private z4 f14297i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(@NotNull k1 adTools, @NotNull s1 adUnitData, @NotNull x1.b level) {
        super(adTools, level);
        kotlin.jvm.internal.t.i(adTools, "adTools");
        kotlin.jvm.internal.t.i(adUnitData, "adUnitData");
        kotlin.jvm.internal.t.i(level, "level");
        this.f14295g = adTools;
        k2 k2VarA = ks.a(adUnitData, adUnitData.e().c());
        kotlin.jvm.internal.t.h(k2VarA, "getAdUnitPerformance(\n  …auctionSavedHistoryLimit)");
        this.f14296h = k2VarA;
    }

    @Nullable
    public final BaseAdAdapter<?, ?> a(@NotNull y instanceData) {
        kotlin.jvm.internal.t.i(instanceData, "instanceData");
        return com.ironsource.mediationsdk.c.b().a(instanceData.u(), instanceData.h(), instanceData.i().b().d().b());
    }

    public final void c(@NotNull yp task) {
        kotlin.jvm.internal.t.i(task, "task");
        ls.a(ls.f13064a, task, 0L, 2, null);
    }

    @NotNull
    public final String h(@NotNull String serverData) {
        kotlin.jvm.internal.t.i(serverData, "serverData");
        String strC = com.ironsource.mediationsdk.d.b().c(serverData);
        kotlin.jvm.internal.t.h(strC, "getInstance().getDynamic…romServerData(serverData)");
        return strC;
    }

    @NotNull
    public final k2 i() {
        return this.f14296h;
    }

    @Nullable
    public final z4 j() {
        return this.f14297i;
    }

    @Nullable
    public final String k() {
        return com.ironsource.mediationsdk.p.m().l();
    }

    @Nullable
    public final Map<String, String> l() {
        return com.ironsource.mediationsdk.p.m().s();
    }

    @Nullable
    public final IronSourceSegment m() {
        return ks.a();
    }

    @NotNull
    public final mg.a n() {
        return el.f11917p.a().e();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p2(@NotNull p2 adUnitTools, @NotNull x1.b level) {
        super(adUnitTools, level);
        kotlin.jvm.internal.t.i(adUnitTools, "adUnitTools");
        kotlin.jvm.internal.t.i(level, "level");
        this.f14295g = adUnitTools.f14295g;
        this.f14296h = adUnitTools.f14296h;
        this.f14297i = adUnitTools.f14297i;
    }

    @NotNull
    public final String a(long j10, @NotNull String instanceName) {
        kotlin.jvm.internal.t.i(instanceName, "instanceName");
        String transId = IronSourceUtils.getTransId(j10, instanceName);
        kotlin.jvm.internal.t.h(transId, "getTransId(timeStamp, instanceName)");
        return transId;
    }

    public final void a(@Nullable z4 z4Var) {
        this.f14297i = z4Var;
    }
}
