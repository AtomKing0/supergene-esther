package androidx.compose.ui.semantics;

import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsProperties$IsDialog$1 extends v implements p<k0, k0, k0> {
    public static final SemanticsProperties$IsDialog$1 INSTANCE = new SemanticsProperties$IsDialog$1();

    SemanticsProperties$IsDialog$1() {
        super(2);
    }

    @Override // h9.p
    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method and merged with bridge method [inline-methods] */
    public final k0 mo4invoke(@Nullable k0 k0Var, @NotNull k0 k0Var2) {
        t.i(k0Var2, "<anonymous parameter 1>");
        throw new IllegalStateException("merge function called on unmergeable property IsDialog. A dialog should not be a child of a clickable/focusable node.");
    }
}
