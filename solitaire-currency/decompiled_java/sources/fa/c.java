package fa;

import java.util.List;
import kotlin.collections.v;
import kotlin.jvm.internal.k;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import z9.j;

/* JADX INFO: compiled from: SerializersModule.kt */
/* JADX INFO: loaded from: classes5.dex */
public abstract class c {
    private c() {
    }

    public /* synthetic */ c(k kVar) {
        this();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ KSerializer c(c cVar, KClass kClass, List list, int i10, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getContextual");
        }
        if ((i10 & 2) != 0) {
            list = v.l();
        }
        return cVar.b(kClass, list);
    }

    public abstract void a(@NotNull e eVar);

    @Nullable
    public abstract <T> KSerializer<T> b(@NotNull KClass<T> kClass, @NotNull List<? extends KSerializer<?>> list);

    @Nullable
    public abstract <T> z9.b<? extends T> d(@NotNull KClass<? super T> kClass, @Nullable String str);

    @Nullable
    public abstract <T> j<T> e(@NotNull KClass<? super T> kClass, @NotNull T t10);
}
