package com.onetrust.otpublishers.headless.Internal.Network;

import android.content.Context;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class p {
    public static void a(@NonNull Context context, @NonNull OTPublishersHeadlessSDK oTPublishersHeadlessSDK, @NonNull JSONObject jSONObject) {
        JSONObject jSONObject2;
        JSONObject jSONObject3 = jSONObject.has("otData") ? jSONObject.getJSONObject("otData") : null;
        if (jSONObject.has("vendorListData")) {
            JSONObject jSONObject4 = jSONObject.getJSONObject("vendorListData");
            JSONObject jSONObject5 = jSONObject4.has("iabData") ? jSONObject4.getJSONObject("iabData") : null;
            jSONObject2 = jSONObject4.has("googleData") ? jSONObject4.getJSONObject("googleData") : null;
            jSONObject = jSONObject5;
        } else {
            jSONObject2 = null;
        }
        com.onetrust.otpublishers.headless.Internal.profile.d dVar = new com.onetrust.otpublishers.headless.Internal.profile.d(context);
        if (dVar.m() == null) {
            dVar.u(dVar.o());
        }
        if (jSONObject3 != null) {
            new n(context).h(null, jSONObject3.toString(), null, null, oTPublishersHeadlessSDK, false);
        }
        if (jSONObject != null) {
            new com.onetrust.otpublishers.headless.Internal.Helper.c(context).h(context, jSONObject.toString());
        }
        if (jSONObject2 != null) {
            com.onetrust.otpublishers.headless.Internal.Helper.a.c(context, jSONObject2.toString());
        }
    }
}
