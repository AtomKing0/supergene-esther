package l;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Stable;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.l;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import l.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;
import w.c;
import w.k;

/* JADX INFO: compiled from: AsyncImage.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a {

    /* JADX INFO: renamed from: l.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncImage.kt */
    static final class C0609a extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Object f30090g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ String f30091h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ j.e f30092i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Modifier f30093j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ l<b.c, b.c> f30094k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ l<b.c, k0> f30095l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ Alignment f30096m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ ContentScale f30097n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final /* synthetic */ float f30098o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        final /* synthetic */ ColorFilter f30099p;

        /* JADX INFO: renamed from: q, reason: collision with root package name */
        final /* synthetic */ int f30100q;

        /* JADX INFO: renamed from: r, reason: collision with root package name */
        final /* synthetic */ int f30101r;

        /* JADX INFO: renamed from: s, reason: collision with root package name */
        final /* synthetic */ int f30102s;

        /* JADX INFO: renamed from: t, reason: collision with root package name */
        final /* synthetic */ int f30103t;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C0609a(Object obj, String str, j.e eVar, Modifier modifier, l<? super b.c, ? extends b.c> lVar, l<? super b.c, k0> lVar2, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, int i10, int i11, int i12, int i13) {
            super(2);
            this.f30090g = obj;
            this.f30091h = str;
            this.f30092i = eVar;
            this.f30093j = modifier;
            this.f30094k = lVar;
            this.f30095l = lVar2;
            this.f30096m = alignment;
            this.f30097n = contentScale;
            this.f30098o = f10;
            this.f30099p = colorFilter;
            this.f30100q = i10;
            this.f30101r = i11;
            this.f30102s = i12;
            this.f30103t = i13;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            a.a(this.f30090g, this.f30091h, this.f30092i, this.f30093j, this.f30094k, this.f30095l, this.f30096m, this.f30097n, this.f30098o, this.f30099p, this.f30100q, composer, this.f30101r | 1, this.f30102s, this.f30103t);
        }
    }

    /* JADX INFO: compiled from: Composables.kt */
    public static final class b extends v implements h9.a<ComposeUiNode> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ h9.a f30104g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(h9.a aVar) {
            super(0);
            this.f30104g = aVar;
        }

        /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.node.ComposeUiNode, java.lang.Object] */
        @Override // h9.a
        @NotNull
        public final ComposeUiNode invoke() {
            return this.f30104g.invoke();
        }
    }

    /* JADX INFO: compiled from: AsyncImage.kt */
    static final class c implements MeasurePolicy {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f30105a = new c();

        /* JADX INFO: renamed from: l.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: AsyncImage.kt */
        static final class C0610a extends v implements l<Placeable.PlacementScope, k0> {

            /* JADX INFO: renamed from: g, reason: collision with root package name */
            public static final C0610a f30106g = new C0610a();

            C0610a() {
                super(1);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(@NotNull Placeable.PlacementScope placementScope) {
            }

            @Override // h9.l
            public /* bridge */ /* synthetic */ k0 invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return k0.f35197a;
            }
        }

        c() {
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.a(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.b(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        @NotNull
        /* JADX INFO: renamed from: measure-3p2s80s */
        public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope measureScope, @NotNull List<? extends Measurable> list, long j10) {
            return MeasureScope.CC.p(measureScope, Constraints.m3643getMinWidthimpl(j10), Constraints.m3642getMinHeightimpl(j10), null, C0610a.f30106g, 4, null);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.c(this, intrinsicMeasureScope, list, i10);
        }

        @Override // androidx.compose.ui.layout.MeasurePolicy
        public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i10) {
            return androidx.compose.ui.layout.d.d(this, intrinsicMeasureScope, list, i10);
        }
    }

    /* JADX INFO: compiled from: AsyncImage.kt */
    static final class d extends v implements p<Composer, Integer, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ Modifier f30107g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final /* synthetic */ Painter f30108h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final /* synthetic */ String f30109i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final /* synthetic */ Alignment f30110j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final /* synthetic */ ContentScale f30111k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final /* synthetic */ float f30112l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final /* synthetic */ ColorFilter f30113m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final /* synthetic */ int f30114n;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        d(Modifier modifier, Painter painter, String str, Alignment alignment, ContentScale contentScale, float f10, ColorFilter colorFilter, int i10) {
            super(2);
            this.f30107g = modifier;
            this.f30108h = painter;
            this.f30109i = str;
            this.f30110j = alignment;
            this.f30111k = contentScale;
            this.f30112l = f10;
            this.f30113m = colorFilter;
            this.f30114n = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            a.b(this.f30107g, this.f30108h, this.f30109i, this.f30110j, this.f30111k, this.f30112l, this.f30113m, composer, this.f30114n | 1);
        }
    }

    /* JADX INFO: compiled from: AsyncImage.kt */
    static final class e extends v implements l<SemanticsPropertyReceiver, k0> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final /* synthetic */ String f30115g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        e(String str) {
            super(1);
            this.f30115g = str;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ k0 invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            invoke2(semanticsPropertyReceiver);
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(@NotNull SemanticsPropertyReceiver semanticsPropertyReceiver) {
            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, this.f30115g);
            SemanticsPropertiesKt.m3247setRolekuIjeqM(semanticsPropertyReceiver, Role.Companion.m3236getImageo7Vup1c());
        }
    }

    @Composable
    public static final void a(@Nullable Object obj, @Nullable String str, @NotNull j.e eVar, @Nullable Modifier modifier, @Nullable l<? super b.c, ? extends b.c> lVar, @Nullable l<? super b.c, k0> lVar2, @Nullable Alignment alignment, @Nullable ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, int i10, @Nullable Composer composer, int i11, int i12, int i13) {
        int iM2027getDefaultFilterQualityfv9h1I;
        int i14;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2030202961);
        Modifier modifier2 = (i13 & 8) != 0 ? Modifier.Companion : modifier;
        l<? super b.c, ? extends b.c> lVarA = (i13 & 16) != 0 ? l.b.f30116p.a() : lVar;
        l<? super b.c, k0> lVar3 = (i13 & 32) != 0 ? null : lVar2;
        Alignment center = (i13 & 64) != 0 ? Alignment.Companion.getCenter() : alignment;
        ContentScale fit = (i13 & 128) != 0 ? ContentScale.Companion.getFit() : contentScale;
        float f11 = (i13 & 256) != 0 ? 1.0f : f10;
        ColorFilter colorFilter2 = (i13 & 512) != 0 ? null : colorFilter;
        if ((i13 & 1024) != 0) {
            i14 = i12 & (-15);
            iM2027getDefaultFilterQualityfv9h1I = DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I();
        } else {
            iM2027getDefaultFilterQualityfv9h1I = i10;
            i14 = i12;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2030202961, i11, i14, "coil.compose.AsyncImage (AsyncImage.kt:116)");
        }
        v.i iVarF = f(j.d(obj, composerStartRestartGroup, 8), fit, composerStartRestartGroup, 8 | ((i11 >> 18) & 112));
        int i15 = i11 >> 6;
        int i16 = i11 >> 9;
        int i17 = i16 & 57344;
        l<? super b.c, ? extends b.c> lVar4 = lVarA;
        l<? super b.c, k0> lVar5 = lVar3;
        ContentScale contentScale2 = fit;
        int i18 = iM2027getDefaultFilterQualityfv9h1I;
        l.b bVarD = l.c.d(iVarF, eVar, lVar4, lVar5, contentScale2, i18, composerStartRestartGroup, ((i14 << 15) & 458752) | (i15 & 7168) | (i15 & 896) | 72 | i17, 0);
        w.j jVarK = iVarF.K();
        b(jVarK instanceof l.d ? modifier2.then((Modifier) jVarK) : modifier2, bVarD, str, center, fit, f11, colorFilter2, composerStartRestartGroup, (i16 & 7168) | ((i11 << 3) & 896) | i17 | (i16 & 458752) | (3670016 & i16));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C0609a(obj, str, eVar, modifier2, lVarA, lVar3, center, fit, f11, colorFilter2, iM2027getDefaultFilterQualityfv9h1I, i11, i12, i13));
    }

    @ComposableTarget(applier = "androidx.compose.ui.UiComposable")
    @Composable
    public static final void b(@NotNull Modifier modifier, @NotNull Painter painter, @Nullable String str, @NotNull Alignment alignment, @NotNull ContentScale contentScale, float f10, @Nullable ColorFilter colorFilter, @Nullable Composer composer, int i10) {
        Composer composerStartRestartGroup = composer.startRestartGroup(10290533);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(10290533, i10, -1, "coil.compose.Content (AsyncImage.kt:154)");
        }
        Modifier modifierThen = ClipKt.clipToBounds(d(modifier, str)).then(new l.e(painter, alignment, contentScale, f10, colorFilter));
        c cVar = c.f30105a;
        composerStartRestartGroup.startReplaceableGroup(544976794);
        Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
        LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
        ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
        Modifier modifierMaterialize = ComposedModifierKt.materialize(composerStartRestartGroup, modifierThen);
        ComposeUiNode.Companion companion = ComposeUiNode.Companion;
        h9.a<ComposeUiNode> constructor = companion.getConstructor();
        composerStartRestartGroup.startReplaceableGroup(1405779621);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(new b(constructor));
        } else {
            composerStartRestartGroup.useNode();
        }
        composerStartRestartGroup.disableReusing();
        Composer composerM1258constructorimpl = Updater.m1258constructorimpl(composerStartRestartGroup);
        Updater.m1265setimpl(composerM1258constructorimpl, cVar, companion.getSetMeasurePolicy());
        Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
        Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
        Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
        Updater.m1265setimpl(composerM1258constructorimpl, modifierMaterialize, companion.getSetModifier());
        composerStartRestartGroup.enableReusing();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new d(modifier, painter, str, alignment, contentScale, f10, colorFilter, i10));
    }

    @Stable
    private static final Modifier d(Modifier modifier, String str) {
        return str != null ? SemanticsModifierKt.semantics$default(modifier, false, new e(str), 1, null) : modifier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Stable
    public static final w.i e(long j10) {
        if (Constraints.m3645isZeroimpl(j10)) {
            return null;
        }
        return new w.i(Constraints.m3637getHasBoundedWidthimpl(j10) ? w.a.a(Constraints.m3641getMaxWidthimpl(j10)) : c.b.f35261a, Constraints.m3636getHasBoundedHeightimpl(j10) ? w.a.a(Constraints.m3640getMaxHeightimpl(j10)) : c.b.f35261a);
    }

    @Composable
    @NotNull
    public static final v.i f(@NotNull v.i iVar, @NotNull ContentScale contentScale, @Nullable Composer composer, int i10) {
        w.j jVarA;
        composer.startReplaceableGroup(402368983);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(402368983, i10, -1, "coil.compose.updateRequest (AsyncImage.kt:181)");
        }
        if (iVar.q().m() == null) {
            if (t.d(contentScale, ContentScale.Companion.getNone())) {
                jVarA = k.a(w.i.f35274d);
            } else {
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.Companion.getEmpty()) {
                    objRememberedValue = new l.d();
                    composer.updateRememberedValue(objRememberedValue);
                }
                composer.endReplaceableGroup();
                jVarA = (w.j) objRememberedValue;
            }
            iVar = v.i.R(iVar, null, 1, null).k(jVarA).a();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return iVar;
    }
}
