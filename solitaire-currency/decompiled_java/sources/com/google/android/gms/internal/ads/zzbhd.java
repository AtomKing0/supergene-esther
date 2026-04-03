package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.RemoteException;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzbhd extends RemoteCreator {
    @VisibleForTesting
    public zzbhd() {
        super("com.google.android.gms.ads.NativeAdViewHolderDelegateCreatorImpl");
    }

    @Override // com.google.android.gms.dynamic.RemoteCreator
    protected final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegateCreator");
        return iInterfaceQueryLocalInterface instanceof zzbfq ? (zzbfq) iInterfaceQueryLocalInterface : new zzbfo(iBinder);
    }

    @Nullable
    public final zzbfn zza(View view, HashMap map, HashMap map2) {
        try {
            IBinder iBinderZze = ((zzbfq) getRemoteCreatorInstance(view.getContext())).zze(ObjectWrapper.wrap(view), ObjectWrapper.wrap(map), ObjectWrapper.wrap(map2));
            if (iBinderZze == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinderZze.queryLocalInterface("com.google.android.gms.ads.internal.formats.client.INativeAdViewHolderDelegate");
            return iInterfaceQueryLocalInterface instanceof zzbfn ? (zzbfn) iInterfaceQueryLocalInterface : new zzbfl(iBinderZze);
        } catch (RemoteException | RemoteCreator.RemoteCreatorException e10) {
            com.google.android.gms.ads.internal.util.client.zzm.zzk("Could not create remote NativeAdViewHolderDelegate.", e10);
            return null;
        }
    }
}
