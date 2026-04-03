package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.Looper;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import androidx.media3.common.MimeTypes;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.common.util.concurrent.m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbxg implements zzbxl {
    public static final /* synthetic */ int zzb = 0;
    private static final List zzc = Collections.synchronizedList(new ArrayList());

    @VisibleForTesting
    boolean zza;
    private final zzhbz zzd;
    private final LinkedHashMap zze;
    private final Context zzh;
    private final zzbxi zzi;
    private final List zzf = new ArrayList();
    private final List zzg = new ArrayList();
    private final Object zzj = new Object();
    private HashSet zzk = new HashSet();
    private boolean zzl = false;
    private boolean zzm = false;

    public zzbxg(Context context, VersionInfoParcel versionInfoParcel, zzbxi zzbxiVar, @Nullable String str, zzbxh zzbxhVar) {
        Preconditions.checkNotNull(zzbxiVar, "SafeBrowsing config is not present.");
        this.zzh = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zze = new LinkedHashMap();
        this.zzi = zzbxiVar;
        Iterator it = zzbxiVar.zze.iterator();
        while (it.hasNext()) {
            this.zzk.add(((String) it.next()).toLowerCase(Locale.ENGLISH));
        }
        this.zzk.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzhbz zzhbzVarZzc = zzhdy.zzc();
        zzhbzVarZzc.zzn(9);
        zzhbzVarZzc.zzj(str);
        zzhbzVarZzc.zzh(str);
        zzhca zzhcaVarZzc = zzhcb.zzc();
        String str2 = this.zzi.zza;
        if (str2 != null) {
            zzhcaVarZzc.zza(str2);
        }
        zzhbzVarZzc.zzg((zzhcb) zzhcaVarZzc.zzbr());
        zzhdp zzhdpVarZzc = zzhdq.zzc();
        zzhdpVarZzc.zzc(Wrappers.packageManager(this.zzh).isCallerInstantApp());
        String str3 = versionInfoParcel.afmaVersion;
        if (str3 != null) {
            zzhdpVarZzc.zza(str3);
        }
        long apkVersion = GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzh);
        if (apkVersion > 0) {
            zzhdpVarZzc.zzb(apkVersion);
        }
        zzhbzVarZzc.zzf((zzhdq) zzhdpVarZzc.zzbr());
        this.zzd = zzhbzVarZzc;
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final zzbxi zza() {
        return this.zzi;
    }

    final /* synthetic */ m zzb(Map map) throws Exception {
        zzhdn zzhdnVar;
        m mVarZzm;
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray jSONArrayOptJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (jSONArrayOptJSONArray != null) {
                        synchronized (this.zzj) {
                            int length = jSONArrayOptJSONArray.length();
                            synchronized (this.zzj) {
                                zzhdnVar = (zzhdn) this.zze.get(str);
                            }
                            if (zzhdnVar == null) {
                                zzbxk.zza("Cannot find the corresponding resource object for " + str);
                            } else {
                                for (int i10 = 0; i10 < length; i10++) {
                                    zzhdnVar.zza(jSONArrayOptJSONArray.getJSONObject(i10).getString("threat_type"));
                                }
                                this.zza = (length > 0) | this.zza;
                            }
                        }
                    }
                }
            } catch (JSONException e10) {
                if (((Boolean) zzbea.zza.zze()).booleanValue()) {
                    com.google.android.gms.ads.internal.util.client.zzm.zzf("Failed to get SafeBrowsing metadata", e10);
                }
                return zzgcj.zzg(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zza) {
            synchronized (this.zzj) {
                this.zzd.zzn(10);
            }
        }
        boolean z10 = this.zza;
        if (!(z10 && this.zzi.zzg) && (!(this.zzm && this.zzi.zzf) && (z10 || !this.zzi.zzd))) {
            return zzgcj.zzh(null);
        }
        synchronized (this.zzj) {
            Iterator it = this.zze.values().iterator();
            while (it.hasNext()) {
                this.zzd.zzc((zzhdo) ((zzhdn) it.next()).zzbr());
            }
            this.zzd.zza(this.zzf);
            this.zzd.zzb(this.zzg);
            if (zzbxk.zzb()) {
                StringBuilder sb = new StringBuilder("Sending SB report\n  url: " + this.zzd.zzl() + "\n  clickUrl: " + this.zzd.zzk() + "\n  resources: \n");
                for (zzhdo zzhdoVar : this.zzd.zzm()) {
                    sb.append("    [");
                    sb.append(zzhdoVar.zzc());
                    sb.append("] ");
                    sb.append(zzhdoVar.zzf());
                }
                zzbxk.zza(sb.toString());
            }
            m mVarZzb = new com.google.android.gms.ads.internal.util.zzbo(this.zzh).zzb(1, this.zzi.zzb, null, ((zzhdy) this.zzd.zzbr()).zzaV());
            if (zzbxk.zzb()) {
                mVarZzb.addListener(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxd
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzbxk.zza("Pinged SB successfully.");
                    }
                }, zzbzo.zza);
            }
            mVarZzm = zzgcj.zzm(mVarZzb, new zzful() { // from class: com.google.android.gms.internal.ads.zzbxe
                @Override // com.google.android.gms.internal.ads.zzful
                public final Object apply(Object obj) {
                    int i11 = zzbxg.zzb;
                    return null;
                }
            }, zzbzo.zzf);
        }
        return mVarZzm;
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzd(String str, Map map, int i10) {
        synchronized (this.zzj) {
            if (i10 == 3) {
                this.zzm = true;
            }
            if (this.zze.containsKey(str)) {
                if (i10 == 3) {
                    ((zzhdn) this.zze.get(str)).zze(4);
                }
                return;
            }
            zzhdn zzhdnVarZzd = zzhdo.zzd();
            int iZza = zzhdm.zza(i10);
            if (iZza != 0) {
                zzhdnVarZzd.zze(iZza);
            }
            zzhdnVarZzd.zzb(this.zze.size());
            zzhdnVarZzd.zzd(str);
            zzhcm zzhcmVarZzc = zzhcp.zzc();
            if (!this.zzk.isEmpty() && map != null) {
                for (Map.Entry entry : map.entrySet()) {
                    String str2 = entry.getKey() != null ? (String) entry.getKey() : "";
                    String str3 = entry.getValue() != null ? (String) entry.getValue() : "";
                    if (this.zzk.contains(str2.toLowerCase(Locale.ENGLISH))) {
                        zzhck zzhckVarZzc = zzhcl.zzc();
                        zzhckVarZzc.zza(zzgwm.zzw(str2));
                        zzhckVarZzc.zzb(zzgwm.zzw(str3));
                        zzhcmVarZzc.zza((zzhcl) zzhckVarZzc.zzbr());
                    }
                }
            }
            zzhdnVarZzd.zzc((zzhcp) zzhcmVarZzc.zzbr());
            this.zze.put(str, zzhdnVarZzd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zze() {
        synchronized (this.zzj) {
            this.zze.keySet();
            m mVarZzh = zzgcj.zzh(Collections.emptyMap());
            zzgbq zzgbqVar = new zzgbq() { // from class: com.google.android.gms.internal.ads.zzbxb
                @Override // com.google.android.gms.internal.ads.zzgbq
                public final m zza(Object obj) {
                    return this.zza.zzb((Map) obj);
                }
            };
            zzgcu zzgcuVar = zzbzo.zzf;
            m mVarZzn = zzgcj.zzn(mVarZzh, zzgbqVar, zzgcuVar);
            m mVarZzo = zzgcj.zzo(mVarZzn, 10L, TimeUnit.SECONDS, zzbzo.zzd);
            zzgcj.zzr(mVarZzn, new zzbxf(this, mVarZzo), zzgcuVar);
            zzc.add(mVarZzo);
        }
    }

    final /* synthetic */ void zzf(Bitmap bitmap) {
        zzgwl zzgwlVarZzt = zzgwm.zzt();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzgwlVarZzt);
        synchronized (this.zzj) {
            zzhbz zzhbzVar = this.zzd;
            zzhdh zzhdhVarZzc = zzhdj.zzc();
            zzhdhVarZzc.zza(zzgwlVarZzt.zzb());
            zzhdhVarZzc.zzb(MimeTypes.IMAGE_PNG);
            zzhdhVarZzc.zzc(2);
            zzhbzVar.zzi((zzhdj) zzhdhVarZzc.zzbr());
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzg(View view) {
        Bitmap bitmapCreateBitmap;
        boolean zIsDrawingCacheEnabled;
        if (this.zzi.zzc && !this.zzl) {
            com.google.android.gms.ads.internal.zzu.zzp();
            final Bitmap bitmap = null;
            if (view != null) {
                try {
                    zIsDrawingCacheEnabled = view.isDrawingCacheEnabled();
                    view.setDrawingCacheEnabled(true);
                    Bitmap drawingCache = view.getDrawingCache();
                    bitmapCreateBitmap = drawingCache != null ? Bitmap.createBitmap(drawingCache) : null;
                } catch (RuntimeException e10) {
                    e = e10;
                    bitmapCreateBitmap = null;
                }
                try {
                    view.setDrawingCacheEnabled(zIsDrawingCacheEnabled);
                } catch (RuntimeException e11) {
                    e = e11;
                    com.google.android.gms.ads.internal.util.client.zzm.zzh("Fail to capture the web view", e);
                }
                if (bitmapCreateBitmap == null) {
                    try {
                        int width = view.getWidth();
                        int height = view.getHeight();
                        if (width == 0 || height == 0) {
                            com.google.android.gms.ads.internal.util.client.zzm.zzj("Width or height of view is zero");
                        } else {
                            Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.RGB_565);
                            Canvas canvas = new Canvas(bitmapCreateBitmap2);
                            view.layout(0, 0, width, height);
                            view.draw(canvas);
                            bitmap = bitmapCreateBitmap2;
                        }
                    } catch (RuntimeException e12) {
                        com.google.android.gms.ads.internal.util.client.zzm.zzh("Fail to capture the webview", e12);
                    }
                } else {
                    bitmap = bitmapCreateBitmap;
                }
            }
            if (bitmap == null) {
                zzbxk.zza("Failed to capture the webview bitmap.");
                return;
            }
            this.zzl = true;
            Runnable runnable = new Runnable() { // from class: com.google.android.gms.internal.ads.zzbxc
                @Override // java.lang.Runnable
                public final void run() {
                    this.zza.zzf(bitmap);
                }
            };
            if (Looper.getMainLooper().getThread() != Thread.currentThread()) {
                runnable.run();
            } else {
                zzbzo.zza.execute(runnable);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final void zzh(String str) {
        synchronized (this.zzj) {
            if (str == null) {
                this.zzd.zzd();
            } else {
                this.zzd.zze(str);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbxl
    public final boolean zzi() {
        return PlatformVersion.isAtLeastKitKat() && this.zzi.zzc && !this.zzl;
    }
}
