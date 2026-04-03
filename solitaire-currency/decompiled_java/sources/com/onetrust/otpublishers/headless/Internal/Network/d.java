package com.onetrust.otpublishers.headless.Internal.Network;

import ab.y;
import androidx.annotation.NonNull;
import com.google.android.gms.common.Scopes;
import com.ironsource.v8;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import java.util.concurrent.TimeUnit;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class d implements ab.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f21846a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21847b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OTPublishersHeadlessSDK f21848c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ n f21849d;

    public d(n nVar, String str, OTCallback oTCallback, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        this.f21849d = nVar;
        this.f21846a = str;
        this.f21847b = oTCallback;
        this.f21848c = oTPublishersHeadlessSDK;
    }

    @Override // ab.d
    public final void a(@NonNull ab.b<String> bVar, @NonNull y<String> yVar) {
        OTResponse oTResponse;
        String strA = yVar.a();
        OTLogger.a("NetworkRequestHandler", 4, " OTT response? = " + strA);
        if (yVar.f() != null) {
            long jG0 = yVar.f().G0() - yVar.f().J0();
            OTLogger.a("OneTrust", 3, String.format("%s %d.%d s", "Time taken for OT SDK setup data fetch: ", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(jG0)), Long.valueOf(jG0 % 1000)));
        }
        String str = this.f21846a;
        String string = this.f21849d.f21881a.getResources().getString(p6.f.f32917y);
        if (com.onetrust.otpublishers.headless.Internal.c.q(strA)) {
            oTResponse = new OTResponse(OTResponseType.OT_ERROR, 2, string.replace("SDK_VERSION", str), "");
        } else {
            try {
                JSONObject jSONObject = new JSONObject(strA);
                if (jSONObject.has("culture") && jSONObject.has(v8.i.D) && jSONObject.has(Scopes.PROFILE)) {
                    oTResponse = null;
                } else {
                    OTLogger.a("OneTrust", 6, "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted");
                    oTResponse = new OTResponse(OTResponseType.OT_ERROR, 7, "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted", "");
                }
            } catch (JSONException e10) {
                OTLogger.a("OneTrust", 6, "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted" + e10.toString());
                oTResponse = new OTResponse(OTResponseType.OT_ERROR, 7, "SDK Initialization failed, Cannot parse the data received from Server because it is corrupted", "");
            }
        }
        if (oTResponse == null) {
            this.f21849d.i(yVar, strA, this.f21847b, this.f21848c);
            return;
        }
        OTCallback oTCallback = this.f21847b;
        if (oTCallback != null) {
            oTCallback.onFailure(oTResponse);
        }
    }

    @Override // ab.d
    public final void b(@NonNull ab.b<String> bVar, @NonNull Throwable th) {
        OTLogger.a("NetworkRequestHandler", 6, " network call response error out = " + th.getMessage());
        OTCallback oTCallback = this.f21847b;
        OTResponse oTResponse = new OTResponse(OTResponseType.OT_ERROR, 7, this.f21849d.f21881a.getResources().getString(p6.f.f32893a), "");
        if (oTCallback != null) {
            oTCallback.onFailure(oTResponse);
        }
    }
}
