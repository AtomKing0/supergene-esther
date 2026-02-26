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
final class ThreeLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float IconThreeLineVerticalPadding;
    private static final float ThreeLineBaselineSecondOffset;
    private static final float ThreeLineBaselineThirdOffset;
    private static final float ThreeLineTrailingTopPadding;
    private static final float TrailingRightPadding;

    @NotNull
    public static final ThreeLine INSTANCE = new ThreeLine();
    private static final float MinHeight = Dp.m3673constructorimpl(88);
    private static final float IconMinPaddedWidth = Dp.m3673constructorimpl(40);
    private static final float ThreeLineBaselineFirstOffset = Dp.m3673constructorimpl(28);

    /* JADX INFO: renamed from: androidx.compose.material.ThreeLine$ListItem$2, reason: invalid class name */
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
            ThreeLine.this.ListItem(this.$modifier, this.$icon, this.$text, this.$secondaryText, this.$overlineText, this.$trailing, composer, this.$$changed | 1, this.$$default);
        }
    }

    static {
        float f10 = 16;
        IconLeftPadding = Dp.m3673constructorimpl(f10);
        IconThreeLineVerticalPadding = Dp.m3673constructorimpl(f10);
        ContentLeftPadding = Dp.m3673constructorimpl(f10);
        ContentRightPadding = Dp.m3673constructorimpl(f10);
        float f11 = 20;
        ThreeLineBaselineSecondOffset = Dp.m3673constructorimpl(f11);
        ThreeLineBaselineThirdOffset = Dp.m3673constructorimpl(f11);
        ThreeLineTrailingTopPadding = Dp.m3673constructorimpl(f10);
        TrailingRightPadding = Dp.m3673constructorimpl(f10);
    }

    private ThreeLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x02ed  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:108:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01ab  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ListItem(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r33, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r34, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r35, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r36, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r37, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r38, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r39, int r40, int r41) {
        /*
            Method dump skipped, instruction units count: 839
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ThreeLine.ListItem(androidx.compose.ui.Modifier, h9.p, h9.p, h9.p, h9.p, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }
}
