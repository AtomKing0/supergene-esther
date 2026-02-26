package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.internal.measurement.zzfn;
import com.google.android.gms.internal.measurement.zzqv;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
public final class zznb extends zzmz {
    zznb(zznd zzndVar) {
        super(zzndVar);
    }

    private final String zzc(String str) throws Throwable {
        String strZzf = zzm().zzf(str);
        if (TextUtils.isEmpty(strZzf)) {
            return zzbh.zzq.zza(null);
        }
        Uri uri = Uri.parse(zzbh.zzq.zza(null));
        Uri.Builder builderBuildUpon = uri.buildUpon();
        builderBuildUpon.authority(strZzf + "." + uri.getAuthority());
        return builderBuildUpon.build().toString();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznm g_() {
        return super.g_();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public final Pair<zzna, Boolean> zzb(String str) {
        zzf zzfVarZze;
        if (zzqv.zza() && zze().zza(zzbh.zzbt)) {
            zzq();
            if (zznt.zzf(str)) {
                zzj().zzp().zza("sgtm feature flag enabled.");
                zzf zzfVarZze2 = zzh().zze(str);
                if (zzfVarZze2 == null) {
                    return Pair.create(new zzna(zzc(str)), Boolean.TRUE);
                }
                String strZzab = zzfVarZze2.zzab();
                zzfn.zzd zzdVarZzc = zzm().zzc(str);
                boolean z10 = false;
                if (zzdVarZzc != null && (zzfVarZze = zzh().zze(str)) != null && ((zzdVarZzc.zzr() && zzdVarZzc.zzh().zza() == 100) || zzq().zzd(str, zzfVarZze.zzak()) || (!TextUtils.isEmpty(strZzab) && strZzab.hashCode() % 100 < zzdVarZzc.zzh().zza()))) {
                    z10 = true;
                }
                if (!z10) {
                    return Pair.create(new zzna(zzc(str)), Boolean.TRUE);
                }
                zzna zznaVar = null;
                if (zzfVarZze2.zzar()) {
                    zzj().zzp().zza("sgtm upload enabled in manifest.");
                    zzfn.zzd zzdVarZzc2 = zzm().zzc(zzfVarZze2.zzaa());
                    if (zzdVarZzc2 != null && zzdVarZzc2.zzr()) {
                        String strZze = zzdVarZzc2.zzh().zze();
                        if (!TextUtils.isEmpty(strZze)) {
                            String strZzd = zzdVarZzc2.zzh().zzd();
                            zzj().zzp().zza("sgtm configured with upload_url, server_info", strZze, TextUtils.isEmpty(strZzd) ? "Y" : "N");
                            if (TextUtils.isEmpty(strZzd)) {
                                zznaVar = new zzna(strZze);
                            } else {
                                HashMap map = new HashMap();
                                map.put("x-sgtm-server-info", strZzd);
                                if (!TextUtils.isEmpty(zzfVarZze2.zzak())) {
                                    map.put("x-gtm-server-preview", zzfVarZze2.zzak());
                                }
                                zznaVar = new zzna(strZze, map);
                            }
                        }
                    }
                }
                if (zznaVar != null) {
                    return Pair.create(zznaVar, Boolean.FALSE);
                }
            }
        }
        return Pair.create(new zzna(zzc(str)), Boolean.TRUE);
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzad zzd() {
        return super.zzd();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzae zze() {
        return super.zze();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzaz zzf() {
        return super.zzf();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzs zzg() {
        return super.zzg();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzan zzh() {
        return super.zzh();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzfw zzi() {
        return super.zzi();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzgb zzj() {
        return super.zzj();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zzgm zzk() {
        return super.zzk();
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ zzhh zzl() {
        return super.zzl();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzgy zzm() {
        return super.zzm();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zzmd zzn() {
        return super.zzn();
    }

    @Override // com.google.android.gms.measurement.internal.zzmz
    public final /* bridge */ /* synthetic */ zznb zzo() {
        return super.zzo();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ zznt zzq() {
        return super.zzq();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    @Override // com.google.android.gms.measurement.internal.zzim
    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    final Uri.Builder zza(String str) throws Throwable {
        String strZzf = zzm().zzf(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(zze().zzd(str, zzbh.zzax));
        if (TextUtils.isEmpty(strZzf)) {
            builder.authority(zze().zzd(str, zzbh.zzay));
        } else {
            builder.authority(strZzf + "." + zze().zzd(str, zzbh.zzay));
        }
        builder.path(zze().zzd(str, zzbh.zzaz));
        return builder;
    }

    @Override // com.google.android.gms.measurement.internal.zzim, com.google.android.gms.measurement.internal.zzio
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }
}
