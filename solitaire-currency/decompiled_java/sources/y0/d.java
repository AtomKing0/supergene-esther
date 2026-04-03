package y0;

import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: ByteBufferFileLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements n<File, ByteBuffer> {

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    public static class b implements o<File, ByteBuffer> {
        @Override // y0.o
        @NonNull
        public n<File, ByteBuffer> b(@NonNull r rVar) {
            return new d();
        }
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<ByteBuffer> b(@NonNull File file, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(file), new a(file));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull File file) {
        return true;
    }

    /* JADX INFO: compiled from: ByteBufferFileLoader.java */
    private static final class a implements s0.d<ByteBuffer> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f36263a;

        a(File file) {
            this.f36263a = file;
        }

        @Override // s0.d
        @NonNull
        public Class<ByteBuffer> a() {
            return ByteBuffer.class;
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return r0.a.LOCAL;
        }

        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super ByteBuffer> aVar) {
            try {
                aVar.f(o1.a.a(this.f36263a));
            } catch (IOException e10) {
                if (Log.isLoggable("ByteBufferFileLoader", 3)) {
                    Log.d("ByteBufferFileLoader", "Failed to obtain ByteBuffer for file", e10);
                }
                aVar.c(e10);
            }
        }

        @Override // s0.d
        public void b() {
        }

        @Override // s0.d
        public void cancel() {
        }
    }
}
