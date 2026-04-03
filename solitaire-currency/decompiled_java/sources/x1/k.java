package x1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import x1.e;

/* JADX INFO: compiled from: ClientInfo.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class k {

    /* JADX INFO: compiled from: ClientInfo.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract k a();

        @NonNull
        public abstract a b(@Nullable x1.a aVar);

        @NonNull
        public abstract a c(@Nullable b bVar);
    }

    /* JADX INFO: compiled from: ClientInfo.java */
    public enum b {
        UNKNOWN(0),
        ANDROID_FIREBASE(23);


        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f35673a;

        b(int i10) {
            this.f35673a = i10;
        }
    }

    @NonNull
    public static a a() {
        return new e.b();
    }

    @Nullable
    public abstract x1.a b();

    @Nullable
    public abstract b c();
}
