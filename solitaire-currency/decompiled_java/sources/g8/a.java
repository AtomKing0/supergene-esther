package g8;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final String f25886a;

    public a(@NotNull String name) {
        kotlin.jvm.internal.t.i(name, "name");
        this.f25886a = name;
        if (name.length() == 0) {
            throw new IllegalStateException("Name can't be blank");
        }
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && a.class == obj.getClass() && kotlin.jvm.internal.t.d(this.f25886a, ((a) obj).f25886a);
    }

    public int hashCode() {
        return this.f25886a.hashCode();
    }

    @NotNull
    public String toString() {
        return "AttributeKey: " + this.f25886a;
    }
}
