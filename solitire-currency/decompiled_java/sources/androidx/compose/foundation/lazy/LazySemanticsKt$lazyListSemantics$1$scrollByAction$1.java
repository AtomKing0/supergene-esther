package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
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
final class LazySemanticsKt$lazyListSemantics$1$scrollByAction$1 extends v implements p<Float, Float, Boolean> {
    final /* synthetic */ o0 $coroutineScope;
    final /* synthetic */ boolean $isVertical;
    final /* synthetic */ LazyListState $state;

    /* JADX INFO: renamed from: androidx.compose.foundation.lazy.LazySemanticsKt$lazyListSemantics$1$scrollByAction$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: LazySemantics.kt */
    @f(c = "androidx.compose.foundation.lazy.LazySemanticsKt$lazyListSemantics$1$scrollByAction$1$1", f = "LazySemantics.kt", l = {95}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ float $delta;
        final /* synthetic */ LazyListState $state;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(LazyListState lazyListState, float f10, d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$state = lazyListState;
            this.$delta = f10;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return new AnonymousClass1(this.$state, this.$delta, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                LazyListState lazyListState = this.$state;
                float f10 = this.$delta;
                this.label = 1;
                if (ScrollExtensionsKt.animateScrollBy$default(lazyListState, f10, null, this, 2, null) == objE) {
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
            return ((AnonymousClass1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LazySemanticsKt$lazyListSemantics$1$scrollByAction$1(boolean z10, o0 o0Var, LazyListState lazyListState) {
        super(2);
        this.$isVertical = z10;
        this.$coroutineScope = o0Var;
        this.$state = lazyListState;
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ Boolean mo4invoke(Float f10, Float f11) {
        return invoke(f10.floatValue(), f11.floatValue());
    }

    @NotNull
    public final Boolean invoke(float f10, float f11) {
        if (this.$isVertical) {
            f10 = f11;
        }
        k.d(this.$coroutineScope, null, null, new AnonymousClass1(this.$state, f10, null), 3, null);
        return Boolean.TRUE;
    }
}
