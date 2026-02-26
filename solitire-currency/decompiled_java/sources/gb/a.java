package gb;

import android.content.Intent;
import android.net.Uri;
import kotlin.jvm.internal.g0;
import kotlin.jvm.internal.o0;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import support.ada.embed.ui.AdaEmbedActivity;
import support.ada.embed.widget.AdaEmbedView;
import v8.l;
import v8.n;

/* JADX INFO: compiled from: FilePickerHandler.kt */
/* JADX INFO: loaded from: classes5.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final /* synthetic */ KProperty[] f26372c = {o0.g(new g0(o0.b(a.class), "filePickerIntent", "getFilePickerIntent()Landroid/content/Intent;"))};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final l f26373a = n.a(C0569a.f26375g);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AdaEmbedView.d f26374b;

    /* JADX INFO: renamed from: gb.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: FilePickerHandler.kt */
    static final class C0569a extends v implements h9.a<Intent> {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final C0569a f26375g = new C0569a();

        C0569a() {
            super(0);
        }

        @Override // h9.a
        @NotNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public final Intent invoke() {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.setType("*/*");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
            return intent;
        }
    }

    public a(@Nullable AdaEmbedView.d dVar) {
        this.f26374b = dVar;
    }

    private final Intent b() {
        l lVar = this.f26373a;
        KProperty kProperty = f26372c[0];
        return (Intent) lVar.getValue();
    }

    public final void a() {
        AdaEmbedView.d dVar = this.f26374b;
        if (dVar != null) {
            dVar.a(null);
        }
        this.f26374b = null;
    }

    public final void c(int i10, int i11, @Nullable Intent intent) {
        Uri data;
        if (i10 == 8395) {
            if (i11 != -1 || intent == null || (data = intent.getData()) == null) {
                data = null;
            }
            AdaEmbedView.d dVar = this.f26374b;
            if (dVar != null) {
                dVar.a(data);
            }
            this.f26374b = null;
        }
    }

    public final void d(@NotNull AdaEmbedActivity adaEmbedActivity) {
        t.j(adaEmbedActivity, "adaEmbedActivity");
        adaEmbedActivity.startActivityForResult(b(), 8395);
    }
}
