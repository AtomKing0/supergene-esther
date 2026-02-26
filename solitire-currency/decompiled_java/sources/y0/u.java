package y0;

import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.io.File;
import java.io.InputStream;
import y0.n;

/* JADX INFO: compiled from: StringLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public class u<Data> implements n<String, Data> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final n<Uri, Data> f36335a;

    /* JADX INFO: compiled from: StringLoader.java */
    public static final class a implements o<String, AssetFileDescriptor> {
        @Override // y0.o
        public n<String, AssetFileDescriptor> b(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, AssetFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class b implements o<String, ParcelFileDescriptor> {
        @Override // y0.o
        @NonNull
        public n<String, ParcelFileDescriptor> b(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, ParcelFileDescriptor.class));
        }
    }

    /* JADX INFO: compiled from: StringLoader.java */
    public static class c implements o<String, InputStream> {
        @Override // y0.o
        @NonNull
        public n<String, InputStream> b(@NonNull r rVar) {
            return new u(rVar.d(Uri.class, InputStream.class));
        }
    }

    public u(n<Uri, Data> nVar) {
        this.f36335a = nVar;
    }

    @Nullable
    private static Uri e(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if (str.charAt(0) == '/') {
            return f(str);
        }
        Uri uri = Uri.parse(str);
        return uri.getScheme() == null ? f(str) : uri;
    }

    private static Uri f(String str) {
        return Uri.fromFile(new File(str));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<Data> b(@NonNull String str, int i10, int i11, @NonNull r0.h hVar) {
        Uri uriE = e(str);
        if (uriE == null || !this.f36335a.a(uriE)) {
            return null;
        }
        return this.f36335a.b(uriE, i10, i11, hVar);
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull String str) {
        return true;
    }
}
