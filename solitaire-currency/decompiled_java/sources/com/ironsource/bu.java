package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class bu implements ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final vn f11475a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f11476b;

    public bu(@NotNull vn folderRootUrl, @NotNull String version) {
        kotlin.jvm.internal.t.i(folderRootUrl, "folderRootUrl");
        kotlin.jvm.internal.t.i(version, "version");
        this.f11475a = folderRootUrl;
        this.f11476b = version;
    }

    @NotNull
    public final String a() {
        return this.f11476b;
    }

    @Override // com.ironsource.ic
    @NotNull
    public String value() {
        return this.f11475a.a() + "/versions/" + this.f11476b + "/mobileController.html";
    }
}
