package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.cct.a;
import com.google.android.gms.internal.play_billing.zzhe;
import w1.c;
import w1.d;
import w1.g;
import w1.h;
import y1.t;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcj {
    private boolean zza;
    private h zzb;

    zzcj(Context context) {
        try {
            t.f(context);
            this.zzb = t.c().g(a.f8418g).a("PLAY_BILLING_LIBRARY", zzhe.class, c.b("proto"), new g() { // from class: com.android.billingclient.api.zzci
                @Override // w1.g
                public final Object apply(Object obj) {
                    return ((zzhe) obj).zzc();
                }
            });
        } catch (Throwable unused) {
            this.zza = true;
        }
    }

    public final void zza(zzhe zzheVar) {
        if (this.zza) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.zzb.a(d.e(zzheVar));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzb.zzk("BillingLogger", "logging failed.");
        }
    }
}
