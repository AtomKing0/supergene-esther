package l;

import android.graphics.drawable.Drawable;
import androidx.annotation.MainThread;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.platform.InspectionModeKt;
import h9.l;
import l.b;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.i;
import v8.k0;
import w.c;
import z.d;

/* JADX INFO: compiled from: AsyncImagePainter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final a f30154a = new a();

    /* JADX INFO: compiled from: AsyncImagePainter.kt */
    public static final class a implements z.d {
        a() {
        }

        @Override // x.a
        @MainThread
        public void a(@NotNull Drawable drawable) {
            d.a.c(this, drawable);
        }

        @Override // x.a
        @MainThread
        public void b(@Nullable Drawable drawable) {
            d.a.b(this, drawable);
        }

        @Override // x.a
        @MainThread
        public void c(@Nullable Drawable drawable) {
            d.a.a(this, drawable);
        }

        @Override // z.d
        @Nullable
        public Drawable d() {
            return null;
        }
    }

    private static final boolean c(long j10) {
        return ((double) Size.m1436getWidthimpl(j10)) >= 0.5d && ((double) Size.m1433getHeightimpl(j10)) >= 0.5d;
    }

    @Composable
    @NotNull
    public static final b d(@Nullable Object obj, @NotNull j.e eVar, @Nullable l<? super b.c, ? extends b.c> lVar, @Nullable l<? super b.c, k0> lVar2, @Nullable ContentScale contentScale, int i10, @Nullable Composer composer, int i11, int i12) {
        composer.startReplaceableGroup(-2020614074);
        if ((i12 & 4) != 0) {
            lVar = b.f30116p.a();
        }
        if ((i12 & 8) != 0) {
            lVar2 = null;
        }
        if ((i12 & 16) != 0) {
            contentScale = ContentScale.Companion.getFit();
        }
        if ((i12 & 32) != 0) {
            i10 = DrawScope.Companion.m2027getDefaultFilterQualityfv9h1I();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2020614074, i11, -1, "coil.compose.rememberAsyncImagePainter (AsyncImagePainter.kt:131)");
        }
        v.i iVarD = j.d(obj, composer, 8);
        h(iVarD);
        composer.startReplaceableGroup(-492369756);
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.Companion.getEmpty()) {
            objRememberedValue = new b(iVarD, eVar);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        b bVar = (b) objRememberedValue;
        bVar.x(lVar);
        bVar.s(lVar2);
        bVar.p(contentScale);
        bVar.q(i10);
        bVar.u(((Boolean) composer.consume(InspectionModeKt.getLocalInspectionMode())).booleanValue());
        bVar.r(eVar);
        bVar.v(iVarD);
        bVar.onRemembered();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final w.i e(long j10) {
        if (j10 == Size.Companion.m1444getUnspecifiedNHjbRc()) {
            return w.i.f35274d;
        }
        if (!c(j10)) {
            return null;
        }
        float fM1436getWidthimpl = Size.m1436getWidthimpl(j10);
        w.c cVarA = !Float.isInfinite(fM1436getWidthimpl) && !Float.isNaN(fM1436getWidthimpl) ? w.a.a(j9.c.c(Size.m1436getWidthimpl(j10))) : c.b.f35261a;
        float fM1433getHeightimpl = Size.m1433getHeightimpl(j10);
        return new w.i(cVarA, (Float.isInfinite(fM1433getHeightimpl) || Float.isNaN(fM1433getHeightimpl)) ? false : true ? w.a.a(j9.c.c(Size.m1433getHeightimpl(j10))) : c.b.f35261a);
    }

    private static final Void f(String str, String str2) {
        throw new IllegalArgumentException("Unsupported type: " + str + ". " + str2);
    }

    static /* synthetic */ Void g(String str, String str2, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            str2 = "If you wish to display this " + str + ", use androidx.compose.foundation.Image.";
        }
        return f(str, str2);
    }

    private static final void h(v.i iVar) {
        Object objM = iVar.m();
        if (objM instanceof i.a) {
            f("ImageRequest.Builder", "Did you forget to call ImageRequest.Builder.build()?");
            throw new v8.h();
        }
        if (objM instanceof ImageBitmap) {
            g("ImageBitmap", null, 2, null);
            throw new v8.h();
        }
        if (objM instanceof ImageVector) {
            g("ImageVector", null, 2, null);
            throw new v8.h();
        }
        if (objM instanceof Painter) {
            g("Painter", null, 2, null);
            throw new v8.h();
        }
        if (!(iVar.M() == null)) {
            throw new IllegalArgumentException("request.target must be null.".toString());
        }
    }
}
