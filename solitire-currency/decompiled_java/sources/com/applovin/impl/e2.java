package com.applovin.impl;

import com.applovin.impl.r5;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public abstract class e2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f5086a;

    /* JADX INFO: Access modifiers changed from: private */
    public static /* synthetic */ void a(com.applovin.impl.sdk.j jVar) {
        if (f5086a) {
            return;
        }
        jVar.A().a(y1.f7798o0, "no_ads_loaded");
    }

    public static void b(final com.applovin.impl.sdk.j jVar) {
        Long l10 = (Long) jVar.a(g3.f5244t7);
        if (l10.longValue() <= 0) {
            return;
        }
        jVar.j0().a(new f6(jVar, true, "submitIntegrationErrorReport", new Runnable() { // from class: com.applovin.impl.f9
            @Override // java.lang.Runnable
            public final void run() {
                e2.a(jVar);
            }
        }), r5.b.OTHER, TimeUnit.SECONDS.toMillis(l10.longValue()));
    }

    public static void a() {
        f5086a = true;
    }
}
