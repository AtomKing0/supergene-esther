package n9;

import java.lang.Comparable;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Ranges.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface e<T extends Comparable<? super T>> extends f<T> {
    boolean a(@NotNull T t10, @NotNull T t11);

    boolean contains(@NotNull T t10);

    @Override // n9.f
    boolean isEmpty();
}
