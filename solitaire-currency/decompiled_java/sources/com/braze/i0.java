package com.braze;

import android.content.Intent;
import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import bo.app.a4;
import bo.app.ci0;
import bo.app.lx;
import bo.app.n60;
import bo.app.tf;
import bo.app.y3;
import bo.app.z3;
import com.braze.support.BrazeLogger;
import java.util.LinkedHashMap;
import org.json.JSONException;
import org.json.JSONObject;
import v8.k0;

/* JADX INFO: loaded from: classes2.dex */
public final class i0 extends kotlin.jvm.internal.v implements h9.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Intent f8077a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Braze f8078b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i0(Intent intent, Braze braze) {
        super(0);
        this.f8077a = intent;
        this.f8078b = braze;
    }

    @Override // h9.a
    public final Object invoke() throws JSONException {
        Intent intent = this.f8077a;
        if (intent == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8078b, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) y3.f4317a, 6, (Object) null);
        } else {
            String campaignId = intent.getStringExtra(CmcdConfiguration.KEY_CONTENT_ID);
            if (campaignId == null || p9.q.z(campaignId)) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8078b, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) a4.f2348a, 6, (Object) null);
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this.f8078b, BrazeLogger.Priority.I, (Throwable) null, false, (h9.a) new z3(campaignId), 6, (Object) null);
                tf tfVar = ((ci0) this.f8078b.getUdm$android_sdk_base_release()).f2570v;
                int i10 = n60.f3470j;
                kotlin.jvm.internal.t.i(campaignId, "campaignId");
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(CmcdConfiguration.KEY_CONTENT_ID, campaignId);
                LinkedHashMap linkedHashMap = lx.f3353b;
                tfVar.a(new n60(jSONObject));
            }
            Braze.Companion.requestTriggersIfInAppMessageTestPush$android_sdk_base_release(this.f8077a, ((ci0) this.f8078b.getUdm$android_sdk_base_release()).f2570v);
        }
        return k0.f35197a;
    }
}
