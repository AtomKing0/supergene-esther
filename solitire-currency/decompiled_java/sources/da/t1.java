package da;

import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Platform.common.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface t1<T> {
    @Nullable
    KSerializer<T> a(@NotNull KClass<Object> kClass);
}
