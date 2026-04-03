package com.google.android.gms.measurement.internal;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzft;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzw {
    private zzft.zze zza;
    private Long zzb;
    private long zzc;
    private final /* synthetic */ zzs zzd;

    final zzft.zze zza(String str, zzft.zze zzeVar) {
        Object obj;
        String strZzg = zzeVar.zzg();
        List<zzft.zzg> listZzh = zzeVar.zzh();
        this.zzd.g_();
        Long l10 = (Long) zznm.zzb(zzeVar, "_eid");
        boolean z10 = l10 != null;
        if (z10 && strZzg.equals("_ep")) {
            Preconditions.checkNotNull(l10);
            this.zzd.g_();
            strZzg = (String) zznm.zzb(zzeVar, "_en");
            if (TextUtils.isEmpty(strZzg)) {
                this.zzd.zzj().zzm().zza("Extra parameter without an event name. eventId", l10);
                return null;
            }
            if (this.zza == null || this.zzb == null || l10.longValue() != this.zzb.longValue()) {
                Pair<zzft.zze, Long> pairZza = this.zzd.zzh().zza(str, l10);
                if (pairZza == null || (obj = pairZza.first) == null) {
                    this.zzd.zzj().zzm().zza("Extra parameter without existing main event. eventName, eventId", strZzg, l10);
                    return null;
                }
                this.zza = (zzft.zze) obj;
                this.zzc = ((Long) pairZza.second).longValue();
                this.zzd.g_();
                this.zzb = (Long) zznm.zzb(this.zza, "_eid");
            }
            long j10 = this.zzc - 1;
            this.zzc = j10;
            if (j10 <= 0) {
                zzan zzanVarZzh = this.zzd.zzh();
                zzanVarZzh.zzt();
                zzanVarZzh.zzj().zzp().zza("Clearing complex main event info. appId", str);
                try {
                    zzanVarZzh.e_().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e10) {
                    zzanVarZzh.zzj().zzg().zza("Error clearing complex main event", e10);
                }
            } else {
                this.zzd.zzh().zza(str, l10, this.zzc, this.zza);
            }
            ArrayList arrayList = new ArrayList();
            for (zzft.zzg zzgVar : this.zza.zzh()) {
                this.zzd.g_();
                if (zznm.zza(zzeVar, zzgVar.zzg()) == null) {
                    arrayList.add(zzgVar);
                }
            }
            if (arrayList.isEmpty()) {
                this.zzd.zzj().zzm().zza("No unique parameters in main event. eventName", strZzg);
            } else {
                arrayList.addAll(listZzh);
                listZzh = arrayList;
            }
        } else if (z10) {
            this.zzb = l10;
            this.zza = zzeVar;
            this.zzd.g_();
            Object objZzb = zznm.zzb(zzeVar, "_epc");
            long jLongValue = ((Long) (objZzb != null ? objZzb : 0L)).longValue();
            this.zzc = jLongValue;
            if (jLongValue <= 0) {
                this.zzd.zzj().zzm().zza("Complex event with zero extra param count. eventName", strZzg);
            } else {
                this.zzd.zzh().zza(str, (Long) Preconditions.checkNotNull(l10), this.zzc, zzeVar);
            }
        }
        return (zzft.zze) ((com.google.android.gms.internal.measurement.zzjt) zzeVar.zzby().zza(strZzg).zzd().zza(listZzh).zzah());
    }

    private zzw(zzs zzsVar) {
        this.zzd = zzsVar;
    }
}
