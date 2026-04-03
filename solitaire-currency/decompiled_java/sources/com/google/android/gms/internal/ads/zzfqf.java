package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.security.GeneralSecurityException;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqf {
    private static final HashMap zza = new HashMap();
    private final Context zzb;
    private final zzfqg zzc;
    private final zzfoh zzd;
    private final zzfoc zze;

    @Nullable
    private zzfpu zzf;
    private final Object zzg = new Object();

    public zzfqf(@NonNull Context context, @NonNull zzfqg zzfqgVar, @NonNull zzfoh zzfohVar, @NonNull zzfoc zzfocVar) {
        this.zzb = context;
        this.zzc = zzfqgVar;
        this.zzd = zzfohVar;
        this.zze = zzfocVar;
    }

    private final synchronized Class zzd(@NonNull zzfpv zzfpvVar) throws zzfqe {
        String strZzk = zzfpvVar.zza().zzk();
        HashMap map = zza;
        Class cls = (Class) map.get(strZzk);
        if (cls != null) {
            return cls;
        }
        try {
            if (!this.zze.zza(zzfpvVar.zzc())) {
                throw new zzfqe(2026, "VM did not pass signature verification");
            }
            try {
                File fileZzb = zzfpvVar.zzb();
                if (!fileZzb.exists()) {
                    fileZzb.mkdirs();
                }
                Class<?> clsLoadClass = new DexClassLoader(zzfpvVar.zzc().getAbsolutePath(), fileZzb.getAbsolutePath(), null, this.zzb.getClassLoader()).loadClass("com.google.ccc.abuse.droidguard.DroidGuard");
                map.put(strZzk, clsLoadClass);
                return clsLoadClass;
            } catch (ClassNotFoundException | IllegalArgumentException | SecurityException e10) {
                throw new zzfqe(2008, e10);
            }
        } catch (GeneralSecurityException e11) {
            throw new zzfqe(2026, e11);
        }
    }

    @Nullable
    public final zzfok zza() {
        zzfpu zzfpuVar;
        synchronized (this.zzg) {
            zzfpuVar = this.zzf;
        }
        return zzfpuVar;
    }

    @Nullable
    public final zzfpv zzb() {
        synchronized (this.zzg) {
            zzfpu zzfpuVar = this.zzf;
            if (zzfpuVar == null) {
                return null;
            }
            return zzfpuVar.zzf();
        }
    }

    public final boolean zzc(@NonNull zzfpv zzfpvVar) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        try {
            try {
                zzfpu zzfpuVar = new zzfpu(zzd(zzfpvVar).getDeclaredConstructor(Context.class, String.class, byte[].class, Object.class, Bundle.class, Integer.TYPE).newInstance(this.zzb, "msa-r", zzfpvVar.zze(), null, new Bundle(), 2), zzfpvVar, this.zzc, this.zzd);
                if (!zzfpuVar.zzh()) {
                    throw new zzfqe(4000, "init failed");
                }
                int iZze = zzfpuVar.zze();
                if (iZze != 0) {
                    throw new zzfqe(4001, "ci: " + iZze);
                }
                synchronized (this.zzg) {
                    zzfpu zzfpuVar2 = this.zzf;
                    if (zzfpuVar2 != null) {
                        try {
                            zzfpuVar2.zzg();
                        } catch (zzfqe e10) {
                            this.zzd.zzc(e10.zza(), -1L, e10);
                        }
                        this.zzf = zzfpuVar;
                    } else {
                        this.zzf = zzfpuVar;
                    }
                }
                this.zzd.zzd(3000, System.currentTimeMillis() - jCurrentTimeMillis);
                return true;
            } catch (Exception e11) {
                throw new zzfqe(2004, e11);
            }
        } catch (zzfqe e12) {
            this.zzd.zzc(e12.zza(), System.currentTimeMillis() - jCurrentTimeMillis, e12);
            return false;
        } catch (Exception e13) {
            this.zzd.zzc(4010, System.currentTimeMillis() - jCurrentTimeMillis, e13);
            return false;
        }
    }
}
