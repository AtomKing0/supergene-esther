package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.exifinterface.media.ExifInterface;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzawc extends zzaxd {
    private static final zzaxe zzh = new zzaxe();
    private final Context zzi;

    public zzawc(zzavp zzavpVar, String str, String str2, zzaro zzaroVar, int i10, int i11, Context context) {
        super(zzavpVar, "LYoHKR17UvbUNibqKPKJklawQJNaw1zk7CnhZAC68YBTzC7x4MYQVXp9Sihs98Ok", "ngqbGKXcQCvq0ft27xRzOzNoEVN+ei+Vq2+CNx9QQMc=", zzaroVar, i10, 29);
        this.zzi = context;
    }

    @Override // com.google.android.gms.internal.ads.zzaxd
    protected final void zza() throws IllegalAccessException, InvocationTargetException {
        this.zzd.zzn(ExifInterface.LONGITUDE_EAST);
        AtomicReference atomicReferenceZza = zzh.zza(this.zzi.getPackageName());
        if (atomicReferenceZza.get() == null) {
            synchronized (atomicReferenceZza) {
                if (atomicReferenceZza.get() == null) {
                    atomicReferenceZza.set((String) this.zze.invoke(null, this.zzi));
                }
            }
        }
        String str = (String) atomicReferenceZza.get();
        synchronized (this.zzd) {
            this.zzd.zzn(zzasz.zza(str.getBytes(), true));
        }
    }
}
