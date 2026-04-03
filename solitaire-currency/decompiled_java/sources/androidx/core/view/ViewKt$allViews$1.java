package androidx.core.view;

import android.view.View;
import android.view.ViewGroup;
import com.ironsource.c3;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: View.kt */
/* JADX INFO: loaded from: classes.dex */
@kotlin.coroutines.jvm.internal.f(c = "androidx.core.view.ViewKt$allViews$1", f = "View.kt", l = {c3.a.b.f11500i, c3.a.b.f11502k}, m = "invokeSuspend")
final class ViewKt$allViews$1 extends kotlin.coroutines.jvm.internal.k implements h9.p<o9.i<? super View>, z8.d<? super v8.k0>, Object> {
    final /* synthetic */ View $this_allViews;
    private /* synthetic */ Object L$0;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewKt$allViews$1(View view, z8.d<? super ViewKt$allViews$1> dVar) {
        super(2, dVar);
        this.$this_allViews = view;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @NotNull
    public final z8.d<v8.k0> create(@Nullable Object obj, @NotNull z8.d<?> dVar) {
        ViewKt$allViews$1 viewKt$allViews$1 = new ViewKt$allViews$1(this.$this_allViews, dVar);
        viewKt$allViews$1.L$0 = obj;
        return viewKt$allViews$1;
    }

    @Override // kotlin.coroutines.jvm.internal.a
    @Nullable
    public final Object invokeSuspend(@NotNull Object obj) {
        o9.i iVar;
        Object objE = a9.d.e();
        int i10 = this.label;
        if (i10 == 0) {
            v8.u.b(obj);
            iVar = (o9.i) this.L$0;
            View view = this.$this_allViews;
            this.L$0 = iVar;
            this.label = 1;
            if (iVar.a(view, this) == objE) {
                return objE;
            }
        } else {
            if (i10 != 1) {
                if (i10 != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                v8.u.b(obj);
                return v8.k0.f35197a;
            }
            iVar = (o9.i) this.L$0;
            v8.u.b(obj);
        }
        View view2 = this.$this_allViews;
        if (view2 instanceof ViewGroup) {
            o9.g<View> descendants = ViewGroupKt.getDescendants((ViewGroup) view2);
            this.L$0 = null;
            this.label = 2;
            if (iVar.e(descendants, this) == objE) {
                return objE;
            }
        }
        return v8.k0.f35197a;
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull o9.i<? super View> iVar, @Nullable z8.d<? super v8.k0> dVar) {
        return ((ViewKt$allViews$1) create(iVar, dVar)).invokeSuspend(v8.k0.f35197a);
    }
}
