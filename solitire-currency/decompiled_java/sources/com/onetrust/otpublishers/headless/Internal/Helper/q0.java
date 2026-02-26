package com.onetrust.otpublishers.headless.Internal.Helper;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTNetworkRequestCallback;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class q0 implements ab.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTNetworkRequestCallback f21792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ a f21793b;

    public q0(a aVar, OTNetworkRequestCallback oTNetworkRequestCallback) {
        this.f21793b = aVar;
        this.f21792a = oTNetworkRequestCallback;
    }

    @Override // ab.d
    public final void a(@NonNull ab.b<String> bVar, @NonNull ab.y<String> yVar) {
        a aVar = this.f21793b;
        OTNetworkRequestCallback oTNetworkRequestCallback = this.f21792a;
        aVar.getClass();
        OTLogger.a("GoogleVendorHelper", 4, "Google Vendor list Api Success : " + yVar.a());
        long jG0 = yVar.f().G0();
        long jJ0 = yVar.f().J0();
        OTLogger.a("GoogleVendorHelper", 2, "Google vendor api response time : " + jG0 + "," + jJ0);
        long j10 = jG0 - jJ0;
        OTLogger.a("OneTrust", 3, String.format("%s %d.%d s", "Time taken for Google Vendor data fetch: ", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(j10)), Long.valueOf(j10 % 1000)));
        a.c(aVar.f21751a, yVar.a());
        if (oTNetworkRequestCallback != null) {
            oTNetworkRequestCallback.onCompletion(true);
        }
    }

    @Override // ab.d
    public final void b(ab.b<String> bVar, Throwable th) {
        OTLogger.a("GoogleVendorHelper", 6, "Google Vendor list Api Failed :  " + th.getMessage());
        OTNetworkRequestCallback oTNetworkRequestCallback = this.f21792a;
        if (oTNetworkRequestCallback != null) {
            oTNetworkRequestCallback.onCompletion(false);
        }
    }
}
