package com.google.ads.mediation.vungle;

import android.content.Context;
import com.vungle.ads.a2;
import com.vungle.ads.n0;
import com.vungle.ads.q1;
import com.vungle.ads.x0;
import com.vungle.ads.z1;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: VungleFactory.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    @NotNull
    public final com.vungle.ads.c a() {
        return new com.vungle.ads.c();
    }

    @NotNull
    public final a2 b(@NotNull Context context, @NotNull String placementId, @NotNull z1 adSize) {
        t.i(context, "context");
        t.i(placementId, "placementId");
        t.i(adSize, "adSize");
        return new a2(context, placementId, adSize);
    }

    @NotNull
    public final n0 c(@NotNull Context context, @NotNull String placementId, @NotNull com.vungle.ads.c adConfig) {
        t.i(context, "context");
        t.i(placementId, "placementId");
        t.i(adConfig, "adConfig");
        return new n0(context, placementId, adConfig);
    }

    @NotNull
    public final x0 d(@NotNull Context context, @NotNull String placementId) {
        t.i(context, "context");
        t.i(placementId, "placementId");
        return new x0(context, placementId);
    }

    @NotNull
    public final q1 e(@NotNull Context context, @NotNull String placementId, @NotNull com.vungle.ads.c adConfig) {
        t.i(context, "context");
        t.i(placementId, "placementId");
        t.i(adConfig, "adConfig");
        return new q1(context, placementId, adConfig);
    }
}
