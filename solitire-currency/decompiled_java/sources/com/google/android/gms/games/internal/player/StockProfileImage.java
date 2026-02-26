package com.google.android.gms.games.internal.player;

import android.net.Uri;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.common.internal.ShowFirstParty;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
public interface StockProfileImage extends Freezable<StockProfileImage>, Parcelable {
    @NonNull
    String getImageUrl();

    @NonNull
    Uri zza();
}
