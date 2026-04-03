package t;

import a0.j;
import a0.r;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import androidx.annotation.VisibleForTesting;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.r0;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import n9.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q.a;
import q.b;
import t.c;
import v.n;
import v.q;
import w.c;

/* JADX INFO: compiled from: MemoryCacheService.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f33993c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final j.e f33994a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final q f33995b;

    /* JADX INFO: compiled from: MemoryCacheService.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    public d(@NotNull j.e eVar, @NotNull q qVar, @Nullable r rVar) {
        this.f33994a = eVar;
        this.f33995b = qVar;
    }

    private final String b(c.C0690c c0690c) {
        Object obj = c0690c.b().get("coil#disk_cache_key");
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }

    private final boolean d(c.C0690c c0690c) {
        Object obj = c0690c.b().get("coil#is_sampled");
        Boolean bool = obj instanceof Boolean ? (Boolean) obj : null;
        if (bool != null) {
            return bool.booleanValue();
        }
        return false;
    }

    private final boolean e(v.i iVar, c.b bVar, c.C0690c c0690c, w.i iVar2, w.h hVar) {
        boolean zD = d(c0690c);
        if (w.b.a(iVar2)) {
            return !zD;
        }
        String str = bVar.c().get("coil#transformation_size");
        if (str != null) {
            return t.d(str, iVar2.toString());
        }
        int width = c0690c.a().getWidth();
        int height = c0690c.a().getHeight();
        w.c cVarB = iVar2.b();
        int i10 = cVarB instanceof c.a ? ((c.a) cVarB).f35260a : Integer.MAX_VALUE;
        w.c cVarA = iVar2.a();
        int i11 = cVarA instanceof c.a ? ((c.a) cVarA).f35260a : Integer.MAX_VALUE;
        double dC = m.h.c(width, height, i10, i11, hVar);
        boolean zA = a0.i.a(iVar);
        if (zA) {
            double dH = o.h(dC, 1.0d);
            if (Math.abs(((double) i10) - (((double) width) * dH)) <= 1.0d || Math.abs(((double) i11) - (dH * ((double) height))) <= 1.0d) {
                return true;
            }
        } else if ((j.s(i10) || Math.abs(i10 - width) <= 1) && (j.s(i11) || Math.abs(i11 - height) <= 1)) {
            return true;
        }
        if ((dC == 1.0d) || zA) {
            return dC <= 1.0d || !zD;
        }
        return false;
    }

    @Nullable
    public final c.C0690c a(@NotNull v.i iVar, @NotNull c.b bVar, @NotNull w.i iVar2, @NotNull w.h hVar) {
        if (!iVar.C().c()) {
            return null;
        }
        c cVarD = this.f33994a.d();
        c.C0690c c0690cB = cVarD != null ? cVarD.b(bVar) : null;
        if (c0690cB == null || !c(iVar, bVar, c0690cB, iVar2, hVar)) {
            return null;
        }
        return c0690cB;
    }

    @VisibleForTesting
    public final boolean c(@NotNull v.i iVar, @NotNull c.b bVar, @NotNull c.C0690c c0690c, @NotNull w.i iVar2, @NotNull w.h hVar) {
        if (this.f33995b.c(iVar, a0.a.c(c0690c.a()))) {
            return e(iVar, bVar, c0690c, iVar2, hVar);
        }
        return false;
    }

    @Nullable
    public final c.b f(@NotNull v.i iVar, @NotNull Object obj, @NotNull n nVar, @NotNull j.c cVar) {
        c.b bVarB = iVar.B();
        if (bVarB != null) {
            return bVarB;
        }
        cVar.i(iVar, obj);
        String strF = this.f33994a.getComponents().f(obj, nVar);
        cVar.l(iVar, strF);
        if (strF == null) {
            return null;
        }
        List<y.a> listO = iVar.O();
        Map<String, String> mapB = iVar.E().b();
        if (listO.isEmpty() && mapB.isEmpty()) {
            return new c.b(strF, null, 2, null);
        }
        Map mapZ = r0.z(mapB);
        if (!listO.isEmpty()) {
            List<y.a> listO2 = iVar.O();
            int size = listO2.size();
            for (int i10 = 0; i10 < size; i10++) {
                mapZ.put("coil#transformation_" + i10, listO2.get(i10).getCacheKey());
            }
            mapZ.put("coil#transformation_size", nVar.n().toString());
        }
        return new c.b(strF, mapZ);
    }

    @NotNull
    public final v.r g(@NotNull b.a aVar, @NotNull v.i iVar, @NotNull c.b bVar, @NotNull c.C0690c c0690c) {
        return new v.r(new BitmapDrawable(iVar.l().getResources(), c0690c.a()), iVar, m.f.MEMORY_CACHE, bVar, b(c0690c), d(c0690c), j.t(aVar));
    }

    public final boolean h(@Nullable c.b bVar, @NotNull v.i iVar, @NotNull a.b bVar2) {
        c cVarD;
        Bitmap bitmap;
        if (iVar.C().d() && (cVarD = this.f33994a.d()) != null && bVar != null) {
            Drawable drawableE = bVar2.e();
            BitmapDrawable bitmapDrawable = drawableE instanceof BitmapDrawable ? (BitmapDrawable) drawableE : null;
            if (bitmapDrawable != null && (bitmap = bitmapDrawable.getBitmap()) != null) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put("coil#is_sampled", Boolean.valueOf(bVar2.f()));
                String strD = bVar2.d();
                if (strD != null) {
                    linkedHashMap.put("coil#disk_cache_key", strD);
                }
                cVarD.c(bVar, new c.C0690c(bitmap, linkedHashMap));
                return true;
            }
        }
        return false;
    }
}
