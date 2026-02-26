package k2;

import android.content.Context;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: AudioFocusManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AudioManager f29050a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final a f29051b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @Nullable
    private b f29052c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    @Nullable
    private m2.e f29053d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f29055f;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private AudioFocusRequest f29057h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f29058i;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f29056g = 1.0f;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f29054e = 0;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: AudioFocusManager.java */
    class a implements AudioManager.OnAudioFocusChangeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Handler f29059a;

        public a(Handler handler) {
            this.f29059a = handler;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public /* synthetic */ void b(int i10) {
            d.this.h(i10);
        }

        @Override // android.media.AudioManager.OnAudioFocusChangeListener
        public void onAudioFocusChange(final int i10) {
            this.f29059a.post(new Runnable() { // from class: k2.c
                @Override // java.lang.Runnable
                public final void run() {
                    this.f29029a.b(i10);
                }
            });
        }
    }

    /* JADX INFO: compiled from: AudioFocusManager.java */
    public interface b {
        void executePlayerCommand(int i10);

        void setVolumeMultiplier(float f10);
    }

    public d(Context context, Handler handler, b bVar) {
        this.f29050a = (AudioManager) a4.a.e((AudioManager) context.getApplicationContext().getSystemService("audio"));
        this.f29052c = bVar;
        this.f29051b = new a(handler);
    }

    private void a() {
        this.f29050a.abandonAudioFocus(this.f29051b);
    }

    private void b() {
        if (this.f29054e == 0) {
            return;
        }
        if (a4.o0.f214a >= 26) {
            c();
        } else {
            a();
        }
        n(0);
    }

    @RequiresApi(26)
    private void c() {
        AudioFocusRequest audioFocusRequest = this.f29057h;
        if (audioFocusRequest != null) {
            this.f29050a.abandonAudioFocusRequest(audioFocusRequest);
        }
    }

    private static int e(@Nullable m2.e eVar) {
        if (eVar == null) {
            return 0;
        }
        switch (eVar.f31253c) {
            case 0:
                a4.t.i("AudioFocusManager", "Specify a proper usage in the audio attributes for audio focus handling. Using AUDIOFOCUS_GAIN by default.");
                return 1;
            case 1:
            case 14:
                return 1;
            case 2:
            case 4:
                return 2;
            case 3:
                return 0;
            case 11:
                if (eVar.f31251a == 1) {
                    return 2;
                }
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 12:
            case 13:
                return 3;
            case 15:
            default:
                a4.t.i("AudioFocusManager", "Unidentified audio usage: " + eVar.f31253c);
                return 0;
            case 16:
                return a4.o0.f214a >= 19 ? 4 : 2;
        }
    }

    private void f(int i10) {
        b bVar = this.f29052c;
        if (bVar != null) {
            bVar.executePlayerCommand(i10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h(int i10) {
        if (i10 == -3 || i10 == -2) {
            if (i10 != -2 && !q()) {
                n(3);
                return;
            } else {
                f(0);
                n(2);
                return;
            }
        }
        if (i10 == -1) {
            f(-1);
            b();
        } else if (i10 == 1) {
            n(1);
            f(1);
        } else {
            a4.t.i("AudioFocusManager", "Unknown focus change type: " + i10);
        }
    }

    private int j() {
        if (this.f29054e == 1) {
            return 1;
        }
        if ((a4.o0.f214a >= 26 ? l() : k()) == 1) {
            n(1);
            return 1;
        }
        n(0);
        return -1;
    }

    private int k() {
        return this.f29050a.requestAudioFocus(this.f29051b, a4.o0.a0(((m2.e) a4.a.e(this.f29053d)).f31253c), this.f29055f);
    }

    @RequiresApi(26)
    private int l() {
        AudioFocusRequest audioFocusRequest = this.f29057h;
        if (audioFocusRequest == null || this.f29058i) {
            this.f29057h = (audioFocusRequest == null ? new AudioFocusRequest.Builder(this.f29055f) : new AudioFocusRequest.Builder(this.f29057h)).setAudioAttributes(((m2.e) a4.a.e(this.f29053d)).b().f31257a).setWillPauseWhenDucked(q()).setOnAudioFocusChangeListener(this.f29051b).build();
            this.f29058i = false;
        }
        return this.f29050a.requestAudioFocus(this.f29057h);
    }

    private void n(int i10) {
        if (this.f29054e == i10) {
            return;
        }
        this.f29054e = i10;
        float f10 = i10 == 3 ? 0.2f : 1.0f;
        if (this.f29056g == f10) {
            return;
        }
        this.f29056g = f10;
        b bVar = this.f29052c;
        if (bVar != null) {
            bVar.setVolumeMultiplier(f10);
        }
    }

    private boolean o(int i10) {
        return i10 == 1 || this.f29055f != 1;
    }

    private boolean q() {
        m2.e eVar = this.f29053d;
        return eVar != null && eVar.f31251a == 1;
    }

    public float g() {
        return this.f29056g;
    }

    public void i() {
        this.f29052c = null;
        b();
    }

    public void m(@Nullable m2.e eVar) {
        if (a4.o0.c(this.f29053d, eVar)) {
            return;
        }
        this.f29053d = eVar;
        int iE = e(eVar);
        this.f29055f = iE;
        boolean z10 = true;
        if (iE != 1 && iE != 0) {
            z10 = false;
        }
        a4.a.b(z10, "Automatic handling of audio focus is only available for USAGE_MEDIA and USAGE_GAME.");
    }

    public int p(boolean z10, int i10) {
        if (o(i10)) {
            b();
            return z10 ? 1 : -1;
        }
        if (z10) {
            return j();
        }
        return -1;
    }
}
