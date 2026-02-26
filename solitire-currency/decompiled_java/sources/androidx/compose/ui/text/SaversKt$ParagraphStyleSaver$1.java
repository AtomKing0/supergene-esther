package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.TextUnit;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$ParagraphStyleSaver$1 extends v implements p<SaverScope, ParagraphStyle, Object> {
    public static final SaversKt$ParagraphStyleSaver$1 INSTANCE = new SaversKt$ParagraphStyleSaver$1();

    SaversKt$ParagraphStyleSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull ParagraphStyle it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return kotlin.collections.v.f(SaversKt.save(it.m3269getTextAlignbuA522U()), SaversKt.save(it.m3270getTextDirectionmmuk1to()), SaversKt.save(TextUnit.m3844boximpl(it.m3268getLineHeightXSAIIZE()), SaversKt.getSaver(TextUnit.Companion), Saver), SaversKt.save(it.getTextIndent(), SaversKt.getSaver(TextIndent.Companion), Saver));
    }
}
