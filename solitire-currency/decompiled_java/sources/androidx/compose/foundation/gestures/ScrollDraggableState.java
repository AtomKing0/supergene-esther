package androidx.compose.foundation.gestures;

import androidx.compose.foundation.MutatePriority;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollDraggableState implements PointerAwareDraggableState, PointerAwareDragScope {

    @NotNull
    private ScrollScope latestScrollScope;

    @NotNull
    private final State<ScrollingLogic> scrollLogic;

    /* JADX INFO: renamed from: androidx.compose.foundation.gestures.ScrollDraggableState$drag$2, reason: invalid class name */
    /* JADX INFO: compiled from: Scrollable.kt */
    @kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollDraggableState$drag$2", f = "Scrollable.kt", l = {445}, m = "invokeSuspend")
    static final class AnonymousClass2 extends l implements p<ScrollScope, z8.d<? super k0>, Object> {
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
            AnonymousClass2 anonymousClass2 = ScrollDraggableState.this.new AnonymousClass2(this.$block, dVar);
            anonymousClass2.L$0 = obj;
            return anonymousClass2;
        }

        @Override // h9.p
        @Nullable
        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
        public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable z8.d<? super k0> dVar) {
            return ((AnonymousClass2) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
        }

        @Override // kotlin.coroutines.jvm.internal.a
        @Nullable
        public final Object invokeSuspend(@NotNull Object obj) {
            Object objE = a9.d.e();
            int i10 = this.label;
            if (i10 == 0) {
                u.b(obj);
                ScrollDraggableState.this.setLatestScrollScope((ScrollScope) this.L$0);
                p<PointerAwareDragScope, z8.d<? super k0>, Object> pVar = this.$block;
                ScrollDraggableState scrollDraggableState = ScrollDraggableState.this;
                this.label = 1;
                if (pVar.mo4invoke(scrollDraggableState, this) == objE) {
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

    public ScrollDraggableState(@NotNull State<ScrollingLogic> scrollLogic) {
        t.i(scrollLogic, "scrollLogic");
        this.scrollLogic = scrollLogic;
        this.latestScrollScope = ScrollableKt.NoOpScrollScope;
    }

    @Override // androidx.compose.foundation.gestures.PointerAwareDraggableState
    public void dispatchRawDelta(float f10) {
        ScrollingLogic value = this.scrollLogic.getValue();
        value.m307performRawScrollMKHz9U(value.m311toOffsettuRUvjQ(f10));
    }

    @Override // androidx.compose.foundation.gestures.PointerAwareDraggableState
    @Nullable
    public Object drag(@NotNull MutatePriority mutatePriority, @NotNull p<? super PointerAwareDragScope, ? super z8.d<? super k0>, ? extends Object> pVar, @NotNull z8.d<? super k0> dVar) {
        Object objScroll = this.scrollLogic.getValue().getScrollableState().scroll(mutatePriority, new AnonymousClass2(pVar, null), dVar);
        return objScroll == a9.d.e() ? objScroll : k0.f35197a;
    }

    @Override // androidx.compose.foundation.gestures.PointerAwareDragScope
    /* JADX INFO: renamed from: dragBy-Uv8p0NA */
    public void mo276dragByUv8p0NA(float f10, long j10) {
        ScrollingLogic value = this.scrollLogic.getValue();
        value.m305dispatchScrollf0eR0lY(this.latestScrollScope, value.m311toOffsettuRUvjQ(f10), Offset.m1356boximpl(j10), NestedScrollSource.Companion.m2787getDragWNlRxjI());
    }

    @NotNull
    public final ScrollScope getLatestScrollScope() {
        return this.latestScrollScope;
    }

    @NotNull
    public final State<ScrollingLogic> getScrollLogic() {
        return this.scrollLogic;
    }

    public final void setLatestScrollScope(@NotNull ScrollScope scrollScope) {
        t.i(scrollScope, "<set-?>");
        this.latestScrollScope = scrollScope;
    }
}
