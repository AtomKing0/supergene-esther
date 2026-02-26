package com.onetrust.otpublishers.headless.UI.fragment;

/* JADX INFO: loaded from: classes4.dex */
public final class e1 extends kotlin.jvm.internal.v implements h9.l<String, Boolean> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c1 f23293g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e1(c1 c1Var) {
        super(1);
        this.f23293g = c1Var;
    }

    @Override // h9.l
    public final Boolean invoke(String str) {
        boolean zK;
        String it = str;
        kotlin.jvm.internal.t.i(it, "it");
        c1 c1Var = this.f23293g;
        int i10 = c1.f23253k;
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = c1Var.N();
        if (it == null) {
            bVarN.getClass();
            zK = false;
        } else {
            zK = bVarN.f23674a.k(it);
        }
        return Boolean.valueOf(zK);
    }
}
