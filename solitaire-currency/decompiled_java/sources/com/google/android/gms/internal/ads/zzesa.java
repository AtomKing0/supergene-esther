package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.common.util.concurrent.m;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzesa implements zzevo {
    private final zzgcu zza;

    public zzesa(Context context, zzgcu zzgcuVar) {
        this.zza = zzgcuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final int zza() {
        return 19;
    }

    @Override // com.google.android.gms.internal.ads.zzevo
    public final m zzb() {
        return this.zza.zzb(new Callable(this) { // from class: com.google.android.gms.internal.ads.zzerz
            @Override // java.util.concurrent.Callable
            public final Object call() {
                String strZzj;
                String strZzk;
                String strZze;
                com.google.android.gms.ads.internal.zzu.zzp();
                zzayv zzayvVarZzg = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzg();
                Bundle bundle = null;
                if (zzayvVarZzg != null && (!com.google.android.gms.ads.internal.zzu.zzo().zzi().zzP() || !com.google.android.gms.ads.internal.zzu.zzo().zzi().zzQ())) {
                    if (zzayvVarZzg.zzh()) {
                        zzayvVarZzg.zzg();
                    }
                    zzayl zzaylVarZza = zzayvVarZzg.zza();
                    if (zzaylVarZza != null) {
                        strZzj = zzaylVarZza.zzd();
                        strZze = zzaylVarZza.zze();
                        strZzk = zzaylVarZza.zzf();
                        if (strZzj != null) {
                            com.google.android.gms.ads.internal.zzu.zzo().zzi().zzx(strZzj);
                        }
                        if (strZzk != null) {
                            com.google.android.gms.ads.internal.zzu.zzo().zzi().zzz(strZzk);
                        }
                    } else {
                        strZzj = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzj();
                        strZzk = com.google.android.gms.ads.internal.zzu.zzo().zzi().zzk();
                        strZze = null;
                    }
                    Bundle bundle2 = new Bundle(1);
                    if (!com.google.android.gms.ads.internal.zzu.zzo().zzi().zzQ()) {
                        if (strZzk == null || TextUtils.isEmpty(strZzk)) {
                            bundle2.putString("v_fp_vertical", "no_hash");
                        } else {
                            bundle2.putString("v_fp_vertical", strZzk);
                        }
                    }
                    if (strZzj != null && !com.google.android.gms.ads.internal.zzu.zzo().zzi().zzP()) {
                        bundle2.putString("fingerprint", strZzj);
                        if (!strZzj.equals(strZze)) {
                            bundle2.putString("v_fp", strZze);
                        }
                    }
                    if (!bundle2.isEmpty()) {
                        bundle = bundle2;
                    }
                }
                return new zzesb(bundle);
            }
        });
    }
}
