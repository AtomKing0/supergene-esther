package z9;

import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SerializationExceptions.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class c extends i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final List<String> f37617a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public c(@NotNull List<String> missingFields, @Nullable String str, @Nullable Throwable th) {
        super(str, th);
        t.i(missingFields, "missingFields");
        this.f37617a = missingFields;
    }

    @NotNull
    public final List<String> a() {
        return this.f37617a;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public c(@NotNull List<String> missingFields, @NotNull String serialName) {
        String str;
        t.i(missingFields, "missingFields");
        t.i(serialName, "serialName");
        if (missingFields.size() == 1) {
            str = "Field '" + missingFields.get(0) + "' is required for type with serial name '" + serialName + "', but it was missing";
        } else {
            str = "Fields " + missingFields + " are required for type with serial name '" + serialName + "', but they were missing";
        }
        this(missingFields, str, null);
    }
}
