package a6;

import a6.b;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: TokenResult.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class f {

    /* JADX INFO: compiled from: TokenResult.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract f a();

        @NonNull
        public abstract a b(@NonNull b bVar);

        @NonNull
        public abstract a c(@NonNull String str);

        @NonNull
        public abstract a d(long j10);
    }

    /* JADX INFO: compiled from: TokenResult.java */
    public enum b {
        OK,
        BAD_CONFIG,
        AUTH_ERROR
    }

    @NonNull
    public static a a() {
        return new b.C0006b().d(0L);
    }

    @Nullable
    public abstract b b();

    @Nullable
    public abstract String c();

    @NonNull
    public abstract long d();
}
