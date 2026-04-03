package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.util.ArrayList;
import java.util.Objects;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbna {
    private final Context zzb;
    private final String zzc;
    private final VersionInfoParcel zzd;

    @Nullable
    private final zzfki zze;
    private final com.google.android.gms.ads.internal.util.zzbd zzf;
    private final com.google.android.gms.ads.internal.util.zzbd zzg;

    @Nullable
    private zzbmz zzh;
    private final Object zza = new Object();
    private int zzi = 1;

    public zzbna(Context context, VersionInfoParcel versionInfoParcel, String str, com.google.android.gms.ads.internal.util.zzbd zzbdVar, com.google.android.gms.ads.internal.util.zzbd zzbdVar2, @Nullable zzfki zzfkiVar) {
        this.zzc = str;
        this.zzb = context.getApplicationContext();
        this.zzd = versionInfoParcel;
        this.zze = zzfkiVar;
        this.zzf = zzbdVar;
        this.zzg = zzbdVar2;
    }

    public final zzbmu zzb(@Nullable zzauo zzauoVar) {
        com.google.android.gms.ads.internal.util.zze.zza("getEngine: Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("getEngine: Lock acquired");
            com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Trying to acquire lock");
            synchronized (this.zza) {
                com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock acquired");
                zzbmz zzbmzVar = this.zzh;
                if (zzbmzVar != null && this.zzi == 0) {
                    zzbmzVar.zzj(new zzbzx() { // from class: com.google.android.gms.internal.ads.zzbmg
                        @Override // com.google.android.gms.internal.ads.zzbzx
                        public final void zza(Object obj) {
                            this.zza.zzk((zzblv) obj);
                        }
                    }, new zzbzv() { // from class: com.google.android.gms.internal.ads.zzbmh
                        @Override // com.google.android.gms.internal.ads.zzbzv
                        public final void zza() {
                        }
                    });
                }
            }
            com.google.android.gms.ads.internal.util.zze.zza("refreshIfDestroyed: Lock released");
            zzbmz zzbmzVar2 = this.zzh;
            if (zzbmzVar2 != null && zzbmzVar2.zze() != -1) {
                int i10 = this.zzi;
                if (i10 == 0) {
                    com.google.android.gms.ads.internal.util.zze.zza("getEngine (NO_UPDATE): Lock released");
                    return this.zzh.zza();
                }
                if (i10 != 1) {
                    com.google.android.gms.ads.internal.util.zze.zza("getEngine (UPDATING): Lock released");
                    return this.zzh.zza();
                }
                this.zzi = 2;
                zzd(null);
                com.google.android.gms.ads.internal.util.zze.zza("getEngine (PENDING_UPDATE): Lock released");
                return this.zzh.zza();
            }
            this.zzi = 2;
            this.zzh = zzd(null);
            com.google.android.gms.ads.internal.util.zze.zza("getEngine (NULL or REJECTED): Lock released");
            return this.zzh.zza();
        }
    }

    protected final zzbmz zzd(@Nullable zzauo zzauoVar) {
        zzfju zzfjuVarZza = zzfjt.zza(this.zzb, 6);
        zzfjuVarZza.zzi();
        final zzbmz zzbmzVar = new zzbmz(this.zzg);
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before UI_THREAD_EXECUTOR");
        final zzauo zzauoVar2 = null;
        zzbzo.zze.execute(new Runnable(zzauoVar2, zzbmzVar) { // from class: com.google.android.gms.internal.ads.zzbmk
            public final /* synthetic */ zzbmz zzb;

            {
                this.zzb = zzbmzVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zza.zzj(null, this.zzb);
            }
        });
        com.google.android.gms.ads.internal.util.zze.zza("loadNewJavascriptEngine: Promise created");
        zzbmzVar.zzj(new zzbmp(this, zzbmzVar, zzfjuVarZza), new zzbmq(this, zzbmzVar, zzfjuVarZza));
        return zzbmzVar;
    }

    final /* synthetic */ void zzi(zzbmz zzbmzVar, final zzblv zzblvVar, ArrayList arrayList, long j10) {
        com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Trying to acquire lock");
        synchronized (this.zza) {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock acquired");
            if (zzbmzVar.zze() != -1 && zzbmzVar.zze() != 1) {
                if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
                    zzbmzVar.zzh(new TimeoutException("Unable to receive /jsLoaded GMSG."), "SdkJavascriptFactory.loadJavascriptEngine.setLoadedListener");
                } else {
                    zzbmzVar.zzg();
                }
                zzgcu zzgcuVar = zzbzo.zze;
                Objects.requireNonNull(zzblvVar);
                zzgcuVar.execute(new Runnable() { // from class: com.google.android.gms.internal.ads.zzbmi
                    @Override // java.lang.Runnable
                    public final void run() {
                        zzblvVar.zzc();
                    }
                });
                com.google.android.gms.ads.internal.util.zze.zza("Could not receive /jsLoaded in " + String.valueOf(com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzb)) + " ms. JS engine session reference status(onEngLoadedTimeout) is " + zzbmzVar.zze() + ". Update status(onEngLoadedTimeout) is " + this.zzi + ". LoadNewJavascriptEngine(onEngLoadedTimeout) latency is " + String.valueOf(arrayList.get(0)) + " ms. Total latency(onEngLoadedTimeout) is " + (com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis() - j10) + " ms. Rejecting.");
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released");
                return;
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > newEngine.setLoadedListener(postDelayed): Lock released, the promise is already settled");
        }
    }

    final /* synthetic */ void zzj(zzauo zzauoVar, zzbmz zzbmzVar) {
        long jCurrentTimeMillis = com.google.android.gms.ads.internal.zzu.zzB().currentTimeMillis();
        ArrayList arrayList = new ArrayList();
        try {
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before createJavascriptEngine");
            zzbmd zzbmdVar = new zzbmd(this.zzb, this.zzd, null, null);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After createJavascriptEngine");
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before setting new engine loaded listener");
            zzbmdVar.zzk(new zzbmj(this, arrayList, jCurrentTimeMillis, zzbmzVar, zzbmdVar));
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /jsLoaded");
            zzbmdVar.zzq("/jsLoaded", new zzbml(this, jCurrentTimeMillis, zzbmzVar, zzbmdVar));
            com.google.android.gms.ads.internal.util.zzby zzbyVar = new com.google.android.gms.ads.internal.util.zzby();
            zzbmm zzbmmVar = new zzbmm(this, null, zzbmdVar, zzbyVar);
            zzbyVar.zzb(zzbmmVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before registering GmsgHandler for /requestReload");
            zzbmdVar.zzq("/requestReload", zzbmmVar);
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > javascriptPath: ".concat(String.valueOf(this.zzc)));
            if (this.zzc.endsWith(".js")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadJavascript");
                zzbmdVar.zzh(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadJavascript");
            } else if (this.zzc.startsWith("<html>")) {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtml");
                zzbmdVar.zzf(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtml");
            } else {
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before newEngine.loadHtmlWrapper");
                zzbmdVar.zzg(this.zzc);
                com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > After newEngine.loadHtmlWrapper");
            }
            com.google.android.gms.ads.internal.util.zze.zza("loadJavascriptEngine > Before calling ADMOB_UI_HANDLER.postDelayed");
            com.google.android.gms.ads.internal.util.zzt.zza.postDelayed(new zzbmo(this, zzbmzVar, zzbmdVar, arrayList, jCurrentTimeMillis), ((Integer) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzc)).intValue());
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Error creating webview.", th);
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgS)).booleanValue()) {
                zzbmzVar.zzh(th, "SdkJavascriptFactory.loadJavascriptEngine.createJavascriptEngine");
                return;
            }
            if (((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzgU)).booleanValue()) {
                com.google.android.gms.ads.internal.zzu.zzo().zzv(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbmzVar.zzg();
            } else {
                com.google.android.gms.ads.internal.zzu.zzo().zzw(th, "SdkJavascriptFactory.loadJavascriptEngine");
                zzbmzVar.zzg();
            }
        }
    }

    final /* synthetic */ void zzk(zzblv zzblvVar) {
        if (zzblvVar.zzi()) {
            this.zzi = 1;
        }
    }
}
