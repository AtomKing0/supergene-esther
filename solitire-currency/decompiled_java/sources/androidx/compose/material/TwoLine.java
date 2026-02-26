package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Dp;
import h9.p;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ListItem.kt */
/* JADX INFO: loaded from: classes.dex */
final class TwoLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float IconVerticalPadding;
    private static final float OverlineToPrimaryBaselineOffset;
    private static final float PrimaryToSecondaryBaselineOffsetNoIcon;
    private static final float PrimaryToSecondaryBaselineOffsetWithIcon;
    private static final float TrailingRightPadding;

    @NotNull
    public static final TwoLine INSTANCE = new TwoLine();
    private static final float MinHeight = Dp.m3673constructorimpl(64);
    private static final float MinHeightWithIcon = Dp.m3673constructorimpl(72);
    private static final float IconMinPaddedWidth = Dp.m3673constructorimpl(40);
    private static final float OverlineBaselineOffset = Dp.m3673constructorimpl(24);
    private static final float PrimaryBaselineOffsetNoIcon = Dp.m3673constructorimpl(28);
    private static final float PrimaryBaselineOffsetWithIcon = Dp.m3673constructorimpl(32);

    /* JADX INFO: renamed from: androidx.compose.material.TwoLine$ListItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: ListItem.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $icon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ p<Composer, Integer, k0> $overlineText;
        final /* synthetic */ p<Composer, Integer, k0> $secondaryText;
        final /* synthetic */ p<Composer, Integer, k0> $text;
        final /* synthetic */ p<Composer, Integer, k0> $trailing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, p<? super Composer, ? super Integer, k0> pVar5, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$icon = pVar;
            this.$text = pVar2;
            this.$secondaryText = pVar3;
            this.$overlineText = pVar4;
            this.$trailing = pVar5;
            this.$$changed = i10;
            this.$$default = i11;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TwoLine.this.ListItem(this.$modifier, this.$icon, this.$text, this.$secondaryText, this.$overlineText, this.$trailing, composer, this.$$changed | 1, this.$$default);
        }
    }

    static {
        float f10 = 16;
        IconLeftPadding = Dp.m3673constructorimpl(f10);
        IconVerticalPadding = Dp.m3673constructorimpl(f10);
        ContentLeftPadding = Dp.m3673constructorimpl(f10);
        ContentRightPadding = Dp.m3673constructorimpl(f10);
        float f11 = 20;
        OverlineToPrimaryBaselineOffset = Dp.m3673constructorimpl(f11);
        PrimaryToSecondaryBaselineOffsetNoIcon = Dp.m3673constructorimpl(f11);
        PrimaryToSecondaryBaselineOffsetWithIcon = Dp.m3673constructorimpl(f11);
        TrailingRightPadding = Dp.m3673constructorimpl(f10);
    }

    private TwoLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:104:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x02f2  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:125:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01cc  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ListItem(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r33, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r34, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r35, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r36, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r37, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 901
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TwoLine.ListItem(androidx.compose.ui.Modifier, h9.p, h9.p, h9.p, h9.p, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }
}
