package p2;

import androidx.annotation.Nullable;
import com.ironsource.v8;

/* JADX INFO: compiled from: SeekMap.java */
/* JADX INFO: loaded from: classes2.dex */
public interface b0 {

    /* JADX INFO: compiled from: SeekMap.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final c0 f32444a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final c0 f32445b;

        public a(c0 c0Var) {
            this(c0Var, c0Var);
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f32444a.equals(aVar.f32444a) && this.f32445b.equals(aVar.f32445b);
        }

        public int hashCode() {
            return (this.f32444a.hashCode() * 31) + this.f32445b.hashCode();
        }

        public String toString() {
            String str;
            StringBuilder sb = new StringBuilder();
            sb.append(v8.i.f15837d);
            sb.append(this.f32444a);
            if (this.f32444a.equals(this.f32445b)) {
                str = "";
            } else {
                str = ", " + this.f32445b;
            }
            sb.append(str);
            sb.append(v8.i.f15839e);
            return sb.toString();
        }

        public a(c0 c0Var, c0 c0Var2) {
            this.f32444a = (c0) a4.a.e(c0Var);
            this.f32445b = (c0) a4.a.e(c0Var2);
        }
    }

    /* JADX INFO: compiled from: SeekMap.java */
    public static class b implements b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final long f32446a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a f32447b;

        public b(long j10) {
            this(j10, 0L);
        }

        @Override // p2.b0
        public long getDurationUs() {
            return this.f32446a;
        }

        @Override // p2.b0
        public a getSeekPoints(long j10) {
            return this.f32447b;
        }

        @Override // p2.b0
        public boolean isSeekable() {
            return false;
        }

        public b(long j10, long j11) {
            this.f32446a = j10;
            this.f32447b = new a(j11 == 0 ? c0.f32448c : new c0(0L, j11));
        }
    }

    long getDurationUs();

    a getSeekPoints(long j10);

    boolean isSeekable();
}
