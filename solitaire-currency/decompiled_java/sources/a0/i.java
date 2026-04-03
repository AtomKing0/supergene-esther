package a0;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import androidx.annotation.DrawableRes;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Requests.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final v.c f38a = new v.c(null, null, null, null, null, null, null, false, false, null, null, null, null, null, null, 32767, null);

    /* JADX INFO: compiled from: Requests.kt */
    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f39a;

        static {
            int[] iArr = new int[w.e.values().length];
            iArr[w.e.EXACT.ordinal()] = 1;
            iArr[w.e.INEXACT.ordinal()] = 2;
            iArr[w.e.AUTOMATIC.ordinal()] = 3;
            f39a = iArr;
        }
    }

    public static final boolean a(@NotNull v.i iVar) {
        int i10 = a.f39a[iVar.H().ordinal()];
        if (i10 == 1) {
            return false;
        }
        if (i10 != 2) {
            if (i10 != 3) {
                throw new v8.q();
            }
            if ((iVar.q().m() != null || !(iVar.K() instanceof w.d)) && (!(iVar.M() instanceof x.b) || !(iVar.K() instanceof w.l) || !(((x.b) iVar.M()).getView() instanceof ImageView) || ((x.b) iVar.M()).getView() != ((w.l) iVar.K()).getView())) {
                return false;
            }
        }
        return true;
    }

    @NotNull
    public static final v.c b() {
        return f38a;
    }

    @Nullable
    public static final Drawable c(@NotNull v.i iVar, @Nullable Drawable drawable, @DrawableRes @Nullable Integer num, @Nullable Drawable drawable2) {
        if (drawable != null) {
            return drawable;
        }
        if (num == null) {
            return drawable2;
        }
        if (num.intValue() == 0) {
            return null;
        }
        return d.a(iVar.l(), num.intValue());
    }
}
