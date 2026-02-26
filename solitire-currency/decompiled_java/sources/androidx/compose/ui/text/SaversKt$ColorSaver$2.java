package androidx.compose.ui.text;

import androidx.compose.ui.graphics.Color;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.e0;

/* JADX INFO: compiled from: Savers.kt */
/* JADX INFO: loaded from: classes.dex */
final class SaversKt$ColorSaver$2 extends v implements l<Object, Color> {
    public static final SaversKt$ColorSaver$2 INSTANCE = new SaversKt$ColorSaver$2();

    SaversKt$ColorSaver$2() {
        super(1);
    }

    @Override // h9.l
    @Nullable
    /* JADX INFO: renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
    public final Color invoke(@NotNull Object it) {
        t.i(it, "it");
        return Color.m1588boximpl(Color.m1594constructorimpl(((e0) it).g()));
    }
}
