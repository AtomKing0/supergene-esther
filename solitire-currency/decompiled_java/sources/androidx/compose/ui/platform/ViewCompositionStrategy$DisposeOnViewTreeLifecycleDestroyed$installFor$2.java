package androidx.compose.ui.platform;

/* JADX INFO: compiled from: ViewCompositionStrategy.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
    final /* synthetic */ kotlin.jvm.internal.n0<h9.a<v8.k0>> $disposer;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ViewCompositionStrategy$DisposeOnViewTreeLifecycleDestroyed$installFor$2(kotlin.jvm.internal.n0<h9.a<v8.k0>> n0Var) {
        super(0);
        this.$disposer = n0Var;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ v8.k0 invoke() {
        invoke2();
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.$disposer.f29834a.invoke();
    }
}
