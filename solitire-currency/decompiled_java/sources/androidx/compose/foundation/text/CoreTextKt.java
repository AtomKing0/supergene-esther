package androidx.compose.foundation.text;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.Placeholder;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.collections.v;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import v8.s;

/* JADX INFO: compiled from: CoreText.kt */
/* JADX INFO: loaded from: classes.dex */
public final class CoreTextKt {

    @NotNull
    private static final s<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<q<String, Composer, Integer, k0>>>> EmptyInlineContent = new s<>(v.l(), v.l());

    /* JADX INFO: renamed from: androidx.compose.foundation.text.CoreTextKt$InlineChildren$2, reason: invalid class name */
    /* JADX INFO: compiled from: CoreText.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ List<AnnotatedString.Range<q<String, Composer, Integer, k0>>> $inlineContents;
        final /* synthetic */ AnnotatedString $text;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(AnnotatedString annotatedString, List<AnnotatedString.Range<q<String, Composer, Integer, k0>>> list, int i10) {
            super(2);
            this.$text = annotatedString;
            this.$inlineContents = list;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            CoreTextKt.InlineChildren(this.$text, this.$inlineContents, composer, this.$$changed | 1);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void InlineChildren(@NotNull AnnotatedString text, @NotNull List<AnnotatedString.Range<q<String, Composer, Integer, k0>>> inlineContents, @Nullable Composer composer, int i10) {
        t.i(text, "text");
        t.i(inlineContents, "inlineContents");
        Composer composerStartRestartGroup = composer.startRestartGroup(-110905764);
        int size = inlineContents.size();
        int i11 = 0;
        while (i11 < size) {
            AnnotatedString.Range<q<String, Composer, Integer, k0>> range = inlineContents.get(i11);
            q<String, Composer, Integer, k0> qVarComponent1 = range.component1();
            int iComponent2 = range.component2();
            int iComponent3 = range.component3();
            CoreTextKt$InlineChildren$1$2 coreTextKt$InlineChildren$1$2 = new MeasurePolicy() { // from class: androidx.compose.foundation.text.CoreTextKt$InlineChildren$1$2
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.a(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.b(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> children, long j10) {
                    t.i(Layout, "$this$Layout");
                    t.i(children, "children");
                    ArrayList arrayList = new ArrayList(children.size());
                    int size2 = children.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        arrayList.add(children.get(i12).mo2987measureBRTryo0(j10));
                    }
                    return MeasureScope.CC.p(Layout, Constraints.m3641getMaxWidthimpl(j10), Constraints.m3640getMaxHeightimpl(j10), null, new CoreTextKt$InlineChildren$1$2$measure$1(arrayList), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.c(this, intrinsicMeasureScope, list, i12);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i12) {
                    return d.d(this, intrinsicMeasureScope, list, i12);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Modifier.Companion companion = Modifier.Companion;
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion2 = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion2.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(companion);
            int i12 = size;
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            composerStartRestartGroup.disableReusing();
            Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
            Updater.m1265setimpl(composerM1258constructorimpl, coreTextKt$InlineChildren$1$2, companion2.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion2.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion2.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion2.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            composerStartRestartGroup.startReplaceableGroup(-72427749);
            qVarComponent1.invoke(text.subSequence(iComponent2, iComponent3).getText(), composerStartRestartGroup, 0);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            i11++;
            size = i12;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(text, inlineContents, i10));
    }

    @NotNull
    public static final s<List<AnnotatedString.Range<Placeholder>>, List<AnnotatedString.Range<q<String, Composer, Integer, k0>>>> resolveInlineContent(@NotNull AnnotatedString text, @NotNull Map<String, InlineTextContent> inlineContent) {
        t.i(text, "text");
        t.i(inlineContent, "inlineContent");
        if (inlineContent.isEmpty()) {
            return EmptyInlineContent;
        }
        List<AnnotatedString.Range<String>> stringAnnotations = text.getStringAnnotations(InlineTextContentKt.INLINE_CONTENT_TAG, 0, text.length());
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int size = stringAnnotations.size();
        for (int i10 = 0; i10 < size; i10++) {
            AnnotatedString.Range<String> range = stringAnnotations.get(i10);
            InlineTextContent inlineTextContent = inlineContent.get(range.getItem());
            if (inlineTextContent != null) {
                arrayList.add(new AnnotatedString.Range(inlineTextContent.getPlaceholder(), range.getStart(), range.getEnd()));
                arrayList2.add(new AnnotatedString.Range(inlineTextContent.getChildren(), range.getStart(), range.getEnd()));
            }
        }
        return new s<>(arrayList, arrayList2);
    }

    @NotNull
    /* JADX INFO: renamed from: updateTextDelegate-x_uQXYA, reason: not valid java name */
    public static final TextDelegate m667updateTextDelegatex_uQXYA(@NotNull TextDelegate current, @NotNull AnnotatedString text, @NotNull TextStyle style, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, boolean z10, int i10, int i11, @NotNull List<AnnotatedString.Range<Placeholder>> placeholders) {
        t.i(current, "current");
        t.i(text, "text");
        t.i(style, "style");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        t.i(placeholders, "placeholders");
        if (t.d(current.getText(), text) && t.d(current.getStyle(), style)) {
            if (current.getSoftWrap() == z10) {
                if (TextOverflow.m3619equalsimpl0(current.m718getOverflowgIe3tQ8(), i10)) {
                    if (current.getMaxLines() == i11 && t.d(current.getDensity(), density) && t.d(current.getPlaceholders(), placeholders) && current.getFontFamilyResolver() == fontFamilyResolver) {
                        return current;
                    }
                }
                return new TextDelegate(text, style, i11, z10, i10, density, fontFamilyResolver, placeholders, null);
            }
            return new TextDelegate(text, style, i11, z10, i10, density, fontFamilyResolver, placeholders, null);
        }
        return new TextDelegate(text, style, i11, z10, i10, density, fontFamilyResolver, placeholders, null);
    }

    @NotNull
    /* JADX INFO: renamed from: updateTextDelegate-y0k-MQk, reason: not valid java name */
    public static final TextDelegate m669updateTextDelegatey0kMQk(@NotNull TextDelegate current, @NotNull String text, @NotNull TextStyle style, @NotNull Density density, @NotNull FontFamily.Resolver fontFamilyResolver, boolean z10, int i10, int i11) {
        t.i(current, "current");
        t.i(text, "text");
        t.i(style, "style");
        t.i(density, "density");
        t.i(fontFamilyResolver, "fontFamilyResolver");
        if (t.d(current.getText().getText(), text) && t.d(current.getStyle(), style)) {
            if (current.getSoftWrap() == z10) {
                if (TextOverflow.m3619equalsimpl0(current.m718getOverflowgIe3tQ8(), i10)) {
                    if (current.getMaxLines() == i11 && t.d(current.getDensity(), density) && current.getFontFamilyResolver() == fontFamilyResolver) {
                        return current;
                    }
                }
                return new TextDelegate(new AnnotatedString(text, null, null, 6, null), style, i11, z10, i10, density, fontFamilyResolver, null, 128, null);
            }
            return new TextDelegate(new AnnotatedString(text, null, null, 6, null), style, i11, z10, i10, density, fontFamilyResolver, null, 128, null);
        }
        return new TextDelegate(new AnnotatedString(text, null, null, 6, null), style, i11, z10, i10, density, fontFamilyResolver, null, 128, null);
    }
}
