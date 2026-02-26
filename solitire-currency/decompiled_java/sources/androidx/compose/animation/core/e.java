package androidx.compose.animation.core;

import androidx.compose.animation.core.Transition;
import kotlin.jvm.internal.t;

/* JADX INFO: compiled from: Transition.kt */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class e<S> {
    public static boolean a(Transition.Segment segment, Object obj, Object obj2) {
        return t.d(obj, segment.getInitialState()) && t.d(obj2, segment.getTargetState());
    }
}
