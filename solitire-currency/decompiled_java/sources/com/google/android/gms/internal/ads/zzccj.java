package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.os.SystemClock;
import android.text.TextUtils;
import android.view.MotionEvent;
import androidx.core.app.NotificationCompat;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.ironsource.f5;
import com.ironsource.v8;
import com.ironsource.w8;
import io.sentry.protocol.ViewHierarchyNode;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzccj implements zzbix {
    private boolean zza;

    private static int zzb(Context context, Map map, String str, int i10) {
        String str2 = (String) map.get(str);
        if (str2 != null) {
            try {
                com.google.android.gms.ads.internal.client.zzay.zzb();
                i10 = com.google.android.gms.ads.internal.util.client.zzf.zzy(context, Integer.parseInt(str2));
            } catch (NumberFormatException unused) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not parse " + str + " in a video GMSG: " + str2);
            }
        }
        if (com.google.android.gms.ads.internal.util.zze.zzc()) {
            com.google.android.gms.ads.internal.util.zze.zza("Parse pixels for " + str + ", got string " + str2 + ", int " + i10 + ".");
        }
        return i10;
    }

    private static void zzc(zzcay zzcayVar, Map map) {
        String str = (String) map.get("minBufferMs");
        String str2 = (String) map.get("maxBufferMs");
        String str3 = (String) map.get("bufferForPlaybackMs");
        String str4 = (String) map.get("bufferForPlaybackAfterRebufferMs");
        String str5 = (String) map.get("socketReceiveBufferSize");
        if (str != null) {
            try {
                zzcayVar.zzB(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj(String.format("Could not parse buffer parameters in loadControl video GMSG: (%s, %s)", str, str2));
                return;
            }
        }
        if (str2 != null) {
            zzcayVar.zzA(Integer.parseInt(str2));
        }
        if (str3 != null) {
            zzcayVar.zzy(Integer.parseInt(str3));
        }
        if (str4 != null) {
            zzcayVar.zzz(Integer.parseInt(str4));
        }
        if (str5 != null) {
            zzcayVar.zzD(Integer.parseInt(str5));
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbix
    public final /* bridge */ /* synthetic */ void zza(Object obj, Map map) {
        int iMin;
        int iMin2;
        Integer numValueOf;
        zzcbk zzcbkVar = (zzcbk) obj;
        String str = (String) map.get("action");
        if (str == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Action missing from video GMSG.");
            return;
        }
        Integer numValueOf2 = map.containsKey("playerId") ? Integer.valueOf(Integer.parseInt((String) map.get("playerId"))) : null;
        Integer numZzb = zzcbkVar.zzo() != null ? zzcbkVar.zzo().zzb() : null;
        int i10 = 0;
        if (numValueOf2 != null && numZzb != null && !numValueOf2.equals(numZzb) && !str.equals("load")) {
            com.google.android.gms.ads.internal.util.client.zzm.zzi(String.format(Locale.US, "Event intended for player %s, but sent to player %d - event ignored", numValueOf2, numZzb));
            return;
        }
        if (com.google.android.gms.ads.internal.util.client.zzm.zzm(3)) {
            JSONObject jSONObject = new JSONObject(map);
            jSONObject.remove("google.afma.Notify_dt");
            com.google.android.gms.ads.internal.util.client.zzm.zze("Video GMSG: " + str + " " + jSONObject.toString());
        }
        if (str.equals("background")) {
            String str2 = (String) map.get("color");
            if (TextUtils.isEmpty(str2)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Color parameter missing from background video GMSG.");
                return;
            }
            try {
                zzcbkVar.setBackgroundColor(Color.parseColor(str2));
                return;
            } catch (IllegalArgumentException unused) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Invalid color parameter in background video GMSG.");
                return;
            }
        }
        if (str.equals("playerBackground")) {
            String str3 = (String) map.get("color");
            if (TextUtils.isEmpty(str3)) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Color parameter missing from playerBackground video GMSG.");
                return;
            }
            try {
                zzcbkVar.zzB(Color.parseColor(str3));
                return;
            } catch (IllegalArgumentException unused2) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Invalid color parameter in playerBackground video GMSG.");
                return;
            }
        }
        if (str.equals("decoderProps")) {
            String str4 = (String) map.get("mimeTypes");
            if (str4 == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("No MIME types specified for decoder properties inspection.");
                HashMap map2 = new HashMap();
                map2.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
                map2.put("error", "missingMimeTypes");
                zzcbkVar.zzd("onVideoEvent", map2);
                return;
            }
            HashMap map3 = new HashMap();
            String[] strArrSplit = str4.split(",");
            int length = strArrSplit.length;
            while (i10 < length) {
                String str5 = strArrSplit[i10];
                map3.put(str5, com.google.android.gms.ads.internal.util.zzcj.zza(str5.trim()));
                i10++;
            }
            HashMap map4 = new HashMap();
            map4.put(NotificationCompat.CATEGORY_EVENT, "decoderProps");
            map4.put("mimeTypes", map3);
            zzcbkVar.zzd("onVideoEvent", map4);
            return;
        }
        zzcaz zzcazVarZzo = zzcbkVar.zzo();
        if (zzcazVarZzo == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not get underlay container for a video GMSG.");
            return;
        }
        boolean zEquals = str.equals("new");
        boolean zEquals2 = str.equals(v8.h.L);
        if (zEquals || zEquals2) {
            Context context = zzcbkVar.getContext();
            int iZzb = zzb(context, map, ViewHierarchyNode.JsonKeys.X, 0);
            int iZzb2 = zzb(context, map, ViewHierarchyNode.JsonKeys.Y, 0);
            int iZzb3 = zzb(context, map, "w", -1);
            zzbbn zzbbnVar = zzbbw.zzdx;
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                iMin = iZzb3 == -1 ? zzcbkVar.zzh() : Math.min(iZzb3, zzcbkVar.zzh());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Calculate width with original width " + iZzb3 + ", videoHost.getVideoBoundingWidth() " + zzcbkVar.zzh() + ", x " + iZzb + ".");
                }
                iMin = Math.min(iZzb3, zzcbkVar.zzh() - iZzb);
            }
            int iZzb4 = zzb(context, map, CmcdData.Factory.STREAMING_FORMAT_HLS, -1);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbnVar)).booleanValue()) {
                iMin2 = iZzb4 == -1 ? zzcbkVar.zzg() : Math.min(iZzb4, zzcbkVar.zzg());
            } else {
                if (com.google.android.gms.ads.internal.util.zze.zzc()) {
                    com.google.android.gms.ads.internal.util.zze.zza("Calculate height with original height " + iZzb4 + ", videoHost.getVideoBoundingHeight() " + zzcbkVar.zzg() + ", y " + iZzb2 + ".");
                }
                iMin2 = Math.min(iZzb4, zzcbkVar.zzg() - iZzb2);
            }
            try {
                i10 = Integer.parseInt((String) map.get("player"));
            } catch (NumberFormatException unused3) {
            }
            int i11 = i10;
            boolean z10 = Boolean.parseBoolean((String) map.get("spherical"));
            if (!zEquals || zzcazVarZzo.zza() != null) {
                zzcazVarZzo.zzc(iZzb, iZzb2, iMin, iMin2);
                return;
            }
            zzcazVarZzo.zzd(iZzb, iZzb2, iMin, iMin2, i11, z10, new zzcbj((String) map.get("flags")));
            zzcay zzcayVarZza = zzcazVarZzo.zza();
            if (zzcayVarZza != null) {
                zzc(zzcayVarZza, map);
                return;
            }
            return;
        }
        zzcfl zzcflVarZzq = zzcbkVar.zzq();
        if (zzcflVarZzq != null) {
            if (str.equals("timeupdate")) {
                String str6 = (String) map.get("currentTime");
                if (str6 == null) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("currentTime parameter missing from timeupdate video GMSG.");
                    return;
                }
                try {
                    zzcflVarZzq.zzt(Float.parseFloat(str6));
                    return;
                } catch (NumberFormatException unused4) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not parse currentTime parameter from timeupdate video GMSG: ".concat(str6));
                    return;
                }
            }
            if (str.equals("skip")) {
                zzcflVarZzq.zzu();
                return;
            }
        }
        zzcay zzcayVarZza2 = zzcazVarZzo.zza();
        if (zzcayVarZza2 == null) {
            HashMap map5 = new HashMap();
            map5.put(NotificationCompat.CATEGORY_EVENT, "no_video_view");
            zzcbkVar.zzd("onVideoEvent", map5);
            return;
        }
        if (str.equals(w8.f16021d)) {
            Context context2 = zzcbkVar.getContext();
            int iZzb5 = zzb(context2, map, ViewHierarchyNode.JsonKeys.X, 0);
            float fZzb = zzb(context2, map, ViewHierarchyNode.JsonKeys.Y, 0);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 0, iZzb5, fZzb, 0);
            zzcayVarZza2.zzx(motionEventObtain);
            motionEventObtain.recycle();
            return;
        }
        if (str.equals("currentTime")) {
            String str7 = (String) map.get("time");
            if (str7 == null) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Time parameter missing from currentTime video GMSG.");
                return;
            }
            try {
                zzcayVarZza2.zzw((int) (Float.parseFloat(str7) * 1000.0f));
                return;
            } catch (NumberFormatException unused5) {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not parse time parameter from currentTime video GMSG: ".concat(str7));
                return;
            }
        }
        if (str.equals("hide")) {
            zzcayVarZza2.setVisibility(4);
            return;
        }
        if (str.equals("remove")) {
            zzcayVarZza2.setVisibility(8);
            return;
        }
        if (str.equals("load")) {
            zzcayVarZza2.zzr(numValueOf2);
            return;
        }
        if (str.equals("loadControl")) {
            zzc(zzcayVarZza2, map);
            return;
        }
        if (str.equals("muted")) {
            if (Boolean.parseBoolean((String) map.get("muted"))) {
                zzcayVarZza2.zzs();
                return;
            } else {
                zzcayVarZza2.zzI();
                return;
            }
        }
        if (str.equals("pause")) {
            zzcayVarZza2.zzu();
            return;
        }
        if (str.equals("play")) {
            zzcayVarZza2.zzv();
            return;
        }
        if (str.equals(f5.f12054u)) {
            zzcayVarZza2.setVisibility(0);
            return;
        }
        if (str.equals("src")) {
            String str8 = (String) map.get("src");
            if (map.containsKey("periodicReportIntervalMs")) {
                try {
                    numValueOf = Integer.valueOf(Integer.parseInt((String) map.get("periodicReportIntervalMs")));
                } catch (NumberFormatException unused6) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Video gmsg invalid numeric parameter 'periodicReportIntervalMs': ".concat(String.valueOf((String) map.get("periodicReportIntervalMs"))));
                    numValueOf = null;
                }
            } else {
                numValueOf = null;
            }
            String[] strArr = {str8};
            String str9 = (String) map.get("demuxed");
            if (str9 != null) {
                try {
                    JSONArray jSONArray = new JSONArray(str9);
                    String[] strArr2 = new String[jSONArray.length()];
                    for (int i12 = 0; i12 < jSONArray.length(); i12++) {
                        strArr2[i12] = jSONArray.getString(i12);
                    }
                    strArr = strArr2;
                } catch (JSONException unused7) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzj("Malformed demuxed URL list for playback: ".concat(str9));
                    strArr = new String[]{str8};
                }
            }
            if (numValueOf != null) {
                zzcbkVar.zzA(numValueOf.intValue());
            }
            zzcayVarZza2.zzE(str8, strArr);
            return;
        }
        if (str.equals("touchMove")) {
            Context context3 = zzcbkVar.getContext();
            zzcayVarZza2.zzH(zzb(context3, map, "dx", 0), zzb(context3, map, "dy", 0));
            if (this.zza) {
                return;
            }
            zzcbkVar.zzu();
            this.zza = true;
            return;
        }
        if (!str.equals("volume")) {
            if (str.equals("watermark")) {
                zzcayVarZza2.zzn();
                return;
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("Unknown video action: ".concat(str));
                return;
            }
        }
        String str10 = (String) map.get("volume");
        if (str10 == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Level parameter missing from volume video GMSG.");
            return;
        }
        try {
            zzcayVarZza2.zzG(Float.parseFloat(str10));
        } catch (NumberFormatException unused8) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Could not parse volume parameter from volume video GMSG: ".concat(str10));
        }
    }
}
