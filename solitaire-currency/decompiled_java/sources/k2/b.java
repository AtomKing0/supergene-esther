package k2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f28970a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f28971b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f28972c;

    /* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
    private final class a extends BroadcastReceiver implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final InterfaceC0600b f28973a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Handler f28974b;

        public a(Handler handler, InterfaceC0600b interfaceC0600b) {
            this.f28974b = handler;
            this.f28973a = interfaceC0600b;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f28974b.post(this);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (b.this.f28972c) {
                this.f28973a.onAudioBecomingNoisy();
            }
        }
    }

    /* JADX INFO: renamed from: k2.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AudioBecomingNoisyManager.java */
    public interface InterfaceC0600b {
        void onAudioBecomingNoisy();
    }

    public b(Context context, Handler handler, InterfaceC0600b interfaceC0600b) {
        this.f28970a = context.getApplicationContext();
        this.f28971b = new a(handler, interfaceC0600b);
    }

    public void b(boolean z10) {
        if (z10 && !this.f28972c) {
            a4.o0.E0(this.f28970a, this.f28971b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            this.f28972c = true;
        } else {
            if (z10 || !this.f28972c) {
                return;
            }
            this.f28970a.unregisterReceiver(this.f28971b);
            this.f28972c = false;
        }
    }
}
