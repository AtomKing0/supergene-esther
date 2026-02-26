package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.util.Log;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzfqj {

    @VisibleForTesting
    final zzfqm zza;

    @VisibleForTesting
    final boolean zzb;

    private zzfqj(zzfqm zzfqmVar) {
        this.zza = zzfqmVar;
        this.zzb = zzfqmVar != null;
    }

    public static zzfqj zzb(Context context, String str, String str2) {
        zzfqm zzfqkVar;
        try {
            try {
                try {
                    IBinder iBinderInstantiate = DynamiteModule.load(context, DynamiteModule.PREFER_REMOTE, ModuleDescriptor.MODULE_ID).instantiate("com.google.android.gms.gass.internal.clearcut.GassDynamiteClearcutLogger");
                    if (iBinderInstantiate == null) {
                        zzfqkVar = null;
                    } else {
                        IInterface iInterfaceQueryLocalInterface = iBinderInstantiate.queryLocalInterface("com.google.android.gms.gass.internal.clearcut.IGassClearcut");
                        zzfqkVar = iInterfaceQueryLocalInterface instanceof zzfqm ? (zzfqm) iInterfaceQueryLocalInterface : new zzfqk(iBinderInstantiate);
                    }
                    zzfqkVar.zze(ObjectWrapper.wrap(context), str, null);
                    Log.i("GASS", "GassClearcutLogger Initialized.");
                    return new zzfqj(zzfqkVar);
                } catch (Exception e10) {
                    throw new zzfpl(e10);
                }
            } catch (Exception e11) {
                throw new zzfpl(e11);
            }
        } catch (RemoteException | zzfpl | NullPointerException | SecurityException unused) {
            Log.d("GASS", "Cannot dynamite load clearcut");
            return new zzfqj(new zzfqn());
        }
    }

    public static zzfqj zzc() {
        zzfqn zzfqnVar = new zzfqn();
        Log.d("GASS", "Clearcut logging disabled");
        return new zzfqj(zzfqnVar);
    }

    public final zzfqi zza(byte[] bArr) {
        return new zzfqi(this, bArr, null);
    }
}
