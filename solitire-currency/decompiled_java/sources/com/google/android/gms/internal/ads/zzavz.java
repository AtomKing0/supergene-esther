package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.View;
import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzavz extends zzaxd {
    private final Activity zzh;
    private final View zzi;

    public zzavz(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11, View view, Activity activity) {
        super(zzavpVar, "GC4CZUnPsyUcm5NrWw7C8gSktjb/gtBCDrSKBLlqImuOnQy7zHyo6XlIzkH3EMVH", "Kx8fghNUQq+sA+EfmK6qh0KjuKvw753ECuaCFV8szVM=", zzaroVar, i10, 62);
        this.zzi = view;
        this.zzh = activity;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        if (this.zzi == null) {
            return;
        }
        boolean zBooleanValue = ((Boolean) com.google.android.gms.ads.internal.client.zzba.zzc().zza(zzbbw.zzcp)).booleanValue();
        Object[] objArr = (Object[]) this.zze.invoke(null, this.zzi, this.zzh, Boolean.valueOf(zBooleanValue));
        synchronized (this.zzd) {
            this.zzd.zzc(((Long) objArr[0]).longValue());
            this.zzd.zze(((Long) objArr[1]).longValue());
            if (zBooleanValue) {
                this.zzd.zzd((String) objArr[2]);
            }
        }
    }
}
