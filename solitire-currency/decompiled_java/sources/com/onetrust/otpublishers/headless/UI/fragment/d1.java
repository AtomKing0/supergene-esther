package com.onetrust.otpublishers.headless.UI.fragment;

import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;

/* JADX INFO: loaded from: classes4.dex */
public final class d1 extends kotlin.jvm.internal.v implements h9.p<String, Boolean, v8.k0> {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final /* synthetic */ c1 f23287g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d1(c1 c1Var) {
        super(2);
        this.f23287g = c1Var;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public final v8.k0 mo4invoke(String str, Boolean bool) {
        String id = str;
        boolean zBooleanValue = bool.booleanValue();
        kotlin.jvm.internal.t.i(id, "id");
        c1 c1Var = this.f23287g;
        int i10 = c1.f23253k;
        com.onetrust.otpublishers.headless.UI.viewmodel.b bVarN = c1Var.N();
        bVarN.getClass();
        kotlin.jvm.internal.t.i(id, "id");
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = bVarN.f23675b;
        if (oTPublishersHeadlessSDK != null) {
            oTPublishersHeadlessSDK.updateSDKConsentStatus(id, zBooleanValue);
        }
        bVarN.f23685l.add(id);
        String strC = bVarN.f23683j.c(id);
        if (strC != null) {
        }
        bVarN.a();
        if (zBooleanValue) {
            bVarN.d();
        } else {
            bVarN.f23691r.setValue(Boolean.FALSE);
        }
        return v8.k0.f35197a;
    }
}
