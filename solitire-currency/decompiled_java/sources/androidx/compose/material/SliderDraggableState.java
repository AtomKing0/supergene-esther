package androidx.compose.material;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.MutatorMutex;
import androidx.compose.foundation.gestures.DragScope;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import h9.l;
import h9.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.jvm.internal.t;
import kotlinx.coroutines.o0;
import kotlinx.coroutines.p0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;
import z8.d;

/* JADX INFO: compiled from: Slider.kt */
/* JADX INFO: loaded from: classes.dex */
final class SliderDraggableState implements DraggableState {

    @NotNull
    private final DragScope dragScope;

    @NotNull
    private final MutableState isDragging$delegate;

    @NotNull
    private final l<Float, k0> onDelta;

    @NotNull
    private final MutatorMutex scrollMutex;

    /* JADX INFO: renamed from: androidx.compose.material.SliderDraggableState$drag$2, reason: invalid class name */
    /* JADX INFO: compiled from: Slider.kt */
    @f(c = "androidx.compose.material.SliderDraggableState$drag$2", f = "Slider.kt", l = {1156}, m = "invokeSuspend")
    static final class AnonymousClass2 extends kotlin.coroutines.jvm.internal.l implements p<o0, d<? super k0>, Object> {
        final /* synthetic */ p<DragScope, d<? super k0>, Object> $block;
        final /* synthetic */ MutatePriority $dragPriority;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(MutatePriority mutatePriority, p<? super DragScope, ? super d<? super k0>, ? extends Object> pVar, d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$dragPriority = mutatePriority;
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final d<k0> create(@Nullable Object obj, @NotNull d<?> dVar) {
            return SliderDraggableState.this.new AnonymousClass2(this.$dragPriority, this.$block, dVar);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                SliderDraggableState.this.setDragging(true);
                MutatorMutex mutatorMutex = SliderDraggableState.this.scrollMutex;
                DragScope dragScope = SliderDraggableState.this.dragScope;
                MutatePriority mutatePriority = this.$dragPriority;
                p<DragScope, d<? super k0>, Object> pVar = this.$block;
                this.label = 1;
                if (mutatorMutex.mutateWith(dragScope, mutatePriority, pVar, this) == objE) {
                    return objE;
                }
            } else {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                u.b(obj);
            }
            SliderDraggableState.this.setDragging(false);
            return k0.f35197a;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull o0 o0Var, @Nullable d<? super k0> dVar) {
            return ((AnonymousClass2) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public SliderDraggableState(@NotNull l<? super Float, k0> onDelta) {
        t.i(onDelta, "onDelta");
        this.onDelta = onDelta;
        this.isDragging$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.dragScope = new DragScope() { // from class: androidx.compose.material.SliderDraggableState$dragScope$1
            @Override // androidx.compose.foundation.gestures.DragScope
            public void dragBy(float f10) {
                this.this$0.getOnDelta().invoke(Float.valueOf(f10));
            }
        };
        this.scrollMutex = new MutatorMutex();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDragging(boolean z10) {
        this.isDragging$delegate.setValue(Boolean.valueOf(z10));
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    public void dispatchRawDelta(float f10) {
        this.onDelta.invoke(Float.valueOf(f10));
    }

    @Override // androidx.compose.foundation.gestures.DraggableState
    @Nullable
    public Object drag(@NotNull MutatePriority mutatePriority, @NotNull p<? super DragScope, ? super d<? super k0>, ? extends Object> pVar, @NotNull d<? super k0> dVar) {
        Object objF = p0.f(new AnonymousClass2(mutatePriority, pVar, null), dVar);
        return objF == a9.d.e() ? objF : k0.f35197a;
    }

    @NotNull
    public final l<Float, k0> getOnDelta() {
        return this.onDelta;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isDragging() {
        return ((Boolean) this.isDragging$delegate.getValue()).booleanValue();
    }
}
