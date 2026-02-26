package com.onetrust.otpublishers.headless.UI.fragment;

import com.onetrust.otpublishers.headless.Public.OTVendorListMode;

/* JADX INFO: loaded from: classes4.dex */
public final class r2 extends kotlin.jvm.internal.v implements h9.p<String, Boolean, v8.k0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ m2 f23526g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public r2(m2 m2Var) {
        super(2);
        this.f23526g = m2Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final v8.k0 mo4invoke(String str, Boolean bool) {
        String id = str;
        boolean zBooleanValue = bool.booleanValue();
        kotlin.jvm.internal.t.i(id, "id");
        m2.F(this.f23526g, id, zBooleanValue, OTVendorListMode.GENERAL);
        return v8.k0.f35197a;
    }
}
