package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Offset;
import h9.p;
import h9.q;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: TransformableState.kt */
/* JADX INFO: loaded from: classes.dex */
final class DefaultTransformableState implements TransformableState {

    @NotNull
    private final MutableState<Boolean> isTransformingState;

    @NotNull
    private final q<Float, Offset, Float, k0> onTransformation;

    @NotNull
    private final MutatorMutex transformMutex;

    @NotNull
    private final TransformScope transformScope;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultTransformableState$transform$2, reason: invalid class name */
    /* JADX INFO: compiled from: TransformableState.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2", f = "TransformableState.kt", l = {249}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<o0, z8.d<? super k0>, Object> {
        final /* synthetic */ p<TransformScope, z8.d<? super k0>, Object> $block;
        final /* synthetic */ MutatePriority $transformPriority;
        int label;

        /* JADX INFO: renamed from: androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1, reason: invalid class name */
        /* JADX INFO: compiled from: TransformableState.kt */
        @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.DefaultTransformableState$transform$2$1", f = "TransformableState.kt", l = {252}, m = "invokeSuspend")
        static final class AnonymousClass1 extends l implements p<TransformScope, z8.d<? super k0>, Object> {
            final /* synthetic */ p<TransformScope, z8.d<? super k0>, Object> $block;
            private /* synthetic */ Object L$0;
            int label;
            final /* synthetic */ DefaultTransformableState this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(DefaultTransformableState defaultTransformableState, p<? super TransformScope, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass1> dVar) {
                super(2, dVar);
                this.this$0 = defaultTransformableState;
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
            public final Object mo4invoke(@NotNull TransformScope transformScope, @Nullable z8.d<? super k0> dVar) {
                return ((AnonymousClass1) create(transformScope, dVar)).invokeSuspend(k0.f35197a);
            }

            @Override // kotlin.coroutines.jvm.internal.a
            @Nullable
            public final Object invokeSuspend(@NotNull Object obj) {
                Object objE = a9.d.e();
                int i10 = this.label;
                try {
                    if (i10 == 0) {
                        u.b(obj);
                        TransformScope transformScope = (TransformScope) this.L$0;
                        this.this$0.isTransformingState.setValue(kotlin.coroutines.jvm.internal.b.a(true));
                        p<TransformScope, z8.d<? super k0>, Object> pVar = this.$block;
                        this.label = 1;
                        if (pVar.mo4invoke(transformScope, this) == objE) {
                            return objE;
                        }
                    } else {
                        if (i10 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        u.b(obj);
                    }
                    this.this$0.isTransformingState.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                    return k0.f35197a;
                } catch (Throwable th) {
                    this.this$0.isTransformingState.setValue(kotlin.coroutines.jvm.internal.b.a(false));
                    throw th;
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(MutatePriority mutatePriority, p<? super TransformScope, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$transformPriority = mutatePriority;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            return DefaultTransformableState.this.new AnonymousClass2(this.$transformPriority, this.$block, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                MutatorMutex mutatorMutex = DefaultTransformableState.this.transformMutex;
                TransformScope transformScope = DefaultTransformableState.this.transformScope;
                MutatePriority mutatePriority = this.$transformPriority;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(DefaultTransformableState.this, this.$block, null);
                this.label = 1;
                if (mutatorMutex.mutateWith(transformScope, mutatePriority, anonymousClass1, this) == objE) {
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
    public DefaultTransformableState(@NotNull q<? super Float, ? super Offset, ? super Float, k0> onTransformation) {
        t.i(onTransformation, "onTransformation");
        this.onTransformation = onTransformation;
        this.transformScope = new TransformScope() { // from class: androidx.compose.foundation.gestures.DefaultTransformableState$transformScope$1
            @Override // androidx.compose.foundation.gestures.TransformScope
            /* JADX INFO: renamed from: transformBy-d-4ec7I, reason: not valid java name */
            public void mo242transformByd4ec7I(float f10, long j10, float f11) {
                this.this$0.getOnTransformation().invoke(Float.valueOf(f10), Offset.m1356boximpl(j10), Float.valueOf(f11));
            }
        };
        this.transformMutex = new MutatorMutex();
        this.isTransformingState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
    }

    @NotNull
    public final q<Float, Offset, Float, k0> getOnTransformation() {
        return this.onTransformation;
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    public boolean isTransformInProgress() {
        return this.isTransformingState.getValue().booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.TransformableState
    @Nullable
    public Object transform(@NotNull MutatePriority mutatePriority, @NotNull p<? super TransformScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objF = p0.f(new AnonymousClass2(mutatePriority, pVar, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }
}
