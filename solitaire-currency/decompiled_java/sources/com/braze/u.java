package com.braze;

/* JADX INFO: loaded from: classes2.dex */
public final class u extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ boolean f8126a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public u(boolean z10) {
        super(0);
        this.f8126a = z10;
    }

    @Override // h9.a
    public final Object invoke() {
        return "Braze SDK outbound network requests are now ".concat(this.f8126a ? "disabled" : "enabled");
    }
}
