package com.onetrust.otpublishers.headless.Internal.profile;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.OTPublishersHeadlessSDK;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import p6.f;

/* JADX INFO: loaded from: classes4.dex */
public final class c implements OTCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21902a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f21903b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ OTPublishersHeadlessSDK f21904c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ d f21905d;

    public c(d dVar, OTCallback oTCallback, OTPublishersHeadlessSDK oTPublishersHeadlessSDK, String str) {
        this.f21905d = dVar;
        this.f21902a = oTCallback;
        this.f21903b = str;
        this.f21904c = oTPublishersHeadlessSDK;
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onFailure(@NonNull OTResponse oTResponse) {
        d dVar = this.f21905d;
        String str = this.f21903b;
        OTPublishersHeadlessSDK oTPublishersHeadlessSDK = this.f21904c;
        OTCallback oTCallback = this.f21902a;
        dVar.getClass();
        OTLogger.a("MultiprofileConsent", 3, "Switch profile with data download failed, so switching profile without data download now.");
        dVar.c(str, oTPublishersHeadlessSDK);
        if (oTCallback != null) {
            oTCallback.onSuccess(new OTResponse(OTResponseType.OT_SUCCESS, 9, dVar.f21908c.getResources().getString(f.f32907o), ""));
        }
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onSuccess(@NonNull OTResponse oTResponse) {
        OTLogger.a("MultiprofileConsent", 3, "Switch profile with data download successful, returning app callback.");
        OTCallback oTCallback = this.f21902a;
        if (oTCallback != null) {
            oTCallback.onSuccess(oTResponse);
        }
    }
}
