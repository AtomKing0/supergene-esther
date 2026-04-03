package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.AwaitPointerEventScope;
import androidx.compose.ui.input.pointer.PointerEvent;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.p;
import h9.r;
import java.util.List;
import kotlin.coroutines.jvm.internal.k;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TransformGestureDetector.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TransformGestureDetectorKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformGestureDetector.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2", f = "TransformGestureDetector.kt", l = {52}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ r<Offset, Offset, Float, Float, k0> $onGesture;
        final /* synthetic */ boolean $panZoomLock;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TransformGestureDetector.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformGestureDetectorKt$detectTransformGestures$2$1", f = "TransformGestureDetector.kt", l = {60, 62}, m = "invokeSuspend")
        static final class AnonymousClass1 extends k implements p<AwaitPointerEventScope, z8.d<? super k0>, Object> {
            final /* synthetic */ r<Offset, Offset, Float, Float, k0> $onGesture;
            final /* synthetic */ boolean $panZoomLock;
            float F$0;
            float F$1;
            float F$2;
            int I$0;
            int I$1;
            long J$0;
            private /* synthetic */ Object L$0;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(boolean z10, r<? super Offset, ? super Offset, ? super Float, ? super Float, k0> rVar, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.$panZoomLock = z10;
                this.$onGesture = rVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$panZoomLock, this.$onGesture, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull AwaitPointerEventScope awaitPointerEventScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(awaitPointerEventScope, dVar)).invokeSuspend(k0.f35197a);
            }

            /* JADX WARN: Path cross not found for [B:60:0x013c, B:53:0x0125], limit reached: 88 */
            /* JADX WARN: Removed duplicated region for block: B:17:0x0090 A[RETURN] */
            /* JADX WARN: Removed duplicated region for block: B:20:0x009e  */
            /* JADX WARN: Removed duplicated region for block: B:26:0x00b2  */
            /* JADX WARN: Removed duplicated region for block: B:63:0x015c  */
            /* JADX WARN: Removed duplicated region for block: B:67:0x016e  */
            /* JADX WARN: Removed duplicated region for block: B:70:0x0176  */
            /* JADX WARN: Removed duplicated region for block: B:82:0x00af A[SYNTHETIC] */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x008e -> B:18:0x0091). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.a
            @org.jetbrains.annotations.Nullable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r24) {
                /*
                    Method dump skipped, instruction units count: 422
                    To view this dump add '--comments-level debug' option
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.TransformGestureDetectorKt.AnonymousClass2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(boolean z10, r<? super Offset, ? super Offset, ? super Float, ? super Float, k0> rVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$panZoomLock = z10;
            this.$onGesture = rVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.$panZoomLock, this.$onGesture, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$panZoomLock, this.$onGesture, null);
                this.label = 1;
                if (pointerInputScope.awaitPointerEventScope(anonymousClass1, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: angle-k-4lQ0M, reason: not valid java name */
    private static final float m316anglek4lQ0M(long j10) {
        if (Offset.m1367getXimpl(j10) == 0.0f) {
            if (Offset.m1368getYimpl(j10) == 0.0f) {
                return 0.0f;
            }
        }
        return ((-((float) Math.atan2(Offset.m1367getXimpl(j10), Offset.m1368getYimpl(j10)))) * 180.0f) / 3.1415927f;
    }

    public static final long calculateCentroid(@NotNull PointerEvent pointerEvent, boolean z10) {
        t.i(pointerEvent, "<this>");
        long jM1383getZeroF1C5BW0 = Offset.Companion.m1383getZeroF1C5BW0();
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            PointerInputChange pointerInputChange = changes.get(i11);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                jM1383getZeroF1C5BW0 = Offset.m1372plusMKHz9U(jM1383getZeroF1C5BW0, z10 ? pointerInputChange.m2873getPositionF1C5BW0() : pointerInputChange.m2874getPreviousPositionF1C5BW0());
                i10++;
            }
        }
        return i10 == 0 ? Offset.Companion.m1382getUnspecifiedF1C5BW0() : Offset.m1362divtuRUvjQ(jM1383getZeroF1C5BW0, i10);
    }

    public static /* synthetic */ long calculateCentroid$default(PointerEvent pointerEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return calculateCentroid(pointerEvent, z10);
    }

    public static final float calculateCentroidSize(@NotNull PointerEvent pointerEvent, boolean z10) {
        t.i(pointerEvent, "<this>");
        long jCalculateCentroid = calculateCentroid(pointerEvent, z10);
        float fM1365getDistanceimpl = 0.0f;
        if (Offset.m1364equalsimpl0(jCalculateCentroid, Offset.Companion.m1382getUnspecifiedF1C5BW0())) {
            return 0.0f;
        }
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i10 = 0;
        for (int i11 = 0; i11 < size; i11++) {
            PointerInputChange pointerInputChange = changes.get(i11);
            if (pointerInputChange.getPressed() && pointerInputChange.getPreviousPressed()) {
                fM1365getDistanceimpl += Offset.m1365getDistanceimpl(Offset.m1371minusMKHz9U(z10 ? pointerInputChange.m2873getPositionF1C5BW0() : pointerInputChange.m2874getPreviousPositionF1C5BW0(), jCalculateCentroid));
                i10++;
            }
        }
        return fM1365getDistanceimpl / i10;
    }

    public static /* synthetic */ float calculateCentroidSize$default(PointerEvent pointerEvent, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        return calculateCentroidSize(pointerEvent, z10);
    }

    public static final long calculatePan(@NotNull PointerEvent pointerEvent) {
        t.i(pointerEvent, "<this>");
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        Offset.Companion companion = Offset.Companion;
        return Offset.m1364equalsimpl0(jCalculateCentroid, companion.m1382getUnspecifiedF1C5BW0()) ? companion.m1383getZeroF1C5BW0() : Offset.m1371minusMKHz9U(jCalculateCentroid, calculateCentroid(pointerEvent, false));
    }

    public static final float calculateRotation(@NotNull PointerEvent pointerEvent) {
        t.i(pointerEvent, "<this>");
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = 1;
            if (i10 >= size) {
                break;
            }
            PointerInputChange pointerInputChange = changes.get(i10);
            if (!pointerInputChange.getPreviousPressed() || !pointerInputChange.getPressed()) {
                i12 = 0;
            }
            i11 += i12;
            i10++;
        }
        float f10 = 0.0f;
        if (i11 < 2) {
            return 0.0f;
        }
        long jCalculateCentroid = calculateCentroid(pointerEvent, true);
        long jCalculateCentroid2 = calculateCentroid(pointerEvent, false);
        List<PointerInputChange> changes2 = pointerEvent.getChanges();
        int size2 = changes2.size();
        float f11 = 0.0f;
        float f12 = 0.0f;
        int i13 = 0;
        while (i13 < size2) {
            PointerInputChange pointerInputChange2 = changes2.get(i13);
            if (pointerInputChange2.getPressed() && pointerInputChange2.getPreviousPressed()) {
                long jM2873getPositionF1C5BW0 = pointerInputChange2.m2873getPositionF1C5BW0();
                long jM1371minusMKHz9U = Offset.m1371minusMKHz9U(pointerInputChange2.m2874getPreviousPositionF1C5BW0(), jCalculateCentroid2);
                long jM1371minusMKHz9U2 = Offset.m1371minusMKHz9U(jM2873getPositionF1C5BW0, jCalculateCentroid);
                float fM316anglek4lQ0M = m316anglek4lQ0M(jM1371minusMKHz9U2) - m316anglek4lQ0M(jM1371minusMKHz9U);
                float fM1365getDistanceimpl = Offset.m1365getDistanceimpl(Offset.m1372plusMKHz9U(jM1371minusMKHz9U2, jM1371minusMKHz9U)) / 2.0f;
                if (fM316anglek4lQ0M > 180.0f) {
                    fM316anglek4lQ0M -= 360.0f;
                } else if (fM316anglek4lQ0M < -180.0f) {
                    fM316anglek4lQ0M += 360.0f;
                }
                f12 += fM316anglek4lQ0M * fM1365getDistanceimpl;
                f11 += fM1365getDistanceimpl;
            }
            i13++;
            f10 = 0.0f;
        }
        return (f11 > f10 ? 1 : (f11 == f10 ? 0 : -1)) == 0 ? f10 : f12 / f11;
    }

    public static final float calculateZoom(@NotNull PointerEvent pointerEvent) {
        t.i(pointerEvent, "<this>");
        float fCalculateCentroidSize = calculateCentroidSize(pointerEvent, true);
        float fCalculateCentroidSize2 = calculateCentroidSize(pointerEvent, false);
        if (fCalculateCentroidSize == 0.0f) {
            return 1.0f;
        }
        if (fCalculateCentroidSize2 == 0.0f) {
            return 1.0f;
        }
        return fCalculateCentroidSize / fCalculateCentroidSize2;
    }

    @Nullable
    public static final Object detectTransformGestures(@NotNull PointerInputScope pointerInputScope, boolean z10, @NotNull r<? super Offset, ? super Offset, ? super Float, ? super Float, k0> rVar, @NotNull z8.d<? super k0> dVar) {
        Object objForEachGesture = ForEachGestureKt.forEachGesture(pointerInputScope, new AnonymousClass2(z10, rVar, null), dVar);
        return objForEachGesture == a9.d.e() ? objForEachGesture : k0.f35197a;
    }

    public static /* synthetic */ Object detectTransformGestures$default(PointerInputScope pointerInputScope, boolean z10, r rVar, z8.d dVar, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        return detectTransformGestures(pointerInputScope, z10, rVar, dVar);
    }
}
