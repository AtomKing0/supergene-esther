package q0;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.ViewCompat;
import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/* JADX INFO: compiled from: GifHeaderParser.java */
/* JADX INFO: loaded from: classes2.dex */
public class d {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ByteBuffer f33096b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private c f33097c;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final byte[] f33095a = new byte[256];

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f33098d = 0;

    private boolean b() {
        return this.f33097c.f33083b != 0;
    }

    private int d() {
        try {
            return this.f33096b.get() & 255;
        } catch (Exception unused) {
            this.f33097c.f33083b = 1;
            return 0;
        }
    }

    private void e() {
        this.f33097c.f33085d.f33071a = n();
        this.f33097c.f33085d.f33072b = n();
        this.f33097c.f33085d.f33073c = n();
        this.f33097c.f33085d.f33074d = n();
        int iD = d();
        boolean z10 = (iD & 128) != 0;
        int iPow = (int) Math.pow(2.0d, (iD & 7) + 1);
        b bVar = this.f33097c.f33085d;
        bVar.f33075e = (iD & 64) != 0;
        if (z10) {
            bVar.f33081k = g(iPow);
        } else {
            bVar.f33081k = null;
        }
        this.f33097c.f33085d.f33080j = this.f33096b.position();
        r();
        if (b()) {
            return;
        }
        c cVar = this.f33097c;
        cVar.f33084c++;
        cVar.f33086e.add(cVar.f33085d);
    }

    private void f() {
        int iD = d();
        this.f33098d = iD;
        if (iD <= 0) {
            return;
        }
        int i10 = 0;
        int i11 = 0;
        while (true) {
            try {
                i11 = this.f33098d;
                if (i10 >= i11) {
                    return;
                }
                i11 -= i10;
                this.f33096b.get(this.f33095a, i10, i11);
                i10 += i11;
            } catch (Exception e10) {
                if (Log.isLoggable("GifHeaderParser", 3)) {
                    Log.d("GifHeaderParser", "Error Reading Block n: " + i10 + " count: " + i11 + " blockSize: " + this.f33098d, e10);
                }
                this.f33097c.f33083b = 1;
                return;
            }
        }
    }

    @Nullable
    private int[] g(int i10) {
        byte[] bArr = new byte[i10 * 3];
        int[] iArr = null;
        try {
            this.f33096b.get(bArr);
            iArr = new int[256];
            int i11 = 0;
            int i12 = 0;
            while (i11 < i10) {
                int i13 = i12 + 1;
                int i14 = i13 + 1;
                int i15 = i14 + 1;
                int i16 = i11 + 1;
                iArr[i11] = ((bArr[i12] & 255) << 16) | ViewCompat.MEASURED_STATE_MASK | ((bArr[i13] & 255) << 8) | (bArr[i14] & 255);
                i12 = i15;
                i11 = i16;
            }
        } catch (BufferUnderflowException e10) {
            if (Log.isLoggable("GifHeaderParser", 3)) {
                Log.d("GifHeaderParser", "Format Error Reading Color Table", e10);
            }
            this.f33097c.f33083b = 1;
        }
        return iArr;
    }

    private void h() {
        i(Integer.MAX_VALUE);
    }

    private void i(int i10) {
        boolean z10 = false;
        while (!z10 && !b() && this.f33097c.f33084c <= i10) {
            int iD = d();
            if (iD == 33) {
                int iD2 = d();
                if (iD2 == 1) {
                    q();
                } else if (iD2 == 249) {
                    this.f33097c.f33085d = new b();
                    j();
                } else if (iD2 == 254) {
                    q();
                } else if (iD2 != 255) {
                    q();
                } else {
                    f();
                    StringBuilder sb = new StringBuilder();
                    for (int i11 = 0; i11 < 11; i11++) {
                        sb.append((char) this.f33095a[i11]);
                    }
                    if (sb.toString().equals("NETSCAPE2.0")) {
                        m();
                    } else {
                        q();
                    }
                }
            } else if (iD == 44) {
                c cVar = this.f33097c;
                if (cVar.f33085d == null) {
                    cVar.f33085d = new b();
                }
                e();
            } else if (iD != 59) {
                this.f33097c.f33083b = 1;
            } else {
                z10 = true;
            }
        }
    }

    private void j() {
        d();
        int iD = d();
        b bVar = this.f33097c.f33085d;
        int i10 = (iD & 28) >> 2;
        bVar.f33077g = i10;
        if (i10 == 0) {
            bVar.f33077g = 1;
        }
        bVar.f33076f = (iD & 1) != 0;
        int iN = n();
        if (iN < 2) {
            iN = 10;
        }
        b bVar2 = this.f33097c.f33085d;
        bVar2.f33079i = iN * 10;
        bVar2.f33078h = d();
        d();
    }

    private void k() {
        StringBuilder sb = new StringBuilder();
        for (int i10 = 0; i10 < 6; i10++) {
            sb.append((char) d());
        }
        if (!sb.toString().startsWith("GIF")) {
            this.f33097c.f33083b = 1;
            return;
        }
        l();
        if (!this.f33097c.f33089h || b()) {
            return;
        }
        c cVar = this.f33097c;
        cVar.f33082a = g(cVar.f33090i);
        c cVar2 = this.f33097c;
        cVar2.f33093l = cVar2.f33082a[cVar2.f33091j];
    }

    private void l() {
        this.f33097c.f33087f = n();
        this.f33097c.f33088g = n();
        int iD = d();
        c cVar = this.f33097c;
        cVar.f33089h = (iD & 128) != 0;
        cVar.f33090i = (int) Math.pow(2.0d, (iD & 7) + 1);
        this.f33097c.f33091j = d();
        this.f33097c.f33092k = d();
    }

    private void m() {
        do {
            f();
            byte[] bArr = this.f33095a;
            if (bArr[0] == 1) {
                this.f33097c.f33094m = ((bArr[2] & 255) << 8) | (bArr[1] & 255);
            }
            if (this.f33098d <= 0) {
                return;
            }
        } while (!b());
    }

    private int n() {
        return this.f33096b.getShort();
    }

    private void o() {
        this.f33096b = null;
        Arrays.fill(this.f33095a, (byte) 0);
        this.f33097c = new c();
        this.f33098d = 0;
    }

    private void q() {
        int iD;
        do {
            iD = d();
            this.f33096b.position(Math.min(this.f33096b.position() + iD, this.f33096b.limit()));
        } while (iD > 0);
    }

    private void r() {
        d();
        q();
    }

    public void a() {
        this.f33096b = null;
        this.f33097c = null;
    }

    @NonNull
    public c c() {
        if (this.f33096b == null) {
            throw new IllegalStateException("You must call setData() before parseHeader()");
        }
        if (b()) {
            return this.f33097c;
        }
        k();
        if (!b()) {
            h();
            c cVar = this.f33097c;
            if (cVar.f33084c < 0) {
                cVar.f33083b = 1;
            }
        }
        return this.f33097c;
    }

    public d p(@NonNull ByteBuffer byteBuffer) {
        o();
        ByteBuffer byteBufferAsReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        this.f33096b = byteBufferAsReadOnlyBuffer;
        byteBufferAsReadOnlyBuffer.position(0);
        this.f33096b.order(ByteOrder.LITTLE_ENDIAN);
        return this;
    }
}
