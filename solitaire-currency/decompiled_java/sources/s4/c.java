package s4;

import android.os.Build;
import android.view.View;
import android.window.BackEvent;
import android.window.OnBackAnimationCallback;
import android.window.OnBackInvokedCallback;
import android.window.OnBackInvokedDispatcher;
import androidx.activity.BackEventCompat;
import androidx.annotation.DoNotInline;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.media3.common.PlaybackException;
import java.util.Objects;

/* JADX INFO: compiled from: MaterialBackOrchestrator.java */
/* JADX INFO: loaded from: classes3.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    private final d f33539a = a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    @NonNull
    private final s4.b f33540b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    @NonNull
    private final View f33541c;

    /* JADX INFO: compiled from: MaterialBackOrchestrator.java */
    @RequiresApi(33)
    private static class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private OnBackInvokedCallback f33542a;

        private b() {
        }

        @Override // s4.c.d
        @DoNotInline
        public void a(@NonNull View view) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher();
            if (onBackInvokedDispatcherFindOnBackInvokedDispatcher == null) {
                return;
            }
            onBackInvokedDispatcherFindOnBackInvokedDispatcher.unregisterOnBackInvokedCallback(this.f33542a);
            this.f33542a = null;
        }

        @Override // s4.c.d
        @DoNotInline
        public void b(@NonNull s4.b bVar, @NonNull View view, boolean z10) {
            OnBackInvokedDispatcher onBackInvokedDispatcherFindOnBackInvokedDispatcher;
            if (this.f33542a == null && (onBackInvokedDispatcherFindOnBackInvokedDispatcher = view.findOnBackInvokedDispatcher()) != null) {
                OnBackInvokedCallback onBackInvokedCallbackC = c(bVar);
                this.f33542a = onBackInvokedCallbackC;
                onBackInvokedDispatcherFindOnBackInvokedDispatcher.registerOnBackInvokedCallback(z10 ? PlaybackException.CUSTOM_ERROR_CODE_BASE : 0, onBackInvokedCallbackC);
            }
        }

        OnBackInvokedCallback c(@NonNull final s4.b bVar) {
            Objects.requireNonNull(bVar);
            return new OnBackInvokedCallback() { // from class: s4.d
                @Override // android.window.OnBackInvokedCallback
                public final void onBackInvoked() {
                    bVar.d();
                }
            };
        }

        boolean d() {
            return this.f33542a != null;
        }
    }

    /* JADX INFO: renamed from: s4.c$c, reason: collision with other inner class name */
    /* JADX INFO: compiled from: MaterialBackOrchestrator.java */
    @RequiresApi(34)
    private static class C0670c extends b {

        /* JADX INFO: renamed from: s4.c$c$a */
        /* JADX INFO: compiled from: MaterialBackOrchestrator.java */
        class a implements OnBackAnimationCallback {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ s4.b f33543a;

            a(s4.b bVar) {
                this.f33543a = bVar;
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackCancelled() {
                if (C0670c.this.d()) {
                    this.f33543a.a();
                }
            }

            @Override // android.window.OnBackInvokedCallback
            public void onBackInvoked() {
                this.f33543a.d();
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackProgressed(@NonNull BackEvent backEvent) {
                if (C0670c.this.d()) {
                    this.f33543a.c(new BackEventCompat(backEvent));
                }
            }

            @Override // android.window.OnBackAnimationCallback
            public void onBackStarted(@NonNull BackEvent backEvent) {
                if (C0670c.this.d()) {
                    this.f33543a.b(new BackEventCompat(backEvent));
                }
            }
        }

        private C0670c() {
            super();
        }

        @Override // s4.c.b
        OnBackInvokedCallback c(@NonNull s4.b bVar) {
            return new a(bVar);
        }
    }

    /* JADX INFO: compiled from: MaterialBackOrchestrator.java */
    private interface d {
        void a(@NonNull View view);

        void b(@NonNull s4.b bVar, @NonNull View view, boolean z10);
    }

    public c(@NonNull s4.b bVar, @NonNull View view) {
        this.f33540b = bVar;
        this.f33541c = view;
    }

    @Nullable
    private static d a() {
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 34) {
            return new C0670c();
        }
        if (i10 >= 33) {
            return new b();
        }
        return null;
    }

    private void c(boolean z10) {
        d dVar = this.f33539a;
        if (dVar != null) {
            dVar.b(this.f33540b, this.f33541c, z10);
        }
    }

    public void b() {
        c(false);
    }

    public void d() {
        d dVar = this.f33539a;
        if (dVar != null) {
            dVar.a(this.f33541c);
        }
    }
}
