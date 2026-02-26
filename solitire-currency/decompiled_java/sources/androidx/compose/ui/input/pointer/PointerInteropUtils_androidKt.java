package androidx.compose.ui.input.pointer;

import android.os.SystemClock;
import android.view.MotionEvent;
import androidx.compose.ui.geometry.Offset;
import h9.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PointerInteropUtils.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInteropUtils_androidKt {
    public static final void emptyCancelMotionEventScope(long j10, @NotNull l<? super MotionEvent, k0> block) {
        t.i(block, "block");
        MotionEvent motionEvent = MotionEvent.obtain(j10, j10, 3, 0.0f, 0.0f, 0);
        motionEvent.setSource(0);
        t.h(motionEvent, "motionEvent");
        block.invoke(motionEvent);
        motionEvent.recycle();
    }

    public static /* synthetic */ void emptyCancelMotionEventScope$default(long j10, l lVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            j10 = SystemClock.uptimeMillis();
        }
        emptyCancelMotionEventScope(j10, lVar);
    }

    /* JADX INFO: renamed from: toCancelMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m2918toCancelMotionEventScoped4ec7I(@NotNull PointerEvent toCancelMotionEventScope, long j10, @NotNull l<? super MotionEvent, k0> block) {
        t.i(toCancelMotionEventScope, "$this$toCancelMotionEventScope");
        t.i(block, "block");
        m2920toMotionEventScopeubNVwUQ(toCancelMotionEventScope, j10, block, true);
    }

    /* JADX INFO: renamed from: toMotionEventScope-d-4ec7I, reason: not valid java name */
    public static final void m2919toMotionEventScoped4ec7I(@NotNull PointerEvent toMotionEventScope, long j10, @NotNull l<? super MotionEvent, k0> block) {
        t.i(toMotionEventScope, "$this$toMotionEventScope");
        t.i(block, "block");
        m2920toMotionEventScopeubNVwUQ(toMotionEventScope, j10, block, false);
    }

    /* JADX INFO: renamed from: toMotionEventScope-ubNVwUQ, reason: not valid java name */
    private static final void m2920toMotionEventScopeubNVwUQ(PointerEvent pointerEvent, long j10, l<? super MotionEvent, k0> lVar, boolean z10) {
        MotionEvent motionEvent$ui_release = pointerEvent.getMotionEvent$ui_release();
        if (motionEvent$ui_release == null) {
            throw new IllegalArgumentException("The PointerEvent receiver cannot have a null MotionEvent.".toString());
        }
        int action = motionEvent$ui_release.getAction();
        if (z10) {
            motionEvent$ui_release.setAction(3);
        }
        motionEvent$ui_release.offsetLocation(-Offset.m1367getXimpl(j10), -Offset.m1368getYimpl(j10));
        lVar.invoke(motionEvent$ui_release);
        motionEvent$ui_release.offsetLocation(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10));
        motionEvent$ui_release.setAction(action);
    }
}
