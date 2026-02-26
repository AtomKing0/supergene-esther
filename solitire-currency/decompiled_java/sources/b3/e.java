package b3;

import a4.o0;
import android.media.MediaCodec;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
class e {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy("MESSAGE_PARAMS_INSTANCE_POOL")
    private static final ArrayDeque<b> f1950g = new ArrayDeque<>();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object f1951h = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final MediaCodec f1952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f1953b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f1954c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AtomicReference<RuntimeException> f1955d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final a4.g f1956e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f1957f;

    /* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
    class a extends Handler {
        a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            e.this.f(message);
        }
    }

    /* JADX INFO: compiled from: AsynchronousMediaCodecBufferEnqueuer.java */
    private static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f1959a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f1960b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f1961c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final MediaCodec.CryptoInfo f1962d = new MediaCodec.CryptoInfo();

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public long f1963e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public int f1964f;

        b() {
        }

        public void a(int i10, int i11, int i12, long j10, int i13) {
            this.f1959a = i10;
            this.f1960b = i11;
            this.f1961c = i12;
            this.f1963e = j10;
            this.f1964f = i13;
        }
    }

    public e(MediaCodec mediaCodec, HandlerThread handlerThread) {
        this(mediaCodec, handlerThread, new a4.g());
    }

    private void b() throws InterruptedException {
        this.f1956e.c();
        ((Handler) a4.a.e(this.f1954c)).obtainMessage(2).sendToTarget();
        this.f1956e.a();
    }

    private static void c(n2.c cVar, MediaCodec.CryptoInfo cryptoInfo) {
        cryptoInfo.numSubSamples = cVar.f31566f;
        cryptoInfo.numBytesOfClearData = e(cVar.f31564d, cryptoInfo.numBytesOfClearData);
        cryptoInfo.numBytesOfEncryptedData = e(cVar.f31565e, cryptoInfo.numBytesOfEncryptedData);
        cryptoInfo.key = (byte[]) a4.a.e(d(cVar.f31562b, cryptoInfo.key));
        cryptoInfo.iv = (byte[]) a4.a.e(d(cVar.f31561a, cryptoInfo.iv));
        cryptoInfo.mode = cVar.f31563c;
        if (o0.f214a >= 24) {
            cryptoInfo.setPattern(new MediaCodec.CryptoInfo.Pattern(cVar.f31567g, cVar.f31568h));
        }
    }

    @Nullable
    private static byte[] d(@Nullable byte[] bArr, @Nullable byte[] bArr2) {
        if (bArr == null) {
            return bArr2;
        }
        if (bArr2 == null || bArr2.length < bArr.length) {
            return Arrays.copyOf(bArr, bArr.length);
        }
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    @Nullable
    private static int[] e(@Nullable int[] iArr, @Nullable int[] iArr2) {
        if (iArr == null) {
            return iArr2;
        }
        if (iArr2 == null || iArr2.length < iArr.length) {
            return Arrays.copyOf(iArr, iArr.length);
        }
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void f(Message message) {
        b bVar;
        int i10 = message.what;
        if (i10 == 0) {
            bVar = (b) message.obj;
            g(bVar.f1959a, bVar.f1960b, bVar.f1961c, bVar.f1963e, bVar.f1964f);
        } else if (i10 != 1) {
            bVar = null;
            if (i10 != 2) {
                androidx.compose.animation.core.d.a(this.f1955d, null, new IllegalStateException(String.valueOf(message.what)));
            } else {
                this.f1956e.e();
            }
        } else {
            bVar = (b) message.obj;
            h(bVar.f1959a, bVar.f1960b, bVar.f1962d, bVar.f1963e, bVar.f1964f);
        }
        if (bVar != null) {
            o(bVar);
        }
    }

    private void g(int i10, int i11, int i12, long j10, int i13) {
        try {
            this.f1952a.queueInputBuffer(i10, i11, i12, j10, i13);
        } catch (RuntimeException e10) {
            androidx.compose.animation.core.d.a(this.f1955d, null, e10);
        }
    }

    private void h(int i10, int i11, MediaCodec.CryptoInfo cryptoInfo, long j10, int i12) {
        try {
            synchronized (f1951h) {
                this.f1952a.queueSecureInputBuffer(i10, i11, cryptoInfo, j10, i12);
            }
        } catch (RuntimeException e10) {
            androidx.compose.animation.core.d.a(this.f1955d, null, e10);
        }
    }

    private void j() throws InterruptedException {
        ((Handler) a4.a.e(this.f1954c)).removeCallbacksAndMessages(null);
        b();
    }

    private static b k() {
        ArrayDeque<b> arrayDeque = f1950g;
        synchronized (arrayDeque) {
            if (arrayDeque.isEmpty()) {
                return new b();
            }
            return arrayDeque.removeFirst();
        }
    }

    private void l() {
        RuntimeException andSet = this.f1955d.getAndSet(null);
        if (andSet != null) {
            throw andSet;
        }
    }

    private static void o(b bVar) {
        ArrayDeque<b> arrayDeque = f1950g;
        synchronized (arrayDeque) {
            arrayDeque.add(bVar);
        }
    }

    public void i() {
        if (this.f1957f) {
            try {
                j();
            } catch (InterruptedException e10) {
                Thread.currentThread().interrupt();
                throw new IllegalStateException(e10);
            }
        }
    }

    public void m(int i10, int i11, int i12, long j10, int i13) {
        l();
        b bVarK = k();
        bVarK.a(i10, i11, i12, j10, i13);
        ((Handler) o0.j(this.f1954c)).obtainMessage(0, bVarK).sendToTarget();
    }

    public void n(int i10, int i11, n2.c cVar, long j10, int i12) {
        l();
        b bVarK = k();
        bVarK.a(i10, i11, 0, j10, i12);
        c(cVar, bVarK.f1962d);
        ((Handler) o0.j(this.f1954c)).obtainMessage(1, bVarK).sendToTarget();
    }

    public void p() {
        if (this.f1957f) {
            i();
            this.f1953b.quit();
        }
        this.f1957f = false;
    }

    public void q() {
        if (this.f1957f) {
            return;
        }
        this.f1953b.start();
        this.f1954c = new a(this.f1953b.getLooper());
        this.f1957f = true;
    }

    public void r() throws InterruptedException {
        b();
    }

    @VisibleForTesting
    e(MediaCodec mediaCodec, HandlerThread handlerThread, a4.g gVar) {
        this.f1952a = mediaCodec;
        this.f1953b = handlerThread;
        this.f1956e = gVar;
        this.f1955d = new AtomicReference<>();
    }
}
