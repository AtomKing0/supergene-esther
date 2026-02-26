package com.onetrust.otpublishers.headless.Internal.Network;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements OTCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21840a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f21841b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21842c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21843d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final /* synthetic */ OTPublishersHeadlessSDK f21844e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f21845f;

    public c(n nVar, OTCallback oTCallback, a aVar, String str, b bVar, OTPublishersHeadlessSDK oTPublishersHeadlessSDK) {
        this.f21845f = nVar;
        this.f21840a = oTCallback;
        this.f21841b = aVar;
        this.f21842c = str;
        this.f21843d = bVar;
        this.f21844e = oTPublishersHeadlessSDK;
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onFailure(@NonNull OTResponse oTResponse) {
        n nVar = this.f21845f;
        String str = nVar.f21882b;
        a aVar = this.f21841b;
        String str2 = this.f21842c;
        OTCallback oTCallback = this.f21843d;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f21844e;
        OTLogger.a("NetworkRequestHandler", 4, "Requesting OTT data from : " + str);
        OTLogger.a("NetworkRequestHandler", 4, " OTT data Download : Download OTT data started");
        aVar.b(str).i0(new d(nVar, str2, oTCallback, oTPublishersHeadlessSDK));
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onSuccess(@NonNull OTResponse oTResponse) {
        this.f21840a.onSuccess(oTResponse);
    }
}
