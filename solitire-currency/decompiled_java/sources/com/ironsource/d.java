package com.ironsource;

import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements ic {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final vn f11728a;

    public d(@NotNull vn folderRootUrl) {
        kotlin.jvm.internal.t.i(folderRootUrl, "folderRootUrl");
        this.f11728a = folderRootUrl;
    }

    @Override // com.ironsource.ic
    @NotNull
    public String value() {
        return this.f11728a.a() + "/abTestMap.json";
    }
}
