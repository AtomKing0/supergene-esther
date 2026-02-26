package f1;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.load.ImageHeaderParser;
import com.ironsource.v8;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.List;
import java.util.Queue;
import o1.k;
import q0.a;

/* JADX INFO: compiled from: ByteBufferGifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class a implements r0.j<ByteBuffer, c> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final C0551a f25534f = new C0551a();

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final b f25535g = new b();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f25536a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List<ImageHeaderParser> f25537b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final b f25538c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final C0551a f25539d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final f1.b f25540e;

    /* JADX INFO: renamed from: f1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    static class C0551a {
        C0551a() {
        }

        q0.a a(a.InterfaceC0656a interfaceC0656a, q0.c cVar, ByteBuffer byteBuffer, int i10) {
            return new q0.e(interfaceC0656a, cVar, byteBuffer, i10);
        }
    }

    /* JADX INFO: compiled from: ByteBufferGifDecoder.java */
    @VisibleForTesting
    static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<q0.d> f25541a = k.e(0);

        b() {
        }

        synchronized q0.d a(ByteBuffer byteBuffer) {
            q0.d dVarPoll;
            dVarPoll = this.f25541a.poll();
            if (dVarPoll == null) {
                dVarPoll = new q0.d();
            }
            return dVarPoll.p(byteBuffer);
        }

        synchronized void b(q0.d dVar) {
            dVar.a();
            this.f25541a.offer(dVar);
        }
    }

    public a(Context context, List<ImageHeaderParser> list, v0.d dVar, v0.b bVar) {
        this(context, list, dVar, bVar, f25535g, f25534f);
    }

    @Nullable
    private e c(ByteBuffer byteBuffer, int i10, int i11, q0.d dVar, r0.h hVar) {
        long jB = o1.f.b();
        try {
            q0.c cVarC = dVar.c();
            if (cVarC.b() > 0 && cVarC.c() == 0) {
                Bitmap.Config config = hVar.c(i.f25581a) == r0.b.PREFER_RGB_565 ? Bitmap.Config.RGB_565 : Bitmap.Config.ARGB_8888;
                q0.a aVarA = this.f25539d.a(this.f25540e, cVarC, byteBuffer, e(cVarC, i10, i11));
                aVarA.d(config);
                aVarA.b();
                Bitmap bitmapA = aVarA.a();
                if (bitmapA == null) {
                    return null;
                }
                e eVar = new e(new c(this.f25536a, aVarA, a1.k.c(), i10, i11, bitmapA));
                if (Log.isLoggable("BufferGifDecoder", 2)) {
                    Log.v("BufferGifDecoder", "Decoded GIF from stream in " + o1.f.a(jB));
                }
                return eVar;
            }
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + o1.f.a(jB));
            }
            return null;
        } finally {
            if (Log.isLoggable("BufferGifDecoder", 2)) {
                Log.v("BufferGifDecoder", "Decoded GIF from stream in " + o1.f.a(jB));
            }
        }
    }

    private static int e(q0.c cVar, int i10, int i11) {
        int iMin = Math.min(cVar.a() / i11, cVar.d() / i10);
        int iMax = Math.max(1, iMin == 0 ? 0 : Integer.highestOneBit(iMin));
        if (Log.isLoggable("BufferGifDecoder", 2) && iMax > 1) {
            Log.v("BufferGifDecoder", "Downsampling GIF, sampleSize: " + iMax + ", target dimens: [" + i10 + ViewHierarchyNode.JsonKeys.X + i11 + "], actual dimens: [" + cVar.d() + ViewHierarchyNode.JsonKeys.X + cVar.a() + v8.i.f15839e);
        }
        return iMax;
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public e b(@NonNull ByteBuffer byteBuffer, int i10, int i11, @NonNull r0.h hVar) {
        q0.d dVarA = this.f25538c.a(byteBuffer);
        try {
            return c(byteBuffer, i10, i11, dVarA, hVar);
        } finally {
            this.f25538c.b(dVarA);
        }
    }

    @Override // r0.j
    /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull ByteBuffer byteBuffer, @NonNull r0.h hVar) throws IOException {
        return !((Boolean) hVar.c(i.f25582b)).booleanValue() && com.bumptech.glide.load.a.c(this.f25537b, byteBuffer) == ImageHeaderParser.ImageType.GIF;
    }

    @VisibleForTesting
    a(Context context, List<ImageHeaderParser> list, v0.d dVar, v0.b bVar, b bVar2, C0551a c0551a) {
        this.f25536a = context.getApplicationContext();
        this.f25537b = list;
        this.f25539d = c0551a;
        this.f25540e = new f1.b(dVar, bVar);
        this.f25538c = bVar2;
    }
}
