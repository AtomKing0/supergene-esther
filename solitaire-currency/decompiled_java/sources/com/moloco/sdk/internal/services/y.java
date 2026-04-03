package com.moloco.sdk.internal.services;

import android.content.Context;
import android.media.AudioManager;
import androidx.core.content.ContextCompat;
import com.moloco.sdk.internal.MolocoLogger;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public final class y implements x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final AudioManager f18828a;

    public y(@NotNull Context context) {
        AudioManager audioManager;
        kotlin.jvm.internal.t.i(context, "context");
        try {
            audioManager = (AudioManager) ContextCompat.getSystemService(context.getApplicationContext(), AudioManager.class);
        } catch (Exception e10) {
            MolocoLogger.error$default(MolocoLogger.INSTANCE, "AudioService", "couldn't get android.media.AudioManager service", e10, false, 8, null);
            audioManager = null;
        }
        this.f18828a = audioManager;
    }

    @Override // com.moloco.sdk.internal.services.x
    @NotNull
    public i0 a() {
        AudioManager audioManager = this.f18828a;
        Integer numValueOf = audioManager != null ? Integer.valueOf(audioManager.getRingerMode()) : null;
        return (numValueOf != null && numValueOf.intValue() == 0) ? i0.SILENT : (numValueOf != null && numValueOf.intValue() == 1) ? i0.VIBRATE : (numValueOf != null && numValueOf.intValue() == 2) ? i0.NORMAL : i0.NORMAL;
    }

    @Override // com.moloco.sdk.internal.services.x
    public int b() {
        AudioManager audioManager = this.f18828a;
        if (audioManager != null) {
            return audioManager.getStreamVolume(3);
        }
        return 0;
    }

    @Override // com.moloco.sdk.internal.services.x
    public boolean c() {
        AudioManager audioManager = this.f18828a;
        if (audioManager == null) {
            return false;
        }
        return audioManager.isStreamMute(3);
    }
}
