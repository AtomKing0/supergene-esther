package androidx.compose.ui.semantics;

import h9.p;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsProperties$ContentDescription$1 extends v implements p<List<? extends String>, List<? extends String>, List<? extends String>> {
    public static final SemanticsProperties$ContentDescription$1 INSTANCE = new SemanticsProperties$ContentDescription$1();

    SemanticsProperties$ContentDescription$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ List<? extends String> mo4invoke(List<? extends String> list, List<? extends String> list2) {
        return invoke2((List<String>) list, (List<String>) list2);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<String> invoke2(@Nullable List<String> list, @NotNull List<String> childValue) {
        List<String> listR0;
        t.i(childValue, "childValue");
        if (list == null || (listR0 = d0.R0(list)) == null) {
            return childValue;
        }
        listR0.addAll(childValue);
        return listR0;
    }
}
