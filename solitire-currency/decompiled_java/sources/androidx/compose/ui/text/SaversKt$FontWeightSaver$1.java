package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.text.font.FontWeight;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$FontWeightSaver$1 extends v implements p<SaverScope, FontWeight, Object> {
    public static final SaversKt$FontWeightSaver$1 INSTANCE = new SaversKt$FontWeightSaver$1();

    SaversKt$FontWeightSaver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Object mo4invoke(@NotNull SaverScope Saver, @NotNull FontWeight it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return Integer.valueOf(it.getWeight());
    }
}
