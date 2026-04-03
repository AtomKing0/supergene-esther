package com.google.android.gms.internal.games_v2;

import android.content.Intent;
import android.os.RemoteException;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.internal.RemoteCall;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.games.AchievementsClient;
import com.google.android.gms.games.AnnotatedData;
import com.google.android.gms.games.GamesStatusUtils;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class zzce implements AchievementsClient {
    private final zzar zza;

    public zzce(zzar zzarVar) {
        this.zza = zzarVar;
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Intent> getAchievementsIntent() {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzbv
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzcb
                    /* JADX WARN: Multi-variable type inference failed */
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) {
                        TaskCompletionSource taskCompletionSource = (TaskCompletionSource) obj2;
                        try {
                            taskCompletionSource.setResult(((com.google.android.gms.games.internal.zzap) ((com.google.android.gms.games.internal.zzak) obj).getService()).zzg());
                        } catch (SecurityException e10) {
                            GamesStatusUtils.zzb(taskCompletionSource, e10);
                        }
                    }
                }).setMethodKey(6692).build());
            }
        });
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void increment(@NonNull String str, int i10) {
        this.zza.zzb(new zzbs(str, i10));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Boolean> incrementImmediate(@NonNull String str, int i10) {
        return this.zza.zzb(new zzbs(str, i10));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<AnnotatedData<AchievementBuffer>> load(final boolean z10) {
        return this.zza.zzb(new zzaq() { // from class: com.google.android.gms.internal.games_v2.zzbu
            @Override // com.google.android.gms.internal.games_v2.zzaq
            public final Task zza(GoogleApi googleApi) {
                final boolean z11 = z10;
                return googleApi.doRead(TaskApiCall.builder().run(new RemoteCall() { // from class: com.google.android.gms.internal.games_v2.zzca
                    @Override // com.google.android.gms.common.api.internal.RemoteCall
                    public final void accept(Object obj, Object obj2) throws RemoteException {
                        ((com.google.android.gms.games.internal.zzak) obj).zzy((TaskCompletionSource) obj2, z11);
                    }
                }).setMethodKey(6693).build());
            }
        });
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void reveal(@NonNull String str) {
        this.zza.zzb(new zzcc(str));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Void> revealImmediate(@NonNull String str) {
        return this.zza.zzb(new zzcc(str));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void setSteps(@NonNull String str, int i10) {
        this.zza.zzb(new zzbt(str, i10));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Boolean> setStepsImmediate(@NonNull String str, int i10) {
        return this.zza.zzb(new zzbt(str, i10));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final void unlock(@NonNull String str) {
        this.zza.zzb(new zzcd(str));
    }

    @Override // com.google.android.gms.games.AchievementsClient
    public final Task<Void> unlockImmediate(@NonNull String str) {
        return this.zza.zzb(new zzcd(str));
    }
}
