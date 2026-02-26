package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfdy implements zzena {
    private final Context zza;
    private final Executor zzb;
    private final zzcgj zzc;
    private final zzfdo zzd;
    private final zzfcc zze;
    private final zzfey zzf;
    private final zzfki zzg;
    private final zzffe zzh;
    private m zzi;

    public zzfdy(Context context, Executor executor, zzcgj zzcgjVar, zzfcc zzfccVar, zzfdo zzfdoVar, zzffe zzffeVar, zzfey zzfeyVar) {
        this.zza = context;
        this.zzb = executor;
        this.zzc = zzcgjVar;
        this.zze = zzfccVar;
        this.zzd = zzfdoVar;
        this.zzh = zzffeVar;
        this.zzf = zzfeyVar;
        this.zzg = zzcgjVar.zzz();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final zzdot zzk(zzfca zzfcaVar) {
        zzdot zzdotVarZzi = this.zzc.zzi();
        zzcvy zzcvyVar = new zzcvy();
        zzcvyVar.zze(this.zza);
        zzcvyVar.zzi(((zzfdx) zzfcaVar).zza);
        zzcvyVar.zzh(this.zzf);
        zzdotVarZzi.zzd(zzcvyVar.zzj());
        zzdotVarZzi.zzc(new zzdci().zzn());
        return zzdotVarZzi;
    }

    @Override // com.google.android.gms.internal.ads.zzena
    public final boolean zza() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x005c  */
    @Override // com.google.android.gms.internal.ads.zzena
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean zzb(com.google.android.gms.ads.internal.client.zzl r10, java.lang.String r11, com.google.android.gms.internal.ads.zzemy r12, com.google.android.gms.internal.ads.zzemz r13) throws android.os.RemoteException {
        /*
            Method dump skipped, instruction units count: 267
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzfdy.zzb(com.google.android.gms.ads.internal.client.zzl, java.lang.String, com.google.android.gms.internal.ads.zzemy, com.google.android.gms.internal.ads.zzemz):boolean");
    }

    final /* synthetic */ void zzi() {
        this.zzd.zzdB(zzfgi.zzd(6, null, null));
    }

    final void zzj(int i10) {
        this.zzh.zzp().zza(i10);
    }
}
