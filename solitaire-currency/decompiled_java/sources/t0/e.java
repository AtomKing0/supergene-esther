package t0;

import android.content.ContentResolver;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.load.ImageHeaderParser;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/* JADX INFO: compiled from: ThumbnailStreamOpener.java */
/* JADX INFO: loaded from: classes2.dex */
class e {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final a f34018f = new a();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final a f34019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final d f34020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final v0.b f34021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContentResolver f34022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final List<ImageHeaderParser> f34023e;

    e(List<ImageHeaderParser> list, d dVar, v0.b bVar, ContentResolver contentResolver) {
        this(list, f34018f, dVar, bVar, contentResolver);
    }

    /* JADX WARN: Not initialized variable reg: 2, insn: 0x0048: MOVE (r1 I:??[OBJECT, ARRAY]) = (r2 I:??[OBJECT, ARRAY]) (LINE:73), block:B:27:0x0048 */
    /* JADX WARN: Removed duplicated region for block: B:29:0x004b  */
    @androidx.annotation.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.lang.String b(@androidx.annotation.NonNull android.net.Uri r7) throws java.lang.Throwable {
        /*
            r6 = this;
            java.lang.String r0 = "ThumbStreamOpener"
            r1 = 0
            t0.d r2 = r6.f34020b     // Catch: java.lang.Throwable -> L22 java.lang.SecurityException -> L24
            android.database.Cursor r2 = r2.a(r7)     // Catch: java.lang.Throwable -> L22 java.lang.SecurityException -> L24
            if (r2 == 0) goto L1c
            boolean r3 = r2.moveToFirst()     // Catch: java.lang.SecurityException -> L1a java.lang.Throwable -> L47
            if (r3 == 0) goto L1c
            r3 = 0
            java.lang.String r7 = r2.getString(r3)     // Catch: java.lang.SecurityException -> L1a java.lang.Throwable -> L47
            r2.close()
            return r7
        L1a:
            r3 = move-exception
            goto L26
        L1c:
            if (r2 == 0) goto L21
            r2.close()
        L21:
            return r1
        L22:
            r7 = move-exception
            goto L49
        L24:
            r3 = move-exception
            r2 = r1
        L26:
            r4 = 3
            boolean r4 = android.util.Log.isLoggable(r0, r4)     // Catch: java.lang.Throwable -> L47
            if (r4 == 0) goto L41
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> L47
            r4.<init>()     // Catch: java.lang.Throwable -> L47
            java.lang.String r5 = "Failed to query for thumbnail for Uri: "
            r4.append(r5)     // Catch: java.lang.Throwable -> L47
            r4.append(r7)     // Catch: java.lang.Throwable -> L47
            java.lang.String r7 = r4.toString()     // Catch: java.lang.Throwable -> L47
            android.util.Log.d(r0, r7, r3)     // Catch: java.lang.Throwable -> L47
        L41:
            if (r2 == 0) goto L46
            r2.close()
        L46:
            return r1
        L47:
            r7 = move-exception
            r1 = r2
        L49:
            if (r1 == 0) goto L4e
            r1.close()
        L4e:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: t0.e.b(android.net.Uri):java.lang.String");
    }

    private boolean c(File file) {
        return this.f34019a.a(file) && 0 < this.f34019a.c(file);
    }

    int a(Uri uri) {
        InputStream inputStreamOpenInputStream = null;
        try {
            try {
                inputStreamOpenInputStream = this.f34022d.openInputStream(uri);
                int iA = com.bumptech.glide.load.a.a(this.f34023e, inputStreamOpenInputStream, this.f34021c);
                if (inputStreamOpenInputStream != null) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused) {
                    }
                }
                return iA;
            } catch (Throwable th) {
                if (0 != 0) {
                    try {
                        inputStreamOpenInputStream.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (IOException | NullPointerException e10) {
            if (Log.isLoggable("ThumbStreamOpener", 3)) {
                Log.d("ThumbStreamOpener", "Failed to open uri: " + uri, e10);
            }
            if (inputStreamOpenInputStream == null) {
                return -1;
            }
            try {
                inputStreamOpenInputStream.close();
                return -1;
            } catch (IOException unused3) {
                return -1;
            }
        }
    }

    public InputStream d(Uri uri) throws Throwable {
        String strB = b(uri);
        if (TextUtils.isEmpty(strB)) {
            return null;
        }
        File fileB = this.f34019a.b(strB);
        if (!c(fileB)) {
            return null;
        }
        Uri uriFromFile = Uri.fromFile(fileB);
        try {
            return this.f34022d.openInputStream(uriFromFile);
        } catch (NullPointerException e10) {
            throw ((FileNotFoundException) new FileNotFoundException("NPE opening uri: " + uri + " -> " + uriFromFile).initCause(e10));
        }
    }

    e(List<ImageHeaderParser> list, a aVar, d dVar, v0.b bVar, ContentResolver contentResolver) {
        this.f34019a = aVar;
        this.f34020b = dVar;
        this.f34021c = bVar;
        this.f34022d = contentResolver;
        this.f34023e = list;
    }
}
