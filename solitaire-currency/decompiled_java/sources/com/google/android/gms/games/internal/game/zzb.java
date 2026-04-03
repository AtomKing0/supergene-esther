package com.google.android.gms.games.internal.game;

import android.net.Uri;
import android.os.Parcel;
import com.google.android.gms.common.internal.DowngradeableSafeParcel;
import com.google.android.gms.games.internal.GamesDowngradeableSafeParcel;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzb extends zzc {
    zzb() {
    }

    @Override // com.google.android.gms.games.internal.game.zzc, android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        return createFromParcel(parcel);
    }

    @Override // com.google.android.gms.games.internal.game.zzc
    /* JADX INFO: renamed from: zza */
    public final GameBadgeEntity createFromParcel(Parcel parcel) {
        if (GamesDowngradeableSafeParcel.zzo(DowngradeableSafeParcel.getUnparcelClientVersion()) || DowngradeableSafeParcel.canUnparcelSafely(GameBadgeEntity.class.getCanonicalName())) {
            return super.createFromParcel(parcel);
        }
        int i10 = parcel.readInt();
        String string = parcel.readString();
        String string2 = parcel.readString();
        String string3 = parcel.readString();
        return new GameBadgeEntity(i10, string, string2, string3 == null ? null : Uri.parse(string3));
    }
}
