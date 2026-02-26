package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.telephony.TelephonyManager;
import androidx.autofill.HintConstants;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzewd implements zzevo {
    private final zzgcu zza;
    private final Context zzb;

    public zzewd(zzgcu zzgcuVar, Context context) {
        this.zza = zzgcuVar;
        this.zzb = context;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 39;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable() { // from class: com.google.android.gms.internal.ads.zzewc
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return this.zza.zzc();
            }
        });
    }

    final /* synthetic */ zzewb zzc() throws Exception {
        boolean zIsActiveNetworkMetered;
        int i10;
        TelephonyManager telephonyManager = (TelephonyManager) this.zzb.getSystemService(HintConstants.AUTOFILL_HINT_PHONE);
        String networkOperator = telephonyManager.getNetworkOperator();
        int phoneType = telephonyManager.getPhoneType();
        com.google.android.gms.ads.internal.zzu.zzp();
        int i11 = -1;
        if (com.google.android.gms.ads.internal.util.zzt.zzA(this.zzb, "android.permission.ACCESS_NETWORK_STATE")) {
            ConnectivityManager connectivityManager = (ConnectivityManager) this.zzb.getSystemService("connectivity");
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                int iOrdinal = activeNetworkInfo.getDetailedState().ordinal();
                i10 = type;
                i11 = iOrdinal;
            } else {
                i10 = -1;
            }
            zIsActiveNetworkMetered = connectivityManager.isActiveNetworkMetered();
        } else {
            zIsActiveNetworkMetered = false;
            i10 = -2;
        }
        return new zzewb(networkOperator, i10, com.google.android.gms.ads.internal.zzu.zzq().zzm(this.zzb), phoneType, zIsActiveNetworkMetered, i11);
    }
}
