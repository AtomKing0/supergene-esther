package com.google.android.gms.ads.internal;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.Nullable;
import com.google.android.gms.internal.ads.zzbue;
import com.google.android.gms.internal.ads.zzbxl;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzb {
    private final Context zza;
    private boolean zzb;

    @Nullable
    private final zzbxl zzc;
    private final zzbue zzd = new zzbue(false, Collections.emptyList());

    public zzb(Context context, @Nullable zzbxl zzbxlVar, @Nullable zzbue zzbueVar) {
        this.zza = context;
        this.zzc = zzbxlVar;
    }

    private final boolean zzd() {
        zzbxl zzbxlVar = this.zzc;
        return (zzbxlVar != null && zzbxlVar.zza().zzf) || this.zzd.zza;
    }

    public final void zza() {
        this.zzb = true;
    }

    public final void zzb(@Nullable String str) {
        List<String> list;
        if (zzd()) {
            if (str == null) {
                str = "";
            }
            zzbxl zzbxlVar = this.zzc;
            if (zzbxlVar != null) {
                zzbxlVar.zzd(str, null, 3);
                return;
            }
            zzbue zzbueVar = this.zzd;
            if (!zzbueVar.zza || (list = zzbueVar.zzb) == null) {
                return;
            }
            for (String str2 : list) {
                if (!TextUtils.isEmpty(str2)) {
                    String strReplace = str2.replace("{NAVIGATION_URL}", Uri.encode(str));
                    Context context = this.zza;
                    zzu.zzp();
                    com.google.android.gms.ads.internal.util.zzt.zzL(context, "", strReplace);
                }
            }
        }
    }

    public final boolean zzc() {
        return !zzd() || this.zzb;
    }
}
