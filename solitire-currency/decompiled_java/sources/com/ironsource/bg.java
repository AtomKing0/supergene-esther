package com.ironsource;

import android.app.Activity;
import com.ironsource.fg;
import com.ironsource.gg;
import com.ironsource.nl;
import com.ironsource.qf;
import com.ironsource.sdk.IronSourceNetwork;
import com.ironsource.v8;
import com.ironsource.vp;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.UUID;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class bg implements fg {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @NotNull
    public static final a f11400j = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11401a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final nl f11402b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final tf f11403c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private dg f11404d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private String f11405e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private String f11406f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @Nullable
    private Long f11407g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    private fg.a f11408h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    private gg f11409i;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final bg a() {
            String string = UUID.randomUUID().toString();
            kotlin.jvm.internal.t.h(string, "randomUUID().toString()");
            com.ironsource.sdk.controller.e controllerManager = IronSourceNetwork.getControllerManager();
            kotlin.jvm.internal.t.h(controllerManager, "controllerManager");
            return new bg(string, new ml(string, controllerManager, null, null, 12, null), new uf());
        }
    }

    public static final class b implements nl.a {
        b() {
        }

        @Override // com.ironsource.nl.a
        public void a() {
            fg.a aVarA = bg.this.a();
            if (aVarA != null) {
                aVarA.onNativeAdShown();
            }
        }

        @Override // com.ironsource.nl.a
        public void b() {
            fg.a aVarA = bg.this.a();
            if (aVarA != null) {
                aVarA.onNativeAdClicked();
            }
        }

        @Override // com.ironsource.nl.a
        public void a(@NotNull dg adData) {
            kotlin.jvm.internal.t.i(adData, "adData");
            bg.this.f11404d = adData;
            tf tfVar = bg.this.f11403c;
            vp.a loadAdSuccess = vp.f15944l;
            kotlin.jvm.internal.t.h(loadAdSuccess, "loadAdSuccess");
            HashMap<String, Object> mapA = bg.this.c().a();
            kotlin.jvm.internal.t.h(mapA, "baseEventParams().data");
            tfVar.a(loadAdSuccess, mapA);
            fg.a aVarA = bg.this.a();
            if (aVarA != null) {
                aVarA.onNativeAdLoadSuccess(adData);
            }
        }

        @Override // com.ironsource.nl.a
        public void a(@NotNull String reason) {
            kotlin.jvm.internal.t.i(reason, "reason");
            sf sfVarA = bg.this.c().a(nb.A, reason);
            tf tfVar = bg.this.f11403c;
            vp.a loadAdFailed = vp.f15939g;
            kotlin.jvm.internal.t.h(loadAdFailed, "loadAdFailed");
            HashMap<String, Object> mapA = sfVarA.a();
            kotlin.jvm.internal.t.h(mapA, "eventParams.data");
            tfVar.a(loadAdFailed, mapA);
            fg.a aVarA = bg.this.a();
            if (aVarA != null) {
                aVarA.onNativeAdLoadFailed(reason);
            }
        }
    }

    public static final class c implements gg.a {

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f11412a;

            static {
                int[] iArr = new int[gg.b.values().length];
                try {
                    iArr[gg.b.PrivacyIcon.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                f11412a = iArr;
            }
        }

        c() {
        }

        @Override // com.ironsource.gg.a
        public void a(@NotNull fu viewVisibilityParams) {
            kotlin.jvm.internal.t.i(viewVisibilityParams, "viewVisibilityParams");
            bg.this.f11402b.a(viewVisibilityParams);
        }

        @Override // com.ironsource.gg.a
        public void a(@NotNull gg.b viewName) throws JSONException {
            kotlin.jvm.internal.t.i(viewName, "viewName");
            if (a.f11412a[viewName.ordinal()] == 1) {
                bg.this.f11402b.b();
                return;
            }
            JSONObject clickParams = new JSONObject().put("viewName", viewName.b());
            nl nlVar = bg.this.f11402b;
            kotlin.jvm.internal.t.h(clickParams, "clickParams");
            nlVar.a(clickParams);
        }
    }

    public bg(@NotNull String id, @NotNull nl controller, @NotNull tf eventTracker) {
        kotlin.jvm.internal.t.i(id, "id");
        kotlin.jvm.internal.t.i(controller, "controller");
        kotlin.jvm.internal.t.i(eventTracker, "eventTracker");
        this.f11401a = id;
        this.f11402b = controller;
        this.f11403c = eventTracker;
        controller.a(e());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final sf c() {
        sf sfVarA = new sf().a(nb.f14126x, this.f11406f).a(nb.f14124v, this.f11405e).a(nb.f14125w, qf.e.NativeAd.toString()).a(nb.I, Long.valueOf(i()));
        kotlin.jvm.internal.t.h(sfVarA, "ISNEventParams()\n       …CUSTOM_C, loadDuration())");
        return sfVarA;
    }

    @NotNull
    public static final bg d() {
        return f11400j.a();
    }

    private final b e() {
        return new b();
    }

    private final c f() {
        return new c();
    }

    private final long i() {
        Long l10 = this.f11407g;
        if (l10 == null) {
            return -1L;
        }
        return Calendar.getInstance().getTimeInMillis() - l10.longValue();
    }

    @Override // com.ironsource.fg
    @Nullable
    public fg.a a() {
        return this.f11408h;
    }

    @Override // com.ironsource.fg
    @Nullable
    public dg b() {
        return this.f11404d;
    }

    @Override // com.ironsource.fg
    public void destroy() {
        gg ggVar = this.f11409i;
        if (ggVar != null) {
            ggVar.a((gg.a) null);
        }
        this.f11402b.destroy();
    }

    @Nullable
    public final String g() {
        return this.f11405e;
    }

    @Nullable
    public final String h() {
        return this.f11406f;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ bg(String str, nl nlVar, tf tfVar, int i10, kotlin.jvm.internal.k kVar) {
        if ((i10 & 1) != 0) {
            str = UUID.randomUUID().toString();
            kotlin.jvm.internal.t.h(str, "randomUUID().toString()");
        }
        this(str, nlVar, tfVar);
    }

    @Override // com.ironsource.fg
    public void a(@NotNull Activity activity, @NotNull JSONObject loadParams) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(loadParams, "loadParams");
        this.f11407g = Long.valueOf(Calendar.getInstance().getTimeInMillis());
        this.f11405e = loadParams.optString("demandSourceName");
        this.f11406f = loadParams.optString("inAppBidding");
        tf tfVar = this.f11403c;
        vp.a loadAd = vp.f15938f;
        kotlin.jvm.internal.t.h(loadAd, "loadAd");
        HashMap<String, Object> mapA = c().a();
        kotlin.jvm.internal.t.h(mapA, "baseEventParams().data");
        tfVar.a(loadAd, mapA);
        JSONObject jSONObject = new JSONObject(loadParams.toString());
        jSONObject.put(v8.h.f15828y0, String.valueOf(this.f11407g));
        this.f11402b.a(activity, jSONObject);
    }

    @Override // com.ironsource.fg
    public void a(@Nullable fg.a aVar) {
        this.f11408h = aVar;
    }

    @Override // com.ironsource.fg
    public void a(@NotNull gg viewHolder) {
        kotlin.jvm.internal.t.i(viewHolder, "viewHolder");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        HashMap<String, Object> mapA = c().a();
        kotlin.jvm.internal.t.h(mapA, "baseEventParams().data");
        linkedHashMap.putAll(mapA);
        String string = viewHolder.t().toString();
        kotlin.jvm.internal.t.h(string, "viewHolder.viewsStatus().toString()");
        linkedHashMap.put(nb.f14127y, string);
        tf tfVar = this.f11403c;
        vp.a registerAd = vp.f15946n;
        kotlin.jvm.internal.t.h(registerAd, "registerAd");
        tfVar.a(registerAd, linkedHashMap);
        this.f11409i = viewHolder;
        viewHolder.a(f());
        this.f11402b.a(viewHolder);
    }
}
