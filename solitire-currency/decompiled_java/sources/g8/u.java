package g8;

import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StringValues.kt */
/* JADX INFO: loaded from: classes.dex */
public interface u {
    @NotNull
    Set<Map.Entry<String, List<String>>> a();

    boolean b();

    @Nullable
    List<String> c(@NotNull String str);

    void clear();

    boolean contains(@NotNull String str);

    void d(@NotNull String str, @NotNull Iterable<String> iterable);

    void e(@NotNull t tVar);

    void f(@NotNull String str, @NotNull String str2);

    boolean isEmpty();

    @NotNull
    Set<String> names();
}
