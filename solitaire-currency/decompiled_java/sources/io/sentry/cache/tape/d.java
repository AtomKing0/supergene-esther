package io.sentry.cache.tape;

import androidx.media3.common.C;
import com.ironsource.v8;
import java.io.Closeable;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jetbrains.annotations.ApiStatus;

/* JADX INFO: compiled from: QueueFile.java */
/* JADX INFO: loaded from: classes5.dex */
@ApiStatus.Internal
public final class d implements Closeable, Iterable<byte[]> {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final byte[] f27689m = new byte[4096];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    RandomAccessFile f27690a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final File f27691b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    long f27693d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f27694e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    b f27695f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private b f27696g;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final boolean f27699j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final int f27700k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    boolean f27701l;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f27692c = 32;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final byte[] f27697h = new byte[32];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    int f27698i = 0;

    /* JADX INFO: compiled from: QueueFile.java */
    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final File f27702a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        boolean f27703b = true;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27704c = -1;

        public a(File file) {
            if (file == null) {
                throw new NullPointerException("file == null");
            }
            this.f27702a = file;
        }

        public d a() throws IOException {
            RandomAccessFile randomAccessFileZ = d.z(this.f27702a);
            try {
                return new d(this.f27702a, randomAccessFileZ, this.f27703b, this.f27704c);
            } catch (Throwable th) {
                randomAccessFileZ.close();
                throw th;
            }
        }

        public a b(int i10) {
            this.f27704c = i10;
            return this;
        }
    }

    /* JADX INFO: compiled from: QueueFile.java */
    static final class b {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        static final b f27705c = new b(0, 0);

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final long f27706a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f27707b;

        b(long j10, int i10) {
            this.f27706a = j10;
            this.f27707b = i10;
        }

        public String toString() {
            return b.class.getSimpleName() + "[position=" + this.f27706a + ", length=" + this.f27707b + v8.i.f15839e;
        }
    }

    /* JADX INFO: compiled from: QueueFile.java */
    private final class c implements Iterator<byte[]> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f27708a = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f27709b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f27710c;

        c() {
            this.f27709b = d.this.f27695f.f27706a;
            this.f27710c = d.this.f27698i;
        }

        private void a() {
            if (d.this.f27698i != this.f27710c) {
                throw new ConcurrentModificationException();
            }
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] next() {
            if (d.this.f27701l) {
                throw new IllegalStateException("closed");
            }
            a();
            if (d.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            int i10 = this.f27708a;
            d dVar = d.this;
            if (i10 >= dVar.f27694e) {
                throw new NoSuchElementException();
            }
            try {
                try {
                    b bVarO = dVar.O(this.f27709b);
                    byte[] bArr = new byte[bVarO.f27707b];
                    long jO0 = d.this.O0(bVarO.f27706a + 4);
                    this.f27709b = jO0;
                    if (!d.this.K0(jO0, bArr, 0, bVarO.f27707b)) {
                        this.f27708a = d.this.f27694e;
                        return d.f27689m;
                    }
                    this.f27709b = d.this.O0(bVarO.f27706a + 4 + ((long) bVarO.f27707b));
                    this.f27708a++;
                    return bArr;
                } catch (IOException e10) {
                    throw ((Error) d.x(e10));
                }
            } catch (IOException e11) {
                throw ((Error) d.x(e11));
            } catch (OutOfMemoryError unused) {
                d.this.I0();
                this.f27708a = d.this.f27694e;
                return d.f27689m;
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            if (d.this.f27701l) {
                throw new IllegalStateException("closed");
            }
            a();
            return this.f27708a != d.this.f27694e;
        }

        @Override // java.util.Iterator
        public void remove() {
            a();
            if (d.this.isEmpty()) {
                throw new NoSuchElementException();
            }
            if (this.f27708a != 1) {
                throw new UnsupportedOperationException("Removal is only permitted from the head.");
            }
            try {
                d.this.i0();
                this.f27710c = d.this.f27698i;
                this.f27708a--;
            } catch (IOException e10) {
                throw ((Error) d.x(e10));
            }
        }
    }

    d(File file, RandomAccessFile randomAccessFile, boolean z10, int i10) throws IOException {
        this.f27691b = file;
        this.f27690a = randomAccessFile;
        this.f27699j = z10;
        this.f27700k = i10;
        R();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void I0() throws IOException {
        this.f27690a.close();
        this.f27691b.delete();
        this.f27690a = z(this.f27691b);
        R();
    }

    private static RandomAccessFile J(File file) throws FileNotFoundException {
        return new RandomAccessFile(file, "rwd");
    }

    private void J0(long j10, long j11) throws IOException {
        while (j11 > 0) {
            byte[] bArr = f27689m;
            int iMin = (int) Math.min(j11, bArr.length);
            L0(j10, bArr, 0, iMin);
            long j12 = iMin;
            j11 -= j12;
            j10 += j12;
        }
    }

    private void L0(long j10, byte[] bArr, int i10, int i11) throws IOException {
        long jO0 = O0(j10);
        long j11 = ((long) i11) + jO0;
        long j12 = this.f27693d;
        if (j11 <= j12) {
            this.f27690a.seek(jO0);
            this.f27690a.write(bArr, i10, i11);
            return;
        }
        int i12 = (int) (j12 - jO0);
        this.f27690a.seek(jO0);
        this.f27690a.write(bArr, i10, i12);
        this.f27690a.seek(32L);
        this.f27690a.write(bArr, i10 + i12, i11 - i12);
    }

    private void M0(long j10) throws IOException {
        this.f27690a.setLength(j10);
        this.f27690a.getChannel().force(true);
    }

    private long N0() {
        if (this.f27694e == 0) {
            return 32L;
        }
        b bVar = this.f27696g;
        long j10 = bVar.f27706a;
        long j11 = this.f27695f.f27706a;
        return j10 >= j11 ? (j10 - j11) + 4 + ((long) bVar.f27707b) + 32 : (((j10 + 4) + ((long) bVar.f27707b)) + this.f27693d) - j11;
    }

    private void P0(long j10, int i10, long j11, long j12) throws IOException {
        this.f27690a.seek(0L);
        Q0(this.f27697h, 0, C.RATE_UNSET_INT);
        R0(this.f27697h, 4, j10);
        Q0(this.f27697h, 12, i10);
        R0(this.f27697h, 16, j11);
        R0(this.f27697h, 24, j12);
        this.f27690a.write(this.f27697h, 0, 32);
    }

    private static void Q0(byte[] bArr, int i10, int i11) {
        bArr[i10] = (byte) (i11 >> 24);
        bArr[i10 + 1] = (byte) (i11 >> 16);
        bArr[i10 + 2] = (byte) (i11 >> 8);
        bArr[i10 + 3] = (byte) i11;
    }

    private void R() throws IOException {
        this.f27690a.seek(0L);
        this.f27690a.readFully(this.f27697h);
        this.f27693d = W(this.f27697h, 4);
        this.f27694e = S(this.f27697h, 12);
        long jW = W(this.f27697h, 16);
        long jW2 = W(this.f27697h, 24);
        if (this.f27693d > this.f27690a.length()) {
            throw new IOException("File is truncated. Expected length: " + this.f27693d + ", Actual length: " + this.f27690a.length());
        }
        if (this.f27693d > 32) {
            this.f27695f = O(jW);
            this.f27696g = O(jW2);
        } else {
            throw new IOException("File is corrupt; length stored in header (" + this.f27693d + ") is invalid.");
        }
    }

    private static void R0(byte[] bArr, int i10, long j10) {
        bArr[i10] = (byte) (j10 >> 56);
        bArr[i10 + 1] = (byte) (j10 >> 48);
        bArr[i10 + 2] = (byte) (j10 >> 40);
        bArr[i10 + 3] = (byte) (j10 >> 32);
        bArr[i10 + 4] = (byte) (j10 >> 24);
        bArr[i10 + 5] = (byte) (j10 >> 16);
        bArr[i10 + 6] = (byte) (j10 >> 8);
        bArr[i10 + 7] = (byte) j10;
    }

    private static int S(byte[] bArr, int i10) {
        return ((bArr[i10] & 255) << 24) + ((bArr[i10 + 1] & 255) << 16) + ((bArr[i10 + 2] & 255) << 8) + (bArr[i10 + 3] & 255);
    }

    private static long W(byte[] bArr, int i10) {
        return ((((long) bArr[i10]) & 255) << 56) + ((((long) bArr[i10 + 1]) & 255) << 48) + ((((long) bArr[i10 + 2]) & 255) << 40) + ((((long) bArr[i10 + 3]) & 255) << 32) + ((((long) bArr[i10 + 4]) & 255) << 24) + ((((long) bArr[i10 + 5]) & 255) << 16) + ((((long) bArr[i10 + 6]) & 255) << 8) + (((long) bArr[i10 + 7]) & 255);
    }

    private long h0() {
        return this.f27693d - N0();
    }

    private void q(long j10) throws IOException {
        long j11;
        long j12;
        long j13 = j10 + 4;
        long jH0 = h0();
        if (jH0 >= j13) {
            return;
        }
        long j14 = this.f27693d;
        while (true) {
            jH0 += j14;
            j11 = j14 << 1;
            if (jH0 >= j13) {
                break;
            } else {
                j14 = j11;
            }
        }
        M0(j11);
        b bVar = this.f27696g;
        long jO0 = O0(bVar.f27706a + 4 + ((long) bVar.f27707b));
        if (jO0 <= this.f27695f.f27706a) {
            FileChannel channel = this.f27690a.getChannel();
            channel.position(this.f27693d);
            j12 = jO0 - 32;
            if (channel.transferTo(32L, j12, channel) != j12) {
                throw new AssertionError("Copied insufficient number of bytes!");
            }
        } else {
            j12 = 0;
        }
        long j15 = j12;
        long j16 = this.f27696g.f27706a;
        long j17 = this.f27695f.f27706a;
        if (j16 < j17) {
            long j18 = (this.f27693d + j16) - 32;
            P0(j11, this.f27694e, j17, j18);
            this.f27696g = new b(j18, this.f27696g.f27707b);
        } else {
            P0(j11, this.f27694e, j17, j16);
        }
        this.f27693d = j11;
        if (this.f27699j) {
            J0(32L, j15);
        }
    }

    static RandomAccessFile z(File file) throws IOException {
        if (!file.exists()) {
            File file2 = new File(file.getPath() + ".tmp");
            RandomAccessFile randomAccessFileJ = J(file2);
            try {
                randomAccessFileJ.setLength(4096L);
                randomAccessFileJ.seek(0L);
                randomAccessFileJ.writeInt(C.RATE_UNSET_INT);
                randomAccessFileJ.writeLong(4096L);
                randomAccessFileJ.close();
                if (!file2.renameTo(file)) {
                    throw new IOException("Rename failed!");
                }
            } catch (Throwable th) {
                randomAccessFileJ.close();
                throw th;
            }
        }
        return J(file);
    }

    public boolean B() {
        return this.f27700k != -1 && size() == this.f27700k;
    }

    public void G0(int i10) throws IOException {
        if (i10 < 0) {
            throw new IllegalArgumentException("Cannot remove negative (" + i10 + ") number of elements.");
        }
        if (i10 == 0) {
            return;
        }
        if (i10 == this.f27694e) {
            clear();
            return;
        }
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        if (i10 > this.f27694e) {
            throw new IllegalArgumentException("Cannot remove more elements (" + i10 + ") than present in queue (" + this.f27694e + ").");
        }
        b bVar = this.f27695f;
        long j10 = bVar.f27706a;
        int iS = bVar.f27707b;
        long j11 = 0;
        int i11 = 0;
        long j12 = j10;
        while (i11 < i10) {
            j11 += (long) (iS + 4);
            long jO0 = O0(j12 + 4 + ((long) iS));
            if (!K0(jO0, this.f27697h, 0, 4)) {
                return;
            }
            iS = S(this.f27697h, 0);
            i11++;
            j12 = jO0;
        }
        P0(this.f27693d, this.f27694e - i10, j12, this.f27696g.f27706a);
        this.f27694e -= i10;
        this.f27698i++;
        this.f27695f = new b(j12, iS);
        if (this.f27699j) {
            J0(j10, j11);
        }
    }

    boolean K0(long j10, byte[] bArr, int i10, int i11) throws IOException {
        try {
            long jO0 = O0(j10);
            long j11 = ((long) i11) + jO0;
            long j12 = this.f27693d;
            if (j11 <= j12) {
                this.f27690a.seek(jO0);
                this.f27690a.readFully(bArr, i10, i11);
                return true;
            }
            int i12 = (int) (j12 - jO0);
            this.f27690a.seek(jO0);
            this.f27690a.readFully(bArr, i10, i12);
            this.f27690a.seek(32L);
            this.f27690a.readFully(bArr, i10 + i12, i11 - i12);
            return true;
        } catch (EOFException unused) {
            I0();
            return false;
        } catch (IOException e10) {
            throw e10;
        } catch (Throwable unused2) {
            I0();
            return false;
        }
    }

    b O(long j10) throws IOException {
        return j10 == 0 ? b.f27705c : !K0(j10, this.f27697h, 0, 4) ? b.f27705c : new b(j10, S(this.f27697h, 0));
    }

    long O0(long j10) {
        long j11 = this.f27693d;
        return j10 < j11 ? j10 : (j10 + 32) - j11;
    }

    public void clear() throws IOException {
        if (this.f27701l) {
            throw new IllegalStateException("closed");
        }
        P0(4096L, 0, 0L, 0L);
        if (this.f27699j) {
            this.f27690a.seek(32L);
            this.f27690a.write(f27689m, 0, 4064);
        }
        this.f27694e = 0;
        b bVar = b.f27705c;
        this.f27695f = bVar;
        this.f27696g = bVar;
        if (this.f27693d > 4096) {
            M0(4096L);
        }
        this.f27693d = 4096L;
        this.f27698i++;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f27701l = true;
        this.f27690a.close();
    }

    public void i0() throws IOException {
        G0(1);
    }

    public boolean isEmpty() {
        return this.f27694e == 0;
    }

    @Override // java.lang.Iterable
    public Iterator<byte[]> iterator() {
        return new c();
    }

    public void n(byte[] bArr, int i10, int i11) throws IOException {
        long jO0;
        if (bArr == null) {
            throw new NullPointerException("data == null");
        }
        if ((i10 | i11) < 0 || i11 > bArr.length - i10) {
            throw new IndexOutOfBoundsException();
        }
        if (this.f27701l) {
            throw new IllegalStateException("closed");
        }
        if (B()) {
            i0();
        }
        q(i11);
        boolean zIsEmpty = isEmpty();
        if (zIsEmpty) {
            jO0 = 32;
        } else {
            b bVar = this.f27696g;
            jO0 = O0(bVar.f27706a + 4 + ((long) bVar.f27707b));
        }
        b bVar2 = new b(jO0, i11);
        Q0(this.f27697h, 0, i11);
        L0(bVar2.f27706a, this.f27697h, 0, 4);
        L0(bVar2.f27706a + 4, bArr, i10, i11);
        P0(this.f27693d, this.f27694e + 1, zIsEmpty ? bVar2.f27706a : this.f27695f.f27706a, bVar2.f27706a);
        this.f27696g = bVar2;
        this.f27694e++;
        this.f27698i++;
        if (zIsEmpty) {
            this.f27695f = bVar2;
        }
    }

    public int size() {
        return this.f27694e;
    }

    public String toString() {
        return "QueueFile{file=" + this.f27691b + ", zero=" + this.f27699j + ", length=" + this.f27693d + ", size=" + this.f27694e + ", first=" + this.f27695f + ", last=" + this.f27696g + '}';
    }

    static <T extends Throwable> T x(Throwable th) throws Throwable {
        throw th;
    }
}
