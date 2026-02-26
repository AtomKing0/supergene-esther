package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.common.util.concurrent.m;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbku implements zzapa {
    private volatile zzbkh zza;
    private final Context zzb;

    public zzbku(Context context) {
        this.zzb = context;
    }

    static /* bridge */ /* synthetic */ void zzc(zzbku zzbkuVar) {
        if (zzbkuVar.zza == null) {
            return;
        }
        zzbkuVar.zza.disconnect();
        Binder.flushPendingCommands();
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzapa
    @Nullable
    public final zzapd zza(zzaph zzaphVar) throws zzapq {
        Parcelable.Creator<zzbki> creator = zzbki.CREATOR;
        Map mapZzl = zzaphVar.zzl();
        int size = mapZzl.size();
        String[] strArr = new String[size];
        String[] strArr2 = new String[size];
        int i10 = 0;
        int i11 = 0;
        for (Map.Entry entry : mapZzl.entrySet()) {
            strArr[i11] = (String) entry.getKey();
            strArr2[i11] = (String) entry.getValue();
            i11++;
        }
        zzbki zzbkiVar = new zzbki(zzaphVar.zzk(), strArr, strArr2);
        long jElapsedRealtime = com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime();
        try {
            zzbzt zzbztVar = new zzbzt();
            this.zza = new zzbkh(this.zzb, com.google.android.gms.ads.internal.zzu.zzt().zzb(), new zzbks(this, zzbztVar), new zzbkt(this, zzbztVar));
            this.zza.checkAvailabilityAndConnect();
            zzbkq zzbkqVar = new zzbkq(this, zzbkiVar);
            zzgcu zzgcuVar = zzbzo.zza;
            m mVarZzo = zzgcj.zzo(zzgcj.zzn(zzbztVar, zzbkqVar, zzgcuVar), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdY)).intValue(), TimeUnit.MILLISECONDS, zzbzo.zzd);
            mVarZzo.addListener(new zzbkr(this), zzgcuVar);
            ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor) mVarZzo.get();
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            zzbkk zzbkkVar = (zzbkk) new zzbuz(parcelFileDescriptor).zza(zzbkk.CREATOR);
            if (zzbkkVar == null) {
                return null;
            }
            if (zzbkkVar.zza) {
                throw new zzapq(zzbkkVar.zzb);
            }
            if (zzbkkVar.zze.length != zzbkkVar.zzf.length) {
                return null;
            }
            HashMap map = new HashMap();
            while (true) {
                String[] strArr3 = zzbkkVar.zze;
                if (i10 >= strArr3.length) {
                    return new zzapd(zzbkkVar.zzc, zzbkkVar.zzd, map, zzbkkVar.zzg, zzbkkVar.zzh);
                }
                map.put(strArr3[i10], zzbkkVar.zzf[i10]);
                i10++;
            }
        } catch (InterruptedException | ExecutionException unused) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            return null;
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.zze.zza("Http assets remote cache took " + (com.google.android.gms.ads.internal.zzu.zzB().elapsedRealtime() - jElapsedRealtime) + "ms");
            throw th;
        }
    }
}
