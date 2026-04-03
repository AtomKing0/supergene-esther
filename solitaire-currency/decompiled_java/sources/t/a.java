package t;

import android.graphics.Bitmap;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.c;

/* JADX INFO: compiled from: StrongMemoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i f33982a;

    public a(@NotNull i iVar) {
        this.f33982a = iVar;
    }

    @Override // t.h
    @Nullable
    public c.C0690c b(@NotNull c.b bVar) {
        return null;
    }

    @Override // t.h
    public void c(@NotNull c.b bVar, @NotNull Bitmap bitmap, @NotNull Map<String, ? extends Object> map) {
        this.f33982a.c(bVar, bitmap, map, a0.a.a(bitmap));
    }

    @Override // t.h
    public void a(int i10) {
    }
}
