package com.onetrust.otpublishers.headless.UI.TVUI.fragments;

import androidx.annotation.NonNull;
import com.onetrust.otpublishers.headless.Internal.Log.OTLogger;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes4.dex */
public final class w implements ab.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a0 f22691a;

    public w(a0 a0Var) {
        this.f22691a = a0Var;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ab.y yVar) {
        try {
            if (yVar.a() != null) {
                JSONObject jSONObject = new JSONObject((String) yVar.a());
                a0 a0Var = this.f22691a;
                com.onetrust.otpublishers.headless.UI.TVUI.datautils.e eVarA = com.onetrust.otpublishers.headless.UI.TVUI.datautils.e.a();
                int i10 = a0.F;
                JSONObject jSONObjectS = a0Var.s(eVarA, jSONObject);
                a0 a0Var2 = this.f22691a;
                a0Var2.f22437x.f22170i = jSONObjectS;
                a0Var2.E = 1;
            }
        } catch (Exception e10) {
            com.onetrust.otpublishers.headless.Internal.Helper.j.a(e10, new StringBuilder("Error while fetching IAB Vendor Disclosure details:  "), "TV Vendor", 6);
        }
    }

    @Override // ab.d
    public final void a(@NonNull ab.b<String> bVar, @NonNull final ab.y<String> yVar) {
        OTLogger.a("TV Vendor", 4, "IAB Vendor Disclosure API Success");
        new Thread(new Runnable() { // from class: com.onetrust.otpublishers.headless.UI.TVUI.fragments.v
            @Override // java.lang.Runnable
            public final void run() {
                this.f22689a.d(yVar);
            }
        }).start();
    }

    @Override // ab.d
    public final void b(@NonNull ab.b<String> bVar, @NonNull Throwable th) {
        OTLogger.a("TV Vendor", 6, "IAB Vendor Disclosure API Failed :  " + th.getMessage());
    }
}
