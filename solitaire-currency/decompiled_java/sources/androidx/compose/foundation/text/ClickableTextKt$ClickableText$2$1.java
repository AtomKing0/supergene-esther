package androidx.compose.foundation.text;

import androidx.compose.runtime.MutableState;
import androidx.compose.ui.text.TextLayoutResult;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ClickableText.kt */
/* JADX INFO: loaded from: classes.dex */
final class ClickableTextKt$ClickableText$2$1 extends v implements l<TextLayoutResult, k0> {
    final /* synthetic */ MutableState<TextLayoutResult> $layoutResult;
    final /* synthetic */ l<TextLayoutResult, k0> $onTextLayout;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    ClickableTextKt$ClickableText$2$1(MutableState<TextLayoutResult> mutableState, l<? super TextLayoutResult, k0> lVar) {
        super(1);
        this.$layoutResult = mutableState;
        this.$onTextLayout = lVar;
    }

    @Override // h9.l
    public /* bridge */ /* synthetic */ k0 invoke(TextLayoutResult textLayoutResult) {
        invoke2(textLayoutResult);
        return k0.f35197a;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(@NotNull TextLayoutResult it) {
        t.i(it, "it");
        this.$layoutResult.setValue(it);
        this.$onTextLayout.invoke(it);
    }
}
