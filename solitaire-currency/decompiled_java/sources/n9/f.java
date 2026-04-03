package n9;

import java.lang.Comparable;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Range.kt */
/* JADX INFO: loaded from: classes5.dex */
public interface f<T extends Comparable<? super T>> {

    /* JADX INFO: compiled from: Range.kt */
    public static final class a {
        public static <T extends Comparable<? super T>> boolean a(@NotNull f<T> fVar, @NotNull T value) {
            t.i(value, "value");
            return value.compareTo(fVar.getStart()) >= 0 && value.compareTo(fVar.getEndInclusive()) <= 0;
        }

        public static <T extends Comparable<? super T>> boolean b(@NotNull f<T> fVar) {
            return fVar.getStart().compareTo(fVar.getEndInclusive()) > 0;
        }
    }

    @NotNull
    T getEndInclusive();

    @NotNull
    T getStart();

    boolean isEmpty();
}
