package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.common.util.concurrent.m;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbap implements BaseGmsClient.BaseConnectionCallbacks {
    public static final /* synthetic */ int zzd = 0;
    final /* synthetic */ zzbah zza;
    final /* synthetic */ zzbzt zzb;
    final /* synthetic */ zzbar zzc;

    zzbap(zzbar zzbarVar, zzbah zzbahVar, zzbzt zzbztVar) {
        this.zza = zzbahVar;
        this.zzb = zzbztVar;
        this.zzc = zzbarVar;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(@Nullable Bundle bundle) {
        synchronized (this.zzc.zzd) {
            zzbar zzbarVar = this.zzc;
            if (zzbarVar.zzb) {
                return;
            }
            zzbarVar.zzb = true;
            final zzbag zzbagVar = this.zzc.zza;
            if (zzbagVar == null) {
                return;
            }
            zzgcu zzgcuVar = zzbzo.zza;
            final zzbah zzbahVar = this.zza;
            final zzbzt zzbztVar = this.zzb;
            final m mVarZza = zzgcuVar.zza(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbam
                @Override // java.lang.Runnable
                public final void run() {
                    zzbap zzbapVar = this.zza;
                    zzbag zzbagVar2 = zzbagVar;
                    zzbzt zzbztVar2 = zzbztVar;
                    try {
                        zzbaj zzbajVarZzq = zzbagVar2.zzq();
                        boolean zZzp = zzbagVar2.zzp();
                        zzbah zzbahVar2 = zzbahVar;
                        zzbae zzbaeVarZzg = zZzp ? zzbajVarZzq.zzg(zzbahVar2) : zzbajVarZzq.zzf(zzbahVar2);
                        if (!zzbaeVarZzg.zze()) {
                            zzbztVar2.zzd(new RuntimeException("No entry contents."));
                            zzbar.zze(zzbapVar.zzc);
                            return;
                        }
                        zzbao zzbaoVar = new zzbao(zzbapVar, zzbaeVarZzg.zzc(), 1);
                        int i10 = zzbaoVar.read();
                        if (i10 == -1) {
                            throw new IOException("Unable to read from cache.");
                        }
                        zzbaoVar.unread(i10);
                        zzbztVar2.zzc(zzbat.zzb(zzbaoVar, zzbaeVarZzg.zzd(), zzbaeVarZzg.zzg(), zzbaeVarZzg.zza(), zzbaeVarZzg.zzf()));
                    } catch (RemoteException | IOException e10) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to obtain a cache service instance.", e10);
                        zzbztVar2.zzd(e10);
                        zzbar.zze(zzbapVar.zzc);
                    }
                }
            });
            final zzbzt zzbztVar2 = this.zzb;
            zzbztVar2.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzban
                @Override // java.lang.Runnable
                public final void run() {
                    if (zzbztVar2.isCancelled()) {
                        mVarZza.cancel(true);
                    }
                }
            }, zzbzo.zzf);
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i10) {
    }
}
