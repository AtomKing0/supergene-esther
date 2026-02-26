package androidx.compose.animation.core;

import androidx.compose.animation.core.AnimationVector;

/* JADX INFO: compiled from: Animation.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class a<T, V extends AnimationVector> {
    public static boolean a(Animation animation, long j10) {
        return j10 >= animation.getDurationNanos();
    }
}
