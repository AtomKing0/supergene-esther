package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.ui.text.caches.LruCache;
import androidx.compose.ui.text.font.TypefaceResult;
import androidx.compose.ui.text.platform.Synchronization_jvmKt;
import androidx.compose.ui.text.platform.SynchronizedObject;
import h9.l;
import java.util.List;
import kotlin.jvm.internal.t;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v8.k0;

/* JADX INFO: compiled from: FontFamilyResolver.kt */
/* JADX INFO: loaded from: classes.dex */
public final class TypefaceRequestCache {

    @NotNull
    private final SynchronizedObject lock = Synchronization_jvmKt.createSynchronizedObject();

    @NotNull
    private final LruCache<TypefaceRequest, TypefaceResult> resultCache = new LruCache<>(16);

    @Nullable
    public final TypefaceResult get$ui_text_release(@NotNull TypefaceRequest typefaceRequest) {
        TypefaceResult typefaceResult;
        t.i(typefaceRequest, "typefaceRequest");
        synchronized (this.lock) {
            typefaceResult = this.resultCache.get(typefaceRequest);
        }
        return typefaceResult;
    }

    @NotNull
    public final SynchronizedObject getLock$ui_text_release() {
        return this.lock;
    }

    public final int getSize$ui_text_release() {
        int size;
        synchronized (this.lock) {
            size = this.resultCache.size();
        }
        return size;
    }

    public final void preWarmCache(@NotNull List<TypefaceRequest> typefaceRequests, @NotNull l<? super TypefaceRequest, ? extends TypefaceResult> resolveTypeface) {
        TypefaceResult typefaceResult;
        t.i(typefaceRequests, "typefaceRequests");
        t.i(resolveTypeface, "resolveTypeface");
        int size = typefaceRequests.size();
        for (int i10 = 0; i10 < size; i10++) {
            TypefaceRequest typefaceRequest = typefaceRequests.get(i10);
            synchronized (this.lock) {
                typefaceResult = this.resultCache.get(typefaceRequest);
            }
            if (typefaceResult == null) {
                try {
                    TypefaceResult typefaceResultInvoke = resolveTypeface.invoke(typefaceRequest);
                    if (typefaceResultInvoke instanceof TypefaceResult.Async) {
                        continue;
                    } else {
                        synchronized (this.lock) {
                            this.resultCache.put(typefaceRequest, typefaceResultInvoke);
                        }
                    }
                } catch (Exception e10) {
                    throw new IllegalStateException("Could not load font", e10);
                }
            }
        }
    }

    @NotNull
    public final State<Object> runCached(@NotNull TypefaceRequest typefaceRequest, @NotNull l<? super l<? super TypefaceResult, k0>, ? extends TypefaceResult> resolveTypeface) {
        t.i(typefaceRequest, "typefaceRequest");
        t.i(resolveTypeface, "resolveTypeface");
        synchronized (this.lock) {
            TypefaceResult typefaceResult = this.resultCache.get(typefaceRequest);
            if (typefaceResult != null) {
                if (typefaceResult.getCacheable()) {
                    return typefaceResult;
                }
                this.resultCache.remove(typefaceRequest);
            }
            try {
                TypefaceResult typefaceResultInvoke = resolveTypeface.invoke(new TypefaceRequestCache$runCached$currentTypefaceResult$1(this, typefaceRequest));
                synchronized (this.lock) {
                    if (this.resultCache.get(typefaceRequest) == null && typefaceResultInvoke.getCacheable()) {
                        this.resultCache.put(typefaceRequest, typefaceResultInvoke);
                    }
                    k0 k0Var = k0.f35197a;
                }
                return typefaceResultInvoke;
            } catch (Exception e10) {
                throw new IllegalStateException("Could not load font", e10);
            }
        }
    }
}
