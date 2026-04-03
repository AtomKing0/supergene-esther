package com.ironsource;

import com.ironsource.environment.thread.IronSourceThreadManager;
import com.ironsource.mediationsdk.logger.IronLog;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public interface bf<T> {

    public static class a<ListenerType> implements bf<ListenerType> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        private ListenerType f11398a;

        /* JADX INFO: renamed from: com.ironsource.bf$a$a, reason: collision with other inner class name */
        public static final class C0251a extends yp {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Runnable f11399a;

            C0251a(Runnable runnable) {
                this.f11399a = runnable;
            }

            @Override // com.ironsource.yp
            public void a() {
                this.f11399a.run();
            }
        }

        @Nullable
        public final ListenerType a() {
            return this.f11398a;
        }

        public final void b(@Nullable ListenerType listenertype) {
            this.f11398a = listenertype;
        }

        public static /* synthetic */ void a(a aVar, Runnable runnable, boolean z10, int i10, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: executeOnUIThreadIfConditionMet");
            }
            if ((i10 & 2) != 0) {
                z10 = true;
            }
            aVar.a(runnable, z10);
        }

        @Override // com.ironsource.bf
        public void a(ListenerType listenertype) {
            this.f11398a = listenertype;
        }

        public final void a(@NotNull Runnable runnable, boolean z10) {
            kotlin.jvm.internal.t.i(runnable, "runnable");
            if (z10) {
                IronSourceThreadManager.postOnUiThreadTask$default(IronSourceThreadManager.INSTANCE, new C0251a(runnable), 0L, 2, null);
            }
        }

        public final void a(@NotNull String instanceId, @NotNull String message) {
            kotlin.jvm.internal.t.i(instanceId, "instanceId");
            kotlin.jvm.internal.t.i(message, "message");
            IronLog.CALLBACK.info(message + " instanceId=" + instanceId);
        }
    }

    void a(T t10);
}
