package f1;

import android.util.Log;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.List;
import u0.v;

/* JADX INFO: compiled from: StreamGifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public class j implements r0.j<InputStream, c> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final List<ImageHeaderParser> f25583a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final r0.j<ByteBuffer, c> f25584b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v0.b f25585c;

    public j(List<ImageHeaderParser> list, r0.j<ByteBuffer, c> jVar, v0.b bVar) {
        this.f25583a = list;
        this.f25584b = jVar;
        this.f25585c = bVar;
    }

    private static byte[] e(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        try {
            byte[] bArr = new byte[16384];
            while (true) {
                int i10 = inputStream.read(bArr);
                if (i10 == -1) {
                    byteArrayOutputStream.flush();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr, 0, i10);
            }
        } catch (IOException e10) {
            if (!Log.isLoggable("StreamGifDecoder", 5)) {
                return null;
            }
            Log.w("StreamGifDecoder", "Error reading data from stream", e10);
            return null;
        }
    }

    @Override // r0.j
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public v<c> b(@NonNull InputStream inputStream, int i10, int i11, @NonNull r0.h hVar) throws IOException {
        byte[] bArrE = e(inputStream);
        if (bArrE == null) {
            return null;
        }
        return this.f25584b.b(ByteBuffer.wrap(bArrE), i10, i11, hVar);
    }

    @Override // r0.j
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull InputStream inputStream, @NonNull r0.h hVar) throws IOException {
        return !((Boolean) hVar.c(i.f25582b)).booleanValue() && com.bumptech.glide.load.a.b(this.f25583a, inputStream, this.f25585c) == ImageHeaderParser.ImageType.GIF;
    }
}
