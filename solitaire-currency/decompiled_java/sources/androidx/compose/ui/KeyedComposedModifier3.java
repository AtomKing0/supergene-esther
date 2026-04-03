package androidx.compose.ui;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.platform.InspectorInfo;
import h9.l;
import h9.q;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: ComposedModifier.kt */
/* JADX INFO: loaded from: classes.dex */
@Stable
final class KeyedComposedModifier3 extends ComposedModifier {

    @NotNull
    private final String fqName;

    @Nullable
    private final Object key1;

    @Nullable
    private final Object key2;

    @Nullable
    private final Object key3;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public KeyedComposedModifier3(@NotNull String fqName, @Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull l<? super InspectorInfo, k0> inspectorInfo, @NotNull q<? super Modifier, ? super Composer, ? super Integer, ? extends Modifier> factory) {
        super(inspectorInfo, factory);
        t.i(fqName, "fqName");
        t.i(inspectorInfo, "inspectorInfo");
        t.i(factory, "factory");
        this.fqName = fqName;
        this.key1 = obj;
        this.key2 = obj2;
        this.key3 = obj3;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof KeyedComposedModifier3) {
            KeyedComposedModifier3 keyedComposedModifier3 = (KeyedComposedModifier3) obj;
            if (t.d(this.fqName, keyedComposedModifier3.fqName) && t.d(this.key1, keyedComposedModifier3.key1) && t.d(this.key2, keyedComposedModifier3.key2) && t.d(this.key3, keyedComposedModifier3.key3)) {
                return true;
            }
        }
        return false;
    }

    @NotNull
    public final String getFqName() {
        return this.fqName;
    }

    @Nullable
    public final Object getKey1() {
        return this.key1;
    }

    @Nullable
    public final Object getKey2() {
        return this.key2;
    }

    @Nullable
    public final Object getKey3() {
        return this.key3;
    }

    public int hashCode() {
        int iHashCode = this.fqName.hashCode() * 31;
        Object obj = this.key1;
        int iHashCode2 = (iHashCode + (obj != null ? obj.hashCode() : 0)) * 31;
        Object obj2 = this.key2;
        int iHashCode3 = (iHashCode2 + (obj2 != null ? obj2.hashCode() : 0)) * 31;
        Object obj3 = this.key3;
        return iHashCode3 + (obj3 != null ? obj3.hashCode() : 0);
    }
}
