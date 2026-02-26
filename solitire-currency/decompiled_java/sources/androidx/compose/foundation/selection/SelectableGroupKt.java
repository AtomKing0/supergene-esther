package androidx.compose.foundation.selection;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: SelectableGroup.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectableGroupKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.selection.SelectableGroupKt$selectableGroup$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectableGroup.kt */
    static final class AnonymousClass1 extends v implements l<SemanticsPropertyReceiver, k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.selectableGroup(semantics);
        }
    }

    @NotNull
    public static final Modifier selectableGroup(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return SemanticsModifierKt.semantics$default(modifier, false, AnonymousClass1.INSTANCE, 1, null);
    }
}
