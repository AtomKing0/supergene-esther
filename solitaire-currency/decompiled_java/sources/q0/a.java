package q0;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: GifDecoder.java */
/* JADX INFO: loaded from: classes2.dex */
public interface a {

    /* JADX INFO: renamed from: q0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GifDecoder.java */
    public interface InterfaceC0656a {
        void a(@NonNull Bitmap bitmap);

        @NonNull
        byte[] b(int i10);

        @NonNull
        Bitmap c(int i10, int i11, @NonNull Bitmap.Config config);

        @NonNull
        int[] d(int i10);

        void e(@NonNull byte[] bArr);

        void f(@NonNull int[] iArr);
    }

    @Nullable
    Bitmap a();

    void b();

    int c();

    void clear();

    void d(@NonNull Bitmap.Config config);

    int e();

    void f();

    int g();

    @NonNull
    ByteBuffer getData();

    int h();
}
