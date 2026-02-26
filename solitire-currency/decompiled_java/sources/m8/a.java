package m8;

import java.lang.reflect.Type;
import kotlin.jvm.internal.t;
import kotlin.reflect.KClass;
import kotlin.reflect.KType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Type.kt */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final KClass<?> f31472a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final Type f31473b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private final KType f31474c;

    public a(@NotNull KClass<?> type, @NotNull Type reifiedType, @Nullable KType kType) {
        t.i(type, "type");
        t.i(reifiedType, "reifiedType");
        this.f31472a = type;
        this.f31473b = reifiedType;
        this.f31474c = kType;
    }

    @NotNull
    public final KClass<?> a() {
        return this.f31472a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return t.d(this.f31472a, aVar.f31472a) && t.d(this.f31473b, aVar.f31473b) && t.d(this.f31474c, aVar.f31474c);
    }

    public int hashCode() {
        int iHashCode = ((this.f31472a.hashCode() * 31) + this.f31473b.hashCode()) * 31;
        KType kType = this.f31474c;
        return iHashCode + (kType == null ? 0 : kType.hashCode());
    }

    @NotNull
    public String toString() {
        return "TypeInfo(type=" + this.f31472a + ", reifiedType=" + this.f31473b + ", kotlinType=" + this.f31474c + ')';
    }
}
