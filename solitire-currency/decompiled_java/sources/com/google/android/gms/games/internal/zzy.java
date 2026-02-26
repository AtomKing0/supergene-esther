package com.google.android.gms.games.internal;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zzy extends zza {
    private final TaskCompletionSource zza;

    zzy(TaskCompletionSource taskCompletionSource) {
        this.zza = taskCompletionSource;
    }

    @Override // com.google.android.gms.games.internal.zza, com.google.android.gms.games.internal.zzam
    public final void zzg(DataHolder dataHolder) {
        int statusCode = dataHolder.getStatusCode();
        boolean z10 = statusCode == 3;
        if (statusCode != 0 && !z10) {
            GamesStatusUtils.zza(this.zza, statusCode);
            dataHolder.close();
            return;
        }
        LeaderboardBuffer leaderboardBuffer = new LeaderboardBuffer(dataHolder);
        try {
            Leaderboard leaderboardFreeze = leaderboardBuffer.getCount() > 0 ? leaderboardBuffer.get(0).freeze() : null;
            leaderboardBuffer.close();
            this.zza.setResult(new AnnotatedData(leaderboardFreeze, z10));
        } catch (Throwable th) {
            try {
                leaderboardBuffer.close();
            } catch (Throwable th2) {
                try {
                    Throwable.class.getDeclaredMethod("addSuppressed", Throwable.class).invoke(th, th2);
                } catch (Exception unused) {
                }
            }
            throw th;
        }
    }
}
