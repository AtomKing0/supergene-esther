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
final class SaversKt$TextIndentSaver$1 extends v implements p<SaverScope, TextIndent, Object> {
    public static final SaversKt$TextIndentSaver$1 INSTANCE = new SaversKt$TextIndentSaver$1();

    SaversKt$TextIndentSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull TextIndent it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        TextUnit textUnitM3844boximpl = TextUnit.m3844boximpl(it.m3614getFirstLineXSAIIZE());
        TextUnit.Companion companion = TextUnit.Companion;
        return kotlin.collections.v.f(SaversKt.save(textUnitM3844boximpl, SaversKt.getSaver(companion), Saver), SaversKt.save(TextUnit.m3844boximpl(it.m3615getRestLineXSAIIZE()), SaversKt.getSaver(companion), Saver));
    }
}
