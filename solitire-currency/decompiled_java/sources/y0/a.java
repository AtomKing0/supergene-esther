package y0;

import android.content.res.AssetManager;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.ironsource.v8;
import java.io.InputStream;
import y0.n;

/* JADX INFO: compiled from: AssetUriLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class a<Data> implements n<Uri, Data> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f36253c = 22;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AssetManager f36254a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final InterfaceC0734a<Data> f36255b;

    /* JADX INFO: renamed from: y0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AssetUriLoader.java */
    public interface InterfaceC0734a<Data> {
        s0.d<Data> a(AssetManager assetManager, String str);
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class b implements o<Uri, ParcelFileDescriptor>, InterfaceC0734a<ParcelFileDescriptor> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f36256a;

        public b(AssetManager assetManager) {
            this.f36256a = assetManager;
        }

        @Override // y0.a.InterfaceC0734a
        public s0.d<ParcelFileDescriptor> a(AssetManager assetManager, String str) {
            return new s0.h(assetManager, str);
        }

        @Override // y0.o
        @NonNull
        public n<Uri, ParcelFileDescriptor> b(r rVar) {
            return new a(this.f36256a, this);
        }
    }

    /* JADX INFO: compiled from: AssetUriLoader.java */
    public static class c implements o<Uri, InputStream>, InterfaceC0734a<InputStream> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AssetManager f36257a;

        public c(AssetManager assetManager) {
            this.f36257a = assetManager;
        }

        @Override // y0.a.InterfaceC0734a
        public s0.d<InputStream> a(AssetManager assetManager, String str) {
            return new s0.m(assetManager, str);
        }

        @Override // y0.o
        @NonNull
        public n<Uri, InputStream> b(r rVar) {
            return new a(this.f36257a, this);
        }
    }

    public a(AssetManager assetManager, InterfaceC0734a<Data> interfaceC0734a) {
        this.f36254a = assetManager;
        this.f36255b = interfaceC0734a;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull Uri uri, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(uri), this.f36255b.a(this.f36254a, uri.toString().substring(f36253c)));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return v8.h.f15781b.equals(uri.getScheme()) && !uri.getPathSegments().isEmpty() && "android_asset".equals(uri.getPathSegments().get(0));
    }
}
