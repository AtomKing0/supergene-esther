package androidx.compose.ui.platform;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: TestTag.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TestTagKt {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.TestTagKt$testTag$1, reason: invalid class name */
    /* JADX INFO: compiled from: TestTag.kt */
    static final class AnonymousClass1 extends kotlin.jvm.internal.v implements h9.l<SemanticsPropertyReceiver, v8.k0> {
        final /* synthetic */ String $tag;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str) {
            super(1);
            this.$tag = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ v8.k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return v8.k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            kotlin.jvm.internal.t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.setTestTag(semantics, this.$tag);
        }
    }

    @Stable
    @NotNull
    public static final Modifier testTag(@NotNull Modifier modifier, @NotNull String tag) {
        kotlin.jvm.internal.t.i(modifier, "<this>");
        kotlin.jvm.internal.t.i(tag, "tag");
        return SemanticsModifierKt.semantics$default(modifier, false, new AnonymousClass1(tag), 1, null);
    }
}
