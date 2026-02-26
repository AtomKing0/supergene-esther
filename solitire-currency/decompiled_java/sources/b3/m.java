package b3;

import a4.o0;
import android.media.MediaCodec;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

/* JADX INFO: compiled from: MediaCodecDecoderException.java */
/* JADX INFO: loaded from: classes2.dex */
public class m extends n2.f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final n f1998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @Nullable
    public final String f1999b;

    public m(Throwable th, @Nullable n nVar) {
        StringBuilder sb = new StringBuilder();
        sb.append("Decoder failed: ");
        sb.append(nVar == null ? null : nVar.f2000a);
        super(sb.toString(), th);
        this.f1998a = nVar;
        this.f1999b = o0.f214a >= 21 ? a(th) : null;
    }

    @Nullable
    @RequiresApi(21)
    private static String a(Throwable th) {
        if (th instanceof MediaCodec.CodecException) {
            return ((MediaCodec.CodecException) th).getDiagnosticInfo();
        }
        return null;
    }
}
