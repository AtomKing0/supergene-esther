package z1;

import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import z1.a;

/* JADX INFO: compiled from: BackendRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class f {

    /* JADX INFO: compiled from: BackendRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract f a();

        public abstract a b(Iterable<y1.i> iterable);

        public abstract a c(@Nullable byte[] bArr);
    }

    public static a a() {
        return new a.b();
    }

    public abstract Iterable<y1.i> b();

    @Nullable
    public abstract byte[] c();
}
