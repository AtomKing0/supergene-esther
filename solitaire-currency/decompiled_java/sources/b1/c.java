package b1;

import android.graphics.Bitmap;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* JADX INFO: compiled from: BitmapEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements r0.k<Bitmap> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r0.g<Integer> f1824b = r0.g.f("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionQuality", 90);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final r0.g<Bitmap.CompressFormat> f1825c = r0.g.e("com.bumptech.glide.load.resource.bitmap.BitmapEncoder.CompressionFormat");

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final v0.b f1826a;

    public c(@NonNull v0.b bVar) {
        this.f1826a = bVar;
    }

    private Bitmap.CompressFormat d(Bitmap bitmap, r0.h hVar) {
        Bitmap.CompressFormat compressFormat = (Bitmap.CompressFormat) hVar.c(f1825c);
        return compressFormat != null ? compressFormat : bitmap.hasAlpha() ? Bitmap.CompressFormat.PNG : Bitmap.CompressFormat.JPEG;
    }

    @Override // r0.k
    @NonNull
    public r0.c b(@NonNull r0.h hVar) {
        return r0.c.TRANSFORMED;
    }

    @Override // r0.d
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull u0.v<Bitmap> vVar, @NonNull File file, @NonNull r0.h hVar) {
        boolean z10;
        FileOutputStream fileOutputStream;
        Bitmap bitmap = vVar.get();
        Bitmap.CompressFormat compressFormatD = d(bitmap, hVar);
        p1.b.c("encode: [%dx%d] %s", Integer.valueOf(bitmap.getWidth()), Integer.valueOf(bitmap.getHeight()), compressFormatD);
        try {
            long jB = o1.f.b();
            int iIntValue = ((Integer) hVar.c(f1824b)).intValue();
            OutputStream cVar = null;
            try {
                try {
                    fileOutputStream = new FileOutputStream(file);
                } catch (IOException e10) {
                    e = e10;
                }
            } catch (Throwable th) {
                th = th;
            }
            try {
                cVar = this.f1826a != null ? new s0.c(fileOutputStream, this.f1826a) : fileOutputStream;
                bitmap.compress(compressFormatD, iIntValue, cVar);
                cVar.close();
                try {
                    cVar.close();
                } catch (IOException unused) {
                }
                z10 = true;
            } catch (IOException e11) {
                e = e11;
                cVar = fileOutputStream;
                if (Log.isLoggable("BitmapEncoder", 3)) {
                    Log.d("BitmapEncoder", "Failed to encode Bitmap", e);
                }
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused2) {
                    }
                }
                z10 = false;
            } catch (Throwable th2) {
                th = th2;
                cVar = fileOutputStream;
                if (cVar != null) {
                    try {
                        cVar.close();
                    } catch (IOException unused3) {
                    }
                }
                throw th;
            }
            if (Log.isLoggable("BitmapEncoder", 2)) {
                Log.v("BitmapEncoder", "Compressed with type: " + compressFormatD + " of size " + o1.k.g(bitmap) + " in " + o1.f.a(jB) + ", options format: " + hVar.c(f1825c) + ", hasAlpha: " + bitmap.hasAlpha());
            }
            return z10;
        } finally {
            p1.b.d();
        }
    }
}
