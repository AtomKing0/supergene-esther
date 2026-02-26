package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.semantics.ProgressBarRangeInfo;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ProgressSemantics.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ProgressSemanticsKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.ProgressSemanticsKt$progressSemantics$1, reason: invalid class name */
    /* JADX INFO: compiled from: ProgressSemantics.kt */
    static final class AnonymousClass1 extends v implements h9.l<SemanticsPropertyReceiver, k0> {
        final /* synthetic */ int $steps;
        final /* synthetic */ float $value;
        final /* synthetic */ n9.e<Float> $valueRange;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(float f10, n9.e<Float> eVar, int i10) {
            super(1);
            this.$value = f10;
            this.$valueRange = eVar;
            this.$steps = i10;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semantics) {
            t.i(semantics, "$this$semantics");
            SemanticsPropertiesKt.setProgressBarRangeInfo(semantics, new ProgressBarRangeInfo(((Number) n9.o.q(Float.valueOf(this.$value), this.$valueRange)).floatValue(), this.$valueRange, this.$steps));
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.ProgressSemanticsKt$progressSemantics$2, reason: invalid class name */
    /* JADX INFO: compiled from: ProgressSemantics.kt */
    static final class AnonymousClass2 extends v implements h9.l<SemanticsPropertyReceiver, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
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
            SemanticsPropertiesKt.setProgressBarRangeInfo(semantics, ProgressBarRangeInfo.Companion.getIndeterminate());
        }
    }

    @Stable
    @NotNull
    public static final Modifier progressSemantics(@NotNull Modifier modifier, float f10, @NotNull n9.e<Float> valueRange, int i10) {
        t.i(modifier, "<this>");
        t.i(valueRange, "valueRange");
        return SemanticsModifierKt.semantics(modifier, true, new AnonymousClass1(f10, valueRange, i10));
    }

    public static /* synthetic */ Modifier progressSemantics$default(Modifier modifier, float f10, n9.e eVar, int i10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            eVar = n9.n.b(0.0f, 1.0f);
        }
        if ((i11 & 4) != 0) {
            i10 = 0;
        }
        return progressSemantics(modifier, f10, eVar, i10);
    }

    @Stable
    @NotNull
    public static final Modifier progressSemantics(@NotNull Modifier modifier) {
        t.i(modifier, "<this>");
        return SemanticsModifierKt.semantics(modifier, true, AnonymousClass2.INSTANCE);
    }
}
