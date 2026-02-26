package p;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.TypedValue;
import android.webkit.MimeTypeMap;
import kotlin.collections.d0;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p.i;
import p9.p;
import p9.q;
import p9.r;
import ua.k0;
import v.n;

/* JADX INFO: compiled from: ResourceUriFetcher.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class l implements i {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NotNull
    public static final a f32369c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private final Uri f32370a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NotNull
    private final n f32371b;

    /* JADX INFO: compiled from: ResourceUriFetcher.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(kotlin.jvm.internal.k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: ResourceUriFetcher.kt */
    public static final class b implements i.a<Uri> {
        private final boolean c(Uri uri) {
            return t.d(uri.getScheme(), "android.resource");
        }

        @Override // p.i.a
        @Nullable
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public i a(@NotNull Uri uri, @NotNull n nVar, @NotNull j.e eVar) {
            if (c(uri)) {
                return new l(uri, nVar);
            }
            return null;
        }
    }

    public l(@NotNull Uri uri, @NotNull n nVar) {
        this.f32370a = uri;
        this.f32371b = nVar;
    }

    private final Void b(Uri uri) {
        throw new IllegalStateException("Invalid android.resource URI: " + uri);
    }

    @Override // p.i
    @Nullable
    public Object a(@NotNull z8.d<? super h> dVar) {
        Integer numL;
        String authority = this.f32370a.getAuthority();
        if (authority != null) {
            if (!(!q.z(authority))) {
                authority = null;
            }
            if (authority != null) {
                String str = (String) d0.u0(this.f32370a.getPathSegments());
                if (str == null || (numL = p.l(str)) == null) {
                    b(this.f32370a);
                    throw new v8.h();
                }
                int iIntValue = numL.intValue();
                Context contextG = this.f32371b.g();
                Resources resources = t.d(authority, contextG.getPackageName()) ? contextG.getResources() : contextG.getPackageManager().getResourcesForApplication(authority);
                TypedValue typedValue = new TypedValue();
                resources.getValue(iIntValue, typedValue, true);
                CharSequence charSequence = typedValue.string;
                String strJ = a0.j.j(MimeTypeMap.getSingleton(), charSequence.subSequence(r.j0(charSequence, '/', 0, false, 6, null), charSequence.length()).toString());
                if (!t.d(strJ, "text/xml")) {
                    TypedValue typedValue2 = new TypedValue();
                    return new m(m.q.b(k0.d(k0.l(resources.openRawResource(iIntValue, typedValue2))), contextG, new m.r(authority, iIntValue, typedValue2.density)), strJ, m.f.DISK);
                }
                Drawable drawableA = t.d(authority, contextG.getPackageName()) ? a0.d.a(contextG, iIntValue) : a0.d.d(contextG, resources, iIntValue);
                boolean zU = a0.j.u(drawableA);
                if (zU) {
                    drawableA = new BitmapDrawable(contextG.getResources(), a0.l.f48a.a(drawableA, this.f32371b.f(), this.f32371b.n(), this.f32371b.m(), this.f32371b.c()));
                }
                return new g(drawableA, zU, m.f.DISK);
            }
        }
        b(this.f32370a);
        throw new v8.h();
    }
}
