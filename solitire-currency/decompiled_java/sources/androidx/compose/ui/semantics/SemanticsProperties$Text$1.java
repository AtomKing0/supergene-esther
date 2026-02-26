package androidx.compose.ui.semantics;

import androidx.compose.ui.text.AnnotatedString;
import h9.p;
import java.util.List;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SemanticsProperties.kt */
/* JADX INFO: loaded from: classes.dex */
final class SemanticsProperties$Text$1 extends v implements p<List<? extends AnnotatedString>, List<? extends AnnotatedString>, List<? extends AnnotatedString>> {
    public static final SemanticsProperties$Text$1 INSTANCE = new SemanticsProperties$Text$1();

    SemanticsProperties$Text$1() {
        super(2);
    }

    @Override // h9.p
    /* JADX INFO: renamed from: invoke */
    public /* bridge */ /* synthetic */ List<? extends AnnotatedString> mo4invoke(List<? extends AnnotatedString> list, List<? extends AnnotatedString> list2) {
        return invoke2((List<AnnotatedString>) list, (List<AnnotatedString>) list2);
    }

    @Nullable
    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final List<AnnotatedString> invoke2(@Nullable List<AnnotatedString> list, @NotNull List<AnnotatedString> childValue) {
        List<AnnotatedString> listR0;
        t.i(childValue, "childValue");
        if (list == null || (listR0 = d0.R0(list)) == null) {
            return childValue;
        }
        listR0.addAll(childValue);
        return listR0;
    }
}
