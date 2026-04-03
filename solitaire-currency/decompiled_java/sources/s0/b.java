package s0;

import android.content.res.AssetManager;
import android.util.Log;
import androidx.annotation.NonNull;
import java.io.IOException;
import s0.d;

/* JADX INFO: compiled from: AssetPathFetcher.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> implements d<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f33440a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final AssetManager f33441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private T f33442c;

    public b(AssetManager assetManager, String str) {
        this.f33441b = assetManager;
        this.f33440a = str;
    }

    @Override // s0.d
    public void b() {
        T t10 = this.f33442c;
        if (t10 == null) {
            return;
        }
        try {
            c(t10);
        } catch (IOException unused) {
        }
    }

    protected abstract void c(T t10) throws IOException;

    @Override // s0.d
    @NonNull
    public r0.a d() {
        return r0.a.LOCAL;
    }

    @Override // s0.d
    public void e(@NonNull com.bumptech.glide.f fVar, @NonNull d.a<? super T> aVar) {
        try {
            T tF = f(this.f33441b, this.f33440a);
            this.f33442c = tF;
            aVar.f(tF);
        } catch (IOException e10) {
            if (Log.isLoggable("AssetPathFetcher", 3)) {
                Log.d("AssetPathFetcher", "Failed to load data from asset manager", e10);
            }
            aVar.c(e10);
        }
    }

    protected abstract T f(AssetManager assetManager, String str) throws IOException;

    @Override // s0.d
    public void cancel() {
    }
}
