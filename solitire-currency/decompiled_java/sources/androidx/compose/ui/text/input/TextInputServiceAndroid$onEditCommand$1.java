package androidx.compose.ui.text.input;

import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextInputServiceAndroid$onEditCommand$1 extends v implements l<List<? extends EditCommand>, k0> {
    public static final TextInputServiceAndroid$onEditCommand$1 INSTANCE = new TextInputServiceAndroid$onEditCommand$1();

    TextInputServiceAndroid$onEditCommand$1() {
        super(1);
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull List<? extends EditCommand> it) {
        t.i(it, "it");
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(List<? extends EditCommand> list) {
        invoke2(list);
        return k0.f35197a;
    }
}
