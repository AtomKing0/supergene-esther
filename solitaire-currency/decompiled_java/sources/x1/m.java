package x1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;
import java.util.List;
import x1.g;

/* JADX INFO: compiled from: LogRequest.java */
/* JADX INFO: loaded from: classes2.dex */
@AutoValue
public abstract class m {

    /* JADX INFO: compiled from: LogRequest.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract m a();

        @NonNull
        public abstract a b(@Nullable k kVar);

        @NonNull
        public abstract a c(@Nullable List<l> list);

        @NonNull
        abstract a d(@Nullable Integer num);

        @NonNull
        abstract a e(@Nullable String str);

        @NonNull
        public abstract a f(@Nullable p pVar);

        @NonNull
        public abstract a g(long j10);

        @NonNull
        public abstract a h(long j10);

        @NonNull
        public a i(int i10) {
            return d(Integer.valueOf(i10));
        }

        @NonNull
        public a j(@NonNull String str) {
            return e(str);
        }
    }

    @NonNull
    public static a a() {
        return new g.b();
    }

    @Nullable
    public abstract k b();

    @Nullable
    public abstract List<l> c();

    @Nullable
    public abstract Integer d();

    @Nullable
    public abstract String e();

    @Nullable
    public abstract p f();

    public abstract long g();

    public abstract long h();
}
