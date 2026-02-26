package com.google.android.gms.games.internal.v2.resolution;

import android.content.Intent;
import android.os.Bundle;
import android.os.Looper;
import android.os.ResultReceiver;
import com.google.android.gms.internal.games_v2.zzfa;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
final class zza extends ResultReceiver {
    private final TaskCompletionSource zza;

    public zza() {
        super(new zzfa(Looper.getMainLooper()));
        this.zza = new TaskCompletionSource();
    }

    @Override // android.os.ResultReceiver
    protected final void onReceiveResult(int i10, Bundle bundle) {
        Intent intent;
        super.onReceiveResult(i10, bundle);
        Boolean boolValueOf = Boolean.valueOf(i10 == -1);
        if (bundle == null || (intent = (Intent) bundle.getParcelable("resultData")) == null) {
            intent = new Intent();
        }
        this.zza.trySetResult(boolValueOf.booleanValue() ? zzc.zzc(intent) : zzc.zzb(intent));
    }

    public final Task zza() {
        return this.zza.getTask();
    }
}
