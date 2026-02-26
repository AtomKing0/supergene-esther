package com.ironsource;

import android.content.Context;
import com.ironsource.sdk.service.Connectivity.BroadcastReceiverStrategy;
import com.ironsource.sdk.utils.Logger;
import com.ironsource.v8;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public abstract class p8 implements zd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private yd f14309a;

    protected p8(JSONObject jSONObject, Context context) {
        this.f14309a = a(jSONObject, context);
        Logger.i(p8.class.getSimpleName(), "created ConnectivityAdapter with strategy " + this.f14309a.getClass().getSimpleName());
    }

    private yd a(JSONObject jSONObject, Context context) {
        if (jSONObject.optInt(v8.i.f15844g0) != 1 && v3.c(context, "android.permission.ACCESS_NETWORK_STATE")) {
            return new bm(this);
        }
        return new BroadcastReceiverStrategy(this);
    }

    public void b() {
        this.f14309a.a();
    }

    public void c(Context context) {
        this.f14309a.a(context);
    }

    public JSONObject a(Context context) {
        return this.f14309a.c(context);
    }

    public void b(Context context) {
        this.f14309a.b(context);
    }

    @Override // com.ironsource.zd
    public void a() {
    }

    @Override // com.ironsource.zd
    public void b(String str, JSONObject jSONObject) {
    }

    @Override // com.ironsource.zd
    public void a(String str, JSONObject jSONObject) {
    }
}
