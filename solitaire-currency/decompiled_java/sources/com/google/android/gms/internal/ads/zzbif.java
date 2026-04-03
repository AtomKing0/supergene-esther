package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzbif implements zzbix {
    zzbif() {
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        if (TextUtils.isEmpty((CharSequence) map.get("appId"))) {
            com.google.android.gms.ads.internal.util.zze.zza("Missing App Id, cannot show LMD Overlay without it");
            return;
        }
        zzftj zzftjVarZzl = zzftk.zzl();
        zzftjVarZzl.zzb((String) map.get("appId"));
        zzftjVarZzl.zzh(zzcejVar.getWidth());
        zzftjVarZzl.zzg(zzcejVar.zzF().getWindowToken());
        if (map.containsKey("gravityX") && map.containsKey("gravityY")) {
            zzftjVarZzl.zzd(Integer.parseInt((String) map.get("gravityX")) | Integer.parseInt((String) map.get("gravityY")));
        } else {
            zzftjVarZzl.zzd(81);
        }
        if (map.containsKey("verticalMargin")) {
            zzftjVarZzl.zze(Float.parseFloat((String) map.get("verticalMargin")));
        } else {
            zzftjVarZzl.zze(0.02f);
        }
        if (map.containsKey("enifd")) {
            zzftjVarZzl.zza((String) map.get("enifd"));
        }
        try {
            com.google.android.gms.ads.internal.zzu.zzj().zzj(zzcejVar, zzftjVarZzl.zzi());
        } catch (NullPointerException e10) {
            com.google.android.gms.ads.internal.zzu.zzo().zzw(e10, "DefaultGmsgHandlers.ShowLMDOverlay");
            com.google.android.gms.ads.internal.util.zze.zza("Missing parameters for LMD Overlay show request");
        }
    }
}
