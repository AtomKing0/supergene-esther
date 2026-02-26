package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzcck implements zzbix {
    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        zzcbk zzcbkVar = (zzcbk) obj;
        zzcfl zzcflVarZzq = zzcbkVar.zzq();
        if (zzcflVarZzq == null) {
            try {
                zzcfl zzcflVar = new zzcfl(zzcbkVar, Float.parseFloat((String) map.get("duration")), "1".equals(map.get("customControlsAllowed")), "1".equals(map.get("clickToExpandAllowed")));
                zzcbkVar.zzC(zzcflVar);
                zzcflVarZzq = zzcflVar;
            } catch (NullPointerException e10) {
                e = e10;
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            } catch (NumberFormatException e11) {
                e = e11;
                com.google.android.gms.ads.internal.util.client.zzm.zzh("Unable to parse videoMeta message.", e);
                com.google.android.gms.ads.internal.zzu.zzo().zzw(e, "VideoMetaGmsgHandler.onGmsg");
                return;
            }
        }
        float f10 = Float.parseFloat((String) map.get("duration"));
        boolean zEquals = "1".equals(map.get("muted"));
        float f11 = Float.parseFloat((String) map.get("currentTime"));
        int i10 = Integer.parseInt((String) map.get("playbackState"));
        int i11 = 0;
        if (i10 >= 0 && i10 <= 3) {
            i11 = i10;
        }
        String str = (String) map.get("aspectRatio");
        float f12 = TextUtils.isEmpty(str) ? 0.0f : Float.parseFloat(str);
        if (com.google.android.gms.ads.internal.util.client.zzm.zzm(3)) {
            com.google.android.gms.ads.internal.util.client.zzm.zze("Video Meta GMSG: currentTime : " + f11 + " , duration : " + f10 + " , isMuted : " + zEquals + " , playbackState : " + i11 + " , aspectRatio : " + str);
        }
        zzcflVarZzq.zzc(f11, f10, i11, zEquals, f12);
    }
}
