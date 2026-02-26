package com.onetrust.otpublishers.headless.Internal.Network;

import ab.y;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import com.onetrust.otpublishers.headless.Public.OTCallback;
import com.onetrust.otpublishers.headless.Public.Response.OTResponse;
import com.onetrust.otpublishers.headless.Public.Response.OTResponseType;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes4.dex */
public final class g implements ab.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OTCallback f21857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ OTResponse f21858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final /* synthetic */ n f21859c;

    public g(n nVar, OTCallback oTCallback, OTResponse oTResponse) {
        this.f21859c = nVar;
        this.f21857a = oTCallback;
        this.f21858b = oTResponse;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(y yVar, final OTCallback oTCallback, Handler handler, final OTResponse oTResponse) {
        OTLogger.a("NetworkRequestHandler", 4, "Parsing IAB data in BG thread.");
        Context context = this.f21859c.f21881a;
        new com.onetrust.otpublishers.headless.Internal.Helper.c(context).h(context, (String) yVar.a());
        if (oTCallback != null) {
            OTLogger.a("NetworkRequestHandler", 3, "Parsing IAB data complete, sending app callback.");
            new com.onetrust.otpublishers.headless.Internal.authenticatedconsent.c(this.f21859c.f21881a).a();
            new com.onetrust.otpublishers.headless.Internal.profile.d(this.f21859c.f21881a).b();
            handler.post(new Runnable() { // from class: com.onetrust.otpublishers.headless.Internal.Network.f
                @Override // java.lang.Runnable
                public final void run() {
                    oTCallback.onSuccess(oTResponse);
                }
            });
        }
    }

    @Override // ab.d
    public final void a(ab.b<String> bVar, final y<String> yVar) {
        OTLogger.a("NetworkRequestHandler", 4, " IAB Vendorlist Api Success : " + yVar.a());
        if (yVar.f() != null) {
            long jG0 = yVar.f().G0() - yVar.f().J0();
            OTLogger.a("OneTrust", 3, String.format("%s %d.%d s", "Time taken for IAB Vendor data fetch: ", Long.valueOf(TimeUnit.MILLISECONDS.toSeconds(jG0)), Long.valueOf(jG0 % 1000)));
        }
        final Handler handler = new Handler(Looper.getMainLooper());
        final OTCallback oTCallback = this.f21857a;
        final OTResponse oTResponse = this.f21858b;
        new Thread(new Runnable() { // from class: com.onetrust.otpublishers.headless.Internal.Network.e
            @Override // java.lang.Runnable
            public final void run() {
                this.f21850a.d(yVar, oTCallback, handler, oTResponse);
            }
        }).start();
    }

    @Override // ab.d
    public final void b(ab.b<String> bVar, Throwable th) {
        OTLogger.a("NetworkRequestHandler", 6, " IAB Vendorlist Api Failed  :  " + th.getMessage());
        if (this.f21857a != null) {
            new com.onetrust.otpublishers.headless.Internal.profile.d(this.f21859c.f21881a).b();
            this.f21857a.onFailure(new OTResponse(OTResponseType.OT_ERROR, 102, " IAB Vendorlist Api Failed ", ""));
        }
    }
}
