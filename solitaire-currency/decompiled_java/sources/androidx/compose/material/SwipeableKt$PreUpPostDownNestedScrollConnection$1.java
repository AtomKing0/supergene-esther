package androidx.compose.material;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;

/* JADX INFO: compiled from: Swipeable.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SwipeableKt$PreUpPostDownNestedScrollConnection$1 implements NestedScrollConnection {
    final /* synthetic */ SwipeableState<T> $this_PreUpPostDownNestedScrollConnection;

    SwipeableKt$PreUpPostDownNestedScrollConnection$1(SwipeableState<T> swipeableState) {
        this.$this_PreUpPostDownNestedScrollConnection = swipeableState;
    }

    private final float toFloat(long j10) {
        return Offset.m1368getYimpl(j10);
    }

    private final long toOffset(float f10) {
        return OffsetKt.Offset(0.0f, f10);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: onPostFling-RZ2iAVY */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo301onPostFlingRZ2iAVY(long r5, long r7, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r4 = this;
            boolean r5 = r9 instanceof androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            if (r5 == 0) goto L13
            r5 = r9
            androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = (androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1) r5
            int r6 = r5.label
            r0 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r6 & r0
            if (r1 == 0) goto L13
            int r6 = r6 - r0
            r5.label = r6
            goto L18
        L13:
            androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1 r5 = new androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPostFling$1
            r5.<init>(r4, r9)
        L18:
            java.lang.Object r6 = r5.result
            java.lang.Object r9 = a9.b.e()
            int r0 = r5.label
            r1 = 1
            if (r0 == 0) goto L33
            if (r0 != r1) goto L2b
            long r7 = r5.J$0
            v8.u.b(r6)
            goto L53
        L2b:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L33:
            v8.u.b(r6)
            androidx.compose.material.SwipeableState<T> r6 = r4.$this_PreUpPostDownNestedScrollConnection
            float r0 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r7)
            float r2 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r7)
            long r2 = androidx.compose.ui.geometry.OffsetKt.Offset(r0, r2)
            float r0 = r4.toFloat(r2)
            r5.J$0 = r7
            r5.label = r1
            java.lang.Object r5 = r6.performFling(r0, r5)
            if (r5 != r9) goto L53
            return r9
        L53:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m3889boximpl(r7)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1.mo301onPostFlingRZ2iAVY(long, long, z8.d):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPostScroll-DzOQY0M */
    public long mo302onPostScrollDzOQY0M(long j10, long j11, int i10) {
        return NestedScrollSource.m2782equalsimpl0(i10, NestedScrollSource.Companion.m2787getDragWNlRxjI()) ? toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(toFloat(j11))) : Offset.Companion.m1383getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: onPreFling-QWom1Mo */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object mo303onPreFlingQWom1Mo(long r7, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1$onPreFling$1
            r0.<init>(r6, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            long r7 = r0.J$0
            v8.u.b(r9)
            goto L78
        L2b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L33:
            v8.u.b(r9)
            float r9 = androidx.compose.ui.unit.Velocity.m3898getXimpl(r7)
            float r2 = androidx.compose.ui.unit.Velocity.m3899getYimpl(r7)
            long r4 = androidx.compose.ui.geometry.OffsetKt.Offset(r9, r2)
            float r9 = r6.toFloat(r4)
            r2 = 0
            int r2 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r2 >= 0) goto L72
            androidx.compose.material.SwipeableState<T> r2 = r6.$this_PreUpPostDownNestedScrollConnection
            androidx.compose.runtime.State r2 = r2.getOffset()
            java.lang.Object r2 = r2.getValue()
            java.lang.Number r2 = (java.lang.Number) r2
            float r2 = r2.floatValue()
            androidx.compose.material.SwipeableState<T> r4 = r6.$this_PreUpPostDownNestedScrollConnection
            float r4 = r4.getMinBound$material_release()
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 <= 0) goto L72
            androidx.compose.material.SwipeableState<T> r2 = r6.$this_PreUpPostDownNestedScrollConnection
            r0.J$0 = r7
            r0.label = r3
            java.lang.Object r9 = r2.performFling(r9, r0)
            if (r9 != r1) goto L78
            return r1
        L72:
            androidx.compose.ui.unit.Velocity$Companion r7 = androidx.compose.ui.unit.Velocity.Companion
            long r7 = r7.m3909getZero9UxMQ8M()
        L78:
            androidx.compose.ui.unit.Velocity r7 = androidx.compose.ui.unit.Velocity.m3889boximpl(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableKt$PreUpPostDownNestedScrollConnection$1.mo303onPreFlingQWom1Mo(long, z8.d):java.lang.Object");
    }

    @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
    /* JADX INFO: renamed from: onPreScroll-OzD1aCk */
    public long mo304onPreScrollOzD1aCk(long j10, int i10) {
        float f10 = toFloat(j10);
        return (f10 >= 0.0f || !NestedScrollSource.m2782equalsimpl0(i10, NestedScrollSource.Companion.m2787getDragWNlRxjI())) ? Offset.Companion.m1383getZeroF1C5BW0() : toOffset(this.$this_PreUpPostDownNestedScrollConnection.performDrag(f10));
    }
}
