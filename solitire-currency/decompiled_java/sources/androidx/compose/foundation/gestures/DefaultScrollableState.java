package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: ScrollableState.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultScrollableState implements ScrollableState {

    @NotNull
    private final MutableState<Boolean> isScrollingState;

    @NotNull
    private final l<Float, Float> onDelta;

    @NotNull
    private final MutatorMutex scrollMutex;

    @NotNull
    private final ScrollScope scrollScope;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: ScrollableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2", f = "ScrollableState.kt", l = {147}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<ScrollScope, z8.d<? super k0>, Object> $block;
        final /* synthetic */ MutatePriority $scrollPriority;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: ScrollableState.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DefaultScrollableState$scroll$2$1", f = "ScrollableState.kt", l = {150}, m = "invokeSuspend")
        static final class AnonymousClass1 extends kotlin.coroutines.jvm.internal.l implements p<ScrollScope, z8.d<? super k0>, Object> {
            final /* synthetic */ p<ScrollScope, z8.d<? super k0>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DefaultScrollableState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(DefaultScrollableState defaultScrollableState, p<? super ScrollScope, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.this$0 = defaultScrollableState;
                this.$block = pVar;
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @NotNull
            public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.this$0, this.$block, dVar);
                anonymousClass1.L$0 = obj;
                return anonymousClass1;
            }

            @Override // h9.p
            @Nullable
            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
            public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        u.b(obj);
                        ScrollScope scrollScope = (ScrollScope) this.L$0;
                        this.this$0.isScrollingState.setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        p<ScrollScope, z8.d<? super k0>, Object> pVar = this.$block;
                        this.label = 1;
                        if (pVar.mo4invoke(scrollScope, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    this.this$0.isScrollingState.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                    return k0.f35197a;
                } catch (Throwable th) {
                    this.this$0.isScrollingState.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(MutatePriority mutatePriority, p<? super ScrollScope, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$scrollPriority = mutatePriority;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return DefaultScrollableState.this.new AnonymousClass2(this.$scrollPriority, this.$block, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                MutatorMutex mutatorMutex = DefaultScrollableState.this.scrollMutex;
                ScrollScope scrollScope = DefaultScrollableState.this.scrollScope;
                MutatePriority mutatePriority = this.$scrollPriority;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DefaultScrollableState.this, this.$block, null);
                this.label = 1;
                if (mutatorMutex.mutateWith(scrollScope, mutatePriority, anonymousClass1, this) == objE) {
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
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultScrollableState(@NotNull l<? super Float, Float> onDelta) {
        t.i(onDelta, "onDelta");
        this.onDelta = onDelta;
        this.scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.DefaultScrollableState$scrollScope$1
            @Override // androidx.compose.foundation.gestures.ScrollScope
            public float scrollBy(float f10) {
                return this.this$0.getOnDelta().invoke(Float.valueOf(f10)).floatValue();
            }
        };
        this.scrollMutex = new MutatorMutex();
        this.isScrollingState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float dispatchRawDelta(float f10) {
        return this.onDelta.invoke(Float.valueOf(f10)).floatValue();
    }

    @NotNull
    public final l<Float, Float> getOnDelta() {
        return this.onDelta;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean isScrollInProgress() {
        return this.isScrollingState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    @Nullable
    public Object scroll(@NotNull MutatePriority mutatePriority, @NotNull p<? super ScrollScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objF = p0.f(new AnonymousClass2(mutatePriority, pVar, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }
}
