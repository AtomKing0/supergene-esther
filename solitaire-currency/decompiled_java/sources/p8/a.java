package p8;

import java.io.EOFException;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: compiled from: Buffer.kt */
/* JADX INFO: loaded from: classes3.dex */
public class a {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @NotNull
    public static final C0652a f32920g = new C0652a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final ByteBuffer f32921a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f32922b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f32923c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f32924d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f32925e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f32926f;

    /* JADX INFO: renamed from: p8.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: Buffer.kt */
    public static final class C0652a {
        private C0652a() {
        }

        public /* synthetic */ C0652a(kotlin.jvm.internal.k kVar) {
            this();
        }

        @NotNull
        public final a a() {
            return q8.a.f33167j.a();
        }
    }

    public /* synthetic */ a(ByteBuffer byteBuffer, kotlin.jvm.internal.k kVar) {
        this(byteBuffer);
    }

    public final void a(int i10) {
        int i11 = this.f32923c + i10;
        if (i10 < 0 || i11 > this.f32925e) {
            d.a(i10, f() - j());
            throw new v8.h();
        }
        this.f32923c = i11;
    }

    public final boolean b(int i10) {
        int i11 = this.f32925e;
        int i12 = this.f32923c;
        if (i10 < i12) {
            d.a(i10 - i12, f() - j());
            throw new v8.h();
        }
        if (i10 < i11) {
            this.f32923c = i10;
            return true;
        }
        if (i10 == i11) {
            this.f32923c = i10;
            return false;
        }
        d.a(i10 - i12, f() - j());
        throw new v8.h();
    }

    public final void c(int i10) {
        if (i10 == 0) {
            return;
        }
        int i11 = this.f32922b + i10;
        if (i10 < 0 || i11 > this.f32923c) {
            d.b(i10, j() - h());
            throw new v8.h();
        }
        this.f32922b = i11;
    }

    public final void d(int i10) {
        if (i10 < 0 || i10 > this.f32923c) {
            d.b(i10 - this.f32922b, j() - h());
            throw new v8.h();
        }
        if (this.f32922b != i10) {
            this.f32922b = i10;
        }
    }

    public final int e() {
        return this.f32926f;
    }

    public final int f() {
        return this.f32925e;
    }

    @NotNull
    public final ByteBuffer g() {
        return this.f32921a;
    }

    public final int h() {
        return this.f32922b;
    }

    public final int i() {
        return this.f32924d;
    }

    public final int j() {
        return this.f32923c;
    }

    public final byte k() throws EOFException {
        int i10 = this.f32922b;
        if (i10 == this.f32923c) {
            throw new EOFException("No readable bytes available.");
        }
        this.f32922b = i10 + 1;
        return this.f32921a.get(i10);
    }

    public final void l() {
        this.f32925e = this.f32926f;
    }

    public final void m() {
        n(0);
        l();
    }

    public final void n(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("newReadPosition shouldn't be negative: " + i10).toString());
        }
        if (i10 <= this.f32922b) {
            this.f32922b = i10;
            if (this.f32924d > i10) {
                this.f32924d = i10;
                return;
            }
            return;
        }
        throw new IllegalArgumentException(("newReadPosition shouldn't be ahead of the read position: " + i10 + " > " + this.f32922b).toString());
    }

    public final void o(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("endGap shouldn't be negative: " + i10).toString());
        }
        int i11 = this.f32926f - i10;
        if (i11 >= this.f32923c) {
            this.f32925e = i11;
            return;
        }
        if (i11 < 0) {
            d.c(this, i10);
        }
        if (i11 < this.f32924d) {
            d.e(this, i10);
        }
        if (this.f32922b != this.f32923c) {
            d.d(this, i10);
            return;
        }
        this.f32925e = i11;
        this.f32922b = i11;
        this.f32923c = i11;
    }

    public final void p(int i10) {
        if (!(i10 >= 0)) {
            throw new IllegalArgumentException(("startGap shouldn't be negative: " + i10).toString());
        }
        int i11 = this.f32922b;
        if (i11 >= i10) {
            this.f32924d = i10;
            return;
        }
        if (i11 != this.f32923c) {
            d.g(this, i10);
            throw new v8.h();
        }
        if (i10 > this.f32925e) {
            d.h(this, i10);
            throw new v8.h();
        }
        this.f32923c = i10;
        this.f32922b = i10;
        this.f32924d = i10;
    }

    public void q() {
        m();
        r();
    }

    public final void r() {
        s(this.f32926f - this.f32924d);
    }

    public final void s(int i10) {
        int i11 = this.f32924d;
        this.f32922b = i11;
        this.f32923c = i11;
        this.f32925e = i10;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Buffer[0x");
        String string = Integer.toString(hashCode(), p9.b.a(16));
        t.h(string, "toString(this, checkRadix(radix))");
        sb.append(string);
        sb.append("](");
        sb.append(j() - h());
        sb.append(" used, ");
        sb.append(f() - j());
        sb.append(" free, ");
        sb.append(this.f32924d + (e() - f()));
        sb.append(" reserved of ");
        sb.append(this.f32926f);
        sb.append(')');
        return sb.toString();
    }

    private a(ByteBuffer memory) {
        t.i(memory, "memory");
        this.f32921a = memory;
        this.f32925e = memory.limit();
        this.f32926f = memory.limit();
    }
}
