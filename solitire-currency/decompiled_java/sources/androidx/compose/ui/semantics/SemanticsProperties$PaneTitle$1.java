package androidx.compose.ui.semantics;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsProperties$PaneTitle$1 extends v implements p<String, String, String> {
    public static final SemanticsProperties$PaneTitle$1 INSTANCE = new SemanticsProperties$PaneTitle$1();

    SemanticsProperties$PaneTitle$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final String mo4invoke(@Nullable String str, @NotNull String str2) {
        t.i(str2, "<anonymous parameter 1>");
        throw new IllegalStateException("merge function called on unmergeable property PaneTitle.");
    }
}
