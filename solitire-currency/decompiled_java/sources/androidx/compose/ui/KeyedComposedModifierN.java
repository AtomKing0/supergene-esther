package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import h9.q;
import java.util.Arrays;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class KeyedComposedModifierN extends ComposedModifier {

    @NotNull
    private final String fqName;

    @NotNull
    private final Object[] keys;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedComposedModifierN(@NotNull String fqName, @NotNull Object[] keys, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        super(inspectorInfo, factory);
        t.i(fqName, "fqName");
        t.i(keys, "keys");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        this.fqName = fqName;
        this.keys = keys;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KeyedComposedModifierN) {
            KeyedComposedModifierN keyedComposedModifierN = (KeyedComposedModifierN) obj;
            if (t.d(this.fqName, keyedComposedModifierN.fqName) && Arrays.equals(this.keys, keyedComposedModifierN.keys)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String getFqName() {
        return this.fqName;
    }

    @NotNull
    public final Object[] getKeys() {
        return this.keys;
    }

    public int hashCode() {
        return (this.fqName.hashCode() * 31) + Arrays.hashCode(this.keys);
    }
}
