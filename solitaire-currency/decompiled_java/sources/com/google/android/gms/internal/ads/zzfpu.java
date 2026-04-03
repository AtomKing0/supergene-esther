package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.util.Base64;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.media3.common.PlaybackException;
import com.ironsource.tj;
import com.ironsource.v8;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzfpu implements zzfok {
    private final Object zza;
    private final zzfpv zzb;
    private final zzfqg zzc;
    private final zzfoh zzd;

    zzfpu(@NonNull Object obj, @NonNull zzfpv zzfpvVar, @NonNull zzfqg zzfqgVar, @NonNull zzfoh zzfohVar) {
        this.zza = obj;
        this.zzb = zzfpvVar;
        this.zzc = zzfqgVar;
        this.zzd = zzfohVar;
    }

    @Nullable
    private static String zzi(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        zzasv zzasvVarZza = zzasw.zza();
        zzasvVarZza.zzc(5);
        zzasvVarZza.zza(zzgwm.zzv(bArr, 0, bArr.length));
        return Base64.encodeToString(((zzasw) zzasvVarZza.zzbr()).zzaV(), 11);
    }

    @Nullable
    private final synchronized byte[] zzj(Map map, Map map2) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
        } catch (Exception e10) {
            this.zzd.zzc(2007, System.currentTimeMillis() - jCurrentTimeMillis, e10);
            return null;
        }
        return (byte[]) this.zza.getClass().getDeclaredMethod("xss", Map.class, Map.class).invoke(this.zza, null, map2);
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    @Nullable
    public final synchronized String zza(Context context, String str, String str2, View view, Activity activity) {
        Map mapZza;
        mapZza = this.zzc.zza();
        mapZza.put("f", "c");
        mapZza.put("ctx", context);
        mapZza.put("cs", str2);
        mapZza.put(tj.f15401b, null);
        mapZza.put("view", view);
        mapZza.put("act", activity);
        return zzi(zzj(null, mapZza));
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    @Nullable
    public final synchronized String zzb(Context context, String str, View view, Activity activity) {
        Map mapZzc;
        mapZzc = this.zzc.zzc();
        mapZzc.put("f", "v");
        mapZzc.put("ctx", context);
        mapZzc.put(tj.f15401b, null);
        mapZzc.put("view", view);
        mapZzc.put("act", activity);
        return zzi(zzj(null, mapZzc));
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    @Nullable
    public final synchronized String zzc(Context context, String str) {
        Map mapZzb;
        mapZzb = this.zzc.zzb();
        mapZzb.put("f", "q");
        mapZzb.put("ctx", context);
        mapZzb.put(tj.f15401b, null);
        return zzi(zzj(null, mapZzb));
    }

    @Override // com.google.android.gms.internal.ads.zzfok
    public final synchronized void zzd(String str, MotionEvent motionEvent) throws zzfqe {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            HashMap map = new HashMap();
            map.put("t", new Throwable());
            map.put(tj.f15401b, null);
            map.put("evt", motionEvent);
            this.zza.getClass().getDeclaredMethod("he", Map.class).invoke(this.zza, map);
            this.zzd.zzd(PlaybackException.ERROR_CODE_PARSING_CONTAINER_UNSUPPORTED, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e10) {
            throw new zzfqe(2005, e10);
        }
    }

    public final synchronized int zze() throws zzfqe {
        try {
        } catch (Exception e10) {
            throw new zzfqe(2006, e10);
        }
        return ((Integer) this.zza.getClass().getDeclaredMethod("lcs", new Class[0]).invoke(this.zza, new Object[0])).intValue();
    }

    final zzfpv zzf() {
        return this.zzb;
    }

    public final synchronized void zzg() throws zzfqe {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            this.zza.getClass().getDeclaredMethod("close", new Class[0]).invoke(this.zza, new Object[0]);
            this.zzd.zzd(3001, System.currentTimeMillis() - jCurrentTimeMillis);
        } catch (Exception e10) {
            throw new zzfqe(2003, e10);
        }
    }

    final synchronized boolean zzh() throws zzfqe {
        try {
        } catch (Exception e10) {
            throw new zzfqe(2001, e10);
        }
        return ((Boolean) this.zza.getClass().getDeclaredMethod(v8.a.f15678e, new Class[0]).invoke(this.zza, new Object[0])).booleanValue();
    }
}
