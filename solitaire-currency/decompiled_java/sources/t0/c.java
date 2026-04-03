package t0;

import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.bumptech.glide.f;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import s0.d;
import s0.g;

/* JADX INFO: compiled from: ThumbFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public class c implements s0.d<InputStream> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f34011a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final e f34012b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private InputStream f34013c;

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class a implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f34014b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f34015a;

        a(ContentResolver contentResolver) {
            this.f34015a = contentResolver;
        }

        @Override // t0.d
        public Cursor a(Uri uri) {
            return this.f34015a.query(MediaStore.Images.Thumbnails.EXTERNAL_CONTENT_URI, f34014b, "kind = 1 AND image_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    /* JADX INFO: compiled from: ThumbFetcher.java */
    static class b implements d {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private static final String[] f34016b = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final ContentResolver f34017a;

        b(ContentResolver contentResolver) {
            this.f34017a = contentResolver;
        }

        @Override // t0.d
        public Cursor a(Uri uri) {
            return this.f34017a.query(MediaStore.Video.Thumbnails.EXTERNAL_CONTENT_URI, f34016b, "kind = 1 AND video_id = ?", new String[]{uri.getLastPathSegment()}, null);
        }
    }

    @VisibleForTesting
    c(Uri uri, e eVar) {
        this.f34011a = uri;
        this.f34012b = eVar;
    }

    private static c c(Context context, Uri uri, d dVar) {
        return new c(uri, new e(com.bumptech.glide.b.c(context).j().g(), dVar, com.bumptech.glide.b.c(context).e(), context.getContentResolver()));
    }

    public static c f(Context context, Uri uri) {
        return c(context, uri, new a(context.getContentResolver()));
    }

    public static c g(Context context, Uri uri) {
        return c(context, uri, new b(context.getContentResolver()));
    }

    private InputStream h() throws Throwable {
        InputStream inputStreamD = this.f34012b.d(this.f34011a);
        int iA = inputStreamD != null ? this.f34012b.a(this.f34011a) : -1;
        return iA != -1 ? new g(inputStreamD, iA) : inputStreamD;
    }

    @Override // s0.d
    @NonNull
    public Class<InputStream> a() {
        return InputStream.class;
    }

    @Override // s0.d
    public void b() {
        InputStream inputStream = this.f34013c;
        if (inputStream != null) {
            try {
                inputStream.close();
            } catch (IOException unused) {
            }
        }
    }

    @Override // s0.d
    @NonNull
    public r0.a d() {
        return r0.a.LOCAL;
    }

    @Override // s0.d
    public void e(@NonNull f fVar, @NonNull d.a<? super InputStream> aVar) throws Throwable {
        try {
            InputStream inputStreamH = h();
            this.f34013c = inputStreamH;
            aVar.f(inputStreamH);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("MediaStoreThumbFetcher", 3)) {
                Log.d("MediaStoreThumbFetcher", "Failed to find thumbnail file", e10);
            }
            aVar.c(e10);
        }
    }

    @Override // s0.d
    public void cancel() {
    }
}
