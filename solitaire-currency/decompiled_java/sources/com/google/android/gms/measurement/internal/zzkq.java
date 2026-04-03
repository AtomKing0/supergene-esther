package com.google.android.gms.measurement.internal;

import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import androidx.annotation.Size;
import androidx.annotation.WorkerThread;
import androidx.media3.extractor.text.ttml.TtmlNode;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzft;
import com.google.android.gms.internal.measurement.zzon;
import com.google.android.gms.internal.measurement.zzqk;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement@@21.6.1 */
/* JADX INFO: loaded from: classes3.dex */
final class zzkq extends zzmy {
    public zzkq(zznd zzndVar) {
        super(zzndVar);
    }

    private static String zza(String str, String str2) {
        throw new SecurityException("This implementation should not be used.");
    }

    @Override // com.google.android.gms.measurement.internal.zzmy
    protected final boolean zzc() {
        return false;
    }

    @WorkerThread
    public final byte[] zza(@NonNull zzbf zzbfVar, @Size(min = 1) String str) {
        zznq next;
        zzft.zzj.zza zzaVar;
        Bundle bundle;
        zzf zzfVar;
        zzft.zzi.zzb zzbVar;
        byte[] bArr;
        long j10;
        zzbb zzbbVarZza;
        zzt();
        this.zzu.zzy();
        Preconditions.checkNotNull(zzbfVar);
        Preconditions.checkNotEmpty(str);
        if (!zze().zze(str, zzbh.zzbe)) {
            zzj().zzc().zza("Generating ScionPayload disabled. packageName", str);
            return new byte[0];
        }
        if (!"_iap".equals(zzbfVar.zza) && !"_iapx".equals(zzbfVar.zza)) {
            zzj().zzc().zza("Generating a payload for this event is not available. package_name, event_name", str, zzbfVar.zza);
            return null;
        }
        zzft.zzi.zzb zzbVarZzb = zzft.zzi.zzb();
        zzh().zzp();
        try {
            zzf zzfVarZze = zzh().zze(str);
            if (zzfVarZze == null) {
                zzj().zzc().zza("Log and bundle not available. package_name", str);
                return new byte[0];
            }
            if (!zzfVarZze.zzap()) {
                zzj().zzc().zza("Log and bundle disabled. package_name", str);
                return new byte[0];
            }
            zzft.zzj.zza zzaVarZzp = zzft.zzj.zzu().zzh(1).zzp("android");
            if (!TextUtils.isEmpty(zzfVarZze.zzaa())) {
                zzaVarZzp.zzb(zzfVarZze.zzaa());
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzac())) {
                zzaVarZzp.zzd((String) Preconditions.checkNotNull(zzfVarZze.zzac()));
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzad())) {
                zzaVarZzp.zze((String) Preconditions.checkNotNull(zzfVarZze.zzad()));
            }
            if (zzfVarZze.zze() != -2147483648L) {
                zzaVarZzp.zze((int) zzfVarZze.zze());
            }
            zzaVarZzp.zzf(zzfVarZze.zzq()).zzd(zzfVarZze.zzo());
            String strZzaf = zzfVarZze.zzaf();
            String strZzy = zzfVarZze.zzy();
            if (!TextUtils.isEmpty(strZzaf)) {
                zzaVarZzp.zzm(strZzaf);
            } else if (!TextUtils.isEmpty(strZzy)) {
                zzaVarZzp.zza(strZzy);
            }
            zzaVarZzp.zzj(zzfVarZze.zzw());
            zziq zziqVarZzb = this.zzf.zzb(str);
            zzaVarZzp.zzc(zzfVarZze.zzn());
            if (this.zzu.zzac() && zze().zzk(zzaVarZzp.zzt()) && zziqVarZzb.zzi() && !TextUtils.isEmpty(null)) {
                zzaVarZzp.zzj((String) null);
            }
            zzaVarZzp.zzg(zziqVarZzb.zzg());
            if (zziqVarZzb.zzi() && zzfVarZze.zzao()) {
                Pair<String, Boolean> pairZza = zzn().zza(zzfVarZze.zzaa(), zziqVarZzb);
                if (zzfVarZze.zzao() && pairZza != null && !TextUtils.isEmpty((CharSequence) pairZza.first)) {
                    zzaVarZzp.zzq(zza((String) pairZza.first, Long.toString(zzbfVar.zzd)));
                    Object obj = pairZza.second;
                    if (obj != null) {
                        zzaVarZzp.zzc(((Boolean) obj).booleanValue());
                    }
                }
            }
            zzf().zzac();
            zzft.zzj.zza zzaVarZzi = zzaVarZzp.zzi(Build.MODEL);
            zzf().zzac();
            zzaVarZzi.zzo(Build.VERSION.RELEASE).zzj((int) zzf().zzg()).zzs(zzf().zzh());
            if (zziqVarZzb.zzj() && zzfVarZze.zzab() != null) {
                zzaVarZzp.zzc(zza((String) Preconditions.checkNotNull(zzfVarZze.zzab()), Long.toString(zzbfVar.zzd)));
            }
            if (!TextUtils.isEmpty(zzfVarZze.zzae())) {
                zzaVarZzp.zzl((String) Preconditions.checkNotNull(zzfVarZze.zzae()));
            }
            String strZzaa = zzfVarZze.zzaa();
            List<zznq> listZzj = zzh().zzj(strZzaa);
            Iterator<zznq> it = listZzj.iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                }
                next = it.next();
                if ("_lte".equals(next.zzc)) {
                    break;
                }
            }
            if (next == null || next.zze == null) {
                zznq zznqVar = new zznq(strZzaa, TtmlNode.TEXT_EMPHASIS_AUTO, "_lte", zzb().currentTimeMillis(), 0L);
                listZzj.add(zznqVar);
                zzh().zza(zznqVar);
            }
            zzft.zzn[] zznVarArr = new zzft.zzn[listZzj.size()];
            for (int i10 = 0; i10 < listZzj.size(); i10++) {
                zzft.zzn.zza zzaVarZzb = zzft.zzn.zze().zza(listZzj.get(i10).zzc).zzb(listZzj.get(i10).zzd);
                g_().zza(zzaVarZzb, listZzj.get(i10).zze);
                zznVarArr[i10] = (zzft.zzn) ((com.google.android.gms.internal.measurement.zzjt) zzaVarZzb.zzah());
            }
            zzaVarZzp.zze(Arrays.asList(zznVarArr));
            g_().zza(zzaVarZzp);
            if (zzon.zza() && zze().zza(zzbh.zzco)) {
                this.zzf.zza(zzfVarZze, zzaVarZzp);
            }
            zzgf zzgfVarZza = zzgf.zza(zzbfVar);
            zzq().zza(zzgfVarZza.zzb, zzh().zzd(str));
            zzq().zza(zzgfVarZza, zze().zzb(str));
            Bundle bundle2 = zzgfVarZza.zzb;
            bundle2.putLong("_c", 1L);
            zzj().zzc().zza("Marking in-app purchase as real-time");
            bundle2.putLong("_r", 1L);
            bundle2.putString("_o", zzbfVar.zzc);
            if (zzq().zzd(zzaVarZzp.zzt(), zzfVarZze.zzak())) {
                zzq().zza(bundle2, "_dbg", (Object) 1L);
                zzq().zza(bundle2, "_r", (Object) 1L);
            }
            zzbb zzbbVarZzd = zzh().zzd(str, zzbfVar.zza);
            if (zzbbVarZzd == null) {
                zzaVar = zzaVarZzp;
                bundle = bundle2;
                zzfVar = zzfVarZze;
                zzbVar = zzbVarZzb;
                bArr = null;
                zzbbVarZza = new zzbb(str, zzbfVar.zza, 0L, 0L, zzbfVar.zzd, 0L, null, null, null, null);
                j10 = 0;
            } else {
                zzaVar = zzaVarZzp;
                bundle = bundle2;
                zzfVar = zzfVarZze;
                zzbVar = zzbVarZzb;
                bArr = null;
                j10 = zzbbVarZzd.zzf;
                zzbbVarZza = zzbbVarZzd.zza(zzbfVar.zzd);
            }
            zzh().zza(zzbbVarZza);
            zzay zzayVar = new zzay(this.zzu, zzbfVar.zzc, str, zzbfVar.zza, zzbfVar.zzd, j10, bundle);
            zzft.zze.zza zzaVarZza = zzft.zze.zze().zzb(zzayVar.zzc).zza(zzayVar.zzb).zza(zzayVar.zzd);
            for (String str2 : zzayVar.zze) {
                zzft.zzg.zza zzaVarZza2 = zzft.zzg.zze().zza(str2);
                Object objZzc = zzayVar.zze.zzc(str2);
                if (objZzc != null) {
                    g_().zza(zzaVarZza2, objZzc);
                    zzaVarZza.zza(zzaVarZza2);
                }
            }
            zzft.zzj.zza zzaVar2 = zzaVar;
            zzaVar2.zza(zzaVarZza).zza(zzft.zzk.zza().zza(zzft.zzf.zza().zza(zzbbVarZza.zzc).zza(zzbfVar.zza)));
            zzaVar2.zza(zzg().zza(zzfVar.zzaa(), Collections.emptyList(), zzaVar2.zzab(), Long.valueOf(zzaVarZza.zzc()), Long.valueOf(zzaVarZza.zzc())));
            if (zzaVarZza.zzg()) {
                zzaVar2.zzi(zzaVarZza.zzc()).zze(zzaVarZza.zzc());
            }
            long jZzs = zzfVar.zzs();
            if (jZzs != 0) {
                zzaVar2.zzg(jZzs);
            }
            long jZzu = zzfVar.zzu();
            if (jZzu != 0) {
                zzaVar2.zzh(jZzu);
            } else if (jZzs != 0) {
                zzaVar2.zzh(jZzs);
            }
            String strZzaj = zzfVar.zzaj();
            if (zzqk.zza() && zze().zze(str, zzbh.zzbs) && strZzaj != null) {
                zzaVar2.zzr(strZzaj);
            }
            zzfVar.zzan();
            zzaVar2.zzf((int) zzfVar.zzt()).zzl(87000L).zzk(zzb().currentTimeMillis()).zzd(true);
            if (zze().zza(zzbh.zzbx)) {
                this.zzf.zza(zzaVar2.zzt(), zzaVar2);
            }
            zzft.zzi.zzb zzbVar2 = zzbVar;
            zzbVar2.zza(zzaVar2);
            zzf zzfVar2 = zzfVar;
            zzfVar2.zzr(zzaVar2.zzf());
            zzfVar2.zzp(zzaVar2.zze());
            zzh().zza(zzfVar2);
            zzh().zzw();
            try {
                return g_().zzb(((zzft.zzi) ((com.google.android.gms.internal.measurement.zzjt) zzbVar2.zzah())).zzbv());
            } catch (IOException e10) {
                zzj().zzg().zza("Data loss. Failed to bundle and serialize. appId", zzgb.zza(str), e10);
                return bArr;
            }
        } catch (SecurityException e11) {
            zzj().zzc().zza("Resettable device id encryption failed", e11.getMessage());
            return new byte[0];
        } catch (SecurityException e12) {
            zzj().zzc().zza("app instance id encryption failed", e12.getMessage());
            return new byte[0];
        } finally {
            zzh().zzu();
        }
    }
}
