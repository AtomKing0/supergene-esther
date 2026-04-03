package y0;

import android.content.ContentResolver;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.ironsource.v8;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import y0.n;

/* JADX INFO: compiled from: UriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class w<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Set<String> f36339b = Collections.unmodifiableSet(new HashSet(Arrays.asList(v8.h.f15781b, "android.resource", "content")));

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final c<Data> f36340a;

    /* JADX INFO: compiled from: UriLoader.java */
    public static final class a implements o<Uri, AssetFileDescriptor>, c<AssetFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f36341a;

        public a(ContentResolver contentResolver) {
            this.f36341a = contentResolver;
        }

        @Override // y0.w.c
        public s0.d<AssetFileDescriptor> a(Uri uri) {
            return new s0.a(this.f36341a, uri);
        }

        @Override // y0.o
        public n<Uri, AssetFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, c<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f36342a;

        public b(ContentResolver contentResolver) {
            this.f36342a = contentResolver;
        }

        @Override // y0.w.c
        public s0.d<ParcelFileDescriptor> a(Uri uri) {
            return new s0.i(this.f36342a, uri);
        }

        @Override // y0.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new w(this);
        }
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public interface c<Data> {
        s0.d<Data> a(Uri uri);
    }

    /* JADX INFO: compiled from: UriLoader.java */
    public static class d implements o<Uri, InputStream>, c<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f36343a;

        public d(ContentResolver contentResolver) {
            this.f36343a = contentResolver;
        }

        @Override // y0.w.c
        public s0.d<InputStream> a(Uri uri) {
            return new s0.n(this.f36343a, uri);
        }

        @Override // y0.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new w(this);
        }
    }

    public w(c<Data> cVar) {
        this.f36340a = cVar;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(uri), this.f36340a.a(uri));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return f36339b.contains(uri.getScheme());
    }
}
