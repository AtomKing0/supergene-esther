package kotlinx.serialization.descriptors;

import ba.i;
import java.lang.annotation.Annotation;
import java.util.List;
import kotlin.collections.v;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: SerialDescriptor.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface SerialDescriptor {

    /* JADX INFO: compiled from: SerialDescriptor.kt */
    public static final class a {
        @NotNull
        public static List<Annotation> a(@NotNull SerialDescriptor serialDescriptor) {
            return v.l();
        }

        public static boolean b(@NotNull SerialDescriptor serialDescriptor) {
            return false;
        }

        public static boolean c(@NotNull SerialDescriptor serialDescriptor) {
            return false;
        }
    }

    boolean b();

    int c(@NotNull String str);

    int d();

    @NotNull
    String e(int i10);

    @NotNull
    List<Annotation> f(int i10);

    @NotNull
    SerialDescriptor g(int i10);

    @NotNull
    List<Annotation> getAnnotations();

    @NotNull
    i getKind();

    @NotNull
    String h();

    boolean i(int i10);

    boolean isInline();
}
