package com.ironsource;

import android.content.Context;
import android.content.Intent;
import com.google.android.gms.drive.DriveFile;
import com.ironsource.mediationsdk.testSuite.TestSuiteActivity;
import com.ironsource.v8;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class ps {
    private final String a(String str, String str2, String str3, String str4, String str5, Boolean bool, JSONObject jSONObject, boolean z10, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4) {
        String string = new JSONObject(kotlin.collections.r0.j(v8.y.a("deviceOS", v8.f15653d), v8.y.a("appKey", str), v8.y.a("sdkVersion", str2), v8.y.a("bundleId", str3), v8.y.a("appName", str4), v8.y.a(v8.i.W, str5), v8.y.a("initResponse", jSONObject), v8.y.a("isRvManual", Boolean.valueOf(z10)), v8.y.a("generalProperties", jSONObject2), v8.y.a("adaptersVersion", jSONObject3), v8.y.a("metaData", jSONObject4), v8.y.a("gdprConsent", bool))).toString();
        kotlin.jvm.internal.t.h(string, "JSONObject(\n            …ent))\n        .toString()");
        return string;
    }

    private final JSONObject a() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry<String, List<String>> entry : zs.f16492a.d().entrySet()) {
            jSONObject.putOpt(entry.getKey(), new JSONArray((Collection) entry.getValue()));
        }
        return jSONObject;
    }

    public final void a(@NotNull Context context, @NotNull String appKey, @NotNull JSONObject initResponse, @NotNull String sdkVersion, @NotNull String testSuiteControllerUrl, @Nullable Boolean bool, boolean z10) {
        kotlin.jvm.internal.t.i(context, "context");
        kotlin.jvm.internal.t.i(appKey, "appKey");
        kotlin.jvm.internal.t.i(initResponse, "initResponse");
        kotlin.jvm.internal.t.i(sdkVersion, "sdkVersion");
        kotlin.jvm.internal.t.i(testSuiteControllerUrl, "testSuiteControllerUrl");
        zs zsVar = zs.f16492a;
        String strA = a(appKey, sdkVersion, zsVar.c(context), zsVar.a(context), zsVar.b(context), bool, initResponse, z10, zsVar.b(), zsVar.c(), a());
        Intent intent = new Intent(context, (Class<?>) TestSuiteActivity.class);
        intent.setFlags(DriveFile.MODE_READ_WRITE);
        intent.putExtra(qs.f14582a, strA);
        intent.putExtra("controllerUrl", testSuiteControllerUrl);
        context.startActivity(intent);
    }
}
