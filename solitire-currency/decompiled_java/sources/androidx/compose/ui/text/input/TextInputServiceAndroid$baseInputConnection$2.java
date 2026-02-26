package androidx.compose.ui.text.input;

import android.view.inputmethod.BaseInputConnection;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TextInputServiceAndroid.android.kt */
/* JADX INFO: loaded from: classes.dex */
final class TextInputServiceAndroid$baseInputConnection$2 extends v implements h9.a<BaseInputConnection> {
    final /* synthetic */ TextInputServiceAndroid this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TextInputServiceAndroid$baseInputConnection$2(TextInputServiceAndroid textInputServiceAndroid) {
        super(0);
        this.this$0 = textInputServiceAndroid;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.a
    @NotNull
    public final BaseInputConnection invoke() {
        return new BaseInputConnection(this.this$0.getView(), false);
    }
}
