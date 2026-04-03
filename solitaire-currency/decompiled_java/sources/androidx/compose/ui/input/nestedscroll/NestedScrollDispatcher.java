package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class NestedScrollDispatcher {
    public static final int $stable = 8;

    @NotNull
    private h9.a<? extends o0> calculateNestedScrollScope = new NestedScrollDispatcher$calculateNestedScrollScope$1(this);

    @Nullable
    private o0 originNestedScrollScope;

    @Nullable
    private NestedScrollConnection parent;

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: dispatchPostFling-RZ2iAVY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m2775dispatchPostFlingRZ2iAVY(long r8, long r10, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r12) {
        /*
            r7 = this;
            boolean r0 = r12 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            if (r0 == 0) goto L13
            r0 = r12
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPostFling$1
            r0.<init>(r7, r12)
        L18:
            r6 = r0
            java.lang.Object r12 = r6.result
            java.lang.Object r0 = a9.b.e()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L32
            if (r1 != r2) goto L2a
            v8.u.b(r12)
            goto L44
        L2a:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L32:
            v8.u.b(r12)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r1 = r7.parent
            if (r1 == 0) goto L4b
            r6.label = r2
            r2 = r8
            r4 = r10
            java.lang.Object r12 = r1.mo301onPostFlingRZ2iAVY(r2, r4, r6)
            if (r12 != r0) goto L44
            return r0
        L44:
            androidx.compose.ui.unit.Velocity r12 = (androidx.compose.ui.unit.Velocity) r12
            long r8 = r12.m3907unboximpl()
            goto L51
        L4b:
            androidx.compose.ui.unit.Velocity$Companion r8 = androidx.compose.ui.unit.Velocity.Companion
            long r8 = r8.m3909getZero9UxMQ8M()
        L51:
            androidx.compose.ui.unit.Velocity r8 = androidx.compose.ui.unit.Velocity.m3889boximpl(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.m2775dispatchPostFlingRZ2iAVY(long, long, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: dispatchPostScroll-DzOQY0M, reason: not valid java name */
    public final long m2776dispatchPostScrollDzOQY0M(long j10, long j11, int i10) {
        NestedScrollConnection nestedScrollConnection = this.parent;
        return nestedScrollConnection != null ? nestedScrollConnection.mo302onPostScrollDzOQY0M(j10, j11, i10) : Offset.Companion.m1383getZeroF1C5BW0();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @org.jetbrains.annotations.Nullable
    /* JADX INFO: renamed from: dispatchPreFling-QWom1Mo, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object m2777dispatchPreFlingQWom1Mo(long r5, @org.jetbrains.annotations.NotNull z8.d<? super androidx.compose.ui.unit.Velocity> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            if (r0 == 0) goto L13
            r0 = r7
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = (androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1 r0 = new androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher$dispatchPreFling$1
            r0.<init>(r4, r7)
        L18:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = a9.b.e()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            v8.u.b(r7)
            goto L41
        L29:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L31:
            v8.u.b(r7)
            androidx.compose.ui.input.nestedscroll.NestedScrollConnection r7 = r4.parent
            if (r7 == 0) goto L48
            r0.label = r3
            java.lang.Object r7 = r7.mo303onPreFlingQWom1Mo(r5, r0)
            if (r7 != r1) goto L41
            return r1
        L41:
            androidx.compose.ui.unit.Velocity r7 = (androidx.compose.ui.unit.Velocity) r7
            long r5 = r7.m3907unboximpl()
            goto L4e
        L48:
            androidx.compose.ui.unit.Velocity$Companion r5 = androidx.compose.ui.unit.Velocity.Companion
            long r5 = r5.m3909getZero9UxMQ8M()
        L4e:
            androidx.compose.ui.unit.Velocity r5 = androidx.compose.ui.unit.Velocity.m3889boximpl(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher.m2777dispatchPreFlingQWom1Mo(long, z8.d):java.lang.Object");
    }

    /* JADX INFO: renamed from: dispatchPreScroll-OzD1aCk, reason: not valid java name */
    public final long m2778dispatchPreScrollOzD1aCk(long j10, int i10) {
        NestedScrollConnection nestedScrollConnection = this.parent;
        return nestedScrollConnection != null ? nestedScrollConnection.mo304onPreScrollOzD1aCk(j10, i10) : Offset.Companion.m1383getZeroF1C5BW0();
    }

    @NotNull
    public final h9.a<o0> getCalculateNestedScrollScope$ui_release() {
        return this.calculateNestedScrollScope;
    }

    @NotNull
    public final o0 getCoroutineScope() {
        o0 o0VarInvoke = this.calculateNestedScrollScope.invoke();
        if (o0VarInvoke != null) {
            return o0VarInvoke;
        }
        throw new IllegalStateException("in order to access nested coroutine scope you need to attach dispatcher to the `Modifier.nestedScroll` first.");
    }

    @Nullable
    public final o0 getOriginNestedScrollScope$ui_release() {
        return this.originNestedScrollScope;
    }

    @Nullable
    public final NestedScrollConnection getParent$ui_release() {
        return this.parent;
    }

    public final void setCalculateNestedScrollScope$ui_release(@NotNull h9.a<? extends o0> aVar) {
        t.i(aVar, "<set-?>");
        this.calculateNestedScrollScope = aVar;
    }

    public final void setOriginNestedScrollScope$ui_release(@Nullable o0 o0Var) {
        this.originNestedScrollScope = o0Var;
    }

    public final void setParent$ui_release(@Nullable NestedScrollConnection nestedScrollConnection) {
        this.parent = nestedScrollConnection;
    }
}
