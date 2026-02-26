package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.m0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2", f = "Scrollable.kt", l = {412}, m = "invokeSuspend")
final class ScrollingLogic$doFlingAnimation$2 extends l implements p<ScrollScope, z8.d<? super k0>, Object> {
    final /* synthetic */ long $available;
    final /* synthetic */ m0 $result;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$2(ScrollingLogic scrollingLogic, m0 m0Var, long j10, z8.d<? super ScrollingLogic$doFlingAnimation$2> dVar) {
        super(2, dVar);
        this.this$0 = scrollingLogic;
        this.$result = m0Var;
        this.$available = j10;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        ScrollingLogic$doFlingAnimation$2 scrollingLogic$doFlingAnimation$2 = new ScrollingLogic$doFlingAnimation$2(this.this$0, this.$result, this.$available, dVar);
        scrollingLogic$doFlingAnimation$2.L$0 = obj;
        return scrollingLogic$doFlingAnimation$2;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull ScrollScope scrollScope, @Nullable z8.d<? super k0> dVar) {
        return ((ScrollingLogic$doFlingAnimation$2) create(scrollScope, dVar)).invokeSuspend(k0.f35197a);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        ScrollingLogic scrollingLogic;
        m0 m0Var;
        ScrollingLogic scrollingLogic2;
        long j10;
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            final ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1 scrollingLogic$doFlingAnimation$2$outerScopeScroll$1 = new ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(this.this$0, (ScrollScope) this.L$0);
            final ScrollingLogic scrollingLogic3 = this.this$0;
            ScrollScope scrollScope = new ScrollScope() { // from class: androidx.compose.foundation.gestures.ScrollingLogic$doFlingAnimation$2$scope$1
                @Override // androidx.compose.foundation.gestures.ScrollScope
                public float scrollBy(float f10) {
                    ScrollingLogic scrollingLogic4 = scrollingLogic3;
                    return scrollingLogic4.m310toFloatk4lQ0M(scrollingLogic$doFlingAnimation$2$outerScopeScroll$1.invoke(Offset.m1356boximpl(scrollingLogic4.m311toOffsettuRUvjQ(f10))).m1377unboximpl());
                }
            };
            scrollingLogic = this.this$0;
            m0 m0Var2 = this.$result;
            long j11 = this.$available;
            FlingBehavior flingBehavior = scrollingLogic.getFlingBehavior();
            long j12 = m0Var2.f29833a;
            float fReverseIfNeeded = scrollingLogic.reverseIfNeeded(scrollingLogic.m309toFloatTH1AsA0(j11));
            this.L$0 = scrollingLogic;
            this.L$1 = scrollingLogic;
            this.L$2 = m0Var2;
            this.J$0 = j12;
            this.label = 1;
            obj = flingBehavior.performFling(scrollScope, fReverseIfNeeded, this);
            if (obj == objE) {
                return objE;
            }
            m0Var = m0Var2;
            scrollingLogic2 = scrollingLogic;
            j10 = j12;
        } else {
            if (i10 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            j10 = this.J$0;
            m0Var = (m0) this.L$2;
            scrollingLogic = (ScrollingLogic) this.L$1;
            scrollingLogic2 = (ScrollingLogic) this.L$0;
            u.b(obj);
        }
        m0Var.f29833a = scrollingLogic.m313updateQWom1Mo(j10, scrollingLogic2.reverseIfNeeded(((Number) obj).floatValue()));
        return k0.f35197a;
    }
}
