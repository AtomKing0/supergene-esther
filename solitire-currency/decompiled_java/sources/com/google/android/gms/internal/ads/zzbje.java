package com.google.android.gms.internal.ads;

import androidx.media3.exoplayer.upstream.CmcdData;
import com.google.android.gms.common.util.CollectionUtils;
import com.ironsource.v8;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbje implements zzbix {
    static final Map zza = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", com.vungle.ads.internal.presenter.l.SET_ORIENTATION_PROPERTIES, "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zzb zzb;
    private final zzbrk zzc;
    private final zzbrr zzd;

    public zzbje(com.google.android.gms.ads.internal.zzb zzbVar, zzbrk zzbrkVar, zzbrr zzbrrVar) {
        this.zzb = zzbVar;
        this.zzc = zzbrkVar;
        this.zzd = zzbrrVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcej zzcejVar = (zzcej) obj;
        int iIntValue = ((Integer) zza.get((String) map.get(CmcdData.Factory.OBJECT_TYPE_AUDIO_ONLY))).intValue();
        int i10 = 6;
        if (iIntValue != 5) {
            if (iIntValue != 7) {
                if (!this.zzb.zzc()) {
                    this.zzb.zzb(null);
                    return;
                }
                if (iIntValue == 1) {
                    this.zzc.zzb(map);
                    return;
                }
                if (iIntValue == 3) {
                    new zzbrn(zzcejVar, map).zzb();
                    return;
                }
                if (iIntValue == 4) {
                    new zzbrh(zzcejVar, map).zzc();
                    return;
                } else if (iIntValue != 5) {
                    if (iIntValue == 6) {
                        this.zzc.zza(true);
                        return;
                    } else if (iIntValue != 7) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzi("Unknown MRAID command called.");
                        return;
                    }
                }
            }
            this.zzd.zzc();
            return;
        }
        String str = (String) map.get("forceOrientation");
        boolean z10 = map.containsKey("allowOrientationChange") ? Boolean.parseBoolean((String) map.get("allowOrientationChange")) : true;
        if (zzcejVar == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("AdWebView is null");
            return;
        }
        if (v8.h.D.equalsIgnoreCase(str)) {
            i10 = 7;
        } else if (!v8.h.C.equalsIgnoreCase(str)) {
            i10 = z10 ? -1 : 14;
        }
        zzcejVar.zzau(i10);
    }
}
