package androidx.compose.ui.input.focus;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.a;
import androidx.compose.ui.b;
import androidx.compose.ui.input.focus.FocusAwareEvent;
import androidx.compose.ui.modifier.ModifierLocalConsumer;
import androidx.compose.ui.modifier.ModifierLocalProvider;
import androidx.compose.ui.modifier.ModifierLocalReadScope;
import androidx.compose.ui.modifier.ProvidableModifierLocal;
import h9.l;
import h9.p;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: FocusAwareInputModifier.kt */
/* JADX INFO: loaded from: classes.dex */
public class FocusAwareInputModifier<T extends FocusAwareEvent> implements ModifierLocalConsumer, ModifierLocalProvider<FocusAwareInputModifier<T>> {

    @Nullable
    private FocusAwareInputModifier<T> focusAwareEventParent;

    @NotNull
    private final ProvidableModifierLocal<FocusAwareInputModifier<T>> key;

    @Nullable
    private final l<FocusAwareEvent, Boolean> onEvent;

    @Nullable
    private final l<FocusAwareEvent, Boolean> onPreEvent;

    /* JADX WARN: Multi-variable type inference failed */
    public FocusAwareInputModifier(@Nullable l<? super FocusAwareEvent, Boolean> lVar, @Nullable l<? super FocusAwareEvent, Boolean> lVar2, @NotNull ProvidableModifierLocal<FocusAwareInputModifier<T>> key) {
        t.i(key, "key");
        this.onEvent = lVar;
        this.onPreEvent = lVar2;
        this.key = key;
    }

    private final boolean propagateEvent(T t10) {
        l<FocusAwareEvent, Boolean> lVar = this.onEvent;
        if (lVar != null && lVar.invoke(t10).booleanValue()) {
            return true;
        }
        FocusAwareInputModifier<T> focusAwareInputModifier = this.focusAwareEventParent;
        if (focusAwareInputModifier != null) {
            return focusAwareInputModifier.propagateEvent(t10);
        }
        return false;
    }

    private final boolean propagatePreEvent(T t10) {
        FocusAwareInputModifier<T> focusAwareInputModifier = this.focusAwareEventParent;
        if (focusAwareInputModifier != null && focusAwareInputModifier.propagatePreEvent(t10)) {
            return true;
        }
        l<FocusAwareEvent, Boolean> lVar = this.onPreEvent;
        if (lVar != null) {
            return lVar.invoke(t10).booleanValue();
        }
        return false;
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean all(l lVar) {
        return b.a(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ boolean any(l lVar) {
        return b.b(this, lVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldIn(Object obj, p pVar) {
        return b.c(this, obj, pVar);
    }

    @Override // androidx.compose.ui.Modifier.Element, androidx.compose.ui.Modifier
    public /* synthetic */ Object foldOut(Object obj, p pVar) {
        return b.d(this, obj, pVar);
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public ProvidableModifierLocal<FocusAwareInputModifier<T>> getKey() {
        return this.key;
    }

    @Nullable
    public final l<FocusAwareEvent, Boolean> getOnEvent() {
        return this.onEvent;
    }

    @Nullable
    public final l<FocusAwareEvent, Boolean> getOnPreEvent() {
        return this.onPreEvent;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalProvider
    @NotNull
    public FocusAwareInputModifier<T> getValue() {
        return this;
    }

    @Override // androidx.compose.ui.modifier.ModifierLocalConsumer
    public void onModifierLocalsUpdated(@NotNull ModifierLocalReadScope scope) {
        t.i(scope, "scope");
        this.focusAwareEventParent = (FocusAwareInputModifier) scope.getCurrent(getKey());
    }

    public final boolean propagateFocusAwareEvent(@NotNull T event) {
        t.i(event, "event");
        return propagatePreEvent(event) || propagateEvent(event);
    }

    @Override // androidx.compose.ui.Modifier
    public /* synthetic */ Modifier then(Modifier modifier) {
        return a.a(this, modifier);
    }
}
