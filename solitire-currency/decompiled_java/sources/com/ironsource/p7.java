package com.ironsource;

import com.ironsource.k7;
import com.ironsource.mediationsdk.logger.IronLog;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import java.util.List;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class p7<Smash extends k7<?>> extends vu<Smash> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f14308h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public p7(int i10, boolean z10, @NotNull List<? extends Smash> waterfall, boolean z11) {
        super(i10, z10, waterfall);
        kotlin.jvm.internal.t.i(waterfall, "waterfall");
        this.f14308h = z11;
    }

    @Override // com.ironsource.vu
    public void c(@NotNull Smash smash) {
        String str;
        kotlin.jvm.internal.t.i(smash, "smash");
        if (!smash.w()) {
            IronLog.INTERNAL.verbose(smash.g().name() + " - Smash " + smash.c() + " (non-bidder) is ready to load");
            smash.a(true);
            c().add(smash);
            return;
        }
        this.f14308h = true;
        if (d() == 0) {
            str = "Advanced Loading: Starting to load bidder " + smash.c() + ". No other instances will be loaded at the same time.";
            smash.a(true);
            c().add(smash);
        } else {
            str = "Advanced Loading: Won't start loading bidder " + smash.c() + " as a non bidder is being loaded";
        }
        IronLog.INTERNAL.verbose(smash.g().name() + " - " + str);
        IronSourceUtils.sendAutomationLog(str);
    }

    @Override // com.ironsource.vu
    public boolean e() {
        return super.e() || this.f14308h;
    }

    public /* synthetic */ p7(int i10, boolean z10, List list, boolean z11, int i11, kotlin.jvm.internal.k kVar) {
        this(i10, z10, list, (i11 & 8) != 0 ? false : z11);
    }
}
