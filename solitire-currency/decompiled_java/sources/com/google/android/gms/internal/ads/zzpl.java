package com.google.android.gms.internal.ads;

import android.media.AudioDeviceInfo;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzpl {
    int zza(zzaf zzafVar);

    long zzb(boolean z10);

    zzbq zzc();

    zzoq zzd(zzaf zzafVar);

    void zze(zzaf zzafVar, int i10, @Nullable int[] iArr) throws zzpg;

    void zzf();

    void zzg();

    void zzh();

    void zzi();

    void zzj() throws zzpk;

    void zzk();

    void zzl();

    void zzm(zzh zzhVar);

    void zzn(int i10);

    void zzo(zzi zziVar);

    void zzp(zzpi zzpiVar);

    @RequiresApi(29)
    void zzq(int i10, int i11);

    void zzr(zzbq zzbqVar);

    void zzs(@Nullable zznz zznzVar);

    @RequiresApi(23)
    void zzt(@Nullable AudioDeviceInfo audioDeviceInfo);

    void zzu(boolean z10);

    void zzv(float f10);

    boolean zzw(ByteBuffer byteBuffer, long j10, int i10) throws zzpk, zzph;

    boolean zzx();

    boolean zzy();

    boolean zzz(zzaf zzafVar);
}
