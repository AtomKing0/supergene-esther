package t;

import android.graphics.Bitmap;
import androidx.collection.LruCache;
import java.util.Map;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import t.c;

/* JADX INFO: compiled from: StrongMemoryCache.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class f implements h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final i f33998a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final b f33999b;

    /* JADX INFO: compiled from: StrongMemoryCache.kt */
    private static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @NotNull
        private final Bitmap f34000a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        @NotNull
        private final Map<String, Object> f34001b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f34002c;

        public a(@NotNull Bitmap bitmap, @NotNull Map<String, ? extends Object> map, int i10) {
            this.f34000a = bitmap;
            this.f34001b = map;
            this.f34002c = i10;
        }

        @NotNull
        public final Bitmap a() {
            return this.f34000a;
        }

        @NotNull
        public final Map<String, Object> b() {
            return this.f34001b;
        }

        public final int c() {
            return this.f34002c;
        }
    }

    /* JADX INFO: compiled from: StrongMemoryCache.kt */
    public static final class b extends LruCache<c.b, a> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ f f34003a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        b(int i10, f fVar) {
            super(i10);
            this.f34003a = fVar;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void entryRemoved(boolean z10, @NotNull c.b bVar, @NotNull a aVar, @Nullable a aVar2) {
            this.f34003a.f33998a.c(bVar, aVar.a(), aVar.b(), aVar.c());
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // androidx.collection.LruCache
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int sizeOf(@NotNull c.b bVar, @NotNull a aVar) {
            return aVar.c();
        }
    }

    public f(int i10, @NotNull i iVar) {
        this.f33998a = iVar;
        this.f33999b = new b(i10, this);
    }

    @Override // t.h
    public void a(int i10) {
        if (i10 >= 40) {
            e();
            return;
        }
        boolean z10 = false;
        if (10 <= i10 && i10 < 20) {
            z10 = true;
        }
        if (z10) {
            this.f33999b.trimToSize(g() / 2);
        }
    }

    @Override // t.h
    @Nullable
    public c.C0690c b(@NotNull c.b bVar) {
        a aVar = this.f33999b.get(bVar);
        if (aVar != null) {
            return new c.C0690c(aVar.a(), aVar.b());
        }
        return null;
    }

    @Override // t.h
    public void c(@NotNull c.b bVar, @NotNull Bitmap bitmap, @NotNull Map<String, ? extends Object> map) {
        int iA = a0.a.a(bitmap);
        if (iA <= f()) {
            this.f33999b.put(bVar, new a(bitmap, map, iA));
        } else {
            this.f33999b.remove(bVar);
            this.f33998a.c(bVar, bitmap, map, iA);
        }
    }

    public void e() {
        this.f33999b.evictAll();
    }

    public int f() {
        return this.f33999b.maxSize();
    }

    public int g() {
        return this.f33999b.size();
    }
}
