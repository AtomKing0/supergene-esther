package com.ironsource;

import android.content.Context;
import android.os.Handler;
import android.view.Choreographer;
import com.ironsource.cr;
import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.IronSource;
import com.ironsource.mediationsdk.adunit.adapter.internal.AdapterBaseInterface;
import com.ironsource.mediationsdk.integration.IntegrationHelper;
import com.ironsource.mediationsdk.utils.IronSourceConstants;
import com.unity3d.mediation.LevelPlay;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public class ok {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final hh f14252a = new hh(null, 1, null);

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f14253a;

        static {
            int[] iArr = new int[LevelPlay.AdFormat.values().length];
            try {
                iArr[LevelPlay.AdFormat.BANNER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[LevelPlay.AdFormat.INTERSTITIAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[LevelPlay.AdFormat.REWARDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[LevelPlay.AdFormat.NATIVE_AD.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            f14253a = iArr;
        }
    }

    public static final class b extends yp {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f14254a;

        b(Runnable runnable) {
            this.f14254a = runnable;
        }

        @Override // com.ironsource.yp
        public void a() {
            this.f14254a.run();
        }
    }

    @NotNull
    public final Handler a() {
        return this.f14252a.a();
    }

    public final void e(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, callback, 0L, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(final ok this$0, final Runnable runnable) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(runnable, "$runnable");
        Choreographer.getInstance().postFrameCallback(new Choreographer.FrameCallback() { // from class: com.ironsource.zy
            @Override // android.view.Choreographer.FrameCallback
            public final void doFrame(long j10) {
                ok.a(this.f16502a, runnable, j10);
            }
        });
    }

    @NotNull
    public final IronSource.AD_UNIT a(@NotNull LevelPlay.AdFormat adFormat) {
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        int i10 = a.f14253a[adFormat.ordinal()];
        if (i10 == 1) {
            return IronSource.AD_UNIT.BANNER;
        }
        if (i10 == 2) {
            return IronSource.AD_UNIT.INTERSTITIAL;
        }
        if (i10 == 3) {
            return IronSource.AD_UNIT.REWARDED_VIDEO;
        }
        if (i10 == 4) {
            return IronSource.AD_UNIT.NATIVE_AD;
        }
        throw new v8.q();
    }

    public final void c(@NotNull final Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        a(this, new Runnable() { // from class: com.ironsource.az
            @Override // java.lang.Runnable
            public final void run() {
                ok.b(this.f11323a, runnable);
            }
        }, 0L, 2, (Object) null);
    }

    public final void d(@NotNull Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        this.f14252a.b(runnable);
    }

    public final void a(long j10, @NotNull cr.a responseOrigin) {
        kotlin.jvm.internal.t.i(responseOrigin, "responseOrigin");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("isMultipleAdUnits", 1);
        jSONObject.put("duration", j10);
        jSONObject.put(IronSourceConstants.EVENTS_EXT1, responseOrigin.a());
        ks.a(IronSourceConstants.SDK_INIT_SUCCESS, jSONObject);
    }

    public final void b(@NotNull yp safeRunnable) {
        kotlin.jvm.internal.t.i(safeRunnable, "safeRunnable");
        this.f14252a.a(safeRunnable);
    }

    public final void a(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        IntegrationHelper.validateIntegration(context.getApplicationContext());
    }

    public final void b(@NotNull final Runnable runnable) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        a(this, new Runnable() { // from class: com.ironsource.yy
            @Override // java.lang.Runnable
            public final void run() {
                ok.a(this.f16352a, runnable);
            }
        }, 0L, 2, (Object) null);
    }

    public final void a(@NotNull dq error, long j10) {
        kotlin.jvm.internal.t.i(error, "error");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, error.c());
        jSONObject.put("reason", error.d());
        jSONObject.put("isMultipleAdUnits", 1);
        jSONObject.put("duration", j10);
        ks.a(IronSourceConstants.SDK_INIT_FAILED, jSONObject);
    }

    public static /* synthetic */ void a(ok okVar, yp ypVar, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postTask");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        okVar.a(ypVar, j10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ok this$0, Runnable runnable) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(runnable, "$runnable");
        this$0.f14252a.b(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ok this$0, Runnable runnable, long j10) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(runnable, "$runnable");
        this$0.b(runnable);
    }

    public static /* synthetic */ void a(ok okVar, Runnable runnable, long j10, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: postOnUIThread");
        }
        if ((i10 & 2) != 0) {
            j10 = 0;
        }
        okVar.a(runnable, j10);
    }

    public final void a(@NotNull yp safeRunnable) {
        kotlin.jvm.internal.t.i(safeRunnable, "safeRunnable");
        a(this, safeRunnable, 0L, 2, (Object) null);
    }

    public final void a(@NotNull yp safeRunnable, long j10) {
        kotlin.jvm.internal.t.i(safeRunnable, "safeRunnable");
        this.f14252a.a(safeRunnable, j10);
    }

    public final void a(@NotNull Runnable callback) {
        kotlin.jvm.internal.t.i(callback, "callback");
        this.f14252a.a(callback);
    }

    public final void a(@NotNull Runnable runnable, long j10) {
        kotlin.jvm.internal.t.i(runnable, "runnable");
        IronSourceThreadManager.INSTANCE.postOnUiThreadTask(new b(runnable), j10);
    }

    public final void a(@NotNull String adUnitId, int i10, @Nullable String str) throws JSONException {
        kotlin.jvm.internal.t.i(adUnitId, "adUnitId");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i10);
        jSONObject.putOpt("reason", str);
        jSONObject.put("mediationAdUnitId", adUnitId);
        jSONObject.put("isMultipleAdUnits", 1);
        ks.a(IronSourceConstants.TROUBLESHOOTING_AD_UNIT_CAPPING_PARSE_ERROR, jSONObject);
    }

    public final void a(@NotNull String placementName, @NotNull IronSource.AD_UNIT adFormat, int i10, @Nullable String str) throws JSONException {
        kotlin.jvm.internal.t.i(placementName, "placementName");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(IronSourceConstants.EVENTS_ERROR_CODE, i10);
        jSONObject.putOpt("reason", str);
        jSONObject.put("placement", placementName);
        jSONObject.put(bk.f11421f, adFormat.toString());
        jSONObject.put("adf", ks.b(adFormat));
        jSONObject.put("isMultipleAdUnits", 1);
        ks.a(IronSourceConstants.TROUBLESHOOTING_PLACEMENT_CAPPING_PARSE_ERROR, jSONObject);
    }

    public final boolean a(@NotNull AdapterBaseInterface networkAdapter, @NotNull IronSource.AD_UNIT adFormat, @NotNull String providerName) {
        kotlin.jvm.internal.t.i(networkAdapter, "networkAdapter");
        kotlin.jvm.internal.t.i(adFormat, "adFormat");
        kotlin.jvm.internal.t.i(providerName, "providerName");
        return ks.a(networkAdapter, adFormat, providerName);
    }

    @NotNull
    public final IronSource.AD_UNIT[] a(@NotNull LevelPlay.AdFormat... adFormats) {
        kotlin.jvm.internal.t.i(adFormats, "adFormats");
        ArrayList arrayList = new ArrayList();
        for (LevelPlay.AdFormat adFormat : adFormats) {
            arrayList.add(a(adFormat));
        }
        return (IronSource.AD_UNIT[]) arrayList.toArray(new IronSource.AD_UNIT[0]);
    }
}
