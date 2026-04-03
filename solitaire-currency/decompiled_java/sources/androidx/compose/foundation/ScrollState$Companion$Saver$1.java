package androidx.compose.foundation;

import androidx.compose.runtime.saveable.SaverScope;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Scroll.kt */
/* JADX INFO: loaded from: classes.dex */
final class ScrollState$Companion$Saver$1 extends v implements h9.p<SaverScope, ScrollState, Integer> {
    public static final ScrollState$Companion$Saver$1 INSTANCE = new ScrollState$Companion$Saver$1();

    ScrollState$Companion$Saver$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final Integer mo4invoke(@NotNull SaverScope Saver, @NotNull ScrollState it) {
        t.i(Saver, "$this$Saver");
        t.i(it, "it");
        return Integer.valueOf(it.getValue());
    }
}
