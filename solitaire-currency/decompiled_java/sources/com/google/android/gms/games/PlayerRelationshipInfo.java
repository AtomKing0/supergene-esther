package com.google.android.gms.games;

import android.os.Parcelable;
import androidx.annotation.Nullable;
import com.google.android.gms.common.data.Freezable;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public interface PlayerRelationshipInfo extends Freezable<PlayerRelationshipInfo>, Parcelable {
    int getFriendStatus();

    @Nullable
    String zza();

    @Nullable
    String zzb();

    @Nullable
    String zzc();
}
