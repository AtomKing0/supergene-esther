package androidx.compose.foundation.text.selection;

import androidx.compose.foundation.text.ContextMenu_androidKt;
import androidx.compose.foundation.text.TextDragObserver;
import androidx.compose.foundation.text.TouchMode_androidKt;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposableTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.hapticfeedback.HapticFeedback;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.ClipboardManager;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.TextToolbar;
import androidx.compose.ui.text.style.ResolvedTextDirection;
import androidx.media3.exoplayer.RendererCapabilities;
import androidx.profileinstaller.ProfileVerifier;
import h9.l;
import h9.p;
import java.util.List;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: SelectionContainer.kt */
/* JADX INFO: loaded from: classes.dex */
public final class SelectionContainerKt {

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$DisableSelection$1, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionContainer.kt */
    static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ p<Composer, Integer, k0> $content;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$content = pVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            SelectionContainerKt.DisableSelection(this.$content, composer, this.$$changed | 1);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$2, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionContainer.kt */
    static final class AnonymousClass2 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $content;
        final /* synthetic */ Modifier $modifier;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(Modifier modifier, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
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
            SelectionContainerKt.SelectionContainer(this.$modifier, this.$content, composer, this.$$changed | 1, this.$$default);
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionContainer.kt */
    static final class AnonymousClass3 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$dirty;
        final /* synthetic */ p<Composer, Integer, k0> $children;
        final /* synthetic */ SelectionManager $manager;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ SelectionRegistrarImpl $registrarImpl;

        /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1, reason: invalid class name */
        /* JADX INFO: compiled from: SelectionContainer.kt */
        static final class AnonymousClass1 extends v implements p<Composer, Integer, k0> {
            final /* synthetic */ int $$dirty;
            final /* synthetic */ p<Composer, Integer, k0> $children;
            final /* synthetic */ SelectionManager $manager;
            final /* synthetic */ Modifier $modifier;

            /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$3$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: SelectionContainer.kt */
            static final class C00721 extends v implements p<Composer, Integer, k0> {
                final /* synthetic */ int $$dirty;
                final /* synthetic */ p<Composer, Integer, k0> $children;
                final /* synthetic */ SelectionManager $manager;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                C00721(p<? super Composer, ? super Integer, k0> pVar, int i10, SelectionManager selectionManager) {
                    super(2);
                    this.$children = pVar;
                    this.$$dirty = i10;
                    this.$manager = selectionManager;
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
                    Selection selection;
                    if ((i10 & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    this.$children.mo4invoke(composer, Integer.valueOf((this.$$dirty >> 9) & 14));
                    if (TouchMode_androidKt.isInTouchMode() && this.$manager.getHasFocus() && (selection = this.$manager.getSelection()) != null) {
                        SelectionManager selectionManager = this.$manager;
                        List listN = kotlin.collections.v.n(Boolean.TRUE, Boolean.FALSE);
                        int size = listN.size();
                        for (int i11 = 0; i11 < size; i11++) {
                            boolean zBooleanValue = ((Boolean) listN.get(i11)).booleanValue();
                            Boolean boolValueOf = Boolean.valueOf(zBooleanValue);
                            composer.startReplaceableGroup(1157296644);
                            boolean zChanged = composer.changed(boolValueOf);
                            Object objRememberedValue = composer.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                                objRememberedValue = selectionManager.handleDragObserver(zBooleanValue);
                                composer.updateRememberedValue(objRememberedValue);
                            }
                            composer.endReplaceableGroup();
                            TextDragObserver textDragObserver = (TextDragObserver) objRememberedValue;
                            Offset offsetM809getStartHandlePosition_m7T9E = zBooleanValue ? selectionManager.m809getStartHandlePosition_m7T9E() : selectionManager.m808getEndHandlePosition_m7T9E();
                            ResolvedTextDirection direction = zBooleanValue ? selection.getStart().getDirection() : selection.getEnd().getDirection();
                            if (offsetM809getStartHandlePosition_m7T9E != null) {
                                AndroidSelectionHandles_androidKt.m754SelectionHandle8fL75g(offsetM809getStartHandlePosition_m7T9E.m1377unboximpl(), zBooleanValue, direction, selection.getHandlesCrossed(), SuspendingPointerInputFilterKt.pointerInput(Modifier.Companion, textDragObserver, new SelectionContainerKt$SelectionContainer$3$1$1$1$1$1(textDragObserver, null)), null, composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
                            }
                        }
                    }
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            AnonymousClass1(Modifier modifier, SelectionManager selectionManager, p<? super Composer, ? super Integer, k0> pVar, int i10) {
                super(2);
                this.$modifier = modifier;
                this.$manager = selectionManager;
                this.$children = pVar;
                this.$$dirty = i10;
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
                    SimpleLayoutKt.SimpleLayout(this.$modifier.then(this.$manager.getModifier()), ComposableLambdaKt.composableLambda(composer, 1375295262, true, new C00721(this.$children, this.$$dirty, this.$manager)), composer, 48, 0);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass3(SelectionRegistrarImpl selectionRegistrarImpl, Modifier modifier, SelectionManager selectionManager, p<? super Composer, ? super Integer, k0> pVar, int i10) {
            super(2);
            this.$registrarImpl = selectionRegistrarImpl;
            this.$modifier = modifier;
            this.$manager = selectionManager;
            this.$children = pVar;
            this.$$dirty = i10;
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
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(this.$registrarImpl)}, ComposableLambdaKt.composableLambda(composer, 935424596, true, new AnonymousClass1(this.$modifier, this.$manager, this.$children, this.$$dirty)), composer, 56);
            }
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionContainer.kt */
    static final class AnonymousClass4 extends v implements l<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ SelectionManager $manager;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass4(SelectionManager selectionManager) {
            super(1);
            this.$manager = selectionManager;
        }

        @Override // h9.l
        @NotNull
        public final DisposableEffectResult invoke(@NotNull DisposableEffectScope DisposableEffect) {
            t.i(DisposableEffect, "$this$DisposableEffect");
            final SelectionManager selectionManager = this.$manager;
            return new DisposableEffectResult() { // from class: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$4$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    selectionManager.hideSelectionToolbar$foundation_release();
                }
            };
        }
    }

    /* JADX INFO: renamed from: androidx.compose.foundation.text.selection.SelectionContainerKt$SelectionContainer$5, reason: invalid class name */
    /* JADX INFO: compiled from: SelectionContainer.kt */
    static final class AnonymousClass5 extends v implements p<Composer, Integer, k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ int $$default;
        final /* synthetic */ p<Composer, Integer, k0> $children;
        final /* synthetic */ Modifier $modifier;
        final /* synthetic */ l<Selection, k0> $onSelectionChange;
        final /* synthetic */ Selection $selection;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass5(Modifier modifier, Selection selection, l<? super Selection, k0> lVar, p<? super Composer, ? super Integer, k0> pVar, int i10, int i11) {
            super(2);
            this.$modifier = modifier;
            this.$selection = selection;
            this.$onSelectionChange = lVar;
            this.$children = pVar;
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
            SelectionContainerKt.SelectionContainer(this.$modifier, this.$selection, this.$onSelectionChange, this.$children, composer, this.$$changed | 1, this.$$default);
        }
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void DisableSelection(@NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10) {
        int i11;
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(336063542);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(content) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{SelectionRegistrarKt.getLocalSelectionRegistrar().provides(null)}, content, composerStartRestartGroup, ((i11 << 3) & 112) | 8);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass1(content, i10));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(@Nullable Modifier modifier, @NotNull p<? super Composer, ? super Integer, k0> content, @Nullable Composer composer, int i10, int i11) {
        int i12;
        t.i(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1075498320);
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
            i12 |= composerStartRestartGroup.changed(content) ? 32 : 16;
        }
        if ((i12 & 91) == 18 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i13 != 0) {
                modifier = Modifier.Companion;
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            MutableState mutableState = (MutableState) objRememberedValue;
            Selection selectionM773SelectionContainer$lambda1 = m773SelectionContainer$lambda1(mutableState);
            composerStartRestartGroup.startReplaceableGroup(1157296644);
            boolean zChanged = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SelectionContainerKt$SelectionContainer$1$1(mutableState);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SelectionContainer(modifier, selectionM773SelectionContainer$lambda1, (l) objRememberedValue2, content, composerStartRestartGroup, (i12 & 14) | ((i12 << 6) & 7168), 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(modifier, content, i10, i11));
    }

    /* JADX INFO: renamed from: SelectionContainer$lambda-1, reason: not valid java name */
    private static final Selection m773SelectionContainer$lambda1(MutableState<Selection> mutableState) {
        return mutableState.getValue();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[androidx.compose.ui.UiComposable[androidx.compose.ui.UiComposable]]")
    public static final void SelectionContainer(@Nullable Modifier modifier, @Nullable Selection selection, @NotNull l<? super Selection, k0> onSelectionChange, @NotNull p<? super Composer, ? super Integer, k0> children, @Nullable Composer composer, int i10, int i11) {
        Modifier modifier2;
        int i12;
        Modifier modifier3;
        t.i(onSelectionChange, "onSelectionChange");
        t.i(children, "children");
        Composer composerStartRestartGroup = composer.startRestartGroup(2078139907);
        int i13 = i11 & 1;
        if (i13 != 0) {
            i12 = i10 | 6;
            modifier2 = modifier;
        } else if ((i10 & 14) == 0) {
            modifier2 = modifier;
            i12 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i10;
        } else {
            modifier2 = modifier;
            i12 = i10;
        }
        if ((i11 & 2) != 0) {
            i12 |= 48;
        } else if ((i10 & 112) == 0) {
            i12 |= composerStartRestartGroup.changed(selection) ? 32 : 16;
        }
        if ((i11 & 4) != 0) {
            i12 |= RendererCapabilities.DECODER_SUPPORT_MASK;
        } else if ((i10 & 896) == 0) {
            i12 |= composerStartRestartGroup.changed(onSelectionChange) ? 256 : 128;
        }
        if ((i11 & 8) != 0) {
            i12 |= 3072;
        } else if ((i10 & 7168) == 0) {
            i12 |= composerStartRestartGroup.changed(children) ? 2048 : 1024;
        }
        int i14 = i12;
        if ((i14 & 5851) == 1170 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            modifier3 = i13 != 0 ? Modifier.Companion : modifier2;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = new SelectionRegistrarImpl();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SelectionRegistrarImpl selectionRegistrarImpl = (SelectionRegistrarImpl) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new SelectionManager(selectionRegistrarImpl);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SelectionManager selectionManager = (SelectionManager) objRememberedValue2;
            selectionManager.setHapticFeedBack((HapticFeedback) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalHapticFeedback()));
            selectionManager.setClipboardManager((ClipboardManager) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalClipboardManager()));
            selectionManager.setTextToolbar((TextToolbar) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalTextToolbar()));
            selectionManager.setOnSelectionChange(onSelectionChange);
            selectionManager.setSelection(selection);
            selectionManager.setTouchMode(TouchMode_androidKt.isInTouchMode());
            ContextMenu_androidKt.ContextMenuArea(selectionManager, ComposableLambdaKt.composableLambda(composerStartRestartGroup, -123806316, true, new AnonymousClass3(selectionRegistrarImpl, modifier3, selectionManager, children, i14)), composerStartRestartGroup, 56);
            EffectsKt.DisposableEffect(selectionManager, new AnonymousClass4(selectionManager), composerStartRestartGroup, 8);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass5(modifier3, selection, onSelectionChange, children, i10, i11));
    }
}
