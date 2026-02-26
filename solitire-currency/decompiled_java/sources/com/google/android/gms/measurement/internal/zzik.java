package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzpy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzik implements Callable<List<zzmv>> {
    private final /* synthetic */ zzn zza;
    private final /* synthetic */ Bundle zzb;
    private final /* synthetic */ zzhs zzc;

    zzik(zzhs zzhsVar, zzn zznVar, Bundle bundle) {
        this.zza = zznVar;
        this.zzb = bundle;
        this.zzc = zzhsVar;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ List<zzmv> call() throws Exception {
        this.zzc.zza.zzr();
        zznd zzndVar = this.zzc.zza;
        zzn zznVar = this.zza;
        Bundle bundle = this.zzb;
        zzndVar.zzl().zzt();
        if (!zzpy.zza() || !zzndVar.zze().zze(zznVar.zza, zzbh.zzcg) || zznVar.zza == null) {
            return new ArrayList();
        }
        if (bundle != null) {
            int[] intArray = bundle.getIntArray("uriSources");
            long[] longArray = bundle.getLongArray("uriTimestamps");
            if (intArray != null) {
                if (longArray == null || longArray.length != intArray.length) {
                    zzndVar.zzj().zzg().zza("Uri sources and timestamps do not match");
                } else {
                    for (int i10 = 0; i10 < intArray.length; i10++) {
                        zzan zzanVarZzf = zzndVar.zzf();
                        String str = zznVar.zza;
                        int i11 = intArray[i10];
                        long j10 = longArray[i10];
                        Preconditions.checkNotEmpty(str);
                        zzanVarZzf.zzt();
                        zzanVarZzf.zzak();
                        try {
                            int iDelete = zzanVarZzf.e_().delete("trigger_uris", "app_id=? and source=? and timestamp_millis<=?", new String[]{str, String.valueOf(i11), String.valueOf(j10)});
                            zzanVarZzf.zzj().zzp().zza("Pruned " + iDelete + " trigger URIs. appId, source, timestamp", str, Integer.valueOf(i11), Long.valueOf(j10));
                        } catch (SQLiteException e10) {
                            zzanVarZzf.zzj().zzg().zza("Error pruning trigger URIs. appId", zzgb.zza(str), e10);
                        }
                    }
                }
            }
        }
        return zzndVar.zzf().zzi(zznVar.zza);
    }
}
