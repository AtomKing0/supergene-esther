package com.google.android.gms.games;

import androidx.annotation.NonNull;
import com.google.android.gms.common.FirstPartyScopes;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.games.achievement.Achievements;
import com.google.android.gms.games.event.Events;
import com.google.android.gms.games.leaderboard.Leaderboards;
import com.google.android.gms.games.snapshot.Snapshots;
import com.google.android.gms.games.stats.Stats;
import com.google.android.gms.games.video.Videos;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
@ShowFirstParty
@VisibleForTesting
public final class Games {
    static final Api.ClientKey zza;

    @NonNull
    public static final Scope zzb;

    @NonNull
    public static final Scope zzc;

    @NonNull
    public static final Scope zzd;

    @NonNull
    @Deprecated
    public static final Api zze;

    @NonNull
    @ShowFirstParty
    public static final Scope zzf;

    @NonNull
    @ShowFirstParty
    public static final Api zzg;

    @NonNull
    @Deprecated
    public static final GamesMetadata zzh;

    @NonNull
    @Deprecated
    public static final Achievements zzi;

    @NonNull
    @Deprecated
    public static final Events zzj;

    @NonNull
    @Deprecated
    public static final Leaderboards zzk;

    @NonNull
    @Deprecated
    public static final Players zzl;

    @NonNull
    @Deprecated
    public static final Snapshots zzm;

    @NonNull
    @Deprecated
    public static final Stats zzn;

    @NonNull
    @Deprecated
    public static final Videos zzo;
    private static final Api.AbstractClientBuilder zzp;
    private static final Api.AbstractClientBuilder zzq;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
    @KeepForSdk
    @Deprecated
    public interface GetServerAuthCodeResult extends Result {
        @NonNull
        @KeepForSdk
        String getCode();
    }

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zza = clientKey;
        zzg zzgVar = new zzg();
        zzp = zzgVar;
        zzh zzhVar = new zzh();
        zzq = zzhVar;
        zzb = new Scope(Scopes.GAMES);
        zzc = new Scope(Scopes.GAMES_LITE);
        zzd = new Scope(Scopes.DRIVE_APPFOLDER);
        zze = new Api("Games.API", zzgVar, clientKey);
        zzf = new Scope(FirstPartyScopes.GAMES_1P);
        zzg = new Api("Games.API_1P", zzhVar, clientKey);
        zzh = new com.google.android.gms.internal.games_v2.zzg();
        zzi = new com.google.android.gms.internal.games_v2.zzd();
        zzj = new com.google.android.gms.internal.games_v2.zzf();
        zzk = new com.google.android.gms.internal.games_v2.zzh();
        zzl = new com.google.android.gms.internal.games_v2.zzi();
        zzm = new com.google.android.gms.internal.games_v2.zzj();
        zzn = new com.google.android.gms.internal.games_v2.zzk();
        zzo = new com.google.android.gms.internal.games_v2.zzl();
    }
}
