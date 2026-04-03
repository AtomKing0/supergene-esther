package com.onetrust.otpublishers.headless.Internal.Helper;

import ab.z;
import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import ga.z;

/* JADX INFO: loaded from: classes4.dex */
public final class r implements OTCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ com.onetrust.otpublishers.headless.Internal.Network.n f21795b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ String f21796c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final /* synthetic */ OTResponse f21797d;

    public r(OTCallback oTCallback, com.onetrust.otpublishers.headless.Internal.Network.n nVar, String str, OTResponse oTResponse) {
        this.f21794a = oTCallback;
        this.f21795b = nVar;
        this.f21796c = str;
        this.f21797d = oTResponse;
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onFailure(@NonNull OTResponse oTResponse) {
        com.onetrust.otpublishers.headless.Internal.Network.n nVar = this.f21795b;
        String str = this.f21796c;
        OTCallback oTCallback = this.f21794a;
        OTResponse oTResponse2 = this.f21797d;
        nVar.getClass();
        OTLogger.a("NetworkRequestHandler", 3, "IAB Vendor list Api called " + str);
        ((com.onetrust.otpublishers.headless.Internal.Network.a) new z.b().c("https://geolocation.1trust.app/").a(bb.k.f()).f(new z.a().b()).d().b(com.onetrust.otpublishers.headless.Internal.Network.a.class)).a(str).i0(new com.onetrust.otpublishers.headless.Internal.Network.g(nVar, oTCallback, oTResponse2));
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onSuccess(@NonNull OTResponse oTResponse) {
        OTCallback oTCallback = this.f21794a;
        if (oTCallback != null) {
            oTCallback.onSuccess(oTResponse);
        }
    }
}
