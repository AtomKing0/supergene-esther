package com.google.android.gms.internal.ads;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.games.GamesActivityResultCodes;
import com.google.android.gms.internal.ads.zzbbc;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzecu {
    private final zzbav zza;
    private final Context zzb;
    private final zzebz zzc;
    private final VersionInfoParcel zzd;

    public zzecu(Context context, VersionInfoParcel versionInfoParcel, zzbav zzbavVar, zzebz zzebzVar) {
        this.zzb = context;
        this.zzd = versionInfoParcel;
        this.zza = zzbavVar;
        this.zzc = zzebzVar;
    }

    final /* synthetic */ Void zza(boolean z10, SQLiteDatabase sQLiteDatabase) throws Exception {
        if (z10) {
            this.zzb.deleteDatabase("OfflineUpload.db");
        } else {
            ArrayList arrayList = new ArrayList();
            Cursor cursorQuery = sQLiteDatabase.query("offline_signal_contents", new String[]{"serialized_proto_data"}, null, null, null, null, null);
            while (cursorQuery.moveToNext()) {
                try {
                    arrayList.add(zzbbc.zzaf.zza.zzx(cursorQuery.getBlob(cursorQuery.getColumnIndexOrThrow("serialized_proto_data"))));
                } catch (zzgyn e10) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzg("Unable to deserialize proto from offline signals database:");
                    com.google.android.gms.ads.internal.util.client.zzm.zzg(e10.getMessage());
                }
            }
            cursorQuery.close();
            Context context = this.zzb;
            zzbbc.zzaf.zzc zzcVarZzi = zzbbc.zzaf.zzi();
            zzcVarZzi.zzv(context.getPackageName());
            zzcVarZzi.zzy(Build.MODEL);
            zzcVarZzi.zzA(zzeco.zza(sQLiteDatabase, 0));
            zzcVarZzi.zzh(arrayList);
            zzcVarZzi.zzE(zzeco.zza(sQLiteDatabase, 1));
            zzcVarZzi.zzx(zzeco.zza(sQLiteDatabase, 3));
            zzcVarZzi.zzF(com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis());
            zzcVarZzi.zzB(zzeco.zzb(sQLiteDatabase, 2));
            final zzbbc.zzaf zzafVarZzbr = zzcVarZzi.zzbr();
            int size = arrayList.size();
            long jZze = 0;
            for (int i10 = 0; i10 < size; i10++) {
                zzbbc.zzaf.zza zzaVar = (zzbbc.zzaf.zza) arrayList.get(i10);
                if (zzaVar.zzk() == zzbbc.zzq.ENUM_TRUE && zzaVar.zze() > jZze) {
                    jZze = zzaVar.zze();
                }
            }
            if (jZze != 0) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("value", Long.valueOf(jZze));
                sQLiteDatabase.update("offline_signal_statistics", contentValues, "statistic_name = 'last_successful_request_time'", null);
            }
            this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzecs
                @Override // com.google.android.gms.internal.ads.zzbau
                public final void zza(zzbbc.zzt.zza zzaVar2) {
                    zzaVar2.zzW(zzafVarZzbr);
                }
            });
            VersionInfoParcel versionInfoParcel = this.zzd;
            zzbbc.zzar.zza zzaVarZzd = zzbbc.zzar.zzd();
            zzaVarZzd.zzg(versionInfoParcel.buddyApkVersion);
            zzaVarZzd.zzi(this.zzd.clientJarVersion);
            zzaVarZzd.zzh(true != this.zzd.isClientJar ? 2 : 0);
            final zzbbc.zzar zzarVarZzbr = zzaVarZzd.zzbr();
            this.zza.zzb(new zzbau() { // from class: com.google.android.gms.internal.ads.zzect
                @Override // com.google.android.gms.internal.ads.zzbau
                public final void zza(zzbbc.zzt.zza zzaVar2) {
                    zzbbc.zzm.zza zzaVarZzbM = zzaVar2.zzg().zzbM();
                    zzaVarZzbM.zzw(zzarVarZzbr);
                    zzaVar2.zzK(zzaVarZzbM);
                }
            });
            this.zza.zzc(GamesActivityResultCodes.RESULT_APP_MISCONFIGURED);
            zzeco.zze(sQLiteDatabase);
        }
        return null;
    }

    public final void zzb(final boolean z10) {
        try {
            this.zzc.zza(new zzfio() { // from class: com.google.android.gms.internal.ads.zzecr
                @Override // com.google.android.gms.internal.ads.zzfio
                public final Object zza(Object obj) throws Exception {
                    this.zza.zza(z10, (SQLiteDatabase) obj);
                    return null;
                }
            });
        } catch (Exception e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzg("Error in offline signals database startup: ".concat(String.valueOf(e10.getMessage())));
        }
    }
}
