package s;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import androidx.annotation.DrawableRes;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v.n;

/* JADX INFO: compiled from: ResourceIntMapper.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements d<Integer, Uri> {
    private final boolean b(@DrawableRes int i10, Context context) {
        try {
            return context.getResources().getResourceEntryName(i10) != null;
        } catch (Resources.NotFoundException unused) {
            return false;
        }
    }

    @Override // s.d
    public /* bridge */ /* synthetic */ Uri a(Integer num, n nVar) {
        return c(num.intValue(), nVar);
    }

    @Nullable
    public Uri c(@DrawableRes int i10, @NotNull n nVar) {
        if (!b(i10, nVar.g())) {
            return null;
        }
        Uri uri = Uri.parse("android.resource://" + nVar.g().getPackageName() + '/' + i10);
        t.h(uri, "parse(this)");
        return uri;
    }
}
