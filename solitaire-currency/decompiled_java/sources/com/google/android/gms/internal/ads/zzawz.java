package com.google.android.gms.internal.ads;

import java.lang.reflect.InvocationTargetException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawz extends zzaxd {
    public zzawz(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11) {
        super(zzavpVar, "5HcA415u1KU8m2yVlDZBhQQK+0IFNRmmWPxuAq0DnfPzSdJ/uWlnYMD1kKfkH6cZ", "u7Ufq5yuXkEXg69T8jpWuOOX55Q9g2DSVI1gtbNUvY8=", zzaroVar, i10, 48);
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzag(3);
        boolean zBooleanValue = ((Boolean) this.zze.invoke(null, this.zza.zzb())).booleanValue();
        synchronized (this.zzd) {
            if (zBooleanValue) {
                this.zzd.zzag(2);
            } else {
                this.zzd.zzag(1);
            }
        }
    }
}
