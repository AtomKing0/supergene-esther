package kotlinx.serialization.json;

import ea.v0;
import kotlin.jvm.internal.o0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: JsonElement.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class n extends JsonPrimitive {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final boolean f30076a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final String f30077b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(@NotNull Object body, boolean z10) {
        super(null);
        kotlin.jvm.internal.t.i(body, "body");
        this.f30076a = z10;
        this.f30077b = body.toString();
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    @NotNull
    public String a() {
        return this.f30077b;
    }

    public boolean b() {
        return this.f30076a;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !kotlin.jvm.internal.t.d(o0.b(n.class), o0.b(obj.getClass()))) {
            return false;
        }
        n nVar = (n) obj;
        return b() == nVar.b() && kotlin.jvm.internal.t.d(a(), nVar.a());
    }

    public int hashCode() {
        return (androidx.compose.foundation.e.a(b()) * 31) + a().hashCode();
    }

    @Override // kotlinx.serialization.json.JsonPrimitive
    @NotNull
    public String toString() {
        if (!b()) {
            return a();
        }
        StringBuilder sb = new StringBuilder();
        v0.c(sb, a());
        String string = sb.toString();
        kotlin.jvm.internal.t.h(string, "StringBuilder().apply(builderAction).toString()");
        return string;
    }
}
