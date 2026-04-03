package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Rect;
import h9.p;
import kotlin.coroutines.jvm.internal.l;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.u;

/* JADX INFO: compiled from: Scrollable.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.compose.foundation.gestures.ContentInViewModifier$onSizeChanged$1", f = "Scrollable.kt", l = {578}, m = "invokeSuspend")
final class ContentInViewModifier$onSizeChanged$1 extends l implements p<o0, z8.d<? super k0>, Object> {
    final /* synthetic */ Rect $adjustedBounds;
    final /* synthetic */ Rect $focusedBounds;
    int label;
    final /* synthetic */ ContentInViewModifier this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ContentInViewModifier$onSizeChanged$1(ContentInViewModifier contentInViewModifier, Rect rect, Rect rect2, z8.d<? super ContentInViewModifier$onSizeChanged$1> dVar) {
        super(2, dVar);
        this.this$0 = contentInViewModifier;
        this.$focusedBounds = rect;
        this.$adjustedBounds = rect2;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        return new ContentInViewModifier$onSizeChanged$1(this.this$0, this.$focusedBounds, this.$adjustedBounds, dVar);
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            u.b(obj);
            ContentInViewModifier contentInViewModifier = this.this$0;
            Rect rect = this.$focusedBounds;
            Rect rect2 = this.$adjustedBounds;
            this.label = 1;
            if (contentInViewModifier.performBringIntoView(rect, rect2, this) == objE) {
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
        return ((ContentInViewModifier$onSizeChanged$1) create(o0Var, dVar)).invokeSuspend(k0.f35197a);
    }
}
