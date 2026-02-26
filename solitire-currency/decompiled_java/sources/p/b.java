package p;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import v.n;

/* JADX INFO: compiled from: BitmapFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Bitmap f32337a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32338b;

    /* JADX INFO: compiled from: BitmapFetcher.kt */
    public static final class a implements i.a<Bitmap> {
        @Override // p.i.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull Bitmap bitmap, @NotNull n nVar, @NotNull j.e eVar) {
            return new b(bitmap, nVar);
        }
    }

    public b(@NotNull Bitmap bitmap, @NotNull n nVar) {
        this.f32337a = bitmap;
        this.f32338b = nVar;
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) {
        return new g(new BitmapDrawable(this.f32338b.g().getResources(), this.f32337a), false, m.f.MEMORY);
    }
}
