package y0;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import java.io.File;
import java.io.FileNotFoundException;
import s0.d;
import y0.n;

/* JADX INFO: compiled from: MediaStoreFileLoader.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k implements n<Uri, File> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f36292a;

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    public static final class a implements o<Uri, File> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f36293a;

        public a(Context context) {
            this.f36293a = context;
        }

        @Override // y0.o
        @NonNull
        public n<Uri, File> b(r rVar) {
            return new k(this.f36293a);
        }
    }

    public k(Context context) {
        this.f36292a = context;
    }

    @Override // y0.n
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public n.a<File> b(@NonNull Uri uri, int i10, int i11, @NonNull r0.h hVar) {
        return new n.a<>(new n1.b(uri), new b(this.f36292a, uri));
    }

    @Override // y0.n
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean a(@NonNull Uri uri) {
        return t0.b.b(uri);
    }

    /* JADX INFO: compiled from: MediaStoreFileLoader.java */
    private static class b implements s0.d<File> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private static final String[] f36294c = {"_data"};

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Context f36295a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Uri f36296b;

        b(Context context, Uri uri) {
            this.f36295a = context;
            this.f36296b = uri;
        }

        @Override // s0.d
        @NonNull
        public Class<File> a() {
            return File.class;
        }

        @Override // s0.d
        @NonNull
        public r0.a d() {
            return r0.a.LOCAL;
        }

        @Override // s0.d
        public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super File> aVar) {
            Cursor cursorQuery = this.f36295a.getContentResolver().query(this.f36296b, f36294c, null, null, null);
            if (cursorQuery != null) {
                try {
                    string = cursorQuery.moveToFirst() ? cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data")) : null;
                } finally {
                    cursorQuery.close();
                }
            }
            if (!TextUtils.isEmpty(string)) {
                aVar.f(new File(string));
                return;
            }
            aVar.c(new FileNotFoundException("Failed to find file path for: " + this.f36296b));
        }

        @Override // s0.d
        public void b() {
        }

        @Override // s0.d
        public void cancel() {
        }
    }
}
