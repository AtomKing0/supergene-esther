package x1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import x1.f;

/* JADX INFO: compiled from: LogEvent.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class l {

    /* JADX INFO: compiled from: LogEvent.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract l a();

        @NonNull
        public abstract a b(@Nullable Integer num);

        @NonNull
        public abstract a c(long j10);

        @NonNull
        public abstract a d(long j10);

        @NonNull
        public abstract a e(@Nullable o oVar);

        @NonNull
        abstract a f(@Nullable byte[] bArr);

        @NonNull
        abstract a g(@Nullable String str);

        @NonNull
        public abstract a h(long j10);
    }

    private static a a() {
        return new f.b();
    }

    @NonNull
    public static a i(@NonNull String str) {
        return a().g(str);
    }

    @NonNull
    public static a j(@NonNull byte[] bArr) {
        return a().f(bArr);
    }

    @Nullable
    public abstract Integer b();

    public abstract long c();

    public abstract long d();

    @Nullable
    public abstract o e();

    @Nullable
    public abstract byte[] f();

    @Nullable
    public abstract String g();

    public abstract long h();
}
