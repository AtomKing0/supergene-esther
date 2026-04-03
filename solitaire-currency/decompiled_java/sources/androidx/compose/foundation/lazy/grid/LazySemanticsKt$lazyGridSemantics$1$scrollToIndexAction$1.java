package androidx.compose.foundation.lazy.grid;

import h9.l;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.k;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: LazySemantics.kt */
/* JADX INFO: loaded from: classes.dex */
final class LazySemanticsKt$lazyGridSemantics$1$scrollToIndexAction$1 extends v implements l<Integer, Boolean> {
    final /* synthetic */ o0 $coroutineScope;
    final /* synthetic */ LazyGridState $state;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.grid.LazySemanticsKt$lazyGridSemantics$1$scrollToIndexAction$1$2, reason: invalid class name */
    /* JADX INFO: compiled from: LazySemantics.kt */
    @f(c = "androidx.compose.foundation.lazy.grid.LazySemanticsKt$lazyGridSemantics$1$scrollToIndexAction$1$2", f = "LazySemantics.kt", l = {112}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ int $index;
        final /* synthetic */ LazyGridState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(LazyGridState lazyGridState, int i10, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$state = lazyGridState;
            this.$index = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass2(this.$state, this.$index, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                LazyGridState lazyGridState = this.$state;
                int i11 = this.$index;
                this.label = 1;
                if (LazyGridState.scrollToItem$default(lazyGridState, i11, 0, this, 2, null) == objE) {
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
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyGridSemantics$1$scrollToIndexAction$1(LazyGridState lazyGridState, o0 o0Var) {
        super(1);
        this.$state = lazyGridState;
        this.$coroutineScope = o0Var;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(Integer num) {
        return invoke(num.intValue());
    }

    @NotNull
    public final Boolean invoke(int i10) {
        boolean z10 = i10 >= 0 && i10 < this.$state.getLayoutInfo().getTotalItemsCount();
        LazyGridState lazyGridState = this.$state;
        if (z10) {
            k.d(this.$coroutineScope, null, null, new AnonymousClass2(lazyGridState, i10, null), 3, null);
            return Boolean.TRUE;
        }
        throw new IllegalArgumentException(("Can't scroll to index " + i10 + ", it is out of bounds [0, " + lazyGridState.getLayoutInfo().getTotalItemsCount() + ')').toString());
    }
}
