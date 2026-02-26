package com.google.android.gms.games.internal.v2.resolution;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.ResultReceiver;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.games_v2.zzez;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final class GamesResolutionActivity extends Activity {

    @Nullable
    private ResultReceiver zza;

    private final void zza(int i10, @Nullable Intent intent) {
        Bundle bundle;
        ResultReceiver resultReceiver = this.zza;
        if (resultReceiver == null) {
            return;
        }
        if (intent == null) {
            bundle = new Bundle();
        } else {
            Bundle bundle2 = new Bundle();
            bundle2.putParcelable("resultData", intent);
            bundle = bundle2;
        }
        resultReceiver.send(i10, bundle);
    }

    @Override // android.app.Activity
    protected final void onActivityResult(int i10, int i11, @NonNull Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 0) {
            zza(i11, intent);
            finish();
            return;
        }
        StringBuilder sb = new StringBuilder(36);
        sb.append("Unexpected request code: ");
        sb.append(i10);
        zzez.zzc("ResultActivity", sb.toString());
        zza(0, intent);
        finish();
    }

    @Override // android.app.Activity
    protected final void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            this.zza = (ResultReceiver) Preconditions.checkNotNull((ResultReceiver) bundle.getParcelable("resultReceiver"));
            return;
        }
        this.zza = (ResultReceiver) Preconditions.checkNotNull((ResultReceiver) getIntent().getParcelableExtra("resultReceiver"));
        try {
            startIntentSenderForResult(((PendingIntent) Preconditions.checkNotNull((PendingIntent) getIntent().getParcelableExtra(BaseGmsClient.KEY_PENDING_INTENT))).getIntentSender(), 0, null, 0, 0, 0);
        } catch (IntentSender.SendIntentException e10) {
            zzez.zzd("ResultActivity", "Failed to launch", e10);
            zza(0, null);
            finish();
        }
    }

    @Override // android.app.Activity
    protected final void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("resultReceiver", this.zza);
    }
}
