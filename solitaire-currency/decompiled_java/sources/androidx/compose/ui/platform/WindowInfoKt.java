package androidx.compose.ui.platform;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: WindowInfo.kt */
/* JADX INFO: loaded from: classes.dex */
public final class WindowInfoKt {

    /* JADX INFO: renamed from: androidx.compose.ui.platform.WindowInfoKt$WindowFocusObserver$2, reason: invalid class name */
    /* JADX INFO: compiled from: WindowInfo.kt */
    static final class AnonymousClass2 extends kotlin.jvm.internal.v implements h9.p<Composer, Integer, v8.k0> {
        final /* synthetic */ int $$changed;
        final /* synthetic */ h9.l<Boolean, v8.k0> $onWindowFocusChanged;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass2(h9.l<? super Boolean, v8.k0> lVar, int i10) {
            super(2);
            this.$onWindowFocusChanged = lVar;
            this.$$changed = i10;
        }

        @Override // h9.p
        /* JADX INFO: renamed from: invoke */
        public /* bridge */ /* synthetic */ v8.k0 mo4invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return v8.k0.f35197a;
        }

        public final void invoke(@Nullable Composer composer, int i10) {
            WindowInfoKt.WindowFocusObserver(this.$onWindowFocusChanged, composer, this.$$changed | 1);
        }
    }

    @Composable
    public static final void WindowFocusObserver(@NotNull h9.l<? super Boolean, v8.k0> onWindowFocusChanged, @Nullable Composer composer, int i10) {
        int i11;
        kotlin.jvm.internal.t.i(onWindowFocusChanged, "onWindowFocusChanged");
        Composer composerStartRestartGroup = composer.startRestartGroup(127829799);
        if ((i10 & 14) == 0) {
            i11 = (composerStartRestartGroup.changed(onWindowFocusChanged) ? 4 : 2) | i10;
        } else {
            i11 = i10;
        }
        if ((i11 & 11) == 2 && composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            WindowInfo windowInfo = (WindowInfo) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalWindowInfo());
            State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(onWindowFocusChanged, composerStartRestartGroup, i11 & 14);
            composerStartRestartGroup.startReplaceableGroup(511388516);
            boolean zChanged = composerStartRestartGroup.changed(windowInfo) | composerStartRestartGroup.changed(stateRememberUpdatedState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.Companion.getEmpty()) {
                objRememberedValue = new WindowInfoKt$WindowFocusObserver$1$1(windowInfo, stateRememberUpdatedState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(windowInfo, (h9.p<? super kotlinx.coroutines.o0, ? super z8.d<? super v8.k0>, ? extends Object>) objRememberedValue, composerStartRestartGroup, 0);
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup == null) {
            return;
        }
        scopeUpdateScopeEndRestartGroup.updateScope(new AnonymousClass2(onWindowFocusChanged, i10));
    }
}
