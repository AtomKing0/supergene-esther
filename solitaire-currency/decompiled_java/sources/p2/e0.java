package p2;

import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.Arrays;
import k2.o1;

/* JADX INFO: compiled from: TrackOutput.java */
/* JADX INFO: loaded from: classes2.dex */
public interface e0 {

    /* JADX INFO: compiled from: TrackOutput.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f32464a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final byte[] f32465b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f32466c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f32467d;

        public a(int i10, byte[] bArr, int i11, int i12) {
            this.f32464a = i10;
            this.f32465b = bArr;
            this.f32466c = i11;
            this.f32467d = i12;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            return this.f32464a == aVar.f32464a && this.f32466c == aVar.f32466c && this.f32467d == aVar.f32467d && Arrays.equals(this.f32465b, aVar.f32465b);
        }

        public int hashCode() {
            return (((((this.f32464a * 31) + Arrays.hashCode(this.f32465b)) * 31) + this.f32466c) * 31) + this.f32467d;
        }
    }

    void a(long j10, int i10, int i11, int i12, @Nullable a aVar);

    void b(a4.c0 c0Var, int i10, int i11);

    int c(z3.h hVar, int i10, boolean z10) throws IOException;

    int d(z3.h hVar, int i10, boolean z10, int i11) throws IOException;

    void e(a4.c0 c0Var, int i10);

    void f(o1 o1Var);
}
