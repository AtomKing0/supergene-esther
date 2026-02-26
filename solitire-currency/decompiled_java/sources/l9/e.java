package l9;

import java.io.Serializable;
import kotlin.jvm.internal.k;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: XorWowRandom.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class e extends c implements Serializable {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @NotNull
    private static final a f30974i = new a(null);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f30975c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f30976d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f30977e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f30978f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f30979g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f30980h;

    /* JADX INFO: compiled from: XorWowRandom.kt */
    private static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public e(int i10, int i11, int i12, int i13, int i14, int i15) {
        this.f30975c = i10;
        this.f30976d = i11;
        this.f30977e = i12;
        this.f30978f = i13;
        this.f30979g = i14;
        this.f30980h = i15;
        int i16 = i10 | i11 | i12 | i13 | i14;
        if (!(i16 != 0)) {
            throw new IllegalArgumentException("Initial state must have at least one non-zero element.".toString());
        }
        for (int i17 = 0; i17 < 64; i17++) {
            c();
        }
    }

    @Override // l9.c
    public int b(int i10) {
        return d.f(c(), i10);
    }

    @Override // l9.c
    public int c() {
        int i10 = this.f30975c;
        int i11 = i10 ^ (i10 >>> 2);
        this.f30975c = this.f30976d;
        this.f30976d = this.f30977e;
        this.f30977e = this.f30978f;
        int i12 = this.f30979g;
        this.f30978f = i12;
        int i13 = ((i11 ^ (i11 << 1)) ^ i12) ^ (i12 << 4);
        this.f30979g = i13;
        int i14 = this.f30980h + 362437;
        this.f30980h = i14;
        return i13 + i14;
    }

    public e(int i10, int i11) {
        this(i10, i11, 0, 0, ~i10, (i10 << 10) ^ (i11 >>> 4));
    }
}
