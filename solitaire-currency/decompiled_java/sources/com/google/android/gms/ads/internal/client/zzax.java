package com.google.android.gms.ads.internal.client;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import com.google.android.gms.internal.ads.zzbbw;
import com.google.android.gms.internal.ads.zzbdn;
import com.google.android.gms.internal.ads.zzbeb;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
abstract class zzax {

    @Nullable
    private static final zzce zza;

    static {
        zzce zzccVar = null;
        try {
            Object objNewInstance = zzaw.class.getClassLoader().loadClass("com.google.android.gms.ads.internal.ClientApi").getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            if (objNewInstance instanceof IBinder) {
                IBinder iBinder = (IBinder) objNewInstance;
                if (iBinder != null) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IClientApi");
                    zzccVar = iInterfaceQueryLocalInterface instanceof zzce ? (zzce) iInterfaceQueryLocalInterface : new zzcc(iBinder);
                }
            } else {
                com.google.android.gms.ads.internal.util.client.zzm.zzj("ClientApi class is not an instance of IBinder.");
            }
        } catch (Exception unused) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("Failed to instantiate ClientApi class.");
        }
        zza = zzccVar;
    }

    zzax() {
    }

    @Nullable
    private final Object zze() {
        zzce zzceVar = zza;
        if (zzceVar == null) {
            com.google.android.gms.ads.internal.util.client.zzm.zzj("ClientApi class cannot be loaded.");
            return null;
        }
        try {
            return zzb(zzceVar);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot invoke local loader using ClientApi class.", e10);
            return null;
        }
    }

    @Nullable
    private final Object zzf() {
        try {
            return zzc();
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Cannot invoke remote loader.", e10);
            return null;
        }
    }

    @NonNull
    protected abstract Object zza();

    @Nullable
    protected abstract Object zzb(zzce zzceVar) throws RemoteException;

    @Nullable
    protected abstract Object zzc() throws RemoteException;

    public final Object zzd(Context context, boolean z10) {
        boolean z11;
        Object objZze;
        if (!z10) {
            zzay.zzb();
            if (!com.google.android.gms.ads.internal.util.client.zzf.zzt(context, 12451000)) {
                com.google.android.gms.ads.internal.util.client.zzm.zze("Google Play Services is not available.");
                z10 = true;
            }
        }
        boolean z12 = false;
        boolean z13 = !(DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) <= DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
        zzbbw.zza(context);
        if (((Boolean) zzbdn.zza.zze()).booleanValue()) {
            z11 = false;
        } else if (((Boolean) zzbdn.zzb.zze()).booleanValue()) {
            z11 = true;
            z12 = true;
        } else {
            z12 = z10 | z13;
            z11 = false;
        }
        if (z12) {
            objZze = zze();
            if (objZze == null && !z11) {
                objZze = zzf();
            }
        } else {
            Object objZzf = zzf();
            if (objZzf == null) {
                if (zzay.zze().nextInt(((Long) zzbeb.zza.zze()).intValue()) == 0) {
                    Bundle bundle = new Bundle();
                    bundle.putString("action", "dynamite_load");
                    bundle.putInt("is_missing", 1);
                    zzay.zzb().zzo(context, zzay.zzc().afmaVersion, "gmob-apps", bundle, true);
                }
            }
            objZze = objZzf == null ? zze() : objZzf;
        }
        return objZze == null ? zza() : objZze;
    }
}
