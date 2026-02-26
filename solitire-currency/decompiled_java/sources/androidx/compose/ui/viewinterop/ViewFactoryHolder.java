package androidx.compose.ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.platform.AbstractComposeView;
import androidx.compose.ui.platform.ViewRootForInspector;
import androidx.compose.ui.platform.e2;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidView.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {

    @Nullable
    private l<? super Context, ? extends T> factory;

    @Nullable
    private T typedView;

    @NotNull
    private l<? super T, k0> updateBlock;

    public /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher, int i10, k kVar) {
        this(context, (i10 & 2) != 0 ? null : compositionContext, (i10 & 4) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher);
    }

    @Nullable
    public final l<Context, T> getFactory() {
        return this.factory;
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    public /* synthetic */ AbstractComposeView getSubCompositionView() {
        return e2.a(this);
    }

    @Nullable
    public final T getTypedView$ui_release() {
        return this.typedView;
    }

    @NotNull
    public final l<T, k0> getUpdateBlock() {
        return this.updateBlock;
    }

    public final void setFactory(@Nullable l<? super Context, ? extends T> lVar) {
        this.factory = lVar;
        if (lVar != null) {
            Context context = getContext();
            t.h(context, "context");
            T tInvoke = lVar.invoke(context);
            this.typedView = tInvoke;
            setView$ui_release(tInvoke);
        }
    }

    public final void setTypedView$ui_release(@Nullable T t10) {
        this.typedView = t10;
    }

    public final void setUpdateBlock(@NotNull l<? super T, k0> value) {
        t.i(value, "value");
        this.updateBlock = value;
        setUpdate(new ViewFactoryHolder$updateBlock$1(this));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(@NotNull Context context, @Nullable CompositionContext compositionContext, @NotNull NestedScrollDispatcher dispatcher) {
        super(context, compositionContext, dispatcher);
        t.i(context, "context");
        t.i(dispatcher, "dispatcher");
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
    }

    @Override // androidx.compose.ui.platform.ViewRootForInspector
    @NotNull
    public View getViewRoot() {
        return this;
    }
}
