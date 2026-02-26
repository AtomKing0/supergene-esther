package x1;

import androidx.annotation.NonNull;
import com.google.auto.value.AutoValue;
import java.util.List;

/* JADX INFO: compiled from: BatchedLogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class j {
    @NonNull
    public static j a(@NonNull List<m> list) {
        return new d(list);
    }

    @NonNull
    public static p5.a b() {
        return new r5.d().j(b.f35570a).k(true).i();
    }

    @NonNull
    public abstract List<m> c();
}
