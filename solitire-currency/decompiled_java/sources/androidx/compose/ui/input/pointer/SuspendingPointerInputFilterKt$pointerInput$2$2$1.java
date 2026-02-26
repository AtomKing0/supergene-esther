package androidx.compose.ui.input.pointer;

import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: SuspendingPointerInputFilter.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$pointerInput$2$2$1", f = "SuspendingPointerInputFilter.kt", l = {243}, m = "invokeSuspend")
final class SuspendingPointerInputFilterKt$pointerInput$2$2$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ p<PointerInputScope, z8.d<? super k0>, Object> $block;
    final /* synthetic */ SuspendingPointerInputFilter $filter;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    SuspendingPointerInputFilterKt$pointerInput$2$2$1(SuspendingPointerInputFilter suspendingPointerInputFilter, p<? super PointerInputScope, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super SuspendingPointerInputFilterKt$pointerInput$2$2$1> dVar) {
        super(2, dVar);
        this.$filter = suspendingPointerInputFilter;
        this.$block = pVar;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        SuspendingPointerInputFilterKt$pointerInput$2$2$1 suspendingPointerInputFilterKt$pointerInput$2$2$1 = new SuspendingPointerInputFilterKt$pointerInput$2$2$1(this.$filter, this.$block, dVar);
        suspendingPointerInputFilterKt$pointerInput$2$2$1.L$0 = obj;
        return suspendingPointerInputFilterKt$pointerInput$2$2$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            this.$filter.setCoroutineScope((o0) this.L$0);
            p<PointerInputScope, z8.d<? super k0>, Object> pVar = this.$block;
            SuspendingPointerInputFilter suspendingPointerInputFilter = this.$filter;
            this.label = 1;
            if (pVar.mo4invoke(suspendingPointerInputFilter, this) == objE) {
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

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o0 o0Var, @Nullable z8.d<? super k0> dVar) {
        return ((SuspendingPointerInputFilterKt$pointerInput$2$2$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
