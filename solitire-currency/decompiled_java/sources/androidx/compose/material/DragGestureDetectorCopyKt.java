package androidx.compose.material;

import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerId;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerType;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Dp;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: DragGestureDetectorCopy.kt */
/* JADX INFO: loaded from: classes.dex */
public final class DragGestureDetectorCopyKt {
    private static final float defaultTouchSlop;
    private static final float mouseSlop;
    private static final float mouseToTouchSlopRatio;

    static {
        float fM3673constructorimpl = Dp.m3673constructorimpl((float) 0.125d);
        mouseSlop = fM3673constructorimpl;
        float fM3673constructorimpl2 = Dp.m3673constructorimpl(18);
        defaultTouchSlop = fM3673constructorimpl2;
        mouseToTouchSlopRatio = fM3673constructorimpl / fM3673constructorimpl2;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00b0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:23:0x00b1  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c8  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0165  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00e3 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:46:0x011b -> B:57:0x0167). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x015a -> B:53:0x015d). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:62:0x0181 -> B:57:0x0167). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: awaitHorizontalPointerSlopOrCancellation-gDDlDlE, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object m992awaitHorizontalPointerSlopOrCancellationgDDlDlE(@org.jetbrains.annotations.NotNull androidx.compose.ui.input.pointer.AwaitPointerEventScope r19, long r20, int r22, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r23, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r24) {
        /*
            Method dump skipped, instruction units count: 391
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.m992awaitHorizontalPointerSlopOrCancellationgDDlDlE(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, h9.p, z8.d):java.lang.Object");
    }

    /* JADX WARN: Code restructure failed: missing block: B:35:0x00cd, code lost:
    
        r21.mo4invoke(r15, java.lang.Float.valueOf(r8 - (java.lang.Math.signum(r8) * r3)));
     */
    /* JADX INFO: renamed from: awaitPointerSlopOrCancellation-pn7EDYM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.lang.Object m993awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope r17, long r18, int r20, h9.p<? super androidx.compose.ui.input.pointer.PointerInputChange, ? super java.lang.Float, v8.k0> r21, h9.l<? super androidx.compose.ui.geometry.Offset, java.lang.Float> r22, z8.d<? super androidx.compose.ui.input.pointer.PointerInputChange> r23) {
        /*
            Method dump skipped, instruction units count: 227
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DragGestureDetectorCopyKt.m993awaitPointerSlopOrCancellationpn7EDYM(androidx.compose.ui.input.pointer.AwaitPointerEventScope, long, int, h9.p, h9.l, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: isPointerUp-DmW0f2w, reason: not valid java name */
    private static final boolean m994isPointerUpDmW0f2w(PointerEvent pointerEvent, long j10) {
        PointerInputChange pointerInputChange;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        boolean z10 = false;
        int i10 = 0;
        while (true) {
            if (i10 >= size) {
                pointerInputChange = null;
                break;
            }
            pointerInputChange = changes.get(i10);
            if (PointerId.m2860equalsimpl0(pointerInputChange.m2872getIdJ3iCeTQ(), j10)) {
                break;
            }
            i10++;
        }
        PointerInputChange pointerInputChange2 = pointerInputChange;
        if (pointerInputChange2 != null && pointerInputChange2.getPressed()) {
            z10 = true;
        }
        return true ^ z10;
    }

    /* JADX INFO: renamed from: pointerSlop-E8SPZFQ, reason: not valid java name */
    public static final float m995pointerSlopE8SPZFQ(@NotNull ViewConfiguration pointerSlop, int i10) {
        t.i(pointerSlop, "$this$pointerSlop");
        return PointerType.m2931equalsimpl0(i10, PointerType.Companion.m2936getMouseT8wyACA()) ? pointerSlop.getTouchSlop() * mouseToTouchSlopRatio : pointerSlop.getTouchSlop();
    }
}
