package androidx.compose.ui.platform;

/* JADX INFO: compiled from: AndroidTextToolbar.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class AndroidTextToolbar$textActionModeCallback$1 extends kotlin.jvm.internal.v implements h9.a<v8.k0> {
    final /* synthetic */ AndroidTextToolbar this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    AndroidTextToolbar$textActionModeCallback$1(AndroidTextToolbar androidTextToolbar) {
        super(0);
        this.this$0 = androidTextToolbar;
    }

    @Override // h9.a
    public /* bridge */ /* synthetic */ v8.k0 invoke() {
        invoke2();
        return v8.k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2() {
        this.this$0.actionMode = null;
    }
}
