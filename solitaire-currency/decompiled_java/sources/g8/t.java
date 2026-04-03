package g8;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.d0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: StringValues.kt */
/* JADX INFO: loaded from: classes.dex */
public interface t {

    /* JADX INFO: compiled from: StringValues.kt */
    public static final class a {
        public static void a(@NotNull t tVar, @NotNull h9.p<? super String, ? super List<String>, k0> body) {
            kotlin.jvm.internal.t.i(body, "body");
            Iterator<T> it = tVar.a().iterator();
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                body.mo4invoke((String) entry.getKey(), (List) entry.getValue());
            }
        }

        @Nullable
        public static String b(@NotNull t tVar, @NotNull String name) {
            kotlin.jvm.internal.t.i(name, "name");
            List<String> listC = tVar.c(name);
            if (listC != null) {
                return (String) d0.k0(listC);
            }
            return null;
        }
    }

    @NotNull
    Set<Map.Entry<String, List<String>>> a();

    boolean b();

    @Nullable
    List<String> c(@NotNull String str);

    void d(@NotNull h9.p<? super String, ? super List<String>, k0> pVar);

    @Nullable
    String get(@NotNull String str);

    boolean isEmpty();

    @NotNull
    Set<String> names();
}
