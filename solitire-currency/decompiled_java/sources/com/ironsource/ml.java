package com.ironsource;

import android.app.Activity;
import com.ironsource.dg;
import com.ironsource.nl;
import com.ironsource.sdk.controller.f;
import com.ironsource.sdk.controller.l;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ml implements nl {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f14019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final com.ironsource.sdk.controller.e f14020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final sg f14021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final u2 f14022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f14023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @Nullable
    private nl.a f14024f;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final a f14025a = new a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        public static final String f14026b = "nativeAd.load";

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        @NotNull
        public static final String f14027c = "nativeAd.loadReport";

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NotNull
        public static final String f14028d = "nativeAd.register";

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        @NotNull
        public static final String f14029e = "nativeAd.click";

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        @NotNull
        public static final String f14030f = "nativeAd.privacyClick";

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        @NotNull
        public static final String f14031g = "nativeAd.visibilityChanged";

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        @NotNull
        public static final String f14032h = "nativeAd.destroy";

        private a() {
        }
    }

    public ml(@NotNull String id, @NotNull com.ironsource.sdk.controller.e controllerManager, @NotNull sg imageLoader, @NotNull u2 adViewManagement) {
        kotlin.jvm.internal.t.i(id, "id");
        kotlin.jvm.internal.t.i(controllerManager, "controllerManager");
        kotlin.jvm.internal.t.i(imageLoader, "imageLoader");
        kotlin.jvm.internal.t.i(adViewManagement, "adViewManagement");
        this.f14019a = id;
        this.f14020b = controllerManager;
        this.f14021c = imageLoader;
        this.f14022d = adViewManagement;
        this.f14023e = ml.class.getSimpleName();
        controllerManager.a(id, c());
    }

    @Override // com.ironsource.nl
    @Nullable
    public nl.a a() {
        return this.f14024f;
    }

    @Override // com.ironsource.nl
    public void destroy() {
        this.f14020b.a(new f.c(this.f14019a, a.f14032h, new JSONObject()), (l.a) null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ ml(String str, com.ironsource.sdk.controller.e eVar, sg sgVar, u2 u2Var, int i10, kotlin.jvm.internal.k kVar) {
        sgVar = (i10 & 4) != 0 ? new rg(null, 1, null) : sgVar;
        if ((i10 & 8) != 0) {
            u2Var = pf.a();
            kotlin.jvm.internal.t.h(u2Var, "getInstance()");
        }
        this(str, eVar, sgVar, u2Var);
    }

    private final void a(Activity activity, f.a aVar) {
        if (aVar.d() == null) {
            nl.a aVarA = a();
            if (aVarA != null) {
                aVarA.a("failed to load native ad: missing params");
                return;
            }
            return;
        }
        if (aVar.d().optBoolean("success", false)) {
            dg.b bVarA = new dg.a(this.f14021c, this.f14022d).a(activity, aVar.d());
            a(bVarA, bVarA.a().h());
            return;
        }
        String reason = aVar.d().optString("reason", "failed to load native ad: unexpected error");
        nl.a aVarA2 = a();
        if (aVarA2 != null) {
            kotlin.jvm.internal.t.h(reason, "reason");
            aVarA2.a(reason);
        }
    }

    private final l.b c() {
        return new l.b() { // from class: com.ironsource.ey
            @Override // com.ironsource.sdk.controller.l.b
            public final void a(gl glVar) {
                ml.a(this.f12003a, glVar);
            }
        };
    }

    private final JSONObject d() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put(f.b.f15008g, a.f14029e).put("sdkCallback", v8.g.T);
        kotlin.jvm.internal.t.h(jSONObjectPut, "JSONObject()\n        .pu…hods.ON_RECEIVED_MESSAGE)");
        return jSONObjectPut;
    }

    @Override // com.ironsource.nl
    public void b() {
        this.f14020b.a(new f.c(this.f14019a, a.f14030f, new JSONObject()), (l.a) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(ml this$0, f.a it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.b(it);
    }

    @Override // com.ironsource.nl
    public void a(@NotNull final Activity activity, @NotNull JSONObject loadParams) {
        kotlin.jvm.internal.t.i(activity, "activity");
        kotlin.jvm.internal.t.i(loadParams, "loadParams");
        this.f14020b.a(activity);
        this.f14020b.a(new f.c(this.f14019a, a.f14026b, loadParams), new l.a() { // from class: com.ironsource.zx
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                ml.a(this.f16500a, activity, aVar);
            }
        });
    }

    private final void a(dg.b bVar, final dg dgVar) {
        this.f14020b.a(new f.c(this.f14019a, "nativeAd.loadReport." + this.f14019a, bVar.b()), new l.a() { // from class: com.ironsource.ay
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                ml.a(this.f11321a, dgVar, aVar);
            }
        });
    }

    private final void b(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.f14023e, "failed to handle show on native ad: missing params");
            return;
        }
        if (aVar.d().optBoolean("success", false)) {
            nl.a aVarA = a();
            if (aVarA != null) {
                aVarA.a();
                return;
            }
            return;
        }
        String strOptString = aVar.d().optString("reason", "unexpected error");
        Logger.i(this.f14023e, "failed to handle show on native ad: " + strOptString);
    }

    private final void a(dg dgVar, f.a aVar) {
        if (aVar.d() == null) {
            nl.a aVarA = a();
            if (aVarA != null) {
                aVarA.a("failed to load native ad: missing report params");
                return;
            }
            return;
        }
        if (aVar.d().optBoolean("success", false)) {
            nl.a aVarA2 = a();
            if (aVarA2 != null) {
                aVarA2.a(dgVar);
                return;
            }
            return;
        }
        String reason = aVar.d().optString("reason", "failed to load native ad: unexpected error");
        nl.a aVarA3 = a();
        if (aVarA3 != null) {
            kotlin.jvm.internal.t.h(reason, "reason");
            aVarA3.a(reason);
        }
    }

    @Override // com.ironsource.nl
    public void a(@NotNull fu viewVisibilityParams) {
        kotlin.jvm.internal.t.i(viewVisibilityParams, "viewVisibilityParams");
        this.f14020b.a(new f.c(this.f14019a, a.f14031g, viewVisibilityParams.g()), new l.a() { // from class: com.ironsource.cy
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                ml.b(this.f11723a, aVar);
            }
        });
    }

    @Override // com.ironsource.nl
    public void a(@NotNull gg viewHolder) throws JSONException {
        kotlin.jvm.internal.t.i(viewHolder, "viewHolder");
        JSONObject params = new JSONObject().put("assetViews", viewHolder.t()).put("adViewClickCommand", d());
        String str = this.f14019a;
        kotlin.jvm.internal.t.h(params, "params");
        this.f14020b.a(new f.c(str, a.f14028d, params), (l.a) null);
    }

    private final void a(gl glVar) {
        if (glVar.f() == null) {
            Logger.i(this.f14023e, "failed to handle click on native ad: missing params");
            return;
        }
        if (glVar.f().optBoolean("success", false)) {
            nl.a aVarA = a();
            if (aVarA != null) {
                aVarA.b();
                return;
            }
            return;
        }
        String strOptString = glVar.f().optString("reason", "unexpected error");
        Logger.i(this.f14023e, "failed to handle click on native ad: " + strOptString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ml this$0, Activity activity, f.a it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(activity, "$activity");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.a(activity, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ml this$0, dg adData, f.a it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(adData, "$adData");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.a(adData, it);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ml this$0, gl msg) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(msg, "msg");
        if (kotlin.jvm.internal.t.d(msg.e(), a.f14029e)) {
            this$0.a(msg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void a(ml this$0, f.a it) {
        kotlin.jvm.internal.t.i(this$0, "this$0");
        kotlin.jvm.internal.t.i(it, "it");
        this$0.a(it);
    }

    @Override // com.ironsource.nl
    public void a(@Nullable nl.a aVar) {
        this.f14024f = aVar;
    }

    private final void a(f.a aVar) {
        if (aVar.d() == null) {
            Logger.i(this.f14023e, "failed to handle click on native ad: missing params");
            return;
        }
        if (aVar.d().optBoolean("success", false)) {
            nl.a aVarA = a();
            if (aVarA != null) {
                aVarA.b();
                return;
            }
            return;
        }
        String strOptString = aVar.d().optString("reason", "unexpected error");
        Logger.i(this.f14023e, "failed to handle click on native ad: " + strOptString);
    }

    @Override // com.ironsource.nl
    public void a(@NotNull JSONObject clickParams) {
        kotlin.jvm.internal.t.i(clickParams, "clickParams");
        this.f14020b.a(new f.c(this.f14019a, a.f14029e, clickParams), new l.a() { // from class: com.ironsource.dy
            @Override // com.ironsource.sdk.controller.l.a
            public final void a(f.a aVar) {
                ml.a(this.f11871a, aVar);
            }
        });
    }
}
