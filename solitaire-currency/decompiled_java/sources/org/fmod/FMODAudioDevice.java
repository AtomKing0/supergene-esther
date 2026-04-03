package org.fmod;

import android.media.AudioTrack;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
public class FMODAudioDevice implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile Thread f32320a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile boolean f32321b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private AudioTrack f32322c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f32323d = false;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private ByteBuffer f32324e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private byte[] f32325f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private volatile a f32326g;

    private native int fmodGetInfo(int i10);

    private native int fmodProcess(ByteBuffer byteBuffer);

    private void releaseAudioTrack() {
        AudioTrack audioTrack = this.f32322c;
        if (audioTrack != null) {
            if (audioTrack.getState() == 1) {
                this.f32322c.stop();
            }
            this.f32322c.release();
            this.f32322c = null;
        }
        this.f32324e = null;
        this.f32325f = null;
        this.f32323d = false;
    }

    public synchronized void close() {
        stop();
    }

    native int fmodProcessMicData(ByteBuffer byteBuffer, int i10);

    public boolean isRunning() {
        return this.f32320a != null && this.f32320a.isAlive();
    }

    @Override // java.lang.Runnable
    public void run() {
        int i10 = 3;
        while (this.f32321b) {
            if (!this.f32323d && i10 > 0) {
                releaseAudioTrack();
                int iFmodGetInfo = fmodGetInfo(0);
                int i11 = fmodGetInfo(4) == 1 ? 4 : 12;
                int minBufferSize = AudioTrack.getMinBufferSize(iFmodGetInfo, i11, 2);
                int iFmodGetInfo2 = fmodGetInfo(4) * 2;
                int iRound = Math.round(minBufferSize * 1.1f) & (~(iFmodGetInfo2 - 1));
                int iFmodGetInfo3 = fmodGetInfo(1);
                int iFmodGetInfo4 = fmodGetInfo(2) * iFmodGetInfo3 * iFmodGetInfo2;
                AudioTrack audioTrack = new AudioTrack(3, iFmodGetInfo, i11, 2, iFmodGetInfo4 > iRound ? iFmodGetInfo4 : iRound, 1);
                this.f32322c = audioTrack;
                boolean z10 = audioTrack.getState() == 1;
                this.f32323d = z10;
                if (z10) {
                    ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(iFmodGetInfo3 * iFmodGetInfo2);
                    this.f32324e = byteBufferAllocateDirect;
                    this.f32325f = new byte[byteBufferAllocateDirect.capacity()];
                    this.f32322c.play();
                    i10 = 3;
                } else {
                    Log.e("FMOD", "AudioTrack failed to initialize (status " + this.f32322c.getState() + ")");
                    releaseAudioTrack();
                    i10 += -1;
                }
            }
            if (this.f32323d) {
                if (fmodGetInfo(3) == 1) {
                    fmodProcess(this.f32324e);
                    ByteBuffer byteBuffer = this.f32324e;
                    byteBuffer.get(this.f32325f, 0, byteBuffer.capacity());
                    this.f32322c.write(this.f32325f, 0, this.f32324e.capacity());
                    this.f32324e.position(0);
                } else {
                    releaseAudioTrack();
                }
            }
        }
        releaseAudioTrack();
    }

    public synchronized void start() {
        if (this.f32320a != null) {
            stop();
        }
        this.f32320a = new Thread(this, "FMODAudioDevice");
        this.f32320a.setPriority(10);
        this.f32321b = true;
        this.f32320a.start();
        if (this.f32326g != null) {
            this.f32326g.c();
        }
    }

    public synchronized int startAudioRecord(int i10, int i11, int i12) {
        if (this.f32326g == null) {
            this.f32326g = new a(this, i10, i11);
            this.f32326g.c();
        }
        return this.f32326g.a();
    }

    public synchronized void stop() {
        while (this.f32320a != null) {
            this.f32321b = false;
            try {
                this.f32320a.join();
                this.f32320a = null;
            } catch (InterruptedException unused) {
            }
        }
        if (this.f32326g != null) {
            this.f32326g.d();
        }
    }

    public synchronized void stopAudioRecord() {
        if (this.f32326g != null) {
            this.f32326g.d();
            this.f32326g = null;
        }
    }
}
