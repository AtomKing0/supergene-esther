package b4;

import android.view.Surface;
import androidx.annotation.Nullable;

/* JADX INFO: compiled from: MediaCodecVideoDecoderException.java */
/* JADX INFO: loaded from: classes2.dex */
public class g extends b3.m {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f2113c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f2114d;

    public g(Throwable th, @Nullable b3.n nVar, @Nullable Surface surface) {
        super(th, nVar);
        this.f2113c = System.identityHashCode(surface);
        this.f2114d = surface == null || surface.isValid();
    }
}
