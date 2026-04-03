package androidx.compose.material;

import androidx.compose.foundation.interaction.FocusInteractionKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.input.TransformedText;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import com.google.android.gms.drive.DriveFile;
import h9.p;
import h9.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: TextFieldImpl.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;

    @NotNull
    private static final Modifier IconDefaultSizeModifier;

    @NotNull
    public static final String LabelId = "Label";

    @NotNull
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;

    @NotNull
    public static final String PlaceholderId = "Hint";

    @NotNull
    public static final String TextFieldId = "TextField";

    @NotNull
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m3673constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m3673constructorimpl(12);

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldImpl.kt */
    static final class AnonymousClass3 extends v implements t<Float, Color, Color, Float, Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ int $$dirty1;
        final /* synthetic */ p<Composer, Integer, k0> $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<Composer, Integer, k0> $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $shouldOverrideTextStyleColor;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ String $transformedText;
        final /* synthetic */ TextFieldType $type;

        /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$3$WhenMappings */
        /* JADX INFO: compiled from: TextFieldImpl.kt */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[TextFieldType.values().length];
                iArr[TextFieldType.Filled.ordinal()] = 1;
                iArr[TextFieldType.Outlined.ordinal()] = 2;
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(p<? super Composer, ? super Integer, k0> pVar, p<? super Composer, ? super Integer, k0> pVar2, String str, boolean z10, int i10, TextFieldColors textFieldColors, boolean z11, InteractionSource interactionSource, int i11, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, TextFieldType textFieldType, p<? super Composer, ? super Integer, k0> pVar5, boolean z12, PaddingValues paddingValues, boolean z13, p<? super Composer, ? super Integer, k0> pVar6) {
            super(6);
            this.$label = pVar;
            this.$placeholder = pVar2;
            this.$transformedText = str;
            this.$isError = z10;
            this.$$dirty1 = i10;
            this.$colors = textFieldColors;
            this.$enabled = z11;
            this.$interactionSource = interactionSource;
            this.$$dirty = i11;
            this.$leadingIcon = pVar3;
            this.$trailingIcon = pVar4;
            this.$type = textFieldType;
            this.$innerTextField = pVar5;
            this.$singleLine = z12;
            this.$contentPadding = paddingValues;
            this.$shouldOverrideTextStyleColor = z13;
            this.$border = pVar6;
        }

        @Override // h9.t
        public /* bridge */ /* synthetic */ k0 invoke(Float f10, Color color, Color color2, Float f11, Composer composer, Integer num) {
            m1205invokeRIQooxk(f10.floatValue(), color.m1608unboximpl(), color2.m1608unboximpl(), f11.floatValue(), composer, num.intValue());
            return k0.f35197a;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:50:0x00b8  */
        /* JADX WARN: Type inference failed for: r14v0 */
        /* JADX WARN: Type inference failed for: r14v1, types: [boolean, int] */
        /* JADX WARN: Type inference failed for: r14v4 */
        /* JADX WARN: Type inference failed for: r27v0, types: [androidx.compose.runtime.Composer] */
        /* JADX WARN: Type inference failed for: r7v5 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v9 */
        @androidx.compose.runtime.ComposableTarget(applier = "androidx.compose.ui.UiComposable")
        @androidx.compose.runtime.Composable
        /* JADX INFO: renamed from: invoke-RIQooxk, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void m1205invokeRIQooxk(float r21, long r22, long r24, float r26, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r27, int r28) {
            /*
                Method dump skipped, instruction units count: 761
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.AnonymousClass3.m1205invokeRIQooxk(float, long, long, float, androidx.compose.runtime.Composer, int):void");
        }
    }

    /* JADX INFO: renamed from: androidx.compose.material.TextFieldImplKt$CommonDecorationBox$4, reason: invalid class name */
    /* JADX INFO: compiled from: TextFieldImpl.kt */
    static final class AnonymousClass4 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$changed1;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $border;
        final /* synthetic */ TextFieldColors $colors;
        final /* synthetic */ PaddingValues $contentPadding;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ p<Composer, Integer, k0> $innerTextField;
        final /* synthetic */ InteractionSource $interactionSource;
        final /* synthetic */ boolean $isError;
        final /* synthetic */ p<Composer, Integer, k0> $label;
        final /* synthetic */ p<Composer, Integer, k0> $leadingIcon;
        final /* synthetic */ p<Composer, Integer, k0> $placeholder;
        final /* synthetic */ boolean $singleLine;
        final /* synthetic */ p<Composer, Integer, k0> $trailingIcon;
        final /* synthetic */ TextFieldType $type;
        final /* synthetic */ String $value;
        final /* synthetic */ VisualTransformation $visualTransformation;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass4(TextFieldType textFieldType, String str, p<? super Composer, ? super Integer, k0> pVar, VisualTransformation visualTransformation, p<? super Composer, ? super Integer, k0> pVar2, p<? super Composer, ? super Integer, k0> pVar3, p<? super Composer, ? super Integer, k0> pVar4, p<? super Composer, ? super Integer, k0> pVar5, boolean z10, boolean z11, boolean z12, InteractionSource interactionSource, PaddingValues paddingValues, TextFieldColors textFieldColors, p<? super Composer, ? super Integer, k0> pVar6, int i10, int i11, int i12) {
            super(2);
            this.$type = textFieldType;
            this.$value = str;
            this.$innerTextField = pVar;
            this.$visualTransformation = visualTransformation;
            this.$label = pVar2;
            this.$placeholder = pVar3;
            this.$leadingIcon = pVar4;
            this.$trailingIcon = pVar5;
            this.$singleLine = z10;
            this.$enabled = z11;
            this.$isError = z12;
            this.$interactionSource = interactionSource;
            this.$contentPadding = paddingValues;
            this.$colors = textFieldColors;
            this.$border = pVar6;
            this.$$changed = i10;
            this.$$changed1 = i11;
            this.$$default = i12;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            TextFieldImplKt.CommonDecorationBox(this.$type, this.$value, this.$innerTextField, this.$visualTransformation, this.$label, this.$placeholder, this.$leadingIcon, this.$trailingIcon, this.$singleLine, this.$enabled, this.$isError, this.$interactionSource, this.$contentPadding, this.$colors, this.$border, composer, this.$$changed | 1, this.$$changed1, this.$$default);
        }
    }

    static {
        float f10 = 48;
        IconDefaultSizeModifier = SizeKt.m424defaultMinSizeVpY3zN4(Modifier.Companion, Dp.m3673constructorimpl(f10), Dp.m3673constructorimpl(f10));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable][androidx.compose.ui.UiComposable]]")
    public static final void CommonDecorationBox(@NotNull TextFieldType type, @NotNull String value, @NotNull p<? super Composer, ? super Integer, k0> innerTextField, @NotNull VisualTransformation visualTransformation, @Nullable p<? super Composer, ? super Integer, k0> pVar, @Nullable p<? super Composer, ? super Integer, k0> pVar2, @Nullable p<? super Composer, ? super Integer, k0> pVar3, @Nullable p<? super Composer, ? super Integer, k0> pVar4, boolean z10, boolean z11, boolean z12, @NotNull InteractionSource interactionSource, @NotNull PaddingValues contentPadding, @NotNull TextFieldColors colors, @Nullable p<? super Composer, ? super Integer, k0> pVar5, @Nullable Composer composer, int i10, int i11, int i12) {
        int i13;
        int i14;
        InputPhase inputPhase;
        Composer composer2;
        p<? super Composer, ? super Integer, k0> pVar6;
        p<? super Composer, ? super Integer, k0> pVar7;
        p<? super Composer, ? super Integer, k0> pVar8;
        boolean z13;
        boolean z14;
        boolean z15;
        p<? super Composer, ? super Integer, k0> pVar9;
        kotlin.jvm.internal.t.i(type, "type");
        kotlin.jvm.internal.t.i(value, "value");
        kotlin.jvm.internal.t.i(innerTextField, "innerTextField");
        kotlin.jvm.internal.t.i(visualTransformation, "visualTransformation");
        kotlin.jvm.internal.t.i(interactionSource, "interactionSource");
        kotlin.jvm.internal.t.i(contentPadding, "contentPadding");
        kotlin.jvm.internal.t.i(colors, "colors");
        Composer composerStartRestartGroup = composer.startRestartGroup(-712568069);
        if ((i12 & 1) != 0) {
            i13 = i10 | 6;
        } else if ((i10 & 14) == 0) {
            i13 = (composerStartRestartGroup.changed(type) ? 4 : 2) | i10;
        } else {
            i13 = i10;
        }
        if ((i12 & 2) != 0) {
            i13 |= 48;
        } else if ((i10 & 112) == 0) {
            i13 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i12 & 4) != 0) {
            i13 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i13 |= composerStartRestartGroup.changed(innerTextField) ? 256 : 128;
        }
        if ((i12 & 8) != 0) {
            i13 |= 3072;
        } else if ((i10 & 7168) == 0) {
            i13 |= composerStartRestartGroup.changed(visualTransformation) ? 2048 : 1024;
        }
        if ((i12 & 16) != 0) {
            i13 |= 24576;
        } else if ((i10 & 57344) == 0) {
            i13 |= composerStartRestartGroup.changed(pVar) ? 16384 : 8192;
        }
        int i15 = i12 & 32;
        if (i15 != 0) {
            i13 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        } else if ((i10 & 458752) == 0) {
            i13 |= composerStartRestartGroup.changed(pVar2) ? 131072 : 65536;
        }
        int i16 = i12 & 64;
        if (i16 != 0) {
            i13 |= 1572864;
        } else if ((i10 & 3670016) == 0) {
            i13 |= composerStartRestartGroup.changed(pVar3) ? 1048576 : 524288;
        }
        int i17 = i12 & 128;
        if (i17 != 0) {
            i13 |= 12582912;
        } else if ((i10 & 29360128) == 0) {
            i13 |= composerStartRestartGroup.changed(pVar4) ? 8388608 : 4194304;
        }
        int i18 = i12 & 256;
        if (i18 != 0) {
            i13 |= 100663296;
        } else if ((i10 & 234881024) == 0) {
            i13 |= composerStartRestartGroup.changed(z10) ? AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL : 33554432;
        }
        int i19 = i12 & 512;
        if (i19 != 0) {
            i13 |= DriveFile.MODE_READ_WRITE;
        } else if ((i10 & 1879048192) == 0) {
            i13 |= composerStartRestartGroup.changed(z11) ? 536870912 : 268435456;
        }
        int i20 = i13;
        int i21 = i12 & 1024;
        if (i21 != 0) {
            i14 = i11 | 6;
        } else if ((i11 & 14) == 0) {
            i14 = i11 | (composerStartRestartGroup.changed(z12) ? 4 : 2);
        } else {
            i14 = i11;
        }
        if ((i12 & 2048) != 0) {
            i14 |= 48;
        } else if ((i11 & 112) == 0) {
            i14 |= composerStartRestartGroup.changed(interactionSource) ? 32 : 16;
        }
        int i22 = i14;
        if ((i12 & 4096) != 0) {
            i22 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i11 & 896) == 0) {
            i22 |= composerStartRestartGroup.changed(contentPadding) ? 256 : 128;
        }
        if ((i12 & 8192) != 0) {
            i22 |= 3072;
        } else if ((i11 & 7168) == 0) {
            i22 |= composerStartRestartGroup.changed(colors) ? 2048 : 1024;
        }
        int i23 = i12 & 16384;
        if (i23 != 0) {
            i22 |= 24576;
        } else if ((i11 & 57344) == 0) {
            i22 |= composerStartRestartGroup.changed(pVar5) ? 16384 : 8192;
        }
        if ((i20 & 1533916891) == 306783378 && (46811 & i22) == 9362 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            pVar6 = pVar2;
            pVar7 = pVar3;
            pVar8 = pVar4;
            z13 = z10;
            z14 = z11;
            z15 = z12;
            pVar9 = pVar5;
            composer2 = composerStartRestartGroup;
        } else {
            p<? super Composer, ? super Integer, k0> pVar10 = i15 != 0 ? null : pVar2;
            p<? super Composer, ? super Integer, k0> pVar11 = i16 != 0 ? null : pVar3;
            p<? super Composer, ? super Integer, k0> pVar12 = i17 != 0 ? null : pVar4;
            boolean z16 = i18 != 0 ? false : z10;
            boolean z17 = i19 != 0 ? true : z11;
            boolean z18 = i21 != 0 ? false : z12;
            p<? super Composer, ? super Integer, k0> pVar13 = i23 != 0 ? null : pVar5;
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(value) | composerStartRestartGroup.changed(visualTransformation);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = visualTransformation.filter(new AnnotatedString(value, null, null, 6, null));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            String text = ((TransformedText) objRememberedValue).getText().getText();
            if (FocusInteractionKt.collectIsFocusedAsState(interactionSource, composerStartRestartGroup, (i22 >> 3) & 14).getValue().booleanValue()) {
                inputPhase = InputPhase.Focused;
            } else {
                inputPhase = text.length() == 0 ? InputPhase.UnfocusedEmpty : InputPhase.UnfocusedNotEmpty;
            }
            InputPhase inputPhase2 = inputPhase;
            TextFieldImplKt$CommonDecorationBox$labelColor$1 textFieldImplKt$CommonDecorationBox$labelColor$1 = new TextFieldImplKt$CommonDecorationBox$labelColor$1(colors, z17, z18, interactionSource, i20, i22);
            MaterialTheme materialTheme = MaterialTheme.INSTANCE;
            Typography typography = materialTheme.getTypography(composerStartRestartGroup, 6);
            TextStyle subtitle1 = typography.getSubtitle1();
            TextStyle caption = typography.getCaption();
            long jM3351getColor0d7_KjU = subtitle1.m3351getColor0d7_KjU();
            Color.Companion companion = Color.Companion;
            boolean z19 = (Color.m1599equalsimpl0(jM3351getColor0d7_KjU, companion.m1634getUnspecified0d7_KjU()) && !Color.m1599equalsimpl0(caption.m3351getColor0d7_KjU(), companion.m1634getUnspecified0d7_KjU())) || (!Color.m1599equalsimpl0(subtitle1.m3351getColor0d7_KjU(), companion.m1634getUnspecified0d7_KjU()) && Color.m1599equalsimpl0(caption.m3351getColor0d7_KjU(), companion.m1634getUnspecified0d7_KjU()));
            TextFieldTransitionScope textFieldTransitionScope = TextFieldTransitionScope.INSTANCE;
            composerStartRestartGroup.startReplaceableGroup(2129141006);
            long jM3351getColor0d7_KjU2 = materialTheme.getTypography(composerStartRestartGroup, 6).getCaption().m3351getColor0d7_KjU();
            if (z19) {
                if (!(jM3351getColor0d7_KjU2 != companion.m1634getUnspecified0d7_KjU())) {
                    jM3351getColor0d7_KjU2 = textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0).m1608unboximpl();
                }
            }
            long j10 = jM3351getColor0d7_KjU2;
            composerStartRestartGroup.endReplaceableGroup();
            long jM3351getColor0d7_KjU3 = materialTheme.getTypography(composerStartRestartGroup, 6).getSubtitle1().m3351getColor0d7_KjU();
            if (z19) {
                if (!(jM3351getColor0d7_KjU3 != companion.m1634getUnspecified0d7_KjU())) {
                    jM3351getColor0d7_KjU3 = textFieldImplKt$CommonDecorationBox$labelColor$1.invoke(inputPhase2, composerStartRestartGroup, 0).m1608unboximpl();
                }
            }
            composer2 = composerStartRestartGroup;
            textFieldTransitionScope.m1216TransitionDTcfvLk(inputPhase2, j10, jM3351getColor0d7_KjU3, textFieldImplKt$CommonDecorationBox$labelColor$1, pVar != null, ComposableLambdaKt.composableLambda(composer2, 341865432, true, new AnonymousClass3(pVar, pVar10, text, z18, i22, colors, z17, interactionSource, i20, pVar11, pVar12, type, innerTextField, z16, contentPadding, z19, pVar13)), composer2, 1769472);
            pVar6 = pVar10;
            pVar7 = pVar11;
            pVar8 = pVar12;
            z13 = z16;
            z14 = z17;
            z15 = z18;
            pVar9 = pVar13;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass4(type, value, innerTextField, visualTransformation, pVar, pVar6, pVar7, pVar8, z13, z14, z15, interactionSource, contentPadding, colors, pVar9, i10, i11, i12));
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004e  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006a  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008d  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:? A[RETURN, SYNTHETIC] */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableOpenTarget(index = 0)
    /* JADX INFO: renamed from: Decoration-euL9pac, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1204DecorationeuL9pac(long r15, @org.jetbrains.annotations.Nullable androidx.compose.ui.text.TextStyle r17, @org.jetbrains.annotations.Nullable java.lang.Float r18, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r19, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r20, int r21, int r22) {
        /*
            Method dump skipped, instruction units count: 232
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m1204DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    @NotNull
    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }

    @Nullable
    public static final Object getLayoutId(@NotNull IntrinsicMeasurable intrinsicMeasurable) {
        kotlin.jvm.internal.t.i(intrinsicMeasurable, "<this>");
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final int heightOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final int widthOrZero(@Nullable Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }
}
