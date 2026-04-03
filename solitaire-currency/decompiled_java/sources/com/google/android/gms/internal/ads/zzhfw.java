package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.customtabs.CustomTabsClient;
import androidx.browser.customtabs.CustomTabsServiceConnection;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzhfw extends CustomTabsServiceConnection {
    private final WeakReference zza;

    public zzhfw(zzbct zzbctVar) {
        this.zza = new WeakReference(zzbctVar);
    }

    @Override // androidx.browser.customtabs.CustomTabsServiceConnection
    public final void onCustomTabsServiceConnected(ComponentName componentName, CustomTabsClient customTabsClient) {
        zzbct zzbctVar = (zzbct) this.zza.get();
        if (zzbctVar != null) {
            zzbctVar.zzc(customTabsClient);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzbct zzbctVar = (zzbct) this.zza.get();
        if (zzbctVar != null) {
            zzbctVar.zzd();
        }
    }
}
