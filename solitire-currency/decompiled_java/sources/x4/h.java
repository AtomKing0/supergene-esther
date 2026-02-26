package x4;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.NonNull;
import com.google.android.material.internal.s;

/* JADX INFO: compiled from: MaterialShapeUtils.java */
/* JADX INFO: loaded from: classes3.dex */
public class h {
    @NonNull
    static d a(int i10) {
        return i10 != 0 ? i10 != 1 ? b() : new e() : new j();
    }

    @NonNull
    static d b() {
        return new j();
    }

    @NonNull
    static f c() {
        return new f();
    }

    public static void d(@NonNull View view, float f10) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            ((g) background).X(f10);
        }
    }

    public static void e(@NonNull View view) {
        Drawable background = view.getBackground();
        if (background instanceof g) {
            f(view, (g) background);
        }
    }

    public static void f(@NonNull View view, @NonNull g gVar) {
        if (gVar.Q()) {
            gVar.b0(s.f(view));
        }
    }
}
