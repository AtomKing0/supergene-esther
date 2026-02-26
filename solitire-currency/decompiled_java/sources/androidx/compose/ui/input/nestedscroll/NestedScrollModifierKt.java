package androidx.compose.ui.input.nestedscroll;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import h9.q;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlinx.coroutines.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z8.h;

/* JADX INFO: compiled from: NestedScrollModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public final class NestedScrollModifierKt {

    /* JADX INFO: renamed from: androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt$nestedScroll$2, reason: invalid class name */
    /* JADX INFO: compiled from: NestedScrollModifier.kt */
    static final class AnonymousClass2 extends v implements q<Modifier, Composer, Integer, Modifier> {
        final /* synthetic */ NestedScrollConnection $connection;
        final /* synthetic */ NestedScrollDispatcher $dispatcher;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(NestedScrollDispatcher nestedScrollDispatcher, NestedScrollConnection nestedScrollConnection) {
            super(3);
            this.$dispatcher = nestedScrollDispatcher;
            this.$connection = nestedScrollConnection;
        }

        @Override // h9.q
        public /* bridge */ /* synthetic */ Modifier invoke(Modifier modifier, Composer composer, Integer num) {
            return invoke(modifier, composer, num.intValue());
        }

        @Composable
        @NotNull
        public final Modifier invoke(@NotNull Modifier composed, @Nullable Composer composer, int i10) {
            t.i(composed, "$this$composed");
            composer.startReplaceableGroup(410346167);
            composer.startReplaceableGroup(773894976);
            composer.startReplaceableGroup(-492369756);
            Object objRememberedValue = composer.rememberedValue();
            Composer.Companion companion = Composer.Companion;
            if (objRememberedValue == companion.getEmpty()) {
                Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(h.f37608a, composer));
                composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
                objRememberedValue = compositionScopedCoroutineScopeCanceller;
            }
            composer.endReplaceableGroup();
            o0 coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
            composer.endReplaceableGroup();
            NestedScrollDispatcher nestedScrollDispatcher = this.$dispatcher;
            composer.startReplaceableGroup(100475938);
            if (nestedScrollDispatcher == null) {
                composer.startReplaceableGroup(-492369756);
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    objRememberedValue2 = new NestedScrollDispatcher();
                    composer.updateRememberedValue(objRememberedValue2);
                }
                composer.endReplaceableGroup();
                nestedScrollDispatcher = (NestedScrollDispatcher) objRememberedValue2;
            }
            composer.endReplaceableGroup();
            NestedScrollConnection nestedScrollConnection = this.$connection;
            composer.startReplaceableGroup(1618982084);
            boolean zChanged = composer.changed(nestedScrollConnection) | composer.changed(nestedScrollDispatcher) | composer.changed(coroutineScope);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                nestedScrollDispatcher.setOriginNestedScrollScope$ui_release(coroutineScope);
                objRememberedValue3 = new NestedScrollModifierLocal(nestedScrollDispatcher, nestedScrollConnection);
                composer.updateRememberedValue(objRememberedValue3);
            }
            composer.endReplaceableGroup();
            NestedScrollModifierLocal nestedScrollModifierLocal = (NestedScrollModifierLocal) objRememberedValue3;
            composer.endReplaceableGroup();
            return nestedScrollModifierLocal;
        }
    }

    @NotNull
    public static final Modifier nestedScroll(@NotNull Modifier modifier, @NotNull NestedScrollConnection connection, @Nullable NestedScrollDispatcher nestedScrollDispatcher) {
        t.i(modifier, "<this>");
        t.i(connection, "connection");
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new NestedScrollModifierKt$nestedScroll$$inlined$debugInspectorInfo$1(connection, nestedScrollDispatcher) : InspectableValueKt.getNoInspectorInfo(), new AnonymousClass2(nestedScrollDispatcher, connection));
    }

    public static /* synthetic */ Modifier nestedScroll$default(Modifier modifier, NestedScrollConnection nestedScrollConnection, NestedScrollDispatcher nestedScrollDispatcher, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            nestedScrollDispatcher = null;
        }
        return nestedScroll(modifier, nestedScrollConnection, nestedScrollDispatcher);
    }
}
