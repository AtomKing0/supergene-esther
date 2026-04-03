package com.vungle.ads.internal.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: RingerModeReceiver.kt */
/* JADX INFO: loaded from: classes4.dex */
public final class s extends BroadcastReceiver {

    @Nullable
    private com.vungle.ads.internal.ui.f webClient;

    @Nullable
    public final com.vungle.ads.internal.ui.f getWebClient() {
        return this.webClient;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(@Nullable Context context, @Nullable Intent intent) {
        String action;
        com.vungle.ads.internal.ui.f fVar;
        if (intent != null) {
            try {
                action = intent.getAction();
            } catch (Exception e10) {
                String localizedMessage = e10.getLocalizedMessage();
                if (localizedMessage != null) {
                    p.Companion.e("RingerModeReceiver", localizedMessage);
                    return;
                }
                return;
            }
        } else {
            action = null;
        }
        if (kotlin.jvm.internal.t.d(action, "android.media.RINGER_MODE_CHANGED")) {
            int intExtra = intent.getIntExtra("android.media.EXTRA_RINGER_MODE", -1);
            p.Companion.d("RingerModeReceiver", "receive ringermode: " + intExtra);
            if (intExtra == 0) {
                com.vungle.ads.internal.ui.f fVar2 = this.webClient;
                if (fVar2 != null) {
                    fVar2.notifySilentModeChange(true);
                    return;
                }
                return;
            }
            if (intExtra != 1) {
                if (intExtra == 2 && (fVar = this.webClient) != null) {
                    fVar.notifySilentModeChange(false);
                    return;
                }
                return;
            }
            com.vungle.ads.internal.ui.f fVar3 = this.webClient;
            if (fVar3 != null) {
                fVar3.notifySilentModeChange(true);
            }
        }
    }

    public final void setWebClient(@Nullable com.vungle.ads.internal.ui.f fVar) {
        this.webClient = fVar;
    }
}
