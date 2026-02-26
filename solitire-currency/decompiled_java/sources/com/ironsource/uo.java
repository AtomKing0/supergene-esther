package com.ironsource;

import android.adservices.measurement.MeasurementManager;
import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.OutcomeReceiver;
import com.ironsource.mediationsdk.utils.IronSourceUtils;
import com.ironsource.v8;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class uo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ge f15614a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.a<Long> f15615b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final me f15616c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final Executor f15617d;

    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.a<Long> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f15618a = new a();

        a() {
            super(0, System.class, "currentTimeMillis", "currentTimeMillis()J", 0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public final Long invoke() {
            return Long.valueOf(System.currentTimeMillis());
        }
    }

    public static final class b implements OutcomeReceiver<Object, Exception> {
        b() {
        }

        @Override // android.os.OutcomeReceiver
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onError(@NotNull Exception error) {
            kotlin.jvm.internal.t.i(error, "error");
            uo.this.a(error.getMessage());
        }

        @Override // android.os.OutcomeReceiver
        public void onResult(@Nullable Object obj) {
            uo.this.c();
        }
    }

    public uo() {
        this(null, null, null, null, 15, null);
    }

    private final Uri a(Context context) {
        ce ceVarF = this.f15616c.f();
        String connectionType = IronSourceUtils.getConnectionType(context);
        Uri uriBuild = new Uri.Builder().scheme("https").authority("android-att.ironsrc.mobi").path("register_trigger").appendQueryParameter("osVersion", Build.VERSION.RELEASE).appendQueryParameter("apiLevel", String.valueOf(Build.VERSION.SDK_INT)).appendQueryParameter(v8.i.f15853l, Build.MODEL).appendQueryParameter("sdkVersion", IronSourceUtils.getSDKVersion()).appendQueryParameter("bundleID", context.getPackageName()).appendQueryParameter(ad.D0, ceVarF.p(context)).appendQueryParameter(ad.f11269u0, ceVarF.D(context)).appendQueryParameter("auid", ceVarF.s(context)).appendQueryParameter("isFirstSession", String.valueOf(b(context))).appendQueryParameter("coppa", b()).appendQueryParameter(ad.Y, String.valueOf(g1.a())).appendQueryParameter("origin", "1").appendQueryParameter("timestamp", String.valueOf(this.f15615b.invoke().longValue())).appendQueryParameter(v8.i.f15872x, ceVarF.b(context)).appendQueryParameter("deviceCarrier", ceVarF.j(context)).appendQueryParameter(v8.i.f15868t, connectionType).appendQueryParameter(r8.f14655b, String.valueOf(p9.q.x(connectionType, r8.f14655b, true))).build();
        kotlin.jvm.internal.t.h(uriBuild, "Builder()\n        .schem…arameter\n        .build()");
        return uriBuild;
    }

    private final String b() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapC = lj.b().c();
        List<String> list = concurrentHashMapC != null ? concurrentHashMapC.get(com.ironsource.mediationsdk.metadata.a.f13683b) : null;
        String str = list != null ? (String) kotlin.collections.d0.i0(list) : null;
        return str == null ? "" : str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void c() {
        this.f15614a.a(new kb(55, null));
    }

    private final void d() {
        this.f15614a.a(new kb(54, null));
    }

    public uo(@NotNull ge eventManager, @NotNull h9.a<Long> getTimeFunction, @NotNull me serviceProvider, @NotNull Executor executor) {
        kotlin.jvm.internal.t.i(eventManager, "eventManager");
        kotlin.jvm.internal.t.i(getTimeFunction, "getTimeFunction");
        kotlin.jvm.internal.t.i(serviceProvider, "serviceProvider");
        kotlin.jvm.internal.t.i(executor, "executor");
        this.f15614a = eventManager;
        this.f15615b = getTimeFunction;
        this.f15616c = serviceProvider;
        this.f15617d = executor;
    }

    @SuppressLint({"NewApi"})
    private final OutcomeReceiver<Object, Exception> a() {
        return new b();
    }

    private final boolean b(Context context) {
        return IronSourceUtils.getFirstSession(context);
    }

    @SuppressLint({"NewApi"})
    public final void c(@NotNull Context context) {
        kotlin.jvm.internal.t.i(context, "context");
        d();
        try {
            MeasurementManager measurementManagerA = g1.a(context);
            if (measurementManagerA == null) {
                a("could not obtain measurement manager");
            } else {
                measurementManagerA.registerTrigger(a(context), this.f15617d, a());
            }
        } catch (Exception e10) {
            a(e10.getMessage());
            i9.d().a(e10);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ uo(ge geVar, h9.a aVar, me meVar, Executor executor, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 1) != 0) {
            geVar = rp.i();
            kotlin.jvm.internal.t.h(geVar, "getInstance()");
        }
        aVar = (i10 & 2) != 0 ? a.f15618a : aVar;
        meVar = (i10 & 4) != 0 ? el.f11917p.d() : meVar;
        if ((i10 & 8) != 0) {
            executor = Executors.newSingleThreadExecutor();
            kotlin.jvm.internal.t.h(executor, "newSingleThreadExecutor()");
        }
        this(geVar, aVar, meVar, executor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(String str) {
        this.f15614a.a(new kb(56, new JSONObject().put("reason", str)));
    }
}
