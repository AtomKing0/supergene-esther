package s8;

import java.io.Closeable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Pool.kt */
/* JADX INFO: loaded from: classes3.dex */
public interface g<T> extends Closeable {

    /* JADX INFO: compiled from: Pool.kt */
    public static final class a {
        public static <T> void a(@NotNull g<T> gVar) {
            gVar.dispose();
        }
    }

    void C0(@NotNull T t10);

    void dispose();

    @NotNull
    T k0();
}
