package a4;

import android.media.MediaFormat;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;
import java.util.List;

/* JADX INFO: compiled from: MediaFormatUtil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w {
    public static void a(MediaFormat mediaFormat, String str, @Nullable byte[] bArr) {
        if (bArr != null) {
            mediaFormat.setByteBuffer(str, ByteBuffer.wrap(bArr));
        }
    }

    public static void b(MediaFormat mediaFormat, @Nullable b4.c cVar) {
        if (cVar != null) {
            d(mediaFormat, "color-transfer", cVar.f2087c);
            d(mediaFormat, "color-standard", cVar.f2085a);
            d(mediaFormat, "color-range", cVar.f2086b);
            a(mediaFormat, "hdr-static-info", cVar.f2088d);
        }
    }

    public static void c(MediaFormat mediaFormat, String str, float f10) {
        if (f10 != -1.0f) {
            mediaFormat.setFloat(str, f10);
        }
    }

    public static void d(MediaFormat mediaFormat, String str, int i10) {
        if (i10 != -1) {
            mediaFormat.setInteger(str, i10);
        }
    }

    public static void e(MediaFormat mediaFormat, List<byte[]> list) {
        for (int i10 = 0; i10 < list.size(); i10++) {
            mediaFormat.setByteBuffer("csd-" + i10, ByteBuffer.wrap(list.get(i10)));
        }
    }
}
