package com.google.android.gms.ads.internal.util;

import android.content.Context;
import com.google.android.gms.internal.ads.zzapd;
import com.google.android.gms.internal.ads.zzaph;
import com.google.android.gms.internal.ads.zzapk;
import com.google.android.gms.internal.ads.zzapq;
import com.google.android.gms.internal.ads.zzapv;
import com.google.android.gms.internal.ads.zzapw;
import com.google.android.gms.internal.ads.zzaqd;
import com.google.android.gms.internal.ads.zzaqi;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbku;
import com.google.android.gms.internal.ads.zzfqt;
import com.google.android.gms.internal.ads.zzfqu;
import java.io.File;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzaz extends zzapw {
    private final Context zzb;

    private zzaz(Context context, zzapv zzapvVar) {
        super(zzapvVar);
        this.zzb = context;
    }

    public static zzapk zzb(Context context) {
        zzapk zzapkVar = new zzapk(new zzaqd(new File(zzfqu.zza(zzfqt.zza(), context.getCacheDir(), "admob_volley")), 20971520), new zzaz(context, new zzaqi(null, null)), 4);
        zzapkVar.zzd();
        return zzapkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzapw, com.google.android.gms.internal.ads.zzapa
    public final zzapd zza(zzaph zzaphVar) throws zzapq {
        if (zzaphVar.zza() == 0) {
            if (Pattern.matches((String) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdX), zzaphVar.zzk())) {
                Context context = this.zzb;
                com.google.android.gms.ads.internal.client.zzay.zzb();
                if (com.google.android.gms.ads.internal.util.client.zzf.zzt(context, 13400000)) {
                    zzapd zzapdVarZza = new zzbku(this.zzb).zza(zzaphVar);
                    if (zzapdVarZza != null) {
                        zze.zza("Got gmscore asset response: ".concat(String.valueOf(zzaphVar.zzk())));
                        return zzapdVarZza;
                    }
                    zze.zza("Failed to get gmscore asset response: ".concat(String.valueOf(zzaphVar.zzk())));
                }
            }
        }
        return super.zza(zzaphVar);
    }
}
