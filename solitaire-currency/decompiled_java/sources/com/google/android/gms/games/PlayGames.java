package com.google.android.gms.games;

import android.app.Activity;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.internal.games_v2.zzal;
import com.google.android.gms.internal.games_v2.zzar;
import com.google.android.gms.internal.games_v2.zzax;
import com.google.android.gms.internal.games_v2.zzbr;
import com.google.android.gms.internal.games_v2.zzce;
import com.google.android.gms.internal.games_v2.zzcl;
import com.google.android.gms.internal.games_v2.zzco;
import com.google.android.gms.internal.games_v2.zzdj;
import com.google.android.gms.internal.games_v2.zzdm;
import com.google.android.gms.internal.games_v2.zzef;
import com.google.android.gms.internal.games_v2.zzey;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@zzal
public final class PlayGames {
    private PlayGames() {
    }

    @NonNull
    @zzal
    public static AchievementsClient getAchievementsClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzce(zzar.zza(zzbr.zza()));
    }

    @NonNull
    @zzal
    public static EventsClient getEventsClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzcl(zzar.zza(zzbr.zza()));
    }

    @NonNull
    @zzal
    public static GamesSignInClient getGamesSignInClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzco(zzax.zza(zzbr.zza()), zzar.zza(zzbr.zza()));
    }

    @NonNull
    @zzal
    public static LeaderboardsClient getLeaderboardsClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzdj(zzar.zza(zzbr.zza()));
    }

    @NonNull
    @zzal
    public static PlayerStatsClient getPlayerStatsClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzdm(zzar.zza(zzbr.zza()));
    }

    @NonNull
    @zzal
    public static PlayersClient getPlayersClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzef(zzar.zza(zzbr.zza()));
    }

    @NonNull
    @zzal
    public static SnapshotsClient getSnapshotsClient(@NonNull Activity activity) {
        zzbr.zzb();
        return new zzey(zzar.zza(zzbr.zza()));
    }
}
