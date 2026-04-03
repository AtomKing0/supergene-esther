package y1;

import android.util.Base64;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import com.google.auto.value.AutoValue;
import y1.d;

/* JADX INFO: compiled from: TransportContext.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class o {

    /* JADX INFO: compiled from: TransportContext.java */
    @AutoValue.Builder
    public static abstract class a {
        public abstract o a();

        public abstract a b(String str);

        public abstract a c(@Nullable byte[] bArr);

        @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
        public abstract a d(w1.e eVar);
    }

    public static a a() {
        return new d.b().d(w1.e.DEFAULT);
    }

    public abstract String b();

    @Nullable
    public abstract byte[] c();

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public abstract w1.e d();

    public boolean e() {
        return c() != null;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    public o f(w1.e eVar) {
        return a().b(b()).d(eVar).c(c()).a();
    }

    public final String toString() {
        Object[] objArr = new Object[3];
        objArr[0] = b();
        objArr[1] = d();
        objArr[2] = c() == null ? "" : Base64.encodeToString(c(), 2);
        return String.format("TransportContext(%s, %s, %s)", objArr);
    }
}
