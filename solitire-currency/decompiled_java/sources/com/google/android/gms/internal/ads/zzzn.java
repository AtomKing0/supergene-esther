package com.google.android.gms.internal.ads;

import android.content.Context;
import androidx.media3.common.C;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzzn implements zzbx {
    private final zzcm zza;

    public zzzn(zzcm zzcmVar) {
        this.zza = zzcmVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbx
    public final zzby zza(Context context, zzo zzoVar, zzr zzrVar, zzco zzcoVar, Executor executor, List list, long j10) throws zzcl {
        try {
            Constructor<?> constructor = Class.forName("androidx.media3.effect.PreviewingSingleInputVideoGraph$Factory").getConstructor(zzcm.class);
            Object[] objArr = new Object[1];
            try {
                objArr[0] = this.zza;
                return ((zzbx) constructor.newInstance(objArr)).zza(context, zzoVar, zzrVar, zzcoVar, executor, list, 0L);
            } catch (Exception e10) {
                e = e10;
                if (e instanceof zzcl) {
                    throw ((zzcl) e);
                }
                throw new zzcl(e, C.TIME_UNSET);
            }
        } catch (Exception e11) {
            e = e11;
        }
    }
}
