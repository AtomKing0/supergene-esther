package com.ironsource.mediationsdk;

import android.content.Context;
import com.ironsource.a5;
import com.ironsource.h5;
import com.ironsource.l4;
import com.ironsource.mediationsdk.e;
import java.net.URL;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class f implements g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final h5 f13578a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f13579b;

    public f(@NotNull h5 settings, @NotNull String sessionId) {
        kotlin.jvm.internal.t.i(settings, "settings");
        kotlin.jvm.internal.t.i(sessionId, "sessionId");
        this.f13578a = settings;
        this.f13579b = sessionId;
    }

    @Override // com.ironsource.mediationsdk.g
    @NotNull
    public e.a a(@NotNull Context context, @NotNull i auctionRequestParams, @NotNull l4 auctionListener) throws JSONException {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(auctionRequestParams, "auctionRequestParams");
        kotlin.jvm.internal.t.i(auctionListener, "auctionListener");
        JSONObject jSONObjectA = a(context, auctionRequestParams);
        String strA = this.f13578a.a(auctionRequestParams.r());
        return auctionRequestParams.r() ? new a5(auctionListener, new URL(strA), jSONObjectA, auctionRequestParams.s(), this.f13578a.g(), this.f13578a.m(), this.f13578a.n(), this.f13578a.o(), this.f13578a.d()) : new e.a(auctionListener, new URL(strA), jSONObjectA, auctionRequestParams.s(), this.f13578a.g(), this.f13578a.m(), this.f13578a.n(), this.f13578a.o(), this.f13578a.d());
    }

    private final JSONObject a(Context context, i iVar) throws JSONException {
        JSONObject jSONObjectA = d.b().a(iVar);
        kotlin.jvm.internal.t.h(jSONObjectA, "getInstance().enrichToke…low(auctionRequestParams)");
        return jSONObjectA;
    }

    @Override // com.ironsource.mediationsdk.g
    public boolean a() {
        return this.f13578a.g() > 0;
    }
}
