package o1;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.io.InputStream;
import java.util.Queue;

/* JADX INFO: compiled from: ExceptionCatchingInputStream.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends InputStream {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Queue<d> f31793c = k.e(0);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private InputStream f31794a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private IOException f31795b;

    d() {
    }

    @NonNull
    public static d c(@NonNull InputStream inputStream) {
        d dVarPoll;
        Queue<d> queue = f31793c;
        synchronized (queue) {
            dVarPoll = queue.poll();
        }
        if (dVarPoll == null) {
            dVarPoll = new d();
        }
        dVarPoll.i(inputStream);
        return dVarPoll;
    }

    @Nullable
    public IOException a() {
        return this.f31795b;
    }

    @Override // java.io.InputStream
    public int available() throws IOException {
        return this.f31794a.available();
    }

    @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        this.f31794a.close();
    }

    void i(@NonNull InputStream inputStream) {
        this.f31794a = inputStream;
    }

    @Override // java.io.InputStream
    public void mark(int i10) {
        this.f31794a.mark(i10);
    }

    @Override // java.io.InputStream
    public boolean markSupported() {
        return this.f31794a.markSupported();
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr) {
        try {
            return this.f31794a.read(bArr);
        } catch (IOException e10) {
            this.f31795b = e10;
            return -1;
        }
    }

    public void release() {
        this.f31795b = null;
        this.f31794a = null;
        Queue<d> queue = f31793c;
        synchronized (queue) {
            queue.offer(this);
        }
    }

    @Override // java.io.InputStream
    public synchronized void reset() throws IOException {
        this.f31794a.reset();
    }

    @Override // java.io.InputStream
    public long skip(long j10) {
        try {
            return this.f31794a.skip(j10);
        } catch (IOException e10) {
            this.f31795b = e10;
            return 0L;
        }
    }

    @Override // java.io.InputStream
    public int read(byte[] bArr, int i10, int i11) {
        try {
            return this.f31794a.read(bArr, i10, i11);
        } catch (IOException e10) {
            this.f31795b = e10;
            return -1;
        }
    }

    @Override // java.io.InputStream
    public int read() {
        try {
            return this.f31794a.read();
        } catch (IOException e10) {
            this.f31795b = e10;
            return -1;
        }
    }
}
