package androidx.compose.ui.input.pointer;

import android.view.MotionEvent;
import androidx.annotation.DoNotInline;
import androidx.annotation.RequiresApi;
import androidx.compose.ui.geometry.OffsetKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: MotionEventAdapter.android.kt */
/* JADX INFO: loaded from: classes.dex */
@RequiresApi(29)
final class MotionEventHelper {

    @NotNull
    public static final MotionEventHelper INSTANCE = new MotionEventHelper();

    private MotionEventHelper() {
    }

    @DoNotInline
    /* JADX INFO: renamed from: toRawOffset-dBAh8RU, reason: not valid java name */
    public final long m2809toRawOffsetdBAh8RU(@NotNull MotionEvent motionEvent, int i10) {
        t.i(motionEvent, "motionEvent");
        return OffsetKt.Offset(motionEvent.getRawX(i10), motionEvent.getRawY(i10));
    }
}
