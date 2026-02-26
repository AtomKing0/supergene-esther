package androidx.compose.ui.semantics;

import androidx.compose.foundation.e;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.platform.JvmActuals_jvmKt;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.g;

/* JADX INFO: compiled from: SemanticsConfiguration.kt */
/* JADX INFO: loaded from: classes.dex */
@StabilityInferred(parameters = 0)
public final class SemanticsConfiguration implements SemanticsPropertyReceiver, Iterable<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>>, i9.a {
    public static final int $stable = 8;
    private boolean isClearingSemantics;
    private boolean isMergingSemanticsOfDescendants;

    @NotNull
    private final Map<SemanticsPropertyKey<?>, Object> props = new LinkedHashMap();

    public final void collapsePeer$ui_release(@NotNull SemanticsConfiguration peer) {
        t.i(peer, "peer");
        if (peer.isMergingSemanticsOfDescendants) {
            this.isMergingSemanticsOfDescendants = true;
        }
        if (peer.isClearingSemantics) {
            this.isClearingSemantics = true;
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : peer.props.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            if (!this.props.containsKey(key)) {
                this.props.put(key, value);
            } else if (value instanceof AccessibilityAction) {
                Object obj = this.props.get(key);
                if (obj == null) {
                    throw new NullPointerException("null cannot be cast to non-null type androidx.compose.ui.semantics.AccessibilityAction<*>");
                }
                AccessibilityAction accessibilityAction = (AccessibilityAction) obj;
                Map<SemanticsPropertyKey<?>, Object> map = this.props;
                String label = accessibilityAction.getLabel();
                if (label == null) {
                    label = ((AccessibilityAction) value).getLabel();
                }
                g action = accessibilityAction.getAction();
                if (action == null) {
                    action = ((AccessibilityAction) value).getAction();
                }
                map.put(key, new AccessibilityAction(label, action));
            } else {
                continue;
            }
        }
    }

    public final <T> boolean contains(@NotNull SemanticsPropertyKey<T> key) {
        t.i(key, "key");
        return this.props.containsKey(key);
    }

    @NotNull
    public final SemanticsConfiguration copy() {
        SemanticsConfiguration semanticsConfiguration = new SemanticsConfiguration();
        semanticsConfiguration.isMergingSemanticsOfDescendants = this.isMergingSemanticsOfDescendants;
        semanticsConfiguration.isClearingSemantics = this.isClearingSemantics;
        semanticsConfiguration.props.putAll(this.props);
        return semanticsConfiguration;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SemanticsConfiguration)) {
            return false;
        }
        SemanticsConfiguration semanticsConfiguration = (SemanticsConfiguration) obj;
        return t.d(this.props, semanticsConfiguration.props) && this.isMergingSemanticsOfDescendants == semanticsConfiguration.isMergingSemanticsOfDescendants && this.isClearingSemantics == semanticsConfiguration.isClearingSemantics;
    }

    public final <T> T get(@NotNull SemanticsPropertyKey<T> key) {
        t.i(key, "key");
        T t10 = (T) this.props.get(key);
        if (t10 != null) {
            return t10;
        }
        throw new IllegalStateException("Key not present: " + key + " - consider getOrElse or getOrNull");
    }

    public final <T> T getOrElse(@NotNull SemanticsPropertyKey<T> key, @NotNull h9.a<? extends T> defaultValue) {
        t.i(key, "key");
        t.i(defaultValue, "defaultValue");
        T t10 = (T) this.props.get(key);
        return t10 == null ? defaultValue.invoke() : t10;
    }

    @Nullable
    public final <T> T getOrElseNullable(@NotNull SemanticsPropertyKey<T> key, @NotNull h9.a<? extends T> defaultValue) {
        t.i(key, "key");
        t.i(defaultValue, "defaultValue");
        T t10 = (T) this.props.get(key);
        return t10 == null ? defaultValue.invoke() : t10;
    }

    public int hashCode() {
        return (((this.props.hashCode() * 31) + e.a(this.isMergingSemanticsOfDescendants)) * 31) + e.a(this.isClearingSemantics);
    }

    public final boolean isClearingSemantics() {
        return this.isClearingSemantics;
    }

    public final boolean isMergingSemanticsOfDescendants() {
        return this.isMergingSemanticsOfDescendants;
    }

    @Override // java.lang.Iterable
    @NotNull
    public Iterator<Map.Entry<? extends SemanticsPropertyKey<?>, ? extends Object>> iterator() {
        return this.props.entrySet().iterator();
    }

    public final void mergeChild$ui_release(@NotNull SemanticsConfiguration child) {
        t.i(child, "child");
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : child.props.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object objMerge = key.merge(this.props.get(key), entry.getValue());
            if (objMerge != null) {
                this.props.put(key, objMerge);
            }
        }
    }

    @Override // androidx.compose.ui.semantics.SemanticsPropertyReceiver
    public <T> void set(@NotNull SemanticsPropertyKey<T> key, T t10) {
        t.i(key, "key");
        this.props.put(key, t10);
    }

    public final void setClearingSemantics(boolean z10) {
        this.isClearingSemantics = z10;
    }

    public final void setMergingSemanticsOfDescendants(boolean z10) {
        this.isMergingSemanticsOfDescendants = z10;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String str = "";
        if (this.isMergingSemanticsOfDescendants) {
            sb.append("");
            sb.append("mergeDescendants=true");
            str = ", ";
        }
        if (this.isClearingSemantics) {
            sb.append(str);
            sb.append("isClearingSemantics=true");
            str = ", ";
        }
        for (Map.Entry<SemanticsPropertyKey<?>, Object> entry : this.props.entrySet()) {
            SemanticsPropertyKey<?> key = entry.getKey();
            Object value = entry.getValue();
            sb.append(str);
            sb.append(key.getName());
            sb.append(" : ");
            sb.append(value);
            str = ", ";
        }
        return JvmActuals_jvmKt.simpleIdentityToString(this, null) + "{ " + ((Object) sb) + " }";
    }
}
