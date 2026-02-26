package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.common.util.concurrent.m;
import com.ironsource.w8;
import com.king.amp.sa.AbmAdPlayer;
import com.king.usdk.localnotification.NotificationSchedulerKeys;
import com.unity3d.ads.core.data.datasource.AndroidDynamicDeviceInfoDataSource;
import io.sentry.protocol.DebugMeta;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzdme {
    private final Context zza;
    private final zzdln zzb;
    private final zzauo zzc;
    private final VersionInfoParcel zzd;
    private final com.google.android.gms.ads.internal.zza zze;
    private final zzbav zzf;
    private final Executor zzg;
    private final zzbes zzh;
    private final zzdmw zzi;
    private final zzdpl zzj;
    private final ScheduledExecutorService zzk;
    private final zzdog zzl;
    private final zzdsk zzm;
    private final zzfll zzn;
    private final zzedh zzo;
    private final zzeds zzp;
    private final zzffk zzq;

    public zzdme(Context context, zzdln zzdlnVar, zzauo zzauoVar, VersionInfoParcel versionInfoParcel, com.google.android.gms.ads.internal.zza zzaVar, zzbav zzbavVar, Executor executor, zzffg zzffgVar, zzdmw zzdmwVar, zzdpl zzdplVar, ScheduledExecutorService scheduledExecutorService, zzdsk zzdskVar, zzfll zzfllVar, zzedh zzedhVar, zzdog zzdogVar, zzeds zzedsVar, zzffk zzffkVar) {
        this.zza = context;
        this.zzb = zzdlnVar;
        this.zzc = zzauoVar;
        this.zzd = versionInfoParcel;
        this.zze = zzaVar;
        this.zzf = zzbavVar;
        this.zzg = executor;
        this.zzh = zzffgVar.zzi;
        this.zzi = zzdmwVar;
        this.zzj = zzdplVar;
        this.zzk = scheduledExecutorService;
        this.zzm = zzdskVar;
        this.zzn = zzfllVar;
        this.zzo = zzedhVar;
        this.zzl = zzdogVar;
        this.zzp = zzedsVar;
        this.zzq = zzffkVar;
    }

    @Nullable
    public static final com.google.android.gms.ads.internal.client.zzel zzi(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject2 == null || (jSONObjectOptJSONObject = jSONObjectOptJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzr(jSONObjectOptJSONObject);
    }

    public static final List zzj(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mute");
        if (jSONObjectOptJSONObject == null) {
            return zzfxr.zzm();
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("reasons");
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzfxr.zzm();
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < jSONArrayOptJSONArray.length(); i10++) {
            com.google.android.gms.ads.internal.client.zzel zzelVarZzr = zzr(jSONArrayOptJSONArray.optJSONObject(i10));
            if (zzelVarZzr != null) {
                arrayList.add(zzelVarZzr);
            }
        }
        return zzfxr.zzk(arrayList);
    }

    private final com.google.android.gms.ads.internal.client.zzq zzk(int i10, int i11) {
        if (i10 == 0) {
            if (i11 == 0) {
                return com.google.android.gms.ads.internal.client.zzq.zzc();
            }
            i10 = 0;
        }
        return new com.google.android.gms.ads.internal.client.zzq(this.zza, new AdSize(i10, i11));
    }

    private static m zzl(m mVar, Object obj) {
        final Object obj2 = null;
        return zzgcj.zzf(mVar, Exception.class, new zzgbq(obj2) { // from class: com.google.android.gms.internal.ads.zzdmc
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj3) {
                com.google.android.gms.ads.internal.util.zze.zzb("Error during loading assets.", (Exception) obj3);
                return zzgcj.zzh(null);
            }
        }, zzbzo.zzf);
    }

    private static m zzm(boolean z10, final m mVar, Object obj) {
        return z10 ? zzgcj.zzn(mVar, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdmd
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj2) {
                return obj2 != null ? mVar : zzgcj.zzg(new zzeir(1, "Retrieve required value in native ad response failed."));
            }
        }, zzbzo.zzf) : zzl(mVar, null);
    }

    private final m zzn(@Nullable JSONObject jSONObject, boolean z10) {
        if (jSONObject == null) {
            return zzgcj.zzh(null);
        }
        final String strOptString = jSONObject.optString("url");
        if (TextUtils.isEmpty(strOptString)) {
            return zzgcj.zzh(null);
        }
        final double dOptDouble = jSONObject.optDouble("scale", 1.0d);
        boolean zOptBoolean = jSONObject.optBoolean("is_transparent", true);
        final int iOptInt = jSONObject.optInt("width", -1);
        final int iOptInt2 = jSONObject.optInt("height", -1);
        if (z10) {
            return zzgcj.zzh(new zzbeq(null, Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2));
        }
        return zzm(jSONObject.optBoolean("require"), zzgcj.zzm(this.zzb.zzb(strOptString, dOptDouble, zOptBoolean), new zzful() { // from class: com.google.android.gms.internal.ads.zzdlu
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return new zzbeq(new BitmapDrawable(Resources.getSystem(), (Bitmap) obj), Uri.parse(strOptString), dOptDouble, iOptInt, iOptInt2);
            }
        }, this.zzg), null);
    }

    private final m zzo(@Nullable JSONArray jSONArray, boolean z10, boolean z11) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzgcj.zzh(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z11 ? jSONArray.length() : 1;
        for (int i10 = 0; i10 < length; i10++) {
            arrayList.add(zzn(jSONArray.optJSONObject(i10), z10));
        }
        return zzgcj.zzm(zzgcj.zzd(arrayList), new zzful() { // from class: com.google.android.gms.internal.ads.zzdlz
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                ArrayList arrayList2 = new ArrayList();
                for (zzbeq zzbeqVar : (List) obj) {
                    if (zzbeqVar != null) {
                        arrayList2.add(zzbeqVar);
                    }
                }
                return arrayList2;
            }
        }, this.zzg);
    }

    private final m zzp(JSONObject jSONObject, zzfel zzfelVar, zzfeo zzfeoVar) {
        final m mVarZzb = this.zzi.zzb(jSONObject.optString("base_url"), jSONObject.optString(AbmAdPlayer.HTML), zzfelVar, zzfeoVar, zzk(jSONObject.optInt("width", 0), jSONObject.optInt("height", 0)));
        return zzgcj.zzn(mVarZzb, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlv
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) throws zzeir {
                zzcej zzcejVar = (zzcej) obj;
                if (zzcejVar == null || zzcejVar.zzq() == null) {
                    throw new zzeir(1, "Retrieve video view in html5 ad response failed.");
                }
                return mVarZzb;
            }
        }, zzbzo.zzf);
    }

    @Nullable
    private static Integer zzq(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt(AndroidDynamicDeviceInfoDataSource.DIRECTORY_MODE_READ), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    @Nullable
    private static final com.google.android.gms.ads.internal.client.zzel zzr(@Nullable JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String strOptString = jSONObject.optString("reason");
        String strOptString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(strOptString) || TextUtils.isEmpty(strOptString2)) {
            return null;
        }
        return new com.google.android.gms.ads.internal.client.zzel(strOptString, strOptString2);
    }

    final /* synthetic */ zzben zza(JSONObject jSONObject, List list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        String strOptString = jSONObject.optString("text");
        Integer numZzq = zzq(jSONObject, "bg_color");
        Integer numZzq2 = zzq(jSONObject, NotificationSchedulerKeys.KEY_TEXT_COLOR);
        int iOptInt = jSONObject.optInt("text_size", -1);
        boolean zOptBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int iOptInt2 = jSONObject.optInt("animation_ms", 1000);
        return new zzben(strOptString, list, numZzq, numZzq2, iOptInt > 0 ? Integer.valueOf(iOptInt) : null, jSONObject.optInt("presentation_ms", 4000) + iOptInt2, this.zzh.zze, zOptBoolean);
    }

    final /* synthetic */ m zzb(com.google.android.gms.ads.internal.client.zzq zzqVar, zzfel zzfelVar, zzfeo zzfeoVar, String str, String str2, Object obj) throws Exception {
        zzcej zzcejVarZza = this.zzj.zza(zzqVar, zzfelVar, zzfeoVar);
        final zzbzs zzbzsVarZza = zzbzs.zza(zzcejVarZza);
        zzdod zzdodVarZzb = this.zzl.zzb();
        zzcejVarZza.zzN().zzR(zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, zzdodVarZzb, false, null, new com.google.android.gms.ads.internal.zzb(this.zza, null, null), null, null, this.zzo, this.zzn, this.zzm, null, zzdodVarZzb, null, null, null, null);
        zzcejVarZza.zzag("/getNativeAdViewSignals", zzbiw.zzs);
        zzcejVarZza.zzag("/getNativeClickMeta", zzbiw.zzt);
        zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdly
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z10, int i10, String str3, String str4) {
                zzbzs zzbzsVar = zzbzsVarZza;
                if (z10) {
                    zzbzsVar.zzb();
                    return;
                }
                zzbzsVar.zzd(new zzeir(1, "Image Web View failed to load. Error code: " + i10 + ", Description: " + str3 + ", Failing URL: " + str4));
            }
        });
        zzcejVarZza.zzae(str, str2, null);
        return zzbzsVarZza;
    }

    final /* synthetic */ m zzc(String str, Object obj) throws Exception {
        com.google.android.gms.ads.internal.zzu.zzz();
        zzcej zzcejVarZza = zzcew.zza(this.zza, zzcgd.zza(), "native-omid", false, false, this.zzc, null, this.zzd, null, null, this.zze, this.zzf, null, null, this.zzp, this.zzq);
        final zzbzs zzbzsVarZza = zzbzs.zza(zzcejVarZza);
        zzcejVarZza.zzN().zzB(new zzcfz() { // from class: com.google.android.gms.internal.ads.zzdma
            @Override // com.google.android.gms.internal.ads.zzcfz
            public final void zza(boolean z10, int i10, String str2, String str3) {
                zzbzsVarZza.zzb();
            }
        });
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzeE)).booleanValue()) {
            zzcejVarZza.loadData(Base64.encodeToString(str.getBytes(), 1), "text/html", "base64");
        } else {
            zzcejVarZza.loadData(str, "text/html", "UTF-8");
        }
        return zzbzsVarZza;
    }

    public final m zzd(JSONObject jSONObject, String str) {
        final JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(w8.f16020c);
        if (jSONObjectOptJSONObject == null) {
            return zzgcj.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray(DebugMeta.JsonKeys.IMAGES);
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("image");
        if (jSONArrayOptJSONArray == null && jSONObjectOptJSONObject2 != null) {
            jSONArrayOptJSONArray = new JSONArray();
            jSONArrayOptJSONArray.put(jSONObjectOptJSONObject2);
        }
        return zzm(jSONObjectOptJSONObject.optBoolean("require"), zzgcj.zzm(zzo(jSONArrayOptJSONArray, false, true), new zzful() { // from class: com.google.android.gms.internal.ads.zzdmb
            @Override // com.google.android.gms.internal.ads.zzful
            public final Object apply(Object obj) {
                return this.zza.zza(jSONObjectOptJSONObject, (List) obj);
            }
        }, this.zzg), null);
    }

    public final m zze(JSONObject jSONObject, String str) {
        return zzn(jSONObject.optJSONObject(str), this.zzh.zzb);
    }

    public final m zzf(JSONObject jSONObject, String str) {
        zzbes zzbesVar = this.zzh;
        return zzo(jSONObject.optJSONArray(DebugMeta.JsonKeys.IMAGES), zzbesVar.zzb, zzbesVar.zzd);
    }

    public final m zzg(JSONObject jSONObject, String str, final zzfel zzfelVar, final zzfeo zzfeoVar) {
        if (!((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzjf)).booleanValue()) {
            return zzgcj.zzh(null);
        }
        JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray(DebugMeta.JsonKeys.IMAGES);
        if (jSONArrayOptJSONArray == null || jSONArrayOptJSONArray.length() <= 0) {
            return zzgcj.zzh(null);
        }
        JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(0);
        if (jSONObjectOptJSONObject == null) {
            return zzgcj.zzh(null);
        }
        final String strOptString = jSONObjectOptJSONObject.optString("base_url");
        final String strOptString2 = jSONObjectOptJSONObject.optString(AbmAdPlayer.HTML);
        final com.google.android.gms.ads.internal.client.zzq zzqVarZzk = zzk(jSONObjectOptJSONObject.optInt("width", 0), jSONObjectOptJSONObject.optInt("height", 0));
        if (TextUtils.isEmpty(strOptString2)) {
            return zzgcj.zzh(null);
        }
        final m mVarZzn = zzgcj.zzn(zzgcj.zzh(null), new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlw
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) {
                return this.zza.zzb(zzqVarZzk, zzfelVar, zzfeoVar, strOptString, strOptString2, obj);
            }
        }, zzbzo.zze);
        return zzgcj.zzn(mVarZzn, new zzgbq() { // from class: com.google.android.gms.internal.ads.zzdlx
            @Override // com.google.android.gms.internal.ads.zzgbq
            public final m zza(Object obj) throws zzeir {
                if (((zzcej) obj) != null) {
                    return mVarZzn;
                }
                throw new zzeir(1, "Retrieve Web View from image ad response failed.");
            }
        }, zzbzo.zzf);
    }

    public final m zzh(JSONObject jSONObject, zzfel zzfelVar, zzfeo zzfeoVar) {
        m mVarZza;
        JSONObject jSONObjectZzh = com.google.android.gms.ads.internal.util.zzbs.zzh(jSONObject, "html_containers", "instream");
        if (jSONObjectZzh != null) {
            return zzp(jSONObjectZzh, zzfelVar, zzfeoVar);
        }
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("video");
        if (jSONObjectOptJSONObject == null) {
            return zzgcj.zzh(null);
        }
        String strOptString = jSONObjectOptJSONObject.optString("vast_xml");
        boolean z10 = false;
        if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzje)).booleanValue() && jSONObjectOptJSONObject.has(AbmAdPlayer.HTML)) {
            z10 = true;
        }
        if (!TextUtils.isEmpty(strOptString)) {
            if (!z10) {
                mVarZza = this.zzi.zza(jSONObjectOptJSONObject);
            }
            return zzl(zzgcj.zzo(mVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdt)).intValue(), TimeUnit.SECONDS, this.zzk), null);
        }
        if (!z10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Required field 'vast_xml' or 'html' is missing");
            return zzgcj.zzh(null);
        }
        mVarZza = zzp(jSONObjectOptJSONObject, zzfelVar, zzfeoVar);
        return zzl(zzgcj.zzo(mVarZza, ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzdt)).intValue(), TimeUnit.SECONDS, this.zzk), null);
    }
}
