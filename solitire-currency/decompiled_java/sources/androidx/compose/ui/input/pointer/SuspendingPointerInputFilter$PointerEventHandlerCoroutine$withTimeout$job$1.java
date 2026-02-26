package androidx.compose.ui.input.pointer;

import androidx.compose.ui.input.pointer.SuspendingPointerInputFilter;
import com.ironsource.mediationsdk.logger.IronSourceError;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1", f = "SuspendingPointerInputFilter.kt", l = {IronSourceError.ERROR_BN_BANNER_CONTAINER_IS_NULL, 618}, m = "invokeSuspend")
final class SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ long $timeMillis;
    int label;
    final /* synthetic */ SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1(long j10, SuspendingPointerInputFilter.PointerEventHandlerCoroutine<R> pointerEventHandlerCoroutine, z8.d<? super SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1> dVar) {
        super(2, dVar);
        this.$timeMillis = j10;
        this.this$0 = pointerEventHandlerCoroutine;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1(this.$timeMillis, this.this$0, dVar);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    @Override // kotlin.coroutines.jvm.internal.a
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(@org.jetbrains.annotations.NotNull java.lang.Object r9) {
        /*
            r8 = this;
            java.lang.Object r0 = a9.b.e()
            int r1 = r8.label
            r2 = 1
            r4 = 2
            r5 = 1
            if (r1 == 0) goto L20
            if (r1 == r5) goto L1c
            if (r1 != r4) goto L14
            v8.u.b(r9)
            goto L38
        L14:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L1c:
            v8.u.b(r9)
            goto L2f
        L20:
            v8.u.b(r9)
            long r6 = r8.$timeMillis
            long r6 = r6 - r2
            r8.label = r5
            java.lang.Object r9 = kotlinx.coroutines.y0.a(r6, r8)
            if (r9 != r0) goto L2f
            return r0
        L2f:
            r8.label = r4
            java.lang.Object r9 = kotlinx.coroutines.y0.a(r2, r8)
            if (r9 != r0) goto L38
            return r0
        L38:
            androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine<R> r9 = r8.this$0
            kotlinx.coroutines.o r9 = androidx.compose.ui.input.pointer.SuspendingPointerInputFilter.PointerEventHandlerCoroutine.access$getPointerAwaiter$p(r9)
            if (r9 == 0) goto L54
            v8.t$a r0 = v8.t.f35208b
            androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException r0 = new androidx.compose.ui.input.pointer.PointerEventTimeoutCancellationException
            long r1 = r8.$timeMillis
            r0.<init>(r1)
            java.lang.Object r0 = v8.u.a(r0)
            java.lang.Object r0 = v8.t.b(r0)
            r9.resumeWith(r0)
        L54:
            v8.k0 r9 = v8.k0.f35197a
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((SuspendingPointerInputFilter$PointerEventHandlerCoroutine$withTimeout$job$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
