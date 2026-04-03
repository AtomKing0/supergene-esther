package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class vk implements cc<uk> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f15926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final oo f15927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    private final x2 f15928c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final boolean f15929d;

    public vk(@NotNull String adm, @NotNull oo providerName, @NotNull x2 adapterConfigs, boolean z10) {
        kotlin.jvm.internal.t.i(adm, "adm");
        kotlin.jvm.internal.t.i(providerName, "providerName");
        kotlin.jvm.internal.t.i(adapterConfigs, "adapterConfigs");
        this.f15926a = adm;
        this.f15927b = providerName;
        this.f15928c = adapterConfigs;
        this.f15929d = z10;
    }

    @Override // com.ironsource.cc
    @Nullable
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public uk a() throws Exception {
        eh ehVarA = this.f15928c.a(this.f15927b);
        new o0(this.f15926a, ehVarA, this.f15929d).a();
        if (ehVarA != null) {
            return new uk(ehVarA.c(), ehVarA.b(), ehVarA.e(), ehVarA.a(), false, 16, null);
        }
        return null;
    }
}
