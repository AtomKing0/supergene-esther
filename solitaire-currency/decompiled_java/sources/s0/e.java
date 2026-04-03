package s0;

import androidx.annotation.NonNull;
import java.io.IOException;

/* JADX INFO: compiled from: DataRewinder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e<T> {

    /* JADX INFO: compiled from: DataRewinder.java */
    public interface a<T> {
        @NonNull
        Class<T> a();

        @NonNull
        e<T> b(@NonNull T t10);
    }

    @NonNull
    T a() throws IOException;

    void b();
}
