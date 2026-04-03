package androidx.compose.ui.text;

import androidx.compose.ui.text.style.TextDecoration;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$TextDecorationSaver$2 extends v implements l<Object, TextDecoration> {
    public static final SaversKt$TextDecorationSaver$2 INSTANCE = new SaversKt$TextDecorationSaver$2();

    SaversKt$TextDecorationSaver$2() {
        super(1);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // h9.l
    @Nullable
    public final TextDecoration invoke(@NotNull Object it) {
        t.i(it, "it");
        return new TextDecoration(((Integer) it).intValue());
    }
}
