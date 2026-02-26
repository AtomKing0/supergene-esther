package androidx.compose.ui.platform;

/* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$1 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
    final /* synthetic */ ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1 $listener;
    final /* synthetic */ AbstractComposeView $view;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$1(AbstractComposeView abstractComposeView, ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1 viewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1) {
        super(0);
        this.$view = abstractComposeView;
        this.$listener = viewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$listener$1;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ v8.k0 invoke() {
        invoke2();
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$view.removeOnAttachStateChangeListener(this.$listener);
    }
}
