package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcky extends com.google.android.gms.ads.internal.client.zzcn {
    private final Context zza;
    private final VersionInfoParcel zzb;
    private final zzdqb zzc;
    private final zzeev zzd;
    private final zzelg zze;
    private final zzdun zzf;
    private final zzbya zzg;
    private final zzdqg zzh;
    private final zzdvi zzi;
    private final zzbel zzj;
    private final zzfki zzk;
    private final zzfgc zzl;
    private final zzcui zzm;
    private final zzdsk zzn;
    private boolean zzo = false;
    private final Long zzp = Long.valueOf(com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime());

    @VisibleForTesting
    zzcky(Context context, VersionInfoParcel versionInfoParcel, zzdqb zzdqbVar, zzeev zzeevVar, zzelg zzelgVar, zzdun zzdunVar, zzbya zzbyaVar, zzdqg zzdqgVar, zzdvi zzdviVar, zzbel zzbelVar, zzfki zzfkiVar, zzfgc zzfgcVar, zzcui zzcuiVar, zzdsk zzdskVar) {
        this.zza = context;
        this.zzb = versionInfoParcel;
        this.zzc = zzdqbVar;
        this.zzd = zzeevVar;
        this.zze = zzelgVar;
        this.zzf = zzdunVar;
        this.zzg = zzbyaVar;
        this.zzh = zzdqgVar;
        this.zzi = zzdviVar;
        this.zzj = zzbelVar;
        this.zzk = zzfkiVar;
        this.zzl = zzfgcVar;
        this.zzm = zzcuiVar;
        this.zzn = zzdskVar;
    }

    @VisibleForTesting
    final void zzb() {
        if (com.google.android.gms.ads.internal.zzu.zzo().zzi().zzR()) {
            String strZzl = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzl();
            if (com.google.android.gms.ads.internal.zzu.zzs().zzj(this.zza, strZzl, this.zzb.afmaVersion)) {
                return;
            }
            com.google.android.gms.ads.internal.zzu.zzo().zzi().zzC(false);
            com.google.android.gms.ads.internal.zzu.zzo().zzi().zzB("");
        }
    }

    @VisibleForTesting
    final void zzc(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map mapZze = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzh().zze();
        if (mapZze.isEmpty()) {
            return;
        }
        if (runnable != null) {
            try {
                runnable.run();
            } catch (Throwable th) {
                com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not initialize rewarded ads.", th);
                return;
            }
        }
        if (this.zzc.zzd()) {
            HashMap map = new HashMap();
            Iterator it = mapZze.values().iterator();
            while (it.hasNext()) {
                for (zzbof zzbofVar : ((zzbog) it.next()).zza) {
                    String str = zzbofVar.zzb;
                    for (String str2 : zzbofVar.zza) {
                        if (!map.containsKey(str2)) {
                            map.put(str2, new ArrayList());
                        }
                        if (str != null) {
                            ((List) map.get(str2)).add(str);
                        }
                    }
                }
            }
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : map.entrySet()) {
                String str3 = (String) entry.getKey();
                try {
                    zzeew zzeewVarZza = this.zzd.zza(str3, jSONObject);
                    if (zzeewVarZza != null) {
                        zzfge zzfgeVar = (zzfge) zzeewVarZza.zzb;
                        if (!zzfgeVar.zzC() && zzfgeVar.zzB()) {
                            zzfgeVar.zzj(this.zza, (zzegq) zzeewVarZza.zzc, (List) entry.getValue());
                            com.google.android.gms.ads.internal.util.client.zzm.zze("Initialized rewarded video mediation adapter " + str3);
                        }
                    }
                } catch (zzffn e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzk("Failed to initialize rewarded video mediation adapter \"" + str3 + "\"", e10);
                }
            }
        }
    }

    final /* synthetic */ void zzd() {
        zzfgl.zzb(this.zza, true);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized float zze() {
        return com.google.android.gms.ads.internal.zzu.zzr().zza();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final String zzf() {
        return this.zzb.afmaVersion;
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final List zzg() throws RemoteException {
        return this.zzf.zzg();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzh(String str) {
        this.zze.zzg(str);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzi() {
        this.zzf.zzl();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzj(boolean z10) throws RemoteException {
        try {
            zzfsc.zzi(this.zza).zzn(z10);
        } catch (IOException e10) {
            throw new RemoteException(e10.getMessage());
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzk() {
        if (this.zzo) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Mobile ads is initialized already.");
            return;
        }
        zzbbw.zza(this.zza);
        com.google.android.gms.ads.internal.zzu.zzo().zzu(this.zza, this.zzb);
        this.zzm.zzd();
        com.google.android.gms.ads.internal.zzu.zzc().zzi(this.zza);
        this.zzo = true;
        this.zzf.zzr();
        this.zze.zze();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdE)).booleanValue()) {
            this.zzh.zzc();
        }
        this.zzi.zzg();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzip)).booleanValue()) {
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckt
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzb();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjY)).booleanValue()) {
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckv
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzw();
                }
            });
        }
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcA)).booleanValue()) {
            zzbzo.zza.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzcku
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzd();
                }
            });
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzl(@Nullable String str, IObjectWrapper iObjectWrapper) {
        String strZzp;
        Runnable runnable;
        zzbbw.zza(this.zza);
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdI)).booleanValue()) {
            try {
                com.google.android.gms.ads.internal.zzu.zzp();
                strZzp = com.google.android.gms.ads.internal.util.zzt.zzp(this.zza);
            } catch (RemoteException | RuntimeException e10) {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "NonagonMobileAdsSettingManager_AppId");
                strZzp = "";
            }
        } else {
            strZzp = "";
        }
        boolean z10 = true;
        String str2 = true == TextUtils.isEmpty(strZzp) ? str : strZzp;
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdC)).booleanValue();
        zzbbn zzbbnVar = zzbbw.zzaH;
        boolean zBooleanValue2 = zBooleanValue | ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue();
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
            final Runnable runnable2 = (Runnable) ObjectWrapper.unwrap(iObjectWrapper);
            runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzckw
                @Override // java.lang.Runnable
                public final void run() {
                    zzgcu zzgcuVar = zzbzo.zze;
                    final zzcky zzckyVar = this.zza;
                    final Runnable runnable3 = runnable2;
                    zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzckx
                        @Override // java.lang.Runnable
                        public final void run() {
                            zzckyVar.zzc(runnable3);
                        }
                    });
                }
            };
        } else {
            runnable = null;
            z10 = zBooleanValue2;
        }
        Runnable runnable3 = runnable;
        if (z10) {
            com.google.android.gms.ads.internal.zzu.zza().zza(this.zza, this.zzb, str2, runnable3, this.zzk, this.zzn, this.zzp);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzm(com.google.android.gms.ads.internal.client.zzda zzdaVar) throws RemoteException {
        this.zzi.zzh(zzdaVar, zzdvh.API);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzn(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Context is null. Failed to open debug menu.");
            return;
        }
        com.google.android.gms.ads.internal.util.zzau zzauVar = new com.google.android.gms.ads.internal.util.zzau(context);
        zzauVar.zzn(str);
        zzauVar.zzo(this.zzb.afmaVersion);
        zzauVar.zzr();
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzo(zzbom zzbomVar) throws RemoteException {
        this.zzl.zzf(zzbomVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzp(boolean z10) {
        com.google.android.gms.ads.internal.zzu.zzr().zzc(z10);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzq(float f10) {
        com.google.android.gms.ads.internal.zzu.zzr().zzd(f10);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized void zzr(String str) {
        zzbbw.zza(this.zza);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdC)).booleanValue()) {
                com.google.android.gms.ads.internal.zzu.zza().zza(this.zza, this.zzb, str, null, this.zzk, null, null);
            }
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzs(zzblc zzblcVar) throws RemoteException {
        this.zzf.zzs(zzblcVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzt(String str) {
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zziA)).booleanValue()) {
            com.google.android.gms.ads.internal.zzu.zzo().zzz(str);
        }
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final void zzu(com.google.android.gms.ads.internal.client.zzff zzffVar) throws RemoteException {
        this.zzg.zzn(this.zza, zzffVar);
    }

    @Override // com.google.android.gms.ads.internal.client.zzco
    public final synchronized boolean zzv() {
        return com.google.android.gms.ads.internal.zzu.zzr().zze();
    }

    final /* synthetic */ void zzw() {
        this.zzj.zza(new zzbtv());
    }
}
