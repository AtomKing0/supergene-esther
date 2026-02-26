package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Draggable.kt */
/* JADX INFO: loaded from: classes.dex */
final class IgnorePointerDraggableState implements PointerAwareDraggableState, PointerAwareDragScope {

    @Nullable
    private DragScope latestConsumptionScope;

    @NotNull
    private final DraggableState origin;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.IgnorePointerDraggableState$drag$2, reason: invalid class name */
    /* JADX INFO: compiled from: Draggable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.IgnorePointerDraggableState$drag$2", f = "Draggable.kt", l = {478}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<DragScope, z8.d<? super k0>, Object> {
        final /* synthetic */ p<PointerAwareDragScope, z8.d<? super k0>, Object> $block;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(p<? super PointerAwareDragScope, ? super z8.d<? super k0>, ? extends Object> pVar, z8.d<? super AnonymousClass2> dVar) {
            super(2, dVar);
            this.$block = pVar;
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @NotNull
        public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
            AnonymousClass2 anonymousClass2 = IgnorePointerDraggableState.this.new AnonymousClass2(this.$block, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull DragScope dragScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(dragScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                IgnorePointerDraggableState.this.setLatestConsumptionScope((DragScope) this.L$0);
                p<PointerAwareDragScope, z8.d<? super k0>, Object> pVar = this.$block;
                IgnorePointerDraggableState ignorePointerDraggableState = IgnorePointerDraggableState.this;
                this.label = 1;
                if (pVar.mo4invoke(ignorePointerDraggableState, this) == objE) {
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

    public IgnorePointerDraggableState(@NotNull DraggableState origin) {
        t.i(origin, "origin");
        this.origin = origin;
    }

    @Override // androidx.compose.foundation.gestures.PointerAwareDraggableState
    public void dispatchRawDelta(float f10) {
        this.origin.dispatchRawDelta(f10);
    }

    @Override // androidx.compose.foundation.gestures.PointerAwareDraggableState
    @Nullable
    public Object drag(@NotNull MutatePriority mutatePriority, @NotNull p<? super PointerAwareDragScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objDrag = this.origin.drag(mutatePriority, new AnonymousClass2(pVar, null), dVar);
        return objDrag == a9.d.e() ? objDrag : k0.f35197a;
    }

    @Override // androidx.compose.foundation.gestures.PointerAwareDragScope
    /* JADX INFO: renamed from: dragBy-Uv8p0NA, reason: not valid java name */
    public void mo276dragByUv8p0NA(float f10, long j10) {
        DragScope dragScope = this.latestConsumptionScope;
        if (dragScope != null) {
            dragScope.dragBy(f10);
        }
    }

    @Nullable
    public final DragScope getLatestConsumptionScope() {
        return this.latestConsumptionScope;
    }

    @NotNull
    public final DraggableState getOrigin() {
        return this.origin;
    }

    public final void setLatestConsumptionScope(@Nullable DragScope dragScope) {
        this.latestConsumptionScope = dragScope;
    }
}
