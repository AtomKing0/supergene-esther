package com.google.android.gms.games.internal.experience;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.Game;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@VisibleForTesting
public interface ExperienceEvent extends Freezable<ExperienceEvent>, Parcelable {
    @NonNull
    @KeepName
    @Deprecated
    String getIconImageUrl();

    int zza();

    int zzb();

    long zzc();

    long zzd();

    long zze();

    @NonNull
    Uri zzf();

    @NonNull
    Game zzg();

    @NonNull
    String zzh();

    @NonNull
    String zzi();

    @NonNull
    String zzj();
}
