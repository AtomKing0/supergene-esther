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
final class OneLine {
    private static final float ContentLeftPadding;
    private static final float ContentRightPadding;
    private static final float IconLeftPadding;
    private static final float TrailingRightPadding;

    @NotNull
    public static final OneLine INSTANCE = new OneLine();
    private static final float MinHeight = Dp.m3673constructorimpl(48);
    private static final float MinHeightWithIcon = Dp.m3673constructorimpl(56);
    private static final float IconMinPaddedWidth = Dp.m3673constructorimpl(40);
    private static final float IconVerticalPadding = Dp.m3673constructorimpl(8);

    /* JADX INFO: renamed from: androidx.compose.material.OneLine$ListItem$2, reason: invalid class name */
    /* JADX INFO: compiled from: ListItem.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $icon;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ p<Composer, Integer, k0> $text;
        final /* synthetic */ p<Composer, Integer, k0> $trailing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$icon = pVar;
            this.$text = pVar2;
            this.$trailing = pVar3;
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
            OneLine.this.ListItem(this.$modifier, this.$icon, this.$text, this.$trailing, composer, this.$$changed | 1, this.$$default);
        }
    }

    static {
        float f10 = 16;
        IconLeftPadding = Dp.m3673constructorimpl(f10);
        ContentLeftPadding = Dp.m3673constructorimpl(f10);
        ContentRightPadding = Dp.m3673constructorimpl(f10);
        TrailingRightPadding = Dp.m3673constructorimpl(f10);
    }

    private OneLine() {
    }

    /* JADX WARN: Removed duplicated region for block: B:105:0x0439  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x034b  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ListItem(@org.jetbrains.annotations.Nullable androidx.compose.ui.Modifier r32, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r33, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r34, @org.jetbrains.annotations.Nullable h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r35, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r36, int r37, int r38) {
        /*
            Method dump skipped, instruction units count: 1103
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OneLine.ListItem(androidx.compose.ui.Modifier, h9.p, h9.p, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }
}
