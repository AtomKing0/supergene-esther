package com.google.android.gms.games.multiplayer;

import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zza extends zzb {
    zza() {
    }

    @Override // com.google.android.gms.games.multiplayer.zzb, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.multiplayer.zzb
    /* JADX INFO: renamed from: zza */
    public final ParticipantEntity createFromParcel(Parcel parcel) {
        return (GamesDowngradeableSafeParcel.zzo(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(ParticipantEntity.class.getCanonicalName())) ? super.createFromParcel(parcel) : new ParticipantEntity();
    }
}
