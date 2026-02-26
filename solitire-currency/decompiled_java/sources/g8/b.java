package g8;

import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Attributes.kt */
/* JADX INFO: loaded from: classes.dex */
public interface b {

    /* JADX INFO: compiled from: Attributes.kt */
    public static final class a {
        @NotNull
        public static <T> T a(@NotNull b bVar, @NotNull g8.a<T> key) {
            kotlin.jvm.internal.t.i(key, "key");
            T t10 = (T) bVar.d(key);
            if (t10 != null) {
                return t10;
            }
            throw new IllegalStateException("No instance for key " + key);
        }
    }

    @NotNull
    <T> T a(@NotNull g8.a<T> aVar);

    <T> void b(@NotNull g8.a<T> aVar);

    <T> void c(@NotNull g8.a<T> aVar, @NotNull T t10);

    @Nullable
    <T> T d(@NotNull g8.a<T> aVar);

    boolean e(@NotNull g8.a<?> aVar);

    @NotNull
    List<g8.a<?>> f();

    @NotNull
    <T> T g(@NotNull g8.a<T> aVar, @NotNull h9.a<? extends T> aVar2);
}
