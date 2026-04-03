package g8;

import com.ironsource.mediationsdk.logger.IronSourceError;
import com.ironsource.nb;
import i9.e;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: CaseInsensitiveMap.kt */
/* JADX INFO: loaded from: classes.dex */
final class o<Key, Value> implements Map.Entry<Key, Value>, e.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Key f25903a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Value f25904b;

    public o(Key key, Value value) {
        this.f25903a = key;
        this.f25904b = value;
    }

    public void a(Value value) {
        this.f25904b = value;
    }

    @Override // java.util.Map.Entry
    public boolean equals(@Nullable Object obj) {
        if (obj == null || !(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        return kotlin.jvm.internal.t.d(entry.getKey(), getKey()) && kotlin.jvm.internal.t.d(entry.getValue(), getValue());
    }

    @Override // java.util.Map.Entry
    public Key getKey() {
        return this.f25903a;
    }

    @Override // java.util.Map.Entry
    public Value getValue() {
        return this.f25904b;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        Key key = getKey();
        kotlin.jvm.internal.t.f(key);
        int iHashCode = key.hashCode() + IronSourceError.ERROR_NON_EXISTENT_INSTANCE;
        Value value = getValue();
        kotlin.jvm.internal.t.f(value);
        return iHashCode + value.hashCode();
    }

    @Override // java.util.Map.Entry
    public Value setValue(Value value) {
        a(value);
        return getValue();
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append(nb.T);
        sb.append(getValue());
        return sb.toString();
    }
}
