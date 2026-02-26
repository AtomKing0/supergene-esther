package s0;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: DataFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public interface d<T> {

    /* JADX INFO: compiled from: DataFetcher.java */
    public interface a<T> {
        void c(@NonNull Exception exc);

        void f(@Nullable T t10);
    }

    @NonNull
    Class<T> a();

    void b();

    void cancel();

    @NonNull
    r0.a d();

    void e(@NonNull com.bumptech.glide.f fVar, @NonNull a<? super T> aVar);
}
