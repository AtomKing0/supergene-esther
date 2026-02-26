package y0;

import android.util.Base64;
import androidx.annotation.NonNull;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: DataUrlLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<Model, Data> implements n<Model, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a<Data> f36264a;

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public interface a<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(String str) throws IllegalArgumentException;
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    public static final class c<Model> implements o<Model, InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final a<InputStream> f36268a = new a();

        /* JADX INFO: compiled from: DataUrlLoader.java */
        class a implements a<InputStream> {
            a() {
            }

            @Override // y0.e.a
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // y0.e.a
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // y0.e.a
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(String str) {
                if (!str.startsWith("data:image")) {
                    throw new IllegalArgumentException("Not a valid image data URL.");
                }
                int iIndexOf = str.indexOf(44);
                if (iIndexOf == -1) {
                    throw new IllegalArgumentException("Missing comma in data URL.");
                }
                if (str.substring(0, iIndexOf).endsWith(";base64")) {
                    return new ByteArrayInputStream(Base64.decode(str.substring(iIndexOf + 1), 0));
                }
                throw new IllegalArgumentException("Not a base64 image data URL.");
            }
        }

        @Override // y0.o
        @NonNull
        public n<Model, InputStream> b(@NonNull r rVar) {
            return new e(this.f36268a);
        }
    }

    public e(a<Data> aVar) {
        this.f36264a = aVar;
    }

    @Override // y0.n
    public boolean a(@NonNull Model model) {
        return model.toString().startsWith("data:image");
    }

    @Override // y0.n
    public n.a<Data> b(@NonNull Model model, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(model), new b(model.toString(), this.f36264a));
    }

    /* JADX INFO: compiled from: DataUrlLoader.java */
    private static final class b<Data> implements s0.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final String f36265a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final a<Data> f36266b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f36267c;

        b(String str, a<Data> aVar) {
            this.f36265a = str;
            this.f36266b = aVar;
        }

        @Override // s0.d
        @NonNull
        public Class<Data> a() {
            return this.f36266b.a();
        }

        @Override // s0.d
        public void b() {
            try {
                this.f36266b.b(this.f36267c);
            } catch (IOException unused) {
            }
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return r0.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r2v3, types: [Data, java.lang.Object] */
        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super Data> aVar) {
            try {
                Data dataC = this.f36266b.c(this.f36265a);
                this.f36267c = dataC;
                aVar.f(dataC);
            } catch (IllegalArgumentException e10) {
                aVar.c(e10);
            }
        }

        @Override // s0.d
        public void cancel() {
        }
    }
}
