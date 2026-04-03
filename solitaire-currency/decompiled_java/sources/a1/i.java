package a1;

import android.annotation.SuppressLint;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import b1.m;
import b1.q;
import b1.v;
import io.sentry.protocol.ViewHierarchyNode;
import java.io.IOException;

/* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
@RequiresApi(api = 28)
public abstract class i<T> implements r0.j<ImageDecoder.Source, T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final v f72a = v.a();

    /* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
    class a implements ImageDecoder.OnHeaderDecodedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ int f73a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ int f74b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f75c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ r0.b f76d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ m f77e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ r0.i f78f;

        /* JADX INFO: renamed from: a1.i$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ImageDecoderResourceDecoder.java */
        class C0002a implements ImageDecoder.OnPartialImageListener {
            C0002a() {
            }

            @Override // android.graphics.ImageDecoder.OnPartialImageListener
            public boolean onPartialImage(@NonNull ImageDecoder.DecodeException decodeException) {
                return false;
            }
        }

        a(int i10, int i11, boolean z10, r0.b bVar, m mVar, r0.i iVar) {
            this.f73a = i10;
            this.f74b = i11;
            this.f75c = z10;
            this.f76d = bVar;
            this.f77e = mVar;
            this.f78f = iVar;
        }

        @Override // android.graphics.ImageDecoder.OnHeaderDecodedListener
        @SuppressLint({"Override"})
        public void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
            boolean z10 = false;
            if (i.this.f72a.c(this.f73a, this.f74b, this.f75c, false)) {
                imageDecoder.setAllocator(3);
            } else {
                imageDecoder.setAllocator(1);
            }
            if (this.f76d == r0.b.PREFER_RGB_565) {
                imageDecoder.setMemorySizePolicy(0);
            }
            imageDecoder.setOnPartialImageListener(new C0002a());
            Size size = imageInfo.getSize();
            int width = this.f73a;
            if (width == Integer.MIN_VALUE) {
                width = size.getWidth();
            }
            int height = this.f74b;
            if (height == Integer.MIN_VALUE) {
                height = size.getHeight();
            }
            float fB = this.f77e.b(size.getWidth(), size.getHeight(), width, height);
            int iRound = Math.round(size.getWidth() * fB);
            int iRound2 = Math.round(size.getHeight() * fB);
            if (Log.isLoggable("ImageDecoder", 2)) {
                Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + ViewHierarchyNode.JsonKeys.X + size.getHeight() + "] to [" + iRound + ViewHierarchyNode.JsonKeys.X + iRound2 + "] scaleFactor: " + fB);
            }
            imageDecoder.setTargetSize(iRound, iRound2);
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < 28) {
                if (i10 >= 26) {
                    imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
                }
            } else {
                if (this.f78f == r0.i.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z10 = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z10 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            }
        }
    }

    protected abstract u0.v<T> c(ImageDecoder.Source source, int i10, int i11, ImageDecoder.OnHeaderDecodedListener onHeaderDecodedListener) throws IOException;

    @Override // r0.j
    @Nullable
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public final u0.v<T> b(@NonNull ImageDecoder.Source source, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        r0.b bVar = (r0.b) hVar.c(q.f1860f);
        m mVar = (m) hVar.c(m.f1855h);
        r0.g<Boolean> gVar = q.f1864j;
        return c(source, i10, i11, new a(i10, i11, hVar.c(gVar) != null && ((Boolean) hVar.c(gVar)).booleanValue(), bVar, mVar, (r0.i) hVar.c(q.f1861g)));
    }

    @Override // r0.j
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final boolean a(@NonNull ImageDecoder.Source source, @NonNull r0.h hVar) {
        return true;
    }
}
