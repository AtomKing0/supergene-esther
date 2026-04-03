package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbbc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdhc implements zzcwq, zzddv {
    private final zzbxw zza;
    private final Context zzb;
    private final zzbya zzc;

    @Nullable
    private final View zzd;
    private String zze;
    private final zzbbc.zza.EnumC0191zza zzf;

    public zzdhc(zzbxw zzbxwVar, Context context, zzbya zzbyaVar, @Nullable View view, zzbbc.zza.EnumC0191zza enumC0191zza) {
        this.zza = zzbxwVar;
        this.zzb = context;
        this.zzc = zzbyaVar;
        this.zzd = view;
        this.zzf = enumC0191zza;
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zza() {
        this.zza.zzb(false);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzc() {
        View view = this.zzd;
        if (view != null && this.zze != null) {
            this.zzc.zzo(view.getContext(), this.zze);
        }
        this.zza.zzb(true);
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzds(zzbvn zzbvnVar, String str, String str2) {
        if (this.zzc.zzp(this.zzb)) {
            try {
                zzbya zzbyaVar = this.zzc;
                Context context = this.zzb;
                zzbyaVar.zzl(context, zzbyaVar.zza(context), this.zza.zza(), zzbvnVar.zzc(), zzbvnVar.zzb());
            } catch (RemoteException e10) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Remote Exception to get reward item.", e10);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzddv
    public final void zzl() {
        if (this.zzf == zzbbc.zza.EnumC0191zza.APP_OPEN) {
            return;
        }
        String strZzc = this.zzc.zzc(this.zzb);
        this.zze = strZzc;
        this.zze = String.valueOf(strZzc).concat(this.zzf == zzbbc.zza.EnumC0191zza.REWARD_BASED_VIDEO_AD ? "/Rewarded" : "/Interstitial");
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzb() {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zze() {
    }

    @Override // com.google.android.gms.internal.ads.zzcwq
    public final void zzf() {
    }

    @Override // com.google.android.gms.internal.ads.zzddv
    public final void zzk() {
    }
}
