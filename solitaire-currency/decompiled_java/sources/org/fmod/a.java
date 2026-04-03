package org.fmod;

import android.media.AudioRecord;
import android.util.Log;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes5.dex */
final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FMODAudioDevice f32327a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ByteBuffer f32328b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f32329c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f32330d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private volatile Thread f32331e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private volatile boolean f32332f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private AudioRecord f32333g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f32334h;

    a(FMODAudioDevice fMODAudioDevice, int i10, int i11) {
        this.f32327a = fMODAudioDevice;
        this.f32329c = i10;
        this.f32330d = i11;
        this.f32328b = ByteBuffer.allocateDirect(AudioRecord.getMinBufferSize(i10, i11, 2));
    }

    private void b() {
        AudioRecord audioRecord = this.f32333g;
        if (audioRecord != null) {
            if (audioRecord.getState() == 1) {
                this.f32333g.stop();
            }
            this.f32333g.release();
            this.f32333g = null;
        }
        this.f32328b.position(0);
        this.f32334h = false;
    }

    public final int a() {
        return this.f32328b.capacity();
    }

    public final void c() {
        if (this.f32331e != null) {
            d();
        }
        this.f32332f = true;
        this.f32331e = new Thread(this);
        this.f32331e.start();
    }

    public final void d() {
        while (this.f32331e != null) {
            this.f32332f = false;
            try {
                this.f32331e.join();
                this.f32331e = null;
            } catch (InterruptedException unused) {
            }
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i10 = 3;
        while (this.f32332f) {
            if (!this.f32334h && i10 > 0) {
                b();
                AudioRecord audioRecord = new AudioRecord(1, this.f32329c, this.f32330d, 2, this.f32328b.capacity());
                this.f32333g = audioRecord;
                boolean z10 = audioRecord.getState() == 1;
                this.f32334h = z10;
                if (z10) {
                    this.f32328b.position(0);
                    this.f32333g.startRecording();
                    i10 = 3;
                } else {
                    Log.e("FMOD", "AudioRecord failed to initialize (status " + this.f32333g.getState() + ")");
                    i10 += -1;
                    b();
                }
            }
            if (this.f32334h && this.f32333g.getRecordingState() == 3) {
                AudioRecord audioRecord2 = this.f32333g;
                ByteBuffer byteBuffer = this.f32328b;
                this.f32327a.fmodProcessMicData(this.f32328b, audioRecord2.read(byteBuffer, byteBuffer.capacity()));
                this.f32328b.position(0);
            }
        }
        b();
    }
}
