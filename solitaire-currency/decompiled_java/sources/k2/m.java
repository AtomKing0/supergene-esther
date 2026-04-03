package k2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import androidx.annotation.Nullable;
import b3.l;
import java.util.ArrayList;
import m2.c0;

/* JADX INFO: compiled from: DefaultRenderersFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public class m implements e3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f29279a;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f29283e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f29285g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f29286h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private boolean f29287i;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final b3.j f29280b = new b3.j();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f29281c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f29282d = 5000;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private b3.q f29284f = b3.q.f2055a;

    public m(Context context) {
        this.f29279a = context;
    }

    @Override // k2.e3
    public a3[] a(Handler handler, b4.z zVar, m2.t tVar, n3.p pVar, c3.f fVar) {
        ArrayList<a3> arrayList = new ArrayList<>();
        h(this.f29279a, this.f29281c, this.f29284f, this.f29283e, handler, zVar, this.f29282d, arrayList);
        m2.v vVarC = c(this.f29279a, this.f29285g, this.f29286h, this.f29287i);
        if (vVarC != null) {
            b(this.f29279a, this.f29281c, this.f29284f, this.f29283e, vVarC, handler, tVar, arrayList);
        }
        g(this.f29279a, pVar, handler.getLooper(), this.f29281c, arrayList);
        e(this.f29279a, fVar, handler.getLooper(), this.f29281c, arrayList);
        d(this.f29279a, this.f29281c, arrayList);
        f(this.f29279a, handler, this.f29281c, arrayList);
        return (a3[]) arrayList.toArray(new a3[0]);
    }

    protected void b(Context context, int i10, b3.q qVar, boolean z10, m2.v vVar, Handler handler, m2.t tVar, ArrayList<a3> arrayList) {
        int i11;
        int i12;
        int i13;
        arrayList.add(new m2.g0(context, i(), qVar, z10, handler, tVar, vVar));
        if (i10 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i10 == 2) {
            size--;
        }
        try {
            try {
                i11 = size + 1;
                try {
                    arrayList.add(size, (a3) Class.forName("com.google.android.exoplayer2.decoder.midi.MidiRenderer").getConstructor(new Class[0]).newInstance(new Object[0]));
                    a4.t.f("DefaultRenderersFactory", "Loaded MidiRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i11;
                    i11 = size;
                }
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating MIDI extension", e10);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            try {
                i12 = i11 + 1;
            } catch (Exception e11) {
                throw new RuntimeException("Error instantiating Opus extension", e11);
            }
        } catch (ClassNotFoundException unused3) {
        }
        try {
            arrayList.add(i11, (a3) Class.forName("com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer").getConstructor(Handler.class, m2.t.class, m2.v.class).newInstance(handler, tVar, vVar));
            a4.t.f("DefaultRenderersFactory", "Loaded LibopusAudioRenderer.");
        } catch (ClassNotFoundException unused4) {
            i11 = i12;
            i12 = i11;
        }
        try {
            try {
                i13 = i12 + 1;
                try {
                    arrayList.add(i12, (a3) Class.forName("com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer").getConstructor(Handler.class, m2.t.class, m2.v.class).newInstance(handler, tVar, vVar));
                    a4.t.f("DefaultRenderersFactory", "Loaded LibflacAudioRenderer.");
                } catch (ClassNotFoundException unused5) {
                    i12 = i13;
                    i13 = i12;
                }
            } catch (Exception e12) {
                throw new RuntimeException("Error instantiating FLAC extension", e12);
            }
        } catch (ClassNotFoundException unused6) {
        }
        try {
            arrayList.add(i13, (a3) Class.forName("com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer").getConstructor(Handler.class, m2.t.class, m2.v.class).newInstance(handler, tVar, vVar));
            a4.t.f("DefaultRenderersFactory", "Loaded FfmpegAudioRenderer.");
        } catch (ClassNotFoundException unused7) {
        } catch (Exception e13) {
            throw new RuntimeException("Error instantiating FFmpeg extension", e13);
        }
    }

    @Nullable
    protected m2.v c(Context context, boolean z10, boolean z11, boolean z12) {
        return new c0.f().g(m2.f.c(context)).i(z10).h(z11).j(z12 ? 1 : 0).f();
    }

    protected void d(Context context, int i10, ArrayList<a3> arrayList) {
        arrayList.add(new c4.b());
    }

    protected void e(Context context, c3.f fVar, Looper looper, int i10, ArrayList<a3> arrayList) {
        arrayList.add(new c3.g(fVar, looper));
    }

    protected void g(Context context, n3.p pVar, Looper looper, int i10, ArrayList<a3> arrayList) {
        arrayList.add(new n3.q(pVar, looper));
    }

    protected void h(Context context, int i10, b3.q qVar, boolean z10, Handler handler, b4.z zVar, long j10, ArrayList<a3> arrayList) {
        int i11;
        arrayList.add(new b4.h(context, i(), qVar, j10, z10, handler, zVar, 50));
        if (i10 == 0) {
            return;
        }
        int size = arrayList.size();
        if (i10 == 2) {
            size--;
        }
        try {
            try {
                i11 = size + 1;
                try {
                    arrayList.add(size, (a3) Class.forName("com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer").getConstructor(Long.TYPE, Handler.class, b4.z.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, zVar, 50));
                    a4.t.f("DefaultRenderersFactory", "Loaded LibvpxVideoRenderer.");
                } catch (ClassNotFoundException unused) {
                    size = i11;
                    i11 = size;
                }
            } catch (Exception e10) {
                throw new RuntimeException("Error instantiating VP9 extension", e10);
            }
        } catch (ClassNotFoundException unused2) {
        }
        try {
            arrayList.add(i11, (a3) Class.forName("com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer").getConstructor(Long.TYPE, Handler.class, b4.z.class, Integer.TYPE).newInstance(Long.valueOf(j10), handler, zVar, 50));
            a4.t.f("DefaultRenderersFactory", "Loaded Libgav1VideoRenderer.");
        } catch (ClassNotFoundException unused3) {
        } catch (Exception e11) {
            throw new RuntimeException("Error instantiating AV1 extension", e11);
        }
    }

    protected l.b i() {
        return this.f29280b;
    }

    protected void f(Context context, Handler handler, int i10, ArrayList<a3> arrayList) {
    }
}
