package com.onetrust.otpublishers.headless.Internal.Network;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;

/* JADX INFO: loaded from: classes4.dex */
public final class b implements OTCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21838a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ n f21839b;

    public b(n nVar, OTCallback oTCallback) {
        this.f21839b = nVar;
        this.f21838a = oTCallback;
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onFailure(@NonNull OTResponse oTResponse) {
        new com.onetrust.otpublishers.headless.Internal.profile.d(this.f21839b.f21881a).b();
        this.f21838a.onFailure(oTResponse);
    }

    @Override // com.onetrust.otpublishers.headless.Public.OTCallback
    public final void onSuccess(@NonNull OTResponse oTResponse) {
        this.f21838a.onSuccess(oTResponse);
    }
}
