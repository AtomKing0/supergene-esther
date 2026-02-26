package com.ironsource;

import com.ironsource.mediationsdk.IronSource;
import com.ironsource.qd;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements qd, qd.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Map<IronSource.AD_UNIT, AtomicBoolean> f14611a = kotlin.collections.r0.j(v8.y.a(IronSource.AD_UNIT.REWARDED_VIDEO, new AtomicBoolean(false)), v8.y.a(IronSource.AD_UNIT.INTERSTITIAL, new AtomicBoolean(false)), v8.y.a(IronSource.AD_UNIT.BANNER, new AtomicBoolean(false)));

    @Override // com.ironsource.qd.a
    public void a(@NotNull IronSource.AD_UNIT adFormat, boolean z10) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        AtomicBoolean atomicBoolean = this.f14611a.get(adFormat);
        if (atomicBoolean != null) {
            atomicBoolean.set(z10);
        }
    }

    @Override // com.ironsource.qd
    public boolean a(@NotNull IronSource.AD_UNIT adFormat) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        AtomicBoolean atomicBoolean = this.f14611a.get(adFormat);
        if (atomicBoolean != null) {
            return atomicBoolean.get();
        }
        return false;
    }
}
