package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class e9 implements sa<zf> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ic f11905a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11906b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final de f11907c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final h9.l<v8.t<? extends zf>, v8.k0> f11908d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @NotNull
    private zf f11909e;

    /* JADX WARN: Multi-variable type inference failed */
    public e9(@NotNull ic fileUrl, @NotNull String destinationPath, @NotNull de downloadManager, @NotNull h9.l<? super v8.t<? extends zf>, v8.k0> onFinish) {
        kotlin.jvm.internal.t.i(fileUrl, "fileUrl");
        kotlin.jvm.internal.t.i(destinationPath, "destinationPath");
        kotlin.jvm.internal.t.i(downloadManager, "downloadManager");
        kotlin.jvm.internal.t.i(onFinish, "onFinish");
        this.f11905a = fileUrl;
        this.f11906b = destinationPath;
        this.f11907c = downloadManager;
        this.f11908d = onFinish;
        this.f11909e = new zf(b());
    }

    @Override // com.ironsource.hn
    public void a(@NotNull zf file) {
        kotlin.jvm.internal.t.i(file, "file");
        i().invoke(v8.t.a(v8.t.b(file)));
    }

    @Override // com.ironsource.sa
    @NotNull
    public String b() {
        return this.f11906b;
    }

    @Override // com.ironsource.sa
    @NotNull
    public ic c() {
        return this.f11905a;
    }

    @Override // com.ironsource.sa
    public /* synthetic */ boolean h() {
        return n00.a(this);
    }

    @Override // com.ironsource.sa
    @NotNull
    public h9.l<v8.t<? extends zf>, v8.k0> i() {
        return this.f11908d;
    }

    @Override // com.ironsource.sa
    @NotNull
    public zf j() {
        return this.f11909e;
    }

    @Override // com.ironsource.sa
    @NotNull
    public de k() {
        return this.f11907c;
    }

    @Override // com.ironsource.sa
    public /* synthetic */ void l() {
        n00.b(this);
    }

    @Override // com.ironsource.hn
    public void a(@Nullable zf zfVar, @NotNull rf error) {
        kotlin.jvm.internal.t.i(error, "error");
        h9.l<v8.t<? extends zf>, v8.k0> lVarI = i();
        t.a aVar = v8.t.f35208b;
        lVarI.invoke(v8.t.a(v8.t.b(v8.u.a(new Exception("Unable to download mobileController.html: " + error.b())))));
    }

    @Override // com.ironsource.sa
    public void b(@NotNull zf zfVar) {
        kotlin.jvm.internal.t.i(zfVar, "<set-?>");
        this.f11909e = zfVar;
    }
}
