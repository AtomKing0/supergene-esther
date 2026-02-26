package a6;

import a6.a;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.google.auto.value.AutoValue;

/* JADX INFO: compiled from: InstallationResponse.java */
/* JADX INFO: loaded from: classes3.dex */
@AutoValue
public abstract class d {

    /* JADX INFO: compiled from: InstallationResponse.java */
    @AutoValue.Builder
    public static abstract class a {
        @NonNull
        public abstract d a();

        @NonNull
        public abstract a b(@NonNull f fVar);

        @NonNull
        public abstract a c(@NonNull String str);

        @NonNull
        public abstract a d(@NonNull String str);

        @NonNull
        public abstract a e(@NonNull b bVar);

        @NonNull
        public abstract a f(@NonNull String str);
    }

    /* JADX INFO: compiled from: InstallationResponse.java */
    public enum b {
        OK,
        BAD_CONFIG
    }

    @NonNull
    public static a a() {
        return new a.b();
    }

    @Nullable
    public abstract f b();

    @Nullable
    public abstract String c();

    @Nullable
    public abstract String d();

    @Nullable
    public abstract b e();

    @Nullable
    public abstract String f();
}
