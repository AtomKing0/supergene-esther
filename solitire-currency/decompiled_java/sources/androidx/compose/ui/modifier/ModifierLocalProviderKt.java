package androidx.compose.ui.modifier;

import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.ExperimentalComposeUiApi;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import v8.k0;

/* JADX INFO: compiled from: ModifierLocalProvider.kt */
/* JADX INFO: loaded from: classes.dex */
public final class ModifierLocalProviderKt {

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: androidx.compose.ui.modifier.ModifierLocalProviderKt$modifierLocalProvider$1, reason: invalid class name */
    /* JADX INFO: compiled from: ModifierLocalProvider.kt */
    public static final class AnonymousClass1<T> extends InspectorValueInfo implements ModifierLocalProvider<T> {

        @NotNull
        private final ProvidableModifierLocal<T> key;

        @NotNull
        private final State value$delegate;

        AnonymousClass1(ProvidableModifierLocal<T> providableModifierLocal, h9.a<? extends T> aVar, l<? super InspectorInfo, k0> lVar) {
            super(lVar);
            this.key = providableModifierLocal;
            this.value$delegate = SnapshotStateKt.derivedStateOf(aVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean all(l lVar) {
            return androidx.compose.ui.b.a(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ boolean any(l lVar) {
            return androidx.compose.ui.b.b(this, lVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldIn(Object obj, p pVar) {
            return androidx.compose.ui.b.c(this, obj, pVar);
        }

        @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
        public /* synthetic */ Object foldOut(Object obj, p pVar) {
            return androidx.compose.ui.b.d(this, obj, pVar);
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        @NotNull
        public ProvidableModifierLocal<T> getKey() {
            return this.key;
        }

        @Override // androidx.compose.ui.modifier.ModifierLocalProvider
        /* JADX INFO: renamed from: getValue */
        public T getValue2() {
            return (T) this.value$delegate.getValue();
        }

        @Override // androidx.compose.ui.Modifier
        public /* synthetic */ Modifier then(Modifier modifier) {
            return androidx.compose.ui.a.a(this, modifier);
        }
    }

    @ExperimentalComposeUiApi
    @NotNull
    public static final <T> Modifier modifierLocalProvider(@NotNull Modifier modifier, @NotNull ProvidableModifierLocal<T> key, @NotNull h9.a<? extends T> value) {
        t.i(modifier, "<this>");
        t.i(key, "key");
        t.i(value, "value");
        return modifier.then(new AnonymousClass1(key, value, InspectableValueKt.isDebugInspectorInfoEnabled() ? new ModifierLocalProviderKt$modifierLocalProvider$$inlined$debugInspectorInfo$1(key, value) : InspectableValueKt.getNoInspectorInfo()));
    }
}
