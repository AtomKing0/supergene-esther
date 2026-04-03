package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbsk extends RemoteCreator {
    public zzbsk() {
        super("com.google.android.gms.ads.AdOverlayCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        return iInterfaceQueryLocalInterface instanceof zzbsq ? (zzbsq) iInterfaceQueryLocalInterface : new zzbso(iBinder);
    }

    @Nullable
    public final zzbsn zza(Activity activity) {
        try {
            IBinder iBinderZze = ((zzbsq) getRemoteCreatorInstance(activity)).zze(ObjectWrapper.wrap(activity));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
            return iInterfaceQueryLocalInterface instanceof zzbsn ? (zzbsn) iInterfaceQueryLocalInterface : new zzbsl(iBinderZze);
        } catch (RemoteException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not create remote AdOverlay.", e10);
            return null;
        } catch (RemoteCreator.RemoteCreatorException e11) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not create remote AdOverlay.", e11);
            return null;
        }
    }
}
