package com.ironsource;

import com.ironsource.sdk.utils.IronSourceStorageUtils;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements sa<JSONObject> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ic f11479a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11480b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final de f11481c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h9.l<v8.t<? extends JSONObject>, v8.k0> f11482d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private zf f11483e;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@NotNull ic fileUrl, @NotNull String destinationPath, @NotNull de downloadManager, @NotNull h9.l<? super v8.t<? extends JSONObject>, v8.k0> onFinish) {
        kotlin.jvm.internal.t.i(fileUrl, "fileUrl");
        kotlin.jvm.internal.t.i(destinationPath, "destinationPath");
        kotlin.jvm.internal.t.i(downloadManager, "downloadManager");
        kotlin.jvm.internal.t.i(onFinish, "onFinish");
        this.f11479a = fileUrl;
        this.f11480b = destinationPath;
        this.f11481c = downloadManager;
        this.f11482d = onFinish;
        this.f11483e = new zf(b(), v8.f15657h);
    }

    @Override // com.ironsource.hn
    public void a(@NotNull zf file) {
        kotlin.jvm.internal.t.i(file, "file");
        if (kotlin.jvm.internal.t.d(file.getName(), v8.f15657h)) {
            try {
                i().invoke(v8.t.a(v8.t.b(c(file))));
            } catch (Exception e10) {
                i9.d().a(e10);
                h9.l<v8.t<? extends JSONObject>, v8.k0> lVarI = i();
                t.a aVar = v8.t.f35208b;
                lVarI.invoke(v8.t.a(v8.t.b(v8.u.a(e10))));
            }
        }
    }

    @Override // com.ironsource.sa
    @NotNull
    public String b() {
        return this.f11480b;
    }

    @Override // com.ironsource.sa
    @NotNull
    public ic c() {
        return this.f11479a;
    }

    @Override // com.ironsource.sa
    public /* synthetic */ boolean h() {
        return n00.a(this);
    }

    @Override // com.ironsource.sa
    @NotNull
    public h9.l<v8.t<? extends JSONObject>, v8.k0> i() {
        return this.f11482d;
    }

    @Override // com.ironsource.sa
    @NotNull
    public zf j() {
        return this.f11483e;
    }

    @Override // com.ironsource.sa
    @NotNull
    public de k() {
        return this.f11481c;
    }

    @Override // com.ironsource.sa
    public /* synthetic */ void l() {
        n00.b(this);
    }

    private final JSONObject c(zf zfVar) {
        return new JSONObject(IronSourceStorageUtils.readFile(zfVar));
    }

    @Override // com.ironsource.hn
    public void a(@Nullable zf zfVar, @NotNull rf error) {
        kotlin.jvm.internal.t.i(error, "error");
        h9.l<v8.t<? extends JSONObject>, v8.k0> lVarI = i();
        t.a aVar = v8.t.f35208b;
        lVarI.invoke(v8.t.a(v8.t.b(v8.u.a(new Exception("Unable to download abTestMap.json: " + error.b())))));
    }

    @Override // com.ironsource.sa
    public void b(@NotNull zf zfVar) {
        kotlin.jvm.internal.t.i(zfVar, "<set-?>");
        this.f11483e = zfVar;
    }
}
