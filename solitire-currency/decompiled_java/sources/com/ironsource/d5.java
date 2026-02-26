package com.ironsource;

import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import v8.t;

/* JADX INFO: loaded from: classes4.dex */
public final class d5 implements e5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f11766a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final oo f11767b;

    public d5(@NotNull String encryptedAuctionResponse, @NotNull oo providerName) {
        kotlin.jvm.internal.t.i(encryptedAuctionResponse, "encryptedAuctionResponse");
        kotlin.jvm.internal.t.i(providerName, "providerName");
        this.f11766a = encryptedAuctionResponse;
        this.f11767b = providerName;
    }

    @Override // com.ironsource.e5
    @NotNull
    public Object a() {
        Object objB;
        String strC = xa.b().c();
        kotlin.jvm.internal.t.h(strC, "getInstance().mediationKey");
        pj pjVar = new pj(new t9(this.f11766a, strC));
        try {
            t.a aVar = v8.t.f35208b;
            objB = v8.t.b(pjVar.a());
        } catch (Throwable th) {
            t.a aVar2 = v8.t.f35208b;
            objB = v8.t.b(v8.u.a(th));
        }
        Throwable thE = v8.t.e(objB);
        if (thE == null) {
            return b5.f11359h.a((JSONObject) objB, this.f11767b.value());
        }
        i9.d().a(thE);
        return thE instanceof IllegalArgumentException ? v8.t.b(v8.u.a(new ef(hb.f12462a.d()))) : v8.t.b(v8.u.a(new ef(hb.f12462a.h())));
    }
}
