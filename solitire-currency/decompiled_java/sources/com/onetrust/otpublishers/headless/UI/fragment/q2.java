package com.onetrust.otpublishers.headless.UI.fragment;

import com.onetrust.otpublishers.headless.UI.fragment.m2;

/* JADX INFO: loaded from: classes4.dex */
public final class q2 extends kotlin.jvm.internal.v implements h9.l<String, v8.k0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m2 f23504g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public q2(m2 m2Var) {
        super(1);
        this.f23504g = m2Var;
    }

    @Override // h9.l
    public final v8.k0 invoke(String str) {
        String vendorId = str;
        kotlin.jvm.internal.t.i(vendorId, "vendorId");
        m2 m2Var = this.f23504g;
        m2.a aVar = m2.f23426o;
        m2Var.J(vendorId, "google");
        return v8.k0.f35197a;
    }
}
