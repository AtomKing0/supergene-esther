package androidx.compose.foundation.gestures;

import androidx.compose.runtime.State;
import androidx.compose.ui.input.pointer.PointerInputScope;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Transformable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1", f = "Transformable.kt", l = {71}, m = "invokeSuspend")
final class TransformableKt$transformable$2$block$1$1 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
    final /* synthetic */ State<Boolean> $updatePanZoomLock;
    final /* synthetic */ State<TransformableState> $updatedState;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: Transformable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.TransformableKt$transformable$2$block$1$1$1", f = "Transformable.kt", l = {72}, m = "invokeSuspend")
    static final class AnonymousClass1 extends l implements p<PointerInputScope, z8.d<? super k0>, Object> {
        final /* synthetic */ State<Boolean> $updatePanZoomLock;
        final /* synthetic */ State<TransformableState> $updatedState;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(State<Boolean> state, State<? extends TransformableState> state2, z8.d<? super AnonymousClass1> dVar) {
            super(2, dVar);
            this.$updatePanZoomLock = state;
            this.$updatedState = state2;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updatePanZoomLock, this.$updatedState, dVar);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
                State<Boolean> state = this.$updatePanZoomLock;
                State<TransformableState> state2 = this.$updatedState;
                this.label = 1;
                if (TransformableKt.detectZoom(pointerInputScope, state, state2, this) == objE) {
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

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    TransformableKt$transformable$2$block$1$1(State<Boolean> state, State<? extends TransformableState> state2, z8.d<? super TransformableKt$transformable$2$block$1$1> dVar) {
        super(2, dVar);
        this.$updatePanZoomLock = state;
        this.$updatedState = state2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        TransformableKt$transformable$2$block$1$1 transformableKt$transformable$2$block$1$1 = new TransformableKt$transformable$2$block$1$1(this.$updatePanZoomLock, this.$updatedState, dVar);
        transformableKt$transformable$2$block$1$1.L$0 = obj;
        return transformableKt$transformable$2$block$1$1;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull PointerInputScope pointerInputScope, @Nullable z8.d<? super k0> dVar) {
        return ((TransformableKt$transformable$2$block$1$1) create(pointerInputScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            PointerInputScope pointerInputScope = (PointerInputScope) this.L$0;
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$updatePanZoomLock, this.$updatedState, null);
            this.label = 1;
            if (ForEachGestureKt.forEachGesture(pointerInputScope, anonymousClass1, this) == objE) {
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
