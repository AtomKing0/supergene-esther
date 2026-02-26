package y0;

import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: ByteArrayLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class b<Data> implements n<byte[], Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final InterfaceC0736b<Data> f36258a;

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class a implements o<byte[], ByteBuffer> {

        /* JADX INFO: renamed from: y0.b$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ByteArrayLoader.java */
        class C0735a implements InterfaceC0736b<ByteBuffer> {
            C0735a() {
            }

            @Override // y0.b.InterfaceC0736b
            public Class<ByteBuffer> a() {
                return ByteBuffer.class;
            }

            @Override // y0.b.InterfaceC0736b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public ByteBuffer b(byte[] bArr) {
                return ByteBuffer.wrap(bArr);
            }
        }

        @Override // y0.o
        @NonNull
        public n<byte[], ByteBuffer> b(@NonNull r rVar) {
            return new b(new C0735a());
        }
    }

    /* JADX INFO: renamed from: y0.b$b, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public interface InterfaceC0736b<Data> {
        Class<Data> a();

        Data b(byte[] bArr);
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    public static class d implements o<byte[], InputStream> {

        /* JADX INFO: compiled from: ByteArrayLoader.java */
        class a implements InterfaceC0736b<InputStream> {
            a() {
            }

            @Override // y0.b.InterfaceC0736b
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // y0.b.InterfaceC0736b
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public InputStream b(byte[] bArr) {
                return new ByteArrayInputStream(bArr);
            }
        }

        @Override // y0.o
        @NonNull
        public n<byte[], InputStream> b(@NonNull r rVar) {
            return new b(new a());
        }
    }

    public b(InterfaceC0736b<Data> interfaceC0736b) {
        this.f36258a = interfaceC0736b;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull byte[] bArr, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(bArr), new c(bArr, this.f36258a));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull byte[] bArr) {
        return true;
    }

    /* JADX INFO: compiled from: ByteArrayLoader.java */
    private static class c<Data> implements s0.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final byte[] f36260a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final InterfaceC0736b<Data> f36261b;

        c(byte[] bArr, InterfaceC0736b<Data> interfaceC0736b) {
            this.f36260a = bArr;
            this.f36261b = interfaceC0736b;
        }

        @Override // s0.d
        @NonNull
        public Class<Data> a() {
            return this.f36261b.a();
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return r0.a.LOCAL;
        }

        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super Data> aVar) {
            aVar.f(this.f36261b.b(this.f36260a));
        }

        @Override // s0.d
        public void b() {
        }

        @Override // s0.d
        public void cancel() {
        }
    }
}
