package da;

import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: PluginHelperInterfaces.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface d0<T> extends KSerializer<T> {

    /* JADX INFO: compiled from: PluginHelperInterfaces.kt */
    public static final class a {
        @NotNull
        public static <T> KSerializer<?>[] a(@NotNull d0<T> d0Var) {
            return k1.f24593a;
        }
    }

    @NotNull
    KSerializer<?>[] childSerializers();

    @NotNull
    KSerializer<?>[] typeParametersSerializers();
}
