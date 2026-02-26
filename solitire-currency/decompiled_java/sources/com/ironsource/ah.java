package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceAES;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final ah f11295a = new ah();

    private ah() {
    }

    @NotNull
    public static final JSONObject a() throws JSONException {
        JSONObject jSONObjectPut = new JSONObject().put("data", IronSourceAES.encode(xa.b().c(), new zg().a().toString()));
        kotlin.jvm.internal.t.h(jSONObjectPut, "InitProvider()\n        .…ATA_KEY, encryptedData) }");
        return jSONObjectPut;
    }
}
