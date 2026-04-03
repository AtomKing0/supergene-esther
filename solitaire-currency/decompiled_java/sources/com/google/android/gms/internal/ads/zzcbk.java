package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import androidx.annotation.Nullable;
import com.google.android.gms.ads.internal.util.client.VersionInfoParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@23.3.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface zzcbk extends zzcfv, zzcfy, zzbls {
    Context getContext();

    void setBackgroundColor(int i10);

    void zzA(int i10);

    void zzB(int i10);

    void zzC(zzcfl zzcflVar);

    String zzdi();

    int zzf();

    int zzg();

    int zzh();

    @Nullable
    Activity zzi();

    @Nullable
    com.google.android.gms.ads.internal.zza zzj();

    @Nullable
    zzbci zzk();

    zzbcj zzm();

    VersionInfoParcel zzn();

    @Nullable
    zzcaz zzo();

    @Nullable
    zzccv zzp(String str);

    @Nullable
    zzcfl zzq();

    @Nullable
    String zzr();

    void zzt(String str, zzccv zzccvVar);

    void zzu();

    void zzv(boolean z10, long j10);

    void zzw();

    void zzx(int i10);

    void zzy(int i10);

    void zzz(boolean z10);
}
