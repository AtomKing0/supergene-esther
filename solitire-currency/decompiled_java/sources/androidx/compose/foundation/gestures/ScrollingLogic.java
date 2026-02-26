package androidx.compose.foundation.gestures;

import androidx.compose.foundation.OverscrollEffect;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.unit.Velocity;
import androidx.compose.ui.unit.VelocityKt;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollingLogic {

    @NotNull
    private final FlingBehavior flingBehavior;

    @NotNull
    private final State<NestedScrollDispatcher> nestedScrollDispatcher;

    @NotNull
    private final Orientation orientation;

    @Nullable
    private final OverscrollEffect overscrollEffect;
    private final boolean reverseDirection;

    @NotNull
    private final ScrollableState scrollableState;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollingLogic$onDragStopped$1, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollingLogic", f = "Scrollable.kt", l = {378, 383, 385, 387, 393}, m = "onDragStopped")
    static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.d {
        float F$0;
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(z8.d<? super AnonymousClass1> dVar) {
            super(dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ScrollingLogic.this.onDragStopped(0.0f, this);
        }
    }

    public ScrollingLogic(@NotNull Orientation orientation, boolean z10, @NotNull State<NestedScrollDispatcher> nestedScrollDispatcher, @NotNull ScrollableState scrollableState, @NotNull FlingBehavior flingBehavior, @Nullable OverscrollEffect overscrollEffect) {
        t.i(orientation, "orientation");
        t.i(nestedScrollDispatcher, "nestedScrollDispatcher");
        t.i(scrollableState, "scrollableState");
        t.i(flingBehavior, "flingBehavior");
        this.orientation = orientation;
        this.reverseDirection = z10;
        this.nestedScrollDispatcher = nestedScrollDispatcher;
        this.scrollableState = scrollableState;
        this.flingBehavior = flingBehavior;
        this.overscrollEffect = overscrollEffect;
    }

    /* JADX INFO: renamed from: dispatchScroll-f0eR0lY, reason: not valid java name */
    public final long m305dispatchScrollf0eR0lY(@NotNull ScrollScope dispatchScroll, long j10, @Nullable Offset offset, int i10) {
        t.i(dispatchScroll, "$this$dispatchScroll");
        OverscrollEffect overscrollEffect = this.overscrollEffect;
        long jM1371minusMKHz9U = Offset.m1371minusMKHz9U(j10, (overscrollEffect == null || !overscrollEffect.isEnabled()) ? Offset.Companion.m1383getZeroF1C5BW0() : this.overscrollEffect.mo161consumePreScrollA0NYTsA(j10, offset, i10));
        NestedScrollDispatcher value = this.nestedScrollDispatcher.getValue();
        long jM1371minusMKHz9U2 = Offset.m1371minusMKHz9U(jM1371minusMKHz9U, value.m2778dispatchPreScrollOzD1aCk(jM1371minusMKHz9U, i10));
        long jM308reverseIfNeededMKHz9U = m308reverseIfNeededMKHz9U(m311toOffsettuRUvjQ(dispatchScroll.scrollBy(m310toFloatk4lQ0M(m308reverseIfNeededMKHz9U(jM1371minusMKHz9U2)))));
        long jM1371minusMKHz9U3 = Offset.m1371minusMKHz9U(jM1371minusMKHz9U2, jM308reverseIfNeededMKHz9U);
        long jM2776dispatchPostScrollDzOQY0M = value.m2776dispatchPostScrollDzOQY0M(jM308reverseIfNeededMKHz9U, jM1371minusMKHz9U3, i10);
        OverscrollEffect overscrollEffect2 = this.overscrollEffect;
        if (overscrollEffect2 != null && overscrollEffect2.isEnabled()) {
            this.overscrollEffect.mo159consumePostScrolll7mfB5k(jM1371minusMKHz9U2, Offset.m1371minusMKHz9U(jM1371minusMKHz9U3, jM2776dispatchPostScrollDzOQY0M), offset, i10);
        }
        return jM1371minusMKHz9U3;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: doFlingAnimation-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m306doFlingAnimationQWom1Mo(long r13, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r15) {
        /*
            r12 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            if (r0 == 0) goto L13
            r0 = r15
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = (androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1 r0 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$1
            r0.<init>(r12, r15)
        L18:
            r4 = r0
            java.lang.Object r15 = r4.result
            java.lang.Object r0 = a9.b.e()
            int r1 = r4.label
            r2 = 1
            if (r1 == 0) goto L36
            if (r1 != r2) goto L2e
            java.lang.Object r13 = r4.L$0
            kotlin.jvm.internal.m0 r13 = (kotlin.jvm.internal.m0) r13
            v8.u.b(r15)
            goto L5d
        L2e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r14 = "call to 'resume' before 'invoke' with coroutine"
            r13.<init>(r14)
            throw r13
        L36:
            v8.u.b(r15)
            kotlin.jvm.internal.m0 r15 = new kotlin.jvm.internal.m0
            r15.<init>()
            r15.f29833a = r13
            androidx.compose.foundation.gestures.ScrollableState r1 = r12.scrollableState
            r3 = 0
            androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2 r11 = new androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2
            r10 = 0
            r5 = r11
            r6 = r12
            r7 = r15
            r8 = r13
            r5.<init>(r6, r7, r8, r10)
            r5 = 1
            r6 = 0
            r4.L$0 = r15
            r4.label = r2
            r2 = r3
            r3 = r11
            java.lang.Object r13 = androidx.compose.foundation.gestures.d.a(r1, r2, r3, r4, r5, r6)
            if (r13 != r0) goto L5c
            return r0
        L5c:
            r13 = r15
        L5d:
            long r13 = r13.f29833a
            androidx.compose.ui.unit.Velocity r13 = androidx.compose.ui.unit.Velocity.m3889boximpl(r13)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.m306doFlingAnimationQWom1Mo(long, z8.d):java.lang.Object");
    }

    @NotNull
    public final FlingBehavior getFlingBehavior() {
        return this.flingBehavior;
    }

    @NotNull
    public final State<NestedScrollDispatcher> getNestedScrollDispatcher() {
        return this.nestedScrollDispatcher;
    }

    @NotNull
    public final Orientation getOrientation() {
        return this.orientation;
    }

    @Nullable
    public final OverscrollEffect getOverscrollEffect() {
        return this.overscrollEffect;
    }

    public final boolean getReverseDirection() {
        return this.reverseDirection;
    }

    @NotNull
    public final ScrollableState getScrollableState() {
        return this.scrollableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00be A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00fa A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object onDragStopped(float r13, @org.jetbrains.annotations.NotNull z8.d<? super v8.k0> r14) {
        /*
            Method dump skipped, instruction units count: 299
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.ScrollingLogic.onDragStopped(float, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: performRawScroll-MK-Hz9U, reason: not valid java name */
    public final long m307performRawScrollMKHz9U(long j10) {
        return this.scrollableState.isScrollInProgress() ? Offset.Companion.m1383getZeroF1C5BW0() : m311toOffsettuRUvjQ(reverseIfNeeded(this.scrollableState.dispatchRawDelta(reverseIfNeeded(m310toFloatk4lQ0M(j10)))));
    }

    public final float reverseIfNeeded(float f10) {
        return this.reverseDirection ? f10 * (-1) : f10;
    }

    /* JADX INFO: renamed from: reverseIfNeeded-MK-Hz9U, reason: not valid java name */
    public final long m308reverseIfNeededMKHz9U(long j10) {
        return this.reverseDirection ? Offset.m1374timestuRUvjQ(j10, -1.0f) : j10;
    }

    public final boolean shouldScrollImmediately() {
        if (!this.scrollableState.isScrollInProgress()) {
            OverscrollEffect overscrollEffect = this.overscrollEffect;
            if (!(overscrollEffect != null ? overscrollEffect.isInProgress() : false)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: toFloat-TH1AsA0, reason: not valid java name */
    public final float m309toFloatTH1AsA0(long j10) {
        return this.orientation == Orientation.Horizontal ? Velocity.m3898getXimpl(j10) : Velocity.m3899getYimpl(j10);
    }

    /* JADX INFO: renamed from: toFloat-k-4lQ0M, reason: not valid java name */
    public final float m310toFloatk4lQ0M(long j10) {
        return this.orientation == Orientation.Horizontal ? Offset.m1367getXimpl(j10) : Offset.m1368getYimpl(j10);
    }

    /* JADX INFO: renamed from: toOffset-tuRUvjQ, reason: not valid java name */
    public final long m311toOffsettuRUvjQ(float f10) {
        return (f10 > 0.0f ? 1 : (f10 == 0.0f ? 0 : -1)) == 0 ? Offset.Companion.m1383getZeroF1C5BW0() : this.orientation == Orientation.Horizontal ? OffsetKt.Offset(f10, 0.0f) : OffsetKt.Offset(0.0f, f10);
    }

    /* JADX INFO: renamed from: toVelocity-adjELrA, reason: not valid java name */
    public final long m312toVelocityadjELrA(float f10) {
        return this.orientation == Orientation.Horizontal ? VelocityKt.Velocity(f10, 0.0f) : VelocityKt.Velocity(0.0f, f10);
    }

    /* JADX INFO: renamed from: update-QWom1Mo, reason: not valid java name */
    public final long m313updateQWom1Mo(long j10, float f10) {
        return this.orientation == Orientation.Horizontal ? Velocity.m3894copyOhffZ5M$default(j10, f10, 0.0f, 2, null) : Velocity.m3894copyOhffZ5M$default(j10, 0.0f, f10, 1, null);
    }
}
