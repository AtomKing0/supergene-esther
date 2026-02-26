package androidx.compose.ui.input.pointer;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.IntSizeKt;
import h9.q;
import java.util.List;
import kotlin.collections.p;
import kotlin.collections.u;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: PointerInputTestUtil.kt */
/* JADX INFO: loaded from: classes.dex */
public final class PointerInputTestUtilKt {
    @NotNull
    public static final PointerInputChange down(long j10, long j11, float f10, float f11) {
        return new PointerInputChange(PointerId.m2858constructorimpl(j10), j11, OffsetKt.Offset(f10, f11), true, j11, OffsetKt.Offset(f10, f11), false, false, 0, 0L, 768, (k) null);
    }

    public static /* synthetic */ PointerInputChange down$default(long j10, long j11, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j11 = 0;
        }
        return down(j10, j11, (i10 & 4) != 0 ? 0.0f : f10, (i10 & 8) != 0 ? 0.0f : f11);
    }

    /* JADX INFO: renamed from: invokeOverAllPasses-H0pRuoY, reason: not valid java name */
    public static final void m2910invokeOverAllPassesH0pRuoY(@NotNull q<? super PointerEvent, ? super PointerEventPass, ? super IntSize, k0> invokeOverAllPasses, @NotNull PointerEvent pointerEvent, long j10) {
        t.i(invokeOverAllPasses, "$this$invokeOverAllPasses");
        t.i(pointerEvent, "pointerEvent");
        m2914invokeOverPasseshUlJWOE(invokeOverAllPasses, pointerEvent, (List<? extends PointerEventPass>) v.n(PointerEventPass.Initial, PointerEventPass.Main, PointerEventPass.Final), j10);
    }

    /* JADX INFO: renamed from: invokeOverAllPasses-H0pRuoY$default, reason: not valid java name */
    public static /* synthetic */ void m2911invokeOverAllPassesH0pRuoY$default(q qVar, PointerEvent pointerEvent, long j10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            j10 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2910invokeOverAllPassesH0pRuoY(qVar, pointerEvent, j10);
    }

    /* JADX INFO: renamed from: invokeOverPass-hUlJWOE, reason: not valid java name */
    public static final void m2912invokeOverPasshUlJWOE(@NotNull q<? super PointerEvent, ? super PointerEventPass, ? super IntSize, k0> invokeOverPass, @NotNull PointerEvent pointerEvent, @NotNull PointerEventPass pointerEventPass, long j10) {
        t.i(invokeOverPass, "$this$invokeOverPass");
        t.i(pointerEvent, "pointerEvent");
        t.i(pointerEventPass, "pointerEventPass");
        m2914invokeOverPasseshUlJWOE(invokeOverPass, pointerEvent, (List<? extends PointerEventPass>) u.e(pointerEventPass), j10);
    }

    /* JADX INFO: renamed from: invokeOverPass-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m2913invokeOverPasshUlJWOE$default(q qVar, PointerEvent pointerEvent, PointerEventPass pointerEventPass, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2912invokeOverPasshUlJWOE(qVar, pointerEvent, pointerEventPass, j10);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m2915invokeOverPasseshUlJWOE(@NotNull q<? super PointerEvent, ? super PointerEventPass, ? super IntSize, k0> invokeOverPasses, @NotNull PointerEvent pointerEvent, @NotNull PointerEventPass[] pointerEventPasses, long j10) {
        t.i(invokeOverPasses, "$this$invokeOverPasses");
        t.i(pointerEvent, "pointerEvent");
        t.i(pointerEventPasses, "pointerEventPasses");
        m2914invokeOverPasseshUlJWOE(invokeOverPasses, pointerEvent, (List<? extends PointerEventPass>) p.o0(pointerEventPasses), j10);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m2917invokeOverPasseshUlJWOE$default(q qVar, PointerEvent pointerEvent, PointerEventPass[] pointerEventPassArr, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2915invokeOverPasseshUlJWOE((q<? super PointerEvent, ? super PointerEventPass, ? super IntSize, k0>) qVar, pointerEvent, pointerEventPassArr, j10);
    }

    @NotNull
    public static final PointerInputChange moveBy(@NotNull PointerInputChange pointerInputChange, long j10, float f10, float f11) {
        t.i(pointerInputChange, "<this>");
        long jM2872getIdJ3iCeTQ = pointerInputChange.m2872getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(jM2872getIdJ3iCeTQ, pointerInputChange.getUptimeMillis() + j10, OffsetKt.Offset(Offset.m1367getXimpl(pointerInputChange.m2873getPositionF1C5BW0()) + f10, Offset.m1368getYimpl(pointerInputChange.m2873getPositionF1C5BW0()) + f11), true, uptimeMillis, pointerInputChange.m2873getPositionF1C5BW0(), pressed, false, 0, 0L, 768, (k) null);
    }

    public static /* synthetic */ PointerInputChange moveBy$default(PointerInputChange pointerInputChange, long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        return moveBy(pointerInputChange, j10, f10, f11);
    }

    @NotNull
    public static final PointerInputChange moveTo(@NotNull PointerInputChange pointerInputChange, long j10, float f10, float f11) {
        t.i(pointerInputChange, "<this>");
        long jM2872getIdJ3iCeTQ = pointerInputChange.m2872getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(jM2872getIdJ3iCeTQ, j10, OffsetKt.Offset(f10, f11), true, uptimeMillis, pointerInputChange.m2873getPositionF1C5BW0(), pressed, false, 0, 0L, 768, (k) null);
    }

    public static /* synthetic */ PointerInputChange moveTo$default(PointerInputChange pointerInputChange, long j10, float f10, float f11, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            f10 = 0.0f;
        }
        if ((i10 & 4) != 0) {
            f11 = 0.0f;
        }
        return moveTo(pointerInputChange, j10, f10, f11);
    }

    @NotNull
    public static final PointerInputChange up(@NotNull PointerInputChange pointerInputChange, long j10) {
        t.i(pointerInputChange, "<this>");
        long jM2872getIdJ3iCeTQ = pointerInputChange.m2872getIdJ3iCeTQ();
        long uptimeMillis = pointerInputChange.getUptimeMillis();
        boolean pressed = pointerInputChange.getPressed();
        return new PointerInputChange(jM2872getIdJ3iCeTQ, j10, pointerInputChange.m2873getPositionF1C5BW0(), false, uptimeMillis, pointerInputChange.m2873getPositionF1C5BW0(), pressed, false, 0, 0L, 768, (k) null);
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE, reason: not valid java name */
    public static final void m2914invokeOverPasseshUlJWOE(@NotNull q<? super PointerEvent, ? super PointerEventPass, ? super IntSize, k0> invokeOverPasses, @NotNull PointerEvent pointerEvent, @NotNull List<? extends PointerEventPass> pointerEventPasses, long j10) {
        t.i(invokeOverPasses, "$this$invokeOverPasses");
        t.i(pointerEvent, "pointerEvent");
        t.i(pointerEventPasses, "pointerEventPasses");
        if (!(!pointerEvent.getChanges().isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (!(!pointerEventPasses.isEmpty())) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        int size = pointerEventPasses.size();
        for (int i10 = 0; i10 < size; i10++) {
            invokeOverPasses.invoke(pointerEvent, pointerEventPasses.get(i10), IntSize.m3825boximpl(j10));
        }
    }

    /* JADX INFO: renamed from: invokeOverPasses-hUlJWOE$default, reason: not valid java name */
    public static /* synthetic */ void m2916invokeOverPasseshUlJWOE$default(q qVar, PointerEvent pointerEvent, List list, long j10, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            j10 = IntSizeKt.IntSize(Integer.MAX_VALUE, Integer.MAX_VALUE);
        }
        m2914invokeOverPasseshUlJWOE((q<? super PointerEvent, ? super PointerEventPass, ? super IntSize, k0>) qVar, pointerEvent, (List<? extends PointerEventPass>) list, j10);
    }
}
