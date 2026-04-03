package com.google.android.gms.internal.ads;

import io.sentry.protocol.OperatingSystem;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzm implements zzcm {
    public static final /* synthetic */ int zza = 0;

    static {
        zzfvo.zza(new zzfvk() { // from class: com.google.android.gms.internal.ads.zzzk
            @Override // com.google.android.gms.internal.ads.zzfvk
            public final Object zza() {
                int i10 = zzzm.zza;
                try {
                    Class<?> cls = Class.forName("androidx.media3.effect.DefaultVideoFrameProcessor$Factory$Builder");
                    Object objInvoke = cls.getMethod(OperatingSystem.JsonKeys.BUILD, new Class[0]).invoke(cls.getConstructor(new Class[0]).newInstance(new Object[0]), new Object[0]);
                    objInvoke.getClass();
                    return (zzcm) objInvoke;
                } catch (Exception e10) {
                    throw new IllegalStateException(e10);
                }
            }
        });
    }

    private zzzm() {
        throw null;
    }

    /* synthetic */ zzzm(zzzl zzzlVar) {
    }
}
