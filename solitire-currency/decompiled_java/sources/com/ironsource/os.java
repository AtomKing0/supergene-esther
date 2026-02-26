package com.ironsource;

import com.ironsource.mediationsdk.utils.IronSourceConstants;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import org.jetbrains.annotations.NotNull;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class os {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    public static final os f14268a = new os();

    private os() {
    }

    private final JSONArray a() {
        ConcurrentHashMap<String, List<String>> concurrentHashMapD = zs.f16492a.d();
        if (concurrentHashMapD.containsKey(com.ironsource.mediationsdk.metadata.a.f13687f)) {
            return new JSONArray((Collection) concurrentHashMapD.get(com.ironsource.mediationsdk.metadata.a.f13687f));
        }
        return null;
    }

    public final void b() throws JSONException {
        a(this, 70, null, null, 6, null);
    }

    public final void c() throws JSONException {
        a(this, 71, null, null, 6, null);
    }

    public final void d() throws JSONException {
        a(this, 73, null, null, 6, null);
    }

    public final void a(int i10) throws JSONException {
        a(72, Integer.valueOf(i10), null);
    }

    private final void a(int i10, Integer num, String str) throws JSONException {
        zs zsVar = zs.f16492a;
        JSONObject jSONObjectA = zsVar.a(false);
        if (num != null) {
            jSONObjectA.put(IronSourceConstants.EVENTS_ERROR_CODE, num.intValue());
            JSONArray jSONArrayA = a();
            if (jSONArrayA != null) {
                jSONObjectA.put(com.ironsource.mediationsdk.metadata.a.f13687f, jSONArrayA);
            }
        }
        if (str != null) {
            jSONObjectA.put("reason", str);
        }
        zsVar.a(i10, jSONObjectA);
    }

    static /* synthetic */ void a(os osVar, int i10, Integer num, String str, int i11, Object obj) throws JSONException {
        if ((i11 & 2) != 0) {
            num = null;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        osVar.a(i10, num, str);
    }

    public final void a(@NotNull String errorReason) throws JSONException {
        kotlin.jvm.internal.t.i(errorReason, "errorReason");
        a(74, Integer.valueOf(IronSourceConstants.errorCode_TEST_SUITE_WEB_CONTROLLER_NOT_LOADED), errorReason);
    }
}
