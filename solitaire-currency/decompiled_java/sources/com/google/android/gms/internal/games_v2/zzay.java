package com.google.android.gms.internal.games_v2;

import androidx.compose.animation.core.d;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: com.google.android.gms:play-services-games-v2@@17.0.0 */
/* JADX INFO: loaded from: classes3.dex */
public final /* synthetic */ class zzay {
    public static /* synthetic */ boolean zza(AtomicReference atomicReference, Object obj, Object obj2) {
        while (!d.a(atomicReference, obj, obj2)) {
            if (atomicReference.get() != obj) {
                return false;
            }
        }
        return true;
    }
}
