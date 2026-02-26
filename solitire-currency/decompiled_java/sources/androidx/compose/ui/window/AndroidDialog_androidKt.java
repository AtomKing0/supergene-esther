package androidx.compose.ui.window;

import androidx.compose.runtime.Applier;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.d;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.ViewConfiguration;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.LayoutDirection;
import h9.a;
import h9.l;
import h9.p;
import h9.q;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: AndroidDialog.android.kt */
/* JADX INFO: loaded from: classes.dex */
public final class AndroidDialog_androidKt {

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    static final class AnonymousClass1 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ DialogWrapper $dialog;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(DialogWrapper dialogWrapper) {
            super(1);
            this.$dialog = dialogWrapper;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            this.$dialog.show();
            final DialogWrapper dialogWrapper = this.$dialog;
            return new DisposableEffectResult() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$1$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    dialogWrapper.dismiss();
                    dialogWrapper.disposeComposition();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$2, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    static final class AnonymousClass2 extends v implements a<k0> {
        final /* synthetic */ DialogWrapper $dialog;
        final /* synthetic */ LayoutDirection $layoutDirection;
        final /* synthetic */ a<k0> $onDismissRequest;
        final /* synthetic */ DialogProperties $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(DialogWrapper dialogWrapper, a<k0> aVar, DialogProperties dialogProperties, LayoutDirection layoutDirection) {
            super(0);
            this.$dialog = dialogWrapper;
            this.$onDismissRequest = aVar;
            this.$properties = dialogProperties;
            this.$layoutDirection = layoutDirection;
        }

        @Override // h9.a
        public /* bridge */ /* synthetic */ k0 invoke() {
            invoke2();
            return k0.f35197a;
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2() {
            this.$dialog.updateParameters(this.$onDismissRequest, this.$properties, this.$layoutDirection);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$Dialog$3, reason: invalid class name */
    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ a<k0> $onDismissRequest;
        final /* synthetic */ DialogProperties $properties;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(a<k0> aVar, DialogProperties dialogProperties, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.$onDismissRequest = aVar;
            this.$properties = dialogProperties;
            this.$content = pVar;
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
            AndroidDialog_androidKt.Dialog(this.$onDismissRequest, this.$properties, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.ui.window.AndroidDialog_androidKt$DialogLayout$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: AndroidDialog.android.kt */
    static final class C10122 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C10122(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$content = pVar;
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
            AndroidDialog_androidKt.DialogLayout(this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:58:0x0108  */
    @androidx.compose.runtime.Composable
    @androidx.compose.runtime.ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Dialog(@org.jetbrains.annotations.NotNull h9.a<v8.k0> r19, @org.jetbrains.annotations.Nullable androidx.compose.ui.window.DialogProperties r20, @org.jetbrains.annotations.NotNull h9.p<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, v8.k0> r21, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r22, int r23, int r24) {
        /*
            Method dump skipped, instruction units count: 358
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.window.AndroidDialog_androidKt.Dialog(h9.a, androidx.compose.ui.window.DialogProperties, h9.p, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: Dialog$lambda-0, reason: not valid java name */
    public static final p<Composer, Integer, k0> m3913Dialog$lambda0(State<? extends p<? super Composer, ? super Integer, k0>> state) {
        return (p) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void DialogLayout(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, Composer composer, int i10, int i11) {
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1177876616);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
        } else if ((i10 & 14) == 0) {
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(pVar) ? 32 : 16;
        }
        if ((i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                modifier = Modifier.Companion;
            }
            C10111 c10111 = new MeasurePolicy() { // from class: androidx.compose.ui.window.AndroidDialog_androidKt.DialogLayout.1
                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i14) {
                    return d.a(this, intrinsicMeasureScope, list, i14);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i14) {
                    return d.b(this, intrinsicMeasureScope, list, i14);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                @NotNull
                /* JADX INFO: renamed from: measure-3p2s80s */
                public final MeasureResult mo8measure3p2s80s(@NotNull MeasureScope Layout, @NotNull List<? extends Measurable> measurables, long j10) {
                    Object obj;
                    t.i(Layout, "$this$Layout");
                    t.i(measurables, "measurables");
                    ArrayList arrayList = new ArrayList(measurables.size());
                    int size = measurables.size();
                    for (int i14 = 0; i14 < size; i14++) {
                        arrayList.add(measurables.get(i14).mo2987measureBRTryo0(j10));
                    }
                    Object obj2 = null;
                    int i15 = 1;
                    if (arrayList.isEmpty()) {
                        obj = null;
                    } else {
                        obj = arrayList.get(0);
                        int width = ((Placeable) obj).getWidth();
                        int iM = kotlin.collections.v.m(arrayList);
                        if (1 <= iM) {
                            int i16 = 1;
                            while (true) {
                                Object obj3 = arrayList.get(i16);
                                int width2 = ((Placeable) obj3).getWidth();
                                if (width < width2) {
                                    obj = obj3;
                                    width = width2;
                                }
                                if (i16 == iM) {
                                    break;
                                }
                                i16++;
                            }
                        }
                    }
                    Placeable placeable = (Placeable) obj;
                    int width3 = placeable != null ? placeable.getWidth() : Constraints.m3643getMinWidthimpl(j10);
                    if (!arrayList.isEmpty()) {
                        Object obj4 = arrayList.get(0);
                        int height = ((Placeable) obj4).getHeight();
                        int iM2 = kotlin.collections.v.m(arrayList);
                        if (1 <= iM2) {
                            while (true) {
                                Object obj5 = arrayList.get(i15);
                                int height2 = ((Placeable) obj5).getHeight();
                                if (height < height2) {
                                    obj4 = obj5;
                                    height = height2;
                                }
                                if (i15 == iM2) {
                                    break;
                                }
                                i15++;
                            }
                        }
                        obj2 = obj4;
                    }
                    Placeable placeable2 = (Placeable) obj2;
                    return MeasureScope.CC.p(Layout, width3, placeable2 != null ? placeable2.getHeight() : Constraints.m3642getMinHeightimpl(j10), null, new AndroidDialog_androidKt$DialogLayout$1$measure$1(arrayList), 4, null);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i14) {
                    return d.c(this, intrinsicMeasureScope, list, i14);
                }

                @Override // androidx.compose.ui.layout.MeasurePolicy
                public /* synthetic */ int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, List list, int i14) {
                    return d.d(this, intrinsicMeasureScope, list, i14);
                }
            };
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            LayoutDirection layoutDirection = (LayoutDirection) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalLayoutDirection());
            ViewConfiguration viewConfiguration = (ViewConfiguration) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalViewConfiguration());
            ComposeUiNode.Companion companion = ComposeUiNode.Companion;
            a<ComposeUiNode> constructor = companion.getConstructor();
            q<SkippableUpdater<ComposeUiNode>, Composer, Integer, k0> qVarMaterializerOf = LayoutKt.materializerOf(modifier);
            int i14 = (((((i12 << 3) & 112) | ((i12 >> 3) & 14)) << 9) & 7168) | 6;
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
            Updater.m1265setimpl(composerM1258constructorimpl, c10111, companion.getSetMeasurePolicy());
            Updater.m1265setimpl(composerM1258constructorimpl, density, companion.getSetDensity());
            Updater.m1265setimpl(composerM1258constructorimpl, layoutDirection, companion.getSetLayoutDirection());
            Updater.m1265setimpl(composerM1258constructorimpl, viewConfiguration, companion.getSetViewConfiguration());
            composerStartRestartGroup.enableReusing();
            qVarMaterializerOf.invoke(SkippableUpdater.m1248boximpl(SkippableUpdater.m1249constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, Integer.valueOf((i14 >> 3) & 112));
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            pVar.mo4invoke(composerStartRestartGroup, Integer.valueOf((i14 >> 9) & 14));
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new C10122(modifier, pVar, i10, i11));
    }
}
