package q1;

import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import v8.l;
import v8.n;
import v8.p;

/* JADX INFO: compiled from: DrawablePainter.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @NotNull
    private static final l f33127a = n.b(p.f35203c, a.f33128g);

    /* JADX INFO: compiled from: DrawablePainter.kt */
    static final class a extends v implements h9.a<Handler> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final a f33128g = new a();

        a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Handler invoke() {
            return new Handler(Looper.getMainLooper());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long c(Drawable drawable) {
        return (drawable.getIntrinsicWidth() < 0 || drawable.getIntrinsicHeight() < 0) ? Size.Companion.m1444getUnspecifiedNHjbRc() : SizeKt.Size(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Handler d() {
        return (Handler) f33127a.getValue();
    }
}
