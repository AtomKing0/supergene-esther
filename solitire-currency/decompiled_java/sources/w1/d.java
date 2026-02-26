package w1;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: Event.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class d<T> {
    public static <T> d<T> e(T t10) {
        return new a(null, t10, e.DEFAULT, null);
    }

    public static <T> d<T> f(T t10, @Nullable f fVar) {
        return new a(null, t10, e.DEFAULT, fVar);
    }

    @Nullable
    public abstract Integer a();

    public abstract T b();

    public abstract e c();

    @Nullable
    public abstract f d();
}
