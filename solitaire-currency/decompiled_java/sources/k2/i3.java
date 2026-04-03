package k2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: StreamVolumeManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class i3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29157a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f29158b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f29159c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final AudioManager f29160d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    @Nullable
    private c f29161e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29162f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f29163g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f29164h;

    /* JADX INFO: compiled from: StreamVolumeManager.java */
    public interface b {
        void onStreamTypeChanged(int i10);

        void onStreamVolumeChanged(int i10, boolean z10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: StreamVolumeManager.java */
    final class c extends BroadcastReceiver {
        private c() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Handler handler = i3.this.f29158b;
            final i3 i3Var = i3.this;
            handler.post(new Runnable() { // from class: k2.j3
                @Override // java.lang.Runnable
                public final void run() {
                    i3.b(i3Var);
                }
            });
        }
    }

    public i3(Context context, Handler handler, b bVar) {
        Context applicationContext = context.getApplicationContext();
        this.f29157a = applicationContext;
        this.f29158b = handler;
        this.f29159c = bVar;
        AudioManager audioManager = (AudioManager) a4.a.i((AudioManager) applicationContext.getSystemService("audio"));
        this.f29160d = audioManager;
        this.f29162f = 3;
        this.f29163g = f(audioManager, 3);
        this.f29164h = e(audioManager, this.f29162f);
        c cVar = new c();
        try {
            a4.o0.E0(applicationContext, cVar, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f29161e = cVar;
        } catch (RuntimeException e10) {
            a4.t.j("StreamVolumeManager", "Error registering stream volume receiver", e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static /* synthetic */ void b(i3 i3Var) {
        i3Var.i();
    }

    private static boolean e(AudioManager audioManager, int i10) {
        return a4.o0.f214a >= 23 ? audioManager.isStreamMute(i10) : f(audioManager, i10) == 0;
    }

    private static int f(AudioManager audioManager, int i10) {
        try {
            return audioManager.getStreamVolume(i10);
        } catch (RuntimeException e10) {
            a4.t.j("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i10, e10);
            return audioManager.getStreamMaxVolume(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        int iF = f(this.f29160d, this.f29162f);
        boolean zE = e(this.f29160d, this.f29162f);
        if (this.f29163g == iF && this.f29164h == zE) {
            return;
        }
        this.f29163g = iF;
        this.f29164h = zE;
        this.f29159c.onStreamVolumeChanged(iF, zE);
    }

    public int c() {
        return this.f29160d.getStreamMaxVolume(this.f29162f);
    }

    public int d() {
        if (a4.o0.f214a >= 28) {
            return this.f29160d.getStreamMinVolume(this.f29162f);
        }
        return 0;
    }

    public void g() {
        c cVar = this.f29161e;
        if (cVar != null) {
            try {
                this.f29157a.unregisterReceiver(cVar);
            } catch (RuntimeException e10) {
                a4.t.j("StreamVolumeManager", "Error unregistering stream volume receiver", e10);
            }
            this.f29161e = null;
        }
    }

    public void h(int i10) {
        if (this.f29162f == i10) {
            return;
        }
        this.f29162f = i10;
        i();
        this.f29159c.onStreamTypeChanged(i10);
    }
}
