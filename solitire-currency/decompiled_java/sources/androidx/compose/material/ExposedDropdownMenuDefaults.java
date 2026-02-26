package androidx.compose.material;

import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.ArrowDropDownKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.RotateKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import h9.a;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ExposedDropdownMenu.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
@ExperimentalMaterialApi
public final class ExposedDropdownMenuDefaults {
    public static final int $stable = 0;

    @NotNull
    public static final ExposedDropdownMenuDefaults INSTANCE = new ExposedDropdownMenuDefaults();

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass1 extends v implements a<k0> {
        public static final AnonymousClass1 INSTANCE = new AnonymousClass1();

        AnonymousClass1() {
            super(0);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass2 extends v implements l<SemanticsPropertyReceiver, k0> {
        public static final AnonymousClass2 INSTANCE = new AnonymousClass2();

        AnonymousClass2() {
            super(1);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver clearAndSetSemantics) {
            t.i(clearAndSetSemantics, "$this$clearAndSetSemantics");
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ boolean $expanded;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(boolean z10) {
            super(2);
            this.$expanded = z10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @Composable
        public final void invoke(@Nullable Composer composer, int i10) {
            if ((i10 & 11) == 2 && composer.getSkipping()) {
                composer.skipToGroupEnd();
            } else {
                IconKt.m1049Iconww6aTOc(ArrowDropDownKt.getArrowDropDown(Icons.Filled.INSTANCE), "Trailing icon for exposed dropdown menu", RotateKt.rotate(Modifier.Companion, this.$expanded ? 180.0f : 360.0f), 0L, composer, 48, 8);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4, reason: invalid class name */
    /* JADX INFO: compiled from: ExposedDropdownMenu.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ boolean $expanded;
        final /* synthetic */ a<k0> $onIconClick;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(boolean z10, a<k0> aVar, int i10, int i11) {
            super(2);
            this.$expanded = z10;
            this.$onIconClick = aVar;
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
            ExposedDropdownMenuDefaults.this.TrailingIcon(this.$expanded, this.$onIconClick, composer, this.$$changed | 1, this.$$default);
        }
    }

    private ExposedDropdownMenuDefaults() {
    }

    /* JADX WARN: Removed duplicated region for block: B:30:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @androidx.compose.runtime.Composable
    @androidx.compose.material.ExperimentalMaterialApi
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void TrailingIcon(boolean r13, @org.jetbrains.annotations.Nullable h9.a<v8.k0> r14, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r15, int r16, int r17) {
        /*
            r12 = this;
            r2 = r13
            r0 = 876077373(0x3437e13d, float:1.7125144E-7)
            r1 = r15
            androidx.compose.runtime.Composer r0 = r15.startRestartGroup(r0)
            r1 = r17 & 1
            if (r1 == 0) goto L10
            r1 = r16 | 6
            goto L22
        L10:
            r1 = r16 & 14
            if (r1 != 0) goto L20
            boolean r1 = r0.changed(r13)
            if (r1 == 0) goto L1c
            r1 = 4
            goto L1d
        L1c:
            r1 = 2
        L1d:
            r1 = r16 | r1
            goto L22
        L20:
            r1 = r16
        L22:
            r3 = r17 & 2
            if (r3 == 0) goto L29
            r1 = r1 | 48
            goto L3b
        L29:
            r4 = r16 & 112(0x70, float:1.57E-43)
            if (r4 != 0) goto L3b
            r4 = r14
            boolean r5 = r0.changed(r14)
            if (r5 == 0) goto L37
            r5 = 32
            goto L39
        L37:
            r5 = 16
        L39:
            r1 = r1 | r5
            goto L3c
        L3b:
            r4 = r14
        L3c:
            r5 = r1 & 91
            r6 = 18
            if (r5 != r6) goto L4e
            boolean r5 = r0.getSkipping()
            if (r5 != 0) goto L49
            goto L4e
        L49:
            r0.skipToGroupEnd()
            r3 = r4
            goto L79
        L4e:
            if (r3 == 0) goto L54
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$1 r3 = androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass1.INSTANCE
            r11 = r3
            goto L55
        L54:
            r11 = r4
        L55:
            androidx.compose.ui.Modifier$Companion r3 = androidx.compose.ui.Modifier.Companion
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$2 r4 = androidx.compose.material.ExposedDropdownMenuDefaults.AnonymousClass2.INSTANCE
            androidx.compose.ui.Modifier r4 = androidx.compose.ui.semantics.SemanticsModifierKt.clearAndSetSemantics(r3, r4)
            r5 = 0
            r6 = 0
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3 r3 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$3
            r3.<init>(r13)
            r7 = 726122713(0x2b47c0d9, float:7.096663E-13)
            r8 = 1
            androidx.compose.runtime.internal.ComposableLambda r7 = androidx.compose.runtime.internal.ComposableLambdaKt.composableLambda(r0, r7, r8, r3)
            int r1 = r1 >> 3
            r1 = r1 & 14
            r9 = r1 | 24576(0x6000, float:3.4438E-41)
            r10 = 12
            r3 = r11
            r8 = r0
            androidx.compose.material.IconButtonKt.IconButton(r3, r4, r5, r6, r7, r8, r9, r10)
        L79:
            androidx.compose.runtime.ScopeUpdateScope r6 = r0.endRestartGroup()
            if (r6 != 0) goto L80
            goto L8f
        L80:
            androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4 r7 = new androidx.compose.material.ExposedDropdownMenuDefaults$TrailingIcon$4
            r0 = r7
            r1 = r12
            r2 = r13
            r4 = r16
            r5 = r17
            r0.<init>(r2, r3, r4, r5)
            r6.updateScope(r7)
        L8f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ExposedDropdownMenuDefaults.TrailingIcon(boolean, h9.a, androidx.compose.runtime.Composer, int, int):void");
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: outlinedTextFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1021outlinedTextFieldColorsDlUQjxs(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, @Nullable Composer composer, int i10, int i11, int i12, int i13) {
        composer.startReplaceableGroup(1162641182);
        long jM1597copywmQWz5c$default = (i13 & 1) != 0 ? Color.m1597copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM1597copywmQWz5c$default2 = (i13 & 2) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1633getTransparent0d7_KjU = (i13 & 4) != 0 ? Color.Companion.m1633getTransparent0d7_KjU() : j12;
        long jM951getPrimary0d7_KjU = (i13 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j13;
        long jM945getError0d7_KjU = (i13 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j14;
        long jM1597copywmQWz5c$default3 = (i13 & 32) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM1597copywmQWz5c$default4 = (i13 & 64) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM1597copywmQWz5c$default5 = (i13 & 128) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default4, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM945getError0d7_KjU2 = (i13 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j18;
        long jM1597copywmQWz5c$default6 = (i13 & 512) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jM1597copywmQWz5c$default7 = (i13 & 1024) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default6, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long j32 = (i13 & 2048) != 0 ? jM1597copywmQWz5c$default6 : j21;
        long jM1597copywmQWz5c$default8 = (i13 & 4096) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j22;
        long jM1597copywmQWz5c$default9 = (i13 & 8192) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        long jM1597copywmQWz5c$default10 = (i13 & 16384) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default8, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j24;
        long jM945getError0d7_KjU3 = (32768 & i13) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j25;
        long jM1597copywmQWz5c$default11 = (65536 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j26;
        long jM1597copywmQWz5c$default12 = (131072 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        long jM1597copywmQWz5c$default13 = (262144 & i13) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default12, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j28;
        long jM945getError0d7_KjU4 = (524288 & i13) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j29;
        long jM1597copywmQWz5c$default14 = (1048576 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j30;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM951getPrimary0d7_KjU, jM945getError0d7_KjU, jM1597copywmQWz5c$default3, jM1597copywmQWz5c$default4, jM945getError0d7_KjU2, jM1597copywmQWz5c$default5, jM1597copywmQWz5c$default6, jM1597copywmQWz5c$default7, j32, jM1597copywmQWz5c$default8, jM1597copywmQWz5c$default9, jM1597copywmQWz5c$default10, jM945getError0d7_KjU3, jM1633getTransparent0d7_KjU, jM1597copywmQWz5c$default11, jM1597copywmQWz5c$default12, jM1597copywmQWz5c$default13, jM945getError0d7_KjU4, jM1597copywmQWz5c$default14, (i13 & 2097152) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default14, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j31, null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }

    @Composable
    @NotNull
    /* JADX INFO: renamed from: textFieldColors-DlUQjxs, reason: not valid java name */
    public final TextFieldColors m1022textFieldColorsDlUQjxs(long j10, long j11, long j12, long j13, long j14, long j15, long j16, long j17, long j18, long j19, long j20, long j21, long j22, long j23, long j24, long j25, long j26, long j27, long j28, long j29, long j30, long j31, @Nullable Composer composer, int i10, int i11, int i12, int i13) {
        composer.startReplaceableGroup(1208167904);
        long jM1597copywmQWz5c$default = (i13 & 1) != 0 ? Color.m1597copywmQWz5c$default(((Color) composer.consume(ContentColorKt.getLocalContentColor())).m1608unboximpl(), ((Number) composer.consume(ContentAlphaKt.getLocalContentAlpha())).floatValue(), 0.0f, 0.0f, 0.0f, 14, null) : j10;
        long jM1597copywmQWz5c$default2 = (i13 & 2) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j11;
        long jM1597copywmQWz5c$default3 = (i13 & 4) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null) : j12;
        long jM951getPrimary0d7_KjU = (i13 & 8) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU() : j13;
        long jM945getError0d7_KjU = (i13 & 16) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j14;
        long jM1597copywmQWz5c$default4 = (i13 & 32) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j15;
        long jM1597copywmQWz5c$default5 = (i13 & 64) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.42f, 0.0f, 0.0f, 0.0f, 14, null) : j16;
        long jM1597copywmQWz5c$default6 = (i13 & 128) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default5, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j17;
        long jM945getError0d7_KjU2 = (i13 & 256) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j18;
        long jM1597copywmQWz5c$default7 = (i13 & 512) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j19;
        long jM1597copywmQWz5c$default8 = (i13 & 1024) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default7, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j20;
        long j32 = (i13 & 2048) != 0 ? jM1597copywmQWz5c$default7 : j21;
        long jM1597copywmQWz5c$default9 = (i13 & 4096) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), 0.54f, 0.0f, 0.0f, 0.0f, 14, null) : j22;
        long jM1597copywmQWz5c$default10 = (i13 & 8192) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j23;
        long jM1597copywmQWz5c$default11 = (i13 & 16384) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default9, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j24;
        long jM945getError0d7_KjU3 = (32768 & i13) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j25;
        long jM1597copywmQWz5c$default12 = (65536 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m951getPrimary0d7_KjU(), ContentAlpha.INSTANCE.getHigh(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j26;
        long jM1597copywmQWz5c$default13 = (131072 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j27;
        long jM1597copywmQWz5c$default14 = (262144 & i13) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default13, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j28;
        long jM945getError0d7_KjU4 = (524288 & i13) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m945getError0d7_KjU() : j29;
        long jM1597copywmQWz5c$default15 = (1048576 & i13) != 0 ? Color.m1597copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m950getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getMedium(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j30;
        DefaultTextFieldForExposedDropdownMenusColors defaultTextFieldForExposedDropdownMenusColors = new DefaultTextFieldForExposedDropdownMenusColors(jM1597copywmQWz5c$default, jM1597copywmQWz5c$default2, jM951getPrimary0d7_KjU, jM945getError0d7_KjU, jM1597copywmQWz5c$default4, jM1597copywmQWz5c$default5, jM945getError0d7_KjU2, jM1597copywmQWz5c$default6, jM1597copywmQWz5c$default7, jM1597copywmQWz5c$default8, j32, jM1597copywmQWz5c$default9, jM1597copywmQWz5c$default10, jM1597copywmQWz5c$default11, jM945getError0d7_KjU3, jM1597copywmQWz5c$default3, jM1597copywmQWz5c$default12, jM1597copywmQWz5c$default13, jM1597copywmQWz5c$default14, jM945getError0d7_KjU4, jM1597copywmQWz5c$default15, (i13 & 2097152) != 0 ? Color.m1597copywmQWz5c$default(jM1597copywmQWz5c$default15, ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j31, null);
        composer.endReplaceableGroup();
        return defaultTextFieldForExposedDropdownMenusColors;
    }
}
