package s0;

import android.content.ContentResolver;
import android.net.Uri;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.FileNotFoundException;
import java.io.IOException;
import s0.d;

/* JADX INFO: compiled from: LocalUriFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class l<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Uri f33464a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ContentResolver f33465b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f33466c;

    public l(ContentResolver contentResolver, Uri uri) {
        this.f33465b = contentResolver;
        this.f33464a = uri;
    }

    @Override // s0.d
    public void b() {
        T t10 = this.f33466c;
        if (t10 != null) {
            try {
                c(t10);
            } catch (IOException unused) {
            }
        }
    }

    protected abstract void c(T t10) throws IOException;

    @Override // s0.d
    @NonNull
    public r0.a d() {
        return r0.a.LOCAL;
    }

    @Override // s0.d
    public final void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super T> aVar) {
        try {
            T tF = f(this.f33464a, this.f33465b);
            this.f33466c = tF;
            aVar.f(tF);
        } catch (FileNotFoundException e10) {
            if (Log.isLoggable("LocalUriFetcher", 3)) {
                Log.d("LocalUriFetcher", "Failed to open Uri", e10);
            }
            aVar.c(e10);
        }
    }

    protected abstract T f(Uri uri, ContentResolver contentResolver) throws FileNotFoundException;

    @Override // s0.d
    public void cancel() {
    }
}
