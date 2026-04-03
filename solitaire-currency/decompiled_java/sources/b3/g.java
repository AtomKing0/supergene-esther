package b3;

import a4.o0;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.HandlerThread;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import io.sentry.protocol.SentryStackFrame;
import java.util.ArrayDeque;

/* JADX INFO: compiled from: AsynchronousMediaCodecCallback.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(23)
final class g extends MediaCodec.Callback {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final HandlerThread f1967b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Handler f1968c;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaFormat f1973h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaFormat f1974i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private MediaCodec.CodecException f1975j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private long f1976k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private boolean f1977l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    @Nullable
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private IllegalStateException f1978m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f1966a = new Object();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final k f1969d = new k();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final k f1970e = new k();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final ArrayDeque<MediaCodec.BufferInfo> f1971f = new ArrayDeque<>();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private final ArrayDeque<MediaFormat> f1972g = new ArrayDeque<>();

    g(HandlerThread handlerThread) {
        this.f1967b = handlerThread;
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private void b(MediaFormat mediaFormat) {
        this.f1970e.a(-2);
        this.f1972g.add(mediaFormat);
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private void f() {
        if (!this.f1972g.isEmpty()) {
            this.f1974i = this.f1972g.getLast();
        }
        this.f1969d.b();
        this.f1970e.b();
        this.f1971f.clear();
        this.f1972g.clear();
        this.f1975j = null;
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private boolean i() {
        return this.f1976k > 0 || this.f1977l;
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private void j() {
        k();
        l();
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private void k() {
        IllegalStateException illegalStateException = this.f1978m;
        if (illegalStateException == null) {
            return;
        }
        this.f1978m = null;
        throw illegalStateException;
    }

    @GuardedBy(SentryStackFrame.JsonKeys.LOCK)
    private void l() {
        MediaCodec.CodecException codecException = this.f1975j;
        if (codecException == null) {
            return;
        }
        this.f1975j = null;
        throw codecException;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m() {
        synchronized (this.f1966a) {
            if (this.f1977l) {
                return;
            }
            long j10 = this.f1976k - 1;
            this.f1976k = j10;
            if (j10 > 0) {
                return;
            }
            if (j10 < 0) {
                n(new IllegalStateException());
            } else {
                f();
            }
        }
    }

    private void n(IllegalStateException illegalStateException) {
        synchronized (this.f1966a) {
            this.f1978m = illegalStateException;
        }
    }

    public int c() {
        synchronized (this.f1966a) {
            int iE = -1;
            if (i()) {
                return -1;
            }
            j();
            if (!this.f1969d.d()) {
                iE = this.f1969d.e();
            }
            return iE;
        }
    }

    public int d(MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f1966a) {
            if (i()) {
                return -1;
            }
            j();
            if (this.f1970e.d()) {
                return -1;
            }
            int iE = this.f1970e.e();
            if (iE >= 0) {
                a4.a.i(this.f1973h);
                MediaCodec.BufferInfo bufferInfoRemove = this.f1971f.remove();
                bufferInfo.set(bufferInfoRemove.offset, bufferInfoRemove.size, bufferInfoRemove.presentationTimeUs, bufferInfoRemove.flags);
            } else if (iE == -2) {
                this.f1973h = this.f1972g.remove();
            }
            return iE;
        }
    }

    public void e() {
        synchronized (this.f1966a) {
            this.f1976k++;
            ((Handler) o0.j(this.f1968c)).post(new Runnable() { // from class: b3.f
                @Override // java.lang.Runnable
                public final void run() {
                    this.f1965a.m();
                }
            });
        }
    }

    public MediaFormat g() {
        MediaFormat mediaFormat;
        synchronized (this.f1966a) {
            mediaFormat = this.f1973h;
            if (mediaFormat == null) {
                throw new IllegalStateException();
            }
        }
        return mediaFormat;
    }

    public void h(MediaCodec mediaCodec) {
        a4.a.g(this.f1968c == null);
        this.f1967b.start();
        Handler handler = new Handler(this.f1967b.getLooper());
        mediaCodec.setCallback(this, handler);
        this.f1968c = handler;
    }

    public void o() {
        synchronized (this.f1966a) {
            this.f1977l = true;
            this.f1967b.quit();
            f();
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        synchronized (this.f1966a) {
            this.f1975j = codecException;
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onInputBufferAvailable(MediaCodec mediaCodec, int i10) {
        synchronized (this.f1966a) {
            this.f1969d.a(i10);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputBufferAvailable(MediaCodec mediaCodec, int i10, MediaCodec.BufferInfo bufferInfo) {
        synchronized (this.f1966a) {
            MediaFormat mediaFormat = this.f1974i;
            if (mediaFormat != null) {
                b(mediaFormat);
                this.f1974i = null;
            }
            this.f1970e.a(i10);
            this.f1971f.add(bufferInfo);
        }
    }

    @Override // android.media.MediaCodec.Callback
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        synchronized (this.f1966a) {
            b(mediaFormat);
            this.f1974i = null;
        }
    }
}
