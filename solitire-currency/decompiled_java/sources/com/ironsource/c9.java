package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class c9 implements be {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11544a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11545b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f11546c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @NotNull
    private final vn f11547d;

    public c9() {
        this(null, null, false, null, 15, null);
    }

    @Override // com.ironsource.be
    @NotNull
    public vn a() {
        return this.f11547d;
    }

    @Override // com.ironsource.be
    @NotNull
    public String b() {
        return this.f11545b;
    }

    @Override // com.ironsource.be
    @NotNull
    public String c() {
        return this.f11544a;
    }

    @Override // com.ironsource.be
    public boolean d() {
        return this.f11546c;
    }

    public c9(@NotNull String controllerUrl, @NotNull String cacheFolder, boolean z10, @NotNull vn rootFolder) {
        kotlin.jvm.internal.t.i(controllerUrl, "controllerUrl");
        kotlin.jvm.internal.t.i(cacheFolder, "cacheFolder");
        kotlin.jvm.internal.t.i(rootFolder, "rootFolder");
        this.f11544a = controllerUrl;
        this.f11545b = cacheFolder;
        this.f11546c = z10;
        this.f11547d = rootFolder;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ c9(String str, String str2, boolean z10, vn vnVar, int i10, kotlin.jvm.internal.k kVar) {
        str = (i10 & 1) != 0 ? "" : str;
        this(str, (i10 & 2) != 0 ? "" : str2, (i10 & 4) != 0 ? false : z10, (i10 & 8) != 0 ? new vn(str) : vnVar);
    }
}
