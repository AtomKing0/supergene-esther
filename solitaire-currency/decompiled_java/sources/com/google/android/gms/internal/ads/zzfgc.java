package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.RemoteException;
import androidx.annotation.GuardedBy;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfgc {

    @GuardedBy("LiteSdkInfoRetriever.class")
    private static zzfgc zza;
    private final Context zzb;
    private final com.google.android.gms.ads.internal.client.zzcl zzc;
    private final AtomicReference zzd = new AtomicReference();

    @VisibleForTesting
    zzfgc(Context context, com.google.android.gms.ads.internal.client.zzcl zzclVar) {
        this.zzb = context;
        this.zzc = zzclVar;
    }

    @VisibleForTesting
    static com.google.android.gms.ads.internal.client.zzcl zza(Context context) {
        try {
            return com.google.android.gms.ads.internal.client.zzck.asInterface((IBinder) context.getClassLoader().loadClass("com.google.android.gms.ads.internal.client.LiteSdkInfo").getConstructor(Context.class).newInstance(context));
        } catch (ClassCastException | ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzh("Failed to retrieve lite SDK info.", e10);
            return null;
        }
    }

    public static zzfgc zzd(Context context) {
        synchronized (zzfgc.class) {
            zzfgc zzfgcVar = zza;
            if (zzfgcVar != null) {
                return zzfgcVar;
            }
            Context applicationContext = context.getApplicationContext();
            long jLongValue = ((Long) zzbdt.zzb.zze()).longValue();
            com.google.android.gms.ads.internal.client.zzcl zzclVarZza = null;
            if (jLongValue > 0 && jLongValue <= 242402501) {
                zzclVarZza = zza(applicationContext);
            }
            zzfgc zzfgcVar2 = new zzfgc(applicationContext, zzclVarZza);
            zza = zzfgcVar2;
            return zzfgcVar2;
        }
    }

    private final com.google.android.gms.ads.internal.client.zzen zzg() {
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar != null) {
            try {
                return zzclVar.getLiteSdkVersion();
            } catch (RemoteException unused) {
            }
        }
        return null;
    }

    public final zzbom zzb() {
        return (zzbom) this.zzd.get();
    }

    public final VersionInfoParcel zzc(int i10, boolean z10, int i11) {
        com.google.android.gms.ads.internal.client.zzen zzenVarZzg;
        com.google.android.gms.ads.internal.zzu.zzp();
        boolean zZzE = com.google.android.gms.ads.internal.util.zzt.zzE(this.zzb);
        VersionInfoParcel versionInfoParcel = new VersionInfoParcel(242402000, i11, true, zZzE);
        return (((Boolean) zzbdt.zzc.zze()).booleanValue() && (zzenVarZzg = zzg()) != null) ? new VersionInfoParcel(242402000, zzenVarZzg.zza(), true, zZzE) : versionInfoParcel;
    }

    public final String zze() {
        com.google.android.gms.ads.internal.client.zzen zzenVarZzg = zzg();
        if (zzenVarZzg != null) {
            return zzenVarZzg.zzb();
        }
        return null;
    }

    public final void zzf(zzbom zzbomVar) {
        zzbom adapterCreator;
        if (!((Boolean) zzbdt.zza.zze()).booleanValue()) {
            zzfgb.zza(this.zzd, null, zzbomVar);
            return;
        }
        com.google.android.gms.ads.internal.client.zzcl zzclVar = this.zzc;
        if (zzclVar == null) {
            adapterCreator = null;
        } else {
            try {
                adapterCreator = zzclVar.getAdapterCreator();
            } catch (RemoteException unused) {
                adapterCreator = null;
            }
        }
        AtomicReference atomicReference = this.zzd;
        if (adapterCreator != null) {
            zzbomVar = adapterCreator;
        }
        zzfgb.zza(atomicReference, null, zzbomVar);
    }
}
