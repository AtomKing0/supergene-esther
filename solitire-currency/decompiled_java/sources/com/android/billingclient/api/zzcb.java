package com.android.billingclient.api;

import androidx.annotation.Nullable;
import com.google.android.gms.internal.play_billing.zzfz;
import com.google.android.gms.internal.play_billing.zzga;
import com.google.android.gms.internal.play_billing.zzgd;
import com.google.android.gms.internal.play_billing.zzge;
import com.google.android.gms.internal.play_billing.zzgg;
import com.google.android.gms.internal.play_billing.zzgk;

/* JADX INFO: compiled from: com.android.billingclient:billing@@7.0.0 */
/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class zzcb {
    public static final /* synthetic */ int zza = 0;

    static {
        com.google.android.gms.internal.play_billing.zzal zzalVar = zzcc.zza;
    }

    @Nullable
    public static zzga zza(int i10, int i11, BillingResult billingResult) {
        try {
            zzfz zzfzVarZzy = zzga.zzy();
            zzgg zzggVarZzy = zzgk.zzy();
            zzggVarZzy.zzn(billingResult.getResponseCode());
            zzggVarZzy.zzm(billingResult.getDebugMessage());
            zzggVarZzy.zzo(i10);
            zzfzVarZzy.zzl(zzggVarZzy);
            zzfzVarZzy.zzn(i11);
            return (zzga) zzfzVarZzy.zzf();
        } catch (Exception e10) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            return null;
        }
    }

    @Nullable
    public static zzga zzb(int i10, int i11, BillingResult billingResult, @Nullable String str) {
        try {
            zzgg zzggVarZzy = zzgk.zzy();
            zzggVarZzy.zzn(billingResult.getResponseCode());
            zzggVarZzy.zzm(billingResult.getDebugMessage());
            zzggVarZzy.zzo(i10);
            if (str != null) {
                zzggVarZzy.zzl(str);
            }
            zzfz zzfzVarZzy = zzga.zzy();
            zzfzVarZzy.zzl(zzggVarZzy);
            zzfzVarZzy.zzn(i11);
            return (zzga) zzfzVarZzy.zzf();
        } catch (Exception e10) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            return null;
        }
    }

    @Nullable
    public static zzge zzc(int i10) {
        try {
            zzgd zzgdVarZzy = zzge.zzy();
            zzgdVarZzy.zzm(i10);
            return (zzge) zzgdVarZzy.zzf();
        } catch (Exception e10) {
            com.google.android.gms.internal.play_billing.zzb.zzl("BillingLogger", "Unable to create logging payload", e10);
            return null;
        }
    }
}
