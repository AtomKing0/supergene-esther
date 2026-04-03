package com.unity3d.ironsourceads.banner;

import com.ironsource.cm;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.tk;
import com.ironsource.ve;
import com.ironsource.wk;
import com.ironsource.z6;
import com.unity3d.ironsourceads.banner.BannerAdLoader;
import java.util.concurrent.Executor;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class BannerAdLoader {

    @NotNull
    public static final BannerAdLoader INSTANCE = new BannerAdLoader();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final Executor f23839a = ve.f15889a.c();

    private BannerAdLoader() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(tk loadTask) {
        t.i(loadTask, "$loadTask");
        loadTask.start();
    }

    public static final void loadAd(@NotNull BannerAdRequest adRequest, @NotNull BannerAdLoaderListener listener) {
        t.i(adRequest, "adRequest");
        t.i(listener, "listener");
        INSTANCE.internalLoadAd$mediationsdk_release(f23839a, new z6(adRequest, listener, cm.f11590e.a(IronSource.AD_UNIT.BANNER), null, 8, null));
    }

    public final void internalLoadAd$mediationsdk_release(@NotNull Executor executor, @NotNull wk loadTaskProvider) {
        t.i(executor, "executor");
        t.i(loadTaskProvider, "loadTaskProvider");
        final tk tkVarA = loadTaskProvider.a();
        executor.execute(new Runnable() { // from class: t6.a
            @Override // java.lang.Runnable
            public final void run() {
                BannerAdLoader.a(tkVarA);
            }
        });
    }
}
