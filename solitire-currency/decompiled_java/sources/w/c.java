package w;

import androidx.annotation.Px;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Dimension.kt */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c {

    /* JADX INFO: compiled from: Dimension.kt */
    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f35260a;

        public a(@Px int i10) {
            super(null);
            this.f35260a = i10;
            if (!(i10 > 0)) {
                throw new IllegalArgumentException("px must be > 0.".toString());
            }
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f35260a == ((a) obj).f35260a;
        }

        public int hashCode() {
            return this.f35260a;
        }

        @NotNull
        public String toString() {
            return String.valueOf(this.f35260a);
        }
    }

    /* JADX INFO: compiled from: Dimension.kt */
    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        public static final b f35261a = new b();

        private b() {
            super(null);
        }

        @NotNull
        public String toString() {
            return "Dimension.Undefined";
        }
    }

    private c() {
    }

    public /* synthetic */ c(kotlin.jvm.internal.k kVar) {
        this();
    }
}
