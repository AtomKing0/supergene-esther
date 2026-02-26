package androidx.compose.foundation;

import androidx.compose.ui.input.key.KeyEvent;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: Clickable.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableKt$genericClickableWithoutGesture$detectClickFromKey$1 extends v implements h9.l<KeyEvent, Boolean> {
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ h9.a<k0> $onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$detectClickFromKey$1(boolean z10, h9.a<k0> aVar) {
        super(1);
        this.$enabled = z10;
        this.$onClick = aVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ Boolean invoke(KeyEvent keyEvent) {
        return m199invokeZmokQxo(keyEvent.m2749unboximpl());
    }

    @NotNull
    /* JADX INFO: renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m199invokeZmokQxo(@NotNull android.view.KeyEvent it) {
        boolean z10;
        t.i(it, "it");
        if (this.$enabled && Clickable_androidKt.m200isClickZmokQxo(it)) {
            this.$onClick.invoke();
            z10 = true;
        } else {
            z10 = false;
        }
        return Boolean.valueOf(z10);
    }
}
