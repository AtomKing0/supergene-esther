package com.ironsource;

import android.util.Log;
import com.ironsource.d9;
import com.ironsource.sdk.utils.IronSourceStorageUtils;
import com.ironsource.sdk.utils.SDKUtils;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f9 implements ae {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final c9 f12085a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final h9.l<zf, Object> f12086b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final de f12087c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final k9 f12088d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f12089e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @NotNull
    private zf f12090f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f12091g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @NotNull
    private final vn f12092h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private String f12093i;

    /* synthetic */ class a extends kotlin.jvm.internal.q implements h9.l<v8.t<? extends zf>, v8.k0> {
        a(Object obj) {
            super(1, obj, f9.class, "onHtmlDownloadFinished", "onHtmlDownloadFinished(Ljava/lang/Object;)V", 0);
        }

        public final void a(@NotNull Object obj) {
            ((f9) this.receiver).b(obj);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(v8.t<? extends zf> tVar) {
            a(tVar.j());
            return v8.k0.f35197a;
        }
    }

    /* synthetic */ class b extends kotlin.jvm.internal.q implements h9.l<v8.t<? extends JSONObject>, v8.k0> {
        b(Object obj) {
            super(1, obj, f9.class, "onAbTestDownloadFinished", "onAbTestDownloadFinished(Ljava/lang/Object;)V", 0);
        }

        public final void a(@NotNull Object obj) throws JSONException {
            ((f9) this.receiver).a(obj);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(v8.t<? extends JSONObject> tVar) throws JSONException {
            a(tVar.j());
            return v8.k0.f35197a;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public f9(@NotNull c9 config, @NotNull h9.l<? super zf, ? extends Object> onFinish, @NotNull de downloadManager, @NotNull k9 currentTimeProvider) {
        kotlin.jvm.internal.t.i(config, "config");
        kotlin.jvm.internal.t.i(onFinish, "onFinish");
        kotlin.jvm.internal.t.i(downloadManager, "downloadManager");
        kotlin.jvm.internal.t.i(currentTimeProvider, "currentTimeProvider");
        this.f12085a = config;
        this.f12086b = onFinish;
        this.f12087c = downloadManager;
        this.f12088d = currentTimeProvider;
        this.f12089e = f9.class.getSimpleName();
        this.f12090f = new zf(config.b(), "mobileController_0.html");
        this.f12091g = currentTimeProvider.a();
        this.f12092h = new vn(config.c());
        this.f12093i = "";
    }

    private final e9 a(String str) {
        return new e9(new bu(this.f12092h, str), this.f12085a.b() + "/mobileController_" + str + ".html", this.f12087c, new a(this));
    }

    @Override // com.ironsource.ae
    @NotNull
    public zf b() {
        return this.f12090f;
    }

    @NotNull
    public final k9 c() {
        return this.f12088d;
    }

    @NotNull
    public final h9.l<zf, Object> d() {
        return this.f12086b;
    }

    @Override // com.ironsource.ae
    public void a() {
        this.f12091g = this.f12088d.a();
        new c(new d(this.f12092h), this.f12085a.b() + "/temp", this.f12087c, new b(this)).l();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public final void b(Object obj) {
        if (v8.t.h(obj)) {
            zf zfVar = (zf) (v8.t.g(obj) ? null : obj);
            if (!kotlin.jvm.internal.t.d(zfVar != null ? zfVar.getAbsolutePath() : null, this.f12090f.getAbsolutePath())) {
                try {
                    IronSourceStorageUtils.deleteFile(this.f12090f);
                    kotlin.jvm.internal.t.f(zfVar);
                    f9.m.o(zfVar, this.f12090f, true, 0, 4, null);
                } catch (Exception e10) {
                    i9.d().a(e10);
                    Log.e(this.f12089e, "Unable to copy downloaded mobileController.html to cache folder: " + e10.getMessage());
                }
                kotlin.jvm.internal.t.f(zfVar);
                this.f12090f = zfVar;
            }
            new d9.b(this.f12085a.d(), this.f12091g, this.f12088d).a();
        } else {
            new d9.a(this.f12085a.d()).a();
        }
        h9.l<zf, Object> lVar = this.f12086b;
        if (v8.t.g(obj)) {
            obj = null;
        }
        lVar.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void a(Object obj) throws JSONException {
        e9 e9VarA;
        if (v8.t.g(obj)) {
            obj = null;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject == null || kotlin.jvm.internal.t.d(jSONObject.optString("htmlBuildNumber"), "")) {
            e9VarA = a("0");
        } else {
            SDKUtils.updateControllerConfig("abTestMap", jSONObject);
            String string = jSONObject.getString("htmlBuildNumber");
            kotlin.jvm.internal.t.h(string, "abTestMapAsJson.getString(\"htmlBuildNumber\")");
            this.f12093i = string;
            e9VarA = a(string);
            if (e9VarA.h()) {
                zf zfVarJ = e9VarA.j();
                this.f12090f = zfVarJ;
                this.f12086b.invoke(zfVarJ);
                return;
            }
        }
        e9VarA.l();
    }

    @Override // com.ironsource.ae
    public boolean a(@NotNull zf file) {
        kotlin.jvm.internal.t.i(file, "file");
        String name = file.getName();
        kotlin.jvm.internal.t.h(name, "file.name");
        return new p9.f("mobileController(_\\d+)?\\.html").a(name);
    }
}
