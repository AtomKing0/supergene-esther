package y0;

import android.os.ParcelFileDescriptor;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: FileLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class f<Data> implements n<File, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final d<Data> f36270a;

    /* JADX INFO: compiled from: FileLoader.java */
    public static class a<Data> implements o<File, Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final d<Data> f36271a;

        public a(d<Data> dVar) {
            this.f36271a = dVar;
        }

        @Override // y0.o
        @NonNull
        public final n<File, Data> b(@NonNull r rVar) {
            return new f(this.f36271a);
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class b extends a<ParcelFileDescriptor> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<ParcelFileDescriptor> {
            a() {
            }

            @Override // y0.f.d
            public Class<ParcelFileDescriptor> a() {
                return ParcelFileDescriptor.class;
            }

            @Override // y0.f.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
                parcelFileDescriptor.close();
            }

            @Override // y0.f.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public ParcelFileDescriptor c(File file) throws FileNotFoundException {
                return ParcelFileDescriptor.open(file, 268435456);
            }
        }

        public b() {
            super(new a());
        }
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public interface d<Data> {
        Class<Data> a();

        void b(Data data) throws IOException;

        Data c(File file) throws FileNotFoundException;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    public static class e extends a<InputStream> {

        /* JADX INFO: compiled from: FileLoader.java */
        class a implements d<InputStream> {
            a() {
            }

            @Override // y0.f.d
            public Class<InputStream> a() {
                return InputStream.class;
            }

            @Override // y0.f.d
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public void b(InputStream inputStream) throws IOException {
                inputStream.close();
            }

            @Override // y0.f.d
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public InputStream c(File file) throws FileNotFoundException {
                return new FileInputStream(file);
            }
        }

        public e() {
            super(new a());
        }
    }

    public f(d<Data> dVar) {
        this.f36270a = dVar;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull File file, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(file), new c(file, this.f36270a));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull File file) {
        return true;
    }

    /* JADX INFO: compiled from: FileLoader.java */
    private static final class c<Data> implements s0.d<Data> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final File f36272a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final d<Data> f36273b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private Data f36274c;

        c(File file, d<Data> dVar) {
            this.f36272a = file;
            this.f36273b = dVar;
        }

        @Override // s0.d
        @NonNull
        public Class<Data> a() {
            return this.f36273b.a();
        }

        @Override // s0.d
        public void b() {
            Data data = this.f36274c;
            if (data != null) {
                try {
                    this.f36273b.b(data);
                } catch (IOException unused) {
                }
            }
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return r0.a.LOCAL;
        }

        /* JADX WARN: Type inference failed for: r3v3, types: [Data, java.lang.Object] */
        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super Data> aVar) {
            try {
                Data dataC = this.f36273b.c(this.f36272a);
                this.f36274c = dataC;
                aVar.f(dataC);
            } catch (FileNotFoundException e10) {
                if (Log.isLoggable("FileLoader", 3)) {
                    Log.d("FileLoader", "Failed to open file", e10);
                }
                aVar.c(e10);
            }
        }

        @Override // s0.d
        public void cancel() {
        }
    }
}
