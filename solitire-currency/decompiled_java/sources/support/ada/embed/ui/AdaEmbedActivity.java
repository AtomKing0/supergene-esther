package support.ada.embed.ui;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import h9.l;
import kotlin.jvm.internal.k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.v;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import support.ada.embed.widget.AdaEmbedView;

/* JADX INFO: compiled from: AdaEmbedActivity.kt */
/* JADX INFO: loaded from: classes5.dex */
public class AdaEmbedActivity extends AppCompatActivity {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f33929c = new a(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private AdaEmbedView f33930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private gb.a f33931b;

    /* JADX INFO: compiled from: AdaEmbedActivity.kt */
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(k kVar) {
            this();
        }
    }

    /* JADX INFO: compiled from: AdaEmbedActivity.kt */
    static final class b extends v implements l<AdaEmbedView.d, Boolean> {
        b() {
            super(1);
        }

        public final boolean a(@NotNull AdaEmbedView.d filePickerCallback) {
            t.j(filePickerCallback, "filePickerCallback");
            AdaEmbedActivity adaEmbedActivity = AdaEmbedActivity.this;
            gb.a aVar = new gb.a(filePickerCallback);
            aVar.d(AdaEmbedActivity.this);
            adaEmbedActivity.f33931b = aVar;
            return true;
        }

        @Override // h9.l
        public /* bridge */ /* synthetic */ Boolean invoke(AdaEmbedView.d dVar) {
            return Boolean.valueOf(a(dVar));
        }
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i10, int i11, @Nullable Intent intent) {
        super.onActivityResult(i10, i11, intent);
        gb.a aVar = this.f33931b;
        if (aVar != null) {
            aVar.c(i10, i11, intent);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        AdaEmbedView.e eVar = (AdaEmbedView.e) getIntent().getParcelableExtra("EXTRA_SETTINGS");
        if (eVar == null) {
            throw new IllegalArgumentException("Settings must not be null!");
        }
        AdaEmbedView adaEmbedView = new AdaEmbedView(this, null, 2, 0 == true ? 1 : 0);
        adaEmbedView.h(eVar);
        this.f33930a = adaEmbedView;
        setContentView(adaEmbedView);
        AdaEmbedView adaEmbedView2 = this.f33930a;
        if (adaEmbedView2 == null) {
            t.A("adaView");
        }
        adaEmbedView2.setFilePickerCallback(new b());
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
        gb.a aVar = this.f33931b;
        if (aVar != null) {
            aVar.a();
        }
        this.f33931b = null;
    }
}
